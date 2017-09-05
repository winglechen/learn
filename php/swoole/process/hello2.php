<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 16/8/30
 * Time: 16:47
 */

$workers = [];
$workerNum = 3;

for($i=0; $i<$workerNum; $i++){
    $worker = new swoole_process('workerAction');
    $worker->useQueue();

    swoole_event_add($worker->pipe, function($pipe) use($worker){
        echo "=============================================\n";
        echo "master get msg \n";
        echo 'worker pid: ' . $worker->pid . "\n";
        $data = $worker->read();
        echo "data: " . $data . "\n";
        echo "=============================================\n";
    });
    
    $workerPid = $worker->start();
    $workers[$workerPid] = $worker;

    $worker->write('master send msg');
}


function workerAction(swoole_process $process)
{
    $workerId = $process->pid;
    echo "=============================================\n";
    echo "worker({$workerId}) started\n";
    echo "=============================================\n";
    
    $process->write("worker({$workerId}) send msg");
    
    swoole_event_add($process->pipe, function($pipe) use($process){
        $workerId = $process->pid;
        $data = $process->read();

        echo "=============================================\n";
        echo "worker({$workerId}) receive msg: {$data}\n";
        echo "=============================================\n";
    });
}