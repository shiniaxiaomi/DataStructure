package com.lyj.list;

import com.lyj.Util;

/**
 * 双向链表
 */
public class DoubleLinkList implements List{

    int length;//保存节点的长度(规定头结点不计入长度)

    Node head;//头结点

    //定义node节点
    class Node{
        Node pre;//保存前一个节点
        Object data;//保存数据
        Node next;//保存下一个节点

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{data=" + data + "}";
        }
    }


    @Override
    public void init(int size) {
        this.head=new Node(null);
    }

    @Override
    public void clearList() {
        //将尾节点置空即可
        this.head=null;
        //长度清零
        this.length=0;
    }

    @Override
    public void insert(int index, Object o) throws Exception {

        Node node = new Node(o);

        Node locateNode = (Node) this.getElem(index-1);

        //如果当前没有节点
        if(this.length==0){
            this.head.next=node;//尾节点指向新插入的节点
        }
        //在最后面插入节点
        else if(locateNode.next==null){
            locateNode.next=node;//让locate节点的next指向插入节点
            node.pre=locateNode;//让插入节点的pre指向locate节点
        }
        //已经存在节点
        else{
            //先解决后面的节点
            locateNode.next.pre=node;//让locate节点的下一个节点的pre指向插入节点
            node.next=locateNode.next;//让插入节点的next指向locate节点的下一个节点

            //在解决前面的节点
            locateNode.next=node;//让locate节点的next指向插入节点
            node.pre=locateNode;//让插入节点的pre指向locate节点

        }

        this.length++;

    }

    @Override
    public void delete(int index) throws Exception {

        //需要删除的节点
        Node delNode = (Node) this.getElem(index);

        if(delNode.pre!=null){
            delNode.pre.next=delNode.next;//删除节点的上一个节点的next指向删除节点的下一个节点
        }

        if(delNode.next!=null){
            delNode.next.pre=delNode.pre;//删除节点的下一个节点的pre指向删除节点的上一个节点
        }

        //将删除节点的pre和next置空,即删除
        delNode.next=null;
        delNode.pre=null;

        this.length--;

    }

    @Override
    public boolean isEmpty() {
        return this.length==0;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    //从尾部往前寻找
    @Override
    public int locateElem(Object o) {

        //如果没有节点
        if(this.length==0){
            return -1;
        }

        Node node=this.head.next;//获取头节点

        for(int i=0;i<this.length;i++){
            if((int)node.data==(int)o){
                return i;
            }
            node=node.next;//获取到下一个节点
        }

        return -1;
    }

    //从尾部往前寻找
    @Override
    public Object getElem(int index) throws Exception {

        if(index>this.length){
            throw new Exception("超出范围");
        }

        //如果没有节点
        if(this.length==0){
            return null;
        }

        Node node=this.head.next;//获取头节点

        while(index>0){
            node=node.next;//获取到下一个节点
            index--;
        }

        return node;

    }

    public Node getPreNode(Node node){
        return node.pre;
    }


    //测试
    public static void main(String[] args) throws Exception {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.init(10);

        //连续插入5个数据
        for(int i=0;i<5;i++){
            doubleLinkList.insert(i,i);
        }

        //单纯插入一个数据
        doubleLinkList.insert(2,10);

        //打印数组数据
        Util.printf(doubleLinkList);
        //打印数据长度
        System.out.println("数组长度:"+doubleLinkList.getLength());


        //删除一个数据
        doubleLinkList.delete(3);
        //打印数组数据
        Util.printf(doubleLinkList);
        //打印数据长度
        System.out.println("数组长度:"+doubleLinkList.getLength());

        //查找数据为3的索引
        int i = doubleLinkList.locateElem(3);
        System.out.println("查找到的索引为:"+i);
        //获取对应的数据
        if(i!=-1){
            System.out.println("获取到的数据为:"+doubleLinkList.getElem(i));
        }

        //清除数据
        doubleLinkList.clearList();
        //打印数组数据
        Util.printf(doubleLinkList);
        //打印数据长度
        System.out.println("数组长度:"+doubleLinkList.getLength());
        //判断是否为空
        System.out.println("数组是否为空:"+doubleLinkList.isEmpty());
    }


}
