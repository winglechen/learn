<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/10/12
 * Time: 21:37
 */

class Task {
    protected $taskId;
    protected $coroutine;
    protected $sendValue = null;
    protected $beforeFirstYield = true;

    public function __construct($taskId, Generator $coroutine) {
        $this->taskId = $taskId;
        $this->coroutine = $coroutine;
    }

    public function getTaskId() {
        return $this->taskId;
    }

    public function setSendValue($sendValue) {
        $this->sendValue = $sendValue;
    }

    public function run() {
        if ($this->beforeFirstYield) {
            $this->beforeFirstYield = false;
            return $this->coroutine->current();
        } else {
            $retval = $this->coroutine->send($this->sendValue);
            $this->sendValue = null;
            return $retval;
        }
    }

    public function result() {
        return $this->coroutine->current();
    }

    public function isFinished() {
        return !$this->coroutine->valid();
    }
}

class Scheduler {
    protected $maxTaskId = 0;
    protected $tashMap = [];
    protected $taskQueue;

    public function __construct() {
        $this->taskQueue = new SplQueue();
    }

    public function newTask(Generator $coroutine) {
        $tid = ++$this->maxTaskId;
        $task = new Task($tid,$coroutine);
        $this->tashMap[$tid] = $task;
        $this->schedule($task);

        return $tid;
    }

    public function killTask($tid) {
        if(!isset($this->tashMap[$tid])) {
            return false;
        }

        unset($this->tashMap[$tid]);

        foreach ($this->taskQueue as $i => $task) {
            if($task->getTaskId() == $tid) {
                unset($this->taskQueue[$i]);
                break;
            }
        }

        return true;
    }

    public function schedule(Task $task) {
        $this->taskQueue->enqueue($task);
    }

    public function run() {
        while (!$this->taskQueue->isEmpty()) {
            $task = $this->taskQueue->dequeue();
            $retval = $task->run();

            if($retval instanceof SystemCall) {
                $retval($task, $this);
                continue;
            }

            if ($task->isFinished()) {
                unset($this->tashMap[$task->getTaskId()]);
            } else {
                $this->schedule($task);
            }
        }
    }
}

class SystemCall {
    protected $callback = null;

    public function __construct(Closure $callback) {
        $this->callback = $callback;
    }

    public function __invoke(Task $task, Scheduler $scheduler) {
        $callback = $this->callback;
        return $callback($task, $scheduler);
    }
}


function newTask(Generator $coroutine) {
    return new SystemCall( function(Task $task, Scheduler $scheduler) use ($coroutine){
        $task->setSendValue($scheduler->newTask($coroutine));
        $scheduler->schedule($task);
    });
}

function killTask($tid) {
    return new SystemCall( function(Task $task, Scheduler $scheduler) use ($tid) {
        $task->setSendValue($scheduler->killTask($tid));
        $scheduler->schedule($task);
    });
}

function getTaskId() {
    return new SystemCall(function(Task $task, Scheduler $scheduler){
        $task->setSendValue($task->getTaskId());
        $scheduler->schedule($task);
    });
}


class Multi {
    public $data = [];
    public static function newInstance() {
        return new self();
    }

    public function add($key, Closure $callback) {
        $cb = $this->createTask($key, $callback);
    }

    public function execute() {

    }

    private function createTask($key, Closure $callback) {
        $that = $this;
        return function () use ($that, $key, $callback) {
            $that->data[$key] = (yield $callback());
        };
    }
}


$scheduler = new Scheduler();

$scheduler->newTask(task());
$scheduler->run();





/*****************************************************************


function childTask() {
$tid = (yield getTaskId());
$i = 0;
while (true) {
echo "child task $tid still alive!\n";
$i++;
yield $i;
}
}

function task() {
$tid = (yield getTaskId());
$childTid = (yield newTask(childTask()));

for ($i=1; $i<=6; $i++) {
echo "Parent task $tid iteration $i\n";
yield $i;

if( 3 === $i) yield killTask($childTid);
}
}

function task($max) {
    $tid = (yield getTaskId());
    for ($i=1; $i<=$max; $i++) {
        echo "this is task $tid iteration $i.\n";
        yield;
    }
}

$scheduler = new Scheduler();

$scheduler->newTask(task(10));
$scheduler->newTask(task(5));

$scheduler->run();

function task1() {
    for ($i=0; $i<10; $i++){
        echo "This is task1 iteration $i. \n";
        yield;
    }
}

function task2() {
    for ($i=0; $i<5; $i++) {
        echo "This is task2 iteration $i. \n";
        yield;
    }
}

$scheduler = new Scheduler();

$coroutin1 = task1();
$scheduler->newTask($coroutin1);

$coroutin2 = task2();
$scheduler->newTask($coroutin2);

$scheduler->run();
*****************************************************************/