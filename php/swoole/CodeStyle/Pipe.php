<?php
/**
 * Created by PhpStorm.
 * User: winglechen
 * Date: 14-11-16
 * Time: 22:06
 */

class Pipe {
    private $steps  = [];
    public function addStep()
    {

    }

    public function output()
    {

    }
}

class Step
{
    private $task       = null;
    private $nextStep   = null;

    public function __construct($task,$nextStep)
    {

    }

    public function doNext()
    {

    }
}

class DemoController
{
    public function getIndexHtml()
    {
        $pipe = new Pipe();

        $pipe->addStep(function($input){
            return (new DemoService())->getData($input);
        });
    }
}

class DemoService
{
    public function getData()
    {

    }
}