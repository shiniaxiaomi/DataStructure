package com.lyj.list;


import com.lyj.Util;

/**
 * 使用链表实现list(单向链表)
 */
public class LinkList implements List {

    int length;//保存节点的长度(规定头结点不计入长度)

    Node head;//头结点

    //定义node节点
    class Node{
        Object data;//保存数据
        Node next;//保存下一个节点

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }



    //对于链表来说,设置size没有意义,在这里就创建一个头结点即可
    @Override
    public void init(int size) {

        //创建头结点
        head=new Node(null);
    }

    @Override
    public void clearList() {
        //重新创建头结点即可
        head=new Node(null);
        //长度清零
        this.length=0;
    }

    @Override
    public void insert(int index, Object o) throws Exception {

        if(index<0 || index>length){
            throw new Exception("非法索引");
        }


        //找到对应的节点
        Node node = this.head;
        for(int i=0;i<index;i++){
            node = node.next;
        }


        //插入操作
        Node insertNode = new Node(o);
        insertNode.next=node.next;
        node.next=insertNode;

        this.length++;

    }

    @Override
    public void delete(int index) throws Exception {

        if(index<0){
            throw new Exception("非法索引");
        }

        //找到对应的节点
        Node node = this.head;
        for(int i=0;i<index;i++){
            node = node.next;
        }

        //删除操作
        node.next=node.next.next;

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

    @Override
    public int locateElem(Object o) {

        if(length==0){
            return -1;
        }

        Node node = this.head;
        for(int i=0;i<this.length;i++){
            node = node.next;
            if((int)node.data==(int)o){
                return i;
            }
        }

        return -1;

    }

    @Override
    public Object getElem(int index) throws Exception {

        if(index<0 || index>length){
            throw new Exception("超出范围");
        }

        Node node = this.head.next;
        for(int i=0;i<index;i++){
            node = node.next;
        }

        return node;
    }


    //测试
    public static void main(String[] args) throws Exception {

        LinkList linkList = new LinkList();
        linkList.init(10);

        //连续插入5个数据
        for(int i=0;i<5;i++){
            linkList.insert(i,i);
        }

        //单纯插入一个数据
        linkList.insert(2,10);

        //打印数组数据
        Util.printf(linkList);
        //打印数据长度
        System.out.println("数组长度:"+linkList.getLength());


        //删除一个数据
        linkList.delete(3);
        //打印数组数据
        Util.printf(linkList);
        //打印数据长度
        System.out.println("数组长度:"+linkList.getLength());

        //查找数据为3的索引
        int i = linkList.locateElem(3);
        System.out.println("查找到的索引为:"+i);
        //获取对应的数据
        if(i!=-1){
            System.out.println("获取到的数据为:"+linkList.getElem(i));
        }

        //清除数据
        linkList.clearList();
        //打印数组数据
        Util.printf(linkList);
        //打印数据长度
        System.out.println("数组长度:"+linkList.getLength());
        //判断是否为空
        System.out.println("数组是否为空:"+linkList.isEmpty());


    }
}
