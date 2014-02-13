<?php
$data = file_get_contents(__DIR__.'/xzqh.js');
$data = json_decode($data,true);

$first   = [];
$second  = [];
foreach($data as $row){
    $first[] = [
        "C"     => $row["C"],
        "N"     => $row["N"],
        "S"     => [],
    ];
    file_put_contents(__DIR__.'/area/'.$row["C"].'.js',json_encode($row["S"]));
}

file_put_contents(__DIR__.'/area/cn.js',json_encode($first));

