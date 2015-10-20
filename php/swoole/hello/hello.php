<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/10/8
 * Time: 14:22
 */

$http = new swoole_http_server("127.0.0.1", 9501);
$http->on('request', function ($request, $response) {
    $requestUri = $request->server['request_uri'];
    if(preg_match('/\.ico$/i',$requestUri)){
        $response->end("img");
        return null;
    }

    var_dump($request,$response);
    $response->end("<h1>Hello Swoole. #".rand(1000, 9999)."</h1>");
});
$http->start();