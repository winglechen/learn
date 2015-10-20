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

    public function schedule(Task $task) {
        $this->taskQueue->enqueue($task);
    }

    public function run() {
        while (!$this->taskQueue->isEmpty()) {
            $task = $this->taskQueue->dequeue();
            $task->run();

            if ($task->isFinished()) {
                unset($this->tashMap[$task->getTaskId()]);
            } else {
                $this->schedule($task);
            }
        }
    }
}

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