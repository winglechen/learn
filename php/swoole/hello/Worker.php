<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/10/26
 * Time: 23:15
 */

//require __DIR__ . '/config.php';

class Worker {
    private $request    = null;
    private $response   = null;

    public function run($request,$response) {
        $this->request = $request;
        $this->response = $response;

        $this->test();
        $this->output();
    }

    private function test() {
        $data = Config::show();

        var_dump($data);
    }

    private function output() {
        $content = "time : " . time() . "<br />";

        $this->response->end($content);
    }
}