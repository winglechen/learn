<?php
/**
 * Created by PhpStorm.
 * User: winglechen
 * Date: 14-11-13
 * Time: 3:35
 */

class Client {
    private $client = null;
    private $host   = '127.0.0.1';
    private $port   = 8080;
    private $cli    = null;

    public function connect($host,$port=80)
    {
        $this->host = $host;
        $this->port = $port;

        $this->init();
        $this->initConnectEvent();
        $this->initErrorEvent();
        $this->initCloseEvent();

        $this->initReceiveEvent();
        $this->client->connect($this->host,$this->port,1000,1);

    }

    public function request($path,$data='')
    {
        $this->client->send($path);
        echo "after send\n";
    }

    private function initReceiveEvent()
    {
        $_this = $this;
        $this->client->on('receive',function($cli,$data) use($_this){
            echo "response: " . $data . "\n";
        });
    }

    private function initConnectEvent()
    {
        $_this = $this;
        $this->client->on('connect',function($cli) use($_this) {
            $cli->send('connect');
            echo "client connect\n";

            $_this->request('long');
            $_this->request('short1');
            $_this->request('short2');
            $_this->request('short3');
        });
    }

    private function initCloseEvent()
    {
        $this->client->on('close',function($cli){
            echo "client close\n";
        });
    }

    private function initErrorEvent()
    {
        $this->client->on('error',function($cli){
            echo "client error\n";
        });
    }

    private function init()
    {
        if(null !== $this->client){
            return $this->client;
        }
        $this->client = new swoole_client(SWOOLE_SOCK_TCP,SWOOLE_SOCK_ASYNC,'123');
        return $this->client;
    }
}

$c = new Client();
$c->connect('127.0.0.1',8080);




