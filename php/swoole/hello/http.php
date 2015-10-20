<?php
/**
 * Created by PhpStorm.
 * User: winglechen
 * Date: 14-11-13
 * Time: 2:34
 */

class Http {
    private $server     = null;
    private $request    = null;
    private $response   = null;

    public function run()
    {
        $server = $this->initServer();
        $self   = $this;
        $server->on('request',function($request,$response) use($self){
            var_dump($request,$response);exit;
            $self->handleRequest($request,$response);
        });
        set_exception_handler([$this,'exceptionHandle']);
        $server->start();
    }

    private function handleRequest($request,$response)
    {
        $this->request  = $request;
        $this->response = $response;

        ob_start();
        $this->processRequest();
    }


    private function exceptionHandle($e)
    {
        echo "exception happend";
        $this->output();
    }

    private function processRequest()
    {
        try{
            throw new Exception('test exception');
        }catch(Exception $e){}
        $content = 'hello world . ' . date('Y-m-d H:i:s') . "<br />";
        //$get     = json_encode($this->request->get);

        //var_dump($this->request);
        //$content.= $get;
        echo $content;

        $this->output();
    }

    private function output()
    {
        $content = ob_get_clean();
        $this->response->end($content);
    }

    private function initServer()
    {
        if(null !== $this->server){
            return $this->server;
        }
        $this->server = new swoole_http_server("127.0.0.1",8080);
        return $this->server;
    }
}

$server = new Http();
$server->run();

