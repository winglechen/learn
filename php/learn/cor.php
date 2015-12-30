<?php

function cor() {
    echo "cor 0 called\n";
    yield 1;
    echo "cor 1 called\n";
    yield 2;
    echo "cor 2 called\n";
    yield 3;
    echo "cor 3 called\n";
    yield 4;
    echo "cor 4 called\n";
 

}


$cor = cor();
$cor->send(1);
$cor->send(2);
$cor->send(3);
$cor->send(4);

