<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/6/13
 * Time: 11:06
 */


$kafka = new Kafka("localhost:9092");

$status = $kafka->produce('test_pub','test msq');
var_dump($status);exit;

$partitions = $kafka->getPartitionsForTopic('test_pub');
$kafka->setPartition($partitions[0]);
$msg = $kafka->consume("test_pub", Kafka::OFFSET_BEGIN, 20);
var_dump($msg);exit;
