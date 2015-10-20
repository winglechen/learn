<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/10/12
 * Time: 14:44
 */

function gen() {
    $ret = (yield 'yield1');
    var_dump('dump ret1:',$ret);

    $ret = (yield 'yield2');
    var_dump('dump ret2:',$ret);

    yield 'finish';
}

$gen = gen();

//var_dump('current:',$gen->current());
echo "\n\n";
var_dump('send ret1:',$gen->send('ret1'));
echo "\n\n";
var_dump('send ret2:',$gen->send('ret2'));