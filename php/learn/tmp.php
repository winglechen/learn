<?php
function gen() {
        $ret = (yield 'yield1');
            var_dump($ret);
                $ret = (yield 'yield2');
                    var_dump($ret);
}

$gen = gen();
var_dump('current',$gen->current());    // string(6) "yield1"

$tmp = $gen->send('ret1');
var_dump('current',$gen->current());
// string(6) "yield2" (the var_dump of the ->send() return value)
var_dump('send',$gen->send('ret2')); // string(4) "ret2"   (again from within gen)
// NULL               (the return value of ->send())
