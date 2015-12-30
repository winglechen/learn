<?php
/**
 * Created by IntelliJ IDEA.
 * User: winglechen
 * Date: 15/12/7
 * Time: 16:33
 */

class Btree
{
    protected $node;
    protected $left;
    protected $right;

    public function __contruct($node = null, $left = null, $right = null)
    {
        $this->node = $node;
        if ( $this->node === null )
        {
            $this->left = null;
            $this->right = null;
        }
        elseif ( $this->left === null )
        {
            $this->left = new Btree();
            $this->right = new Btree();
        }
        else
        {
            $this->left = $left;
            $this->right = $right;
        }
    }

    //清空
    public function clear()
    {
        $this->node = null;
        $this->left = null;
        $this->right = null;

        return true;
    }

    //判断节点为空
    public function isEmpty()
    {
        return $this->node === null;
    }

    //判断叶节点
    public function isLeaf()
    {
        return ! $this->isEmpty()
        && $this->left->isEmpty()
        && $this->right->isEmpty();
    }

    //获取节点
    public function get()
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        return $this->node;
    }

    //写入节点
    public function set($obj)
    {
        if ( ! $this->isEmpty() )
        {
            return false;
        }

        $this->node = $obj;
        $this->left = new Btree();
        $this->right = new Btree();
    }

    //删除节点
    public function del()
    {
        if ( ! $this->isLeaf() )
        {
            return false;
        }

        $this->node = null;
        $this->left = null;
        $this->right = null;

        return true;
    }

    //获取左子树
    public function getLeft()
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        return $this->left;
    }

    //写入左子树
    public function setLeft( $tree )
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        if ( ! $this->left->isEmpty() )
        {
            return false;
        }

        $this->left = $tree;
    }

    //删除左子树
    public function delLeft()
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        $this->left = new Btree();

        return true;
    }

    //获取右子树
    public function getRight()
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        return $this->right;
    }

    //写入右子树
    public function setRight( $tree )
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        if ( ! $this->right->isEmpty() )
        {
            return false;
        }

        $this->right = $tree;
    }

    //删除右子树
    public function delRight()
    {
        if ( $this->isEmpty() )
        {
            return false;
        }

        $this->right = new Btree();

        return true;
    }

    //子树比对
    public function compare( $tree )
    {
        return $tree - $this->get();
    }

    //子树插入
    public function insert( $tree )
    {
        if ( $this->isEmpty() )
        {
            $this->set($tree);
        }
        else
        {
            $diff = $this->compare($tree);
            if ( $diff == 0 )
            {
                return false;
            }

            if ( $diff < 0 )
            {
                $this->getLeft()->insert($tree);
            }

            if ( $diff > 0 )
            {
                $this->getRight()->insert($tree);
            }
        }

        return true;
    }

    //从传参构建整树
    public function build($nums)
    {
        $nums = explode(',', $nums);
        print_r($nums);
        if ( empty($nums) )
        {
            echo "None\n";
            exit;
        }

        $tree = new Btree();
        foreach ( $nums as $num )
        {
            $tree->insert($num);
        }

        return $tree;
    }
}

$nums = '1,99,36,24,12,87,50,2,4,19,10,25,33,32,14';
$tree = new Btree();
$tree = $tree->build($nums);
print_r($tree);