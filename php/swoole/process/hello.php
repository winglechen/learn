<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 16/8/30
 * Time: 16:33
 */

$masterProcess = new swoole_process('masterAction', true);



function masterAction(swoole_process $master)
{
    $master = new MasterProcess($master);
    $master->start();
}


function workerAction(swooleProcess $worker)
{

}

class MasterProcess
{
    private $process = null;
    public function __construct(swoole_process $process)
    {
        $this->process = $process;
    }

    public function start()
    {
        
    }
}

class WorkerProcess
{

}

