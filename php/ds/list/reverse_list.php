<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 2016/10/13
 * Time: 18:44
 */

class Node{
    private $next = null;
    private $data = null;

    public function __construct($data=null)
    {
        $this->data = $data;
    }

    public function setNext(Node $n)
    {
        $this->next = $n;
    }

    public function getNext()
    {
        return $this->next;
    }

}

$list = new Node('head');

$a = new Node('a');
$list->setNext($a);

$b = new Node('b');
$a->setNext($b);

$c = new Node('c');
$b->setNext($c);





$n = $list;
$t = new Node('tmp');
while(null !== $n){
    $next = $n->getNext();
    
    $tmpNext = $t->getNext();
    $t->setNext($next);
    $next->setNext($tmpNext);

    $n->setNext($next->getNext());
}

