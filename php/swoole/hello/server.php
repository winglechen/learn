<?php
/**
 * Created by PhpStorm.
 * User: winglechen
 * Date: 14-11-15
 * Time: 23:59
 */

class Server {
    private static $server = null;
    public function start()
    {
        $this->initServer();
        $this->initServerSetting();
        $this->work();
    }

    private function initServer()
    {
        if(null !== self::$server){
            return self::$server;
        }
        self::$server = new swoole_server('127.0.0.1',8080);
    }

    private function initServerSetting()
    {
        self::$server->set([
            'worker_num'    => 4,
            //'daemonize'     => true,
        ]);
    }

    private function work()
    {
        $this->initConnectEvent();
        $this->initReceiveEvent();
        $this->initCloseEvent();
        self::$server->start();
    }

    private function initConnectEvent()
    {
        self::$server->on('connect',function($serv,$fd){
            echo "client:Connected.\n";
        });
    }

    private function initCloseEvent()
    {
        self::$server->on('close',function($serv,$fd){
            echo "client:Close.\n";
        });
    }

    private function initTimerEvent($fd,$from_id,$request)
    {
        $_this = $this;
        self::$server->on('Timer',function($serv,$interval) use($_this,$fd,$from_id,$request){
            $serv->send($fd,$request);
        });
    }

    private function initReceiveEvent()
    {
        $_this = $this;
        self::$server->on('receive',function($serv,$fd,$from_id,$request) use ($_this){
            return $_this->response($serv,$fd,$from_id,$request);
        });
    }

    private function response($serv,$fd,$from_id,$request)
    {
        if(preg_match('/^short/i',$request)){
            $serv->send($fd,$request);
        }elseif('long' == $request){
            $this->initTimerEvent($fd,$from_id,$request);
            $serv->addtimer(10000);
        }else{
            $serv->send($fd,$request);
        }
    }
}

$s = new Server();
$s->start();