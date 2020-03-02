package com.lyj.list;

import com.lyj.Util;

/**
 * 使用数组实现list
 */
public class ArrayList implements List {

    private Object[] array;//保存数据的数组

    private int length;//当前数据的长度

    private int size;//保存数据的大小

    @Override
    public void init(int size) {
        this.size=size;
        this.array=new Object[size];
    }

    @Override
    public void clearList() {
        //重新new一个数组即可
        array=new Object[size];
        //长度清零
        this.length=0;
    }

    @Override
    public void insert(int index,Object o) throws Exception {
        if(array==null){
            throw new Exception("请先初始化");
        }

        if(length==size){
            throw new Exception("数组已满");
        }

        if(index>size){
            throw new Exception("超出数组范围");
        }

        //将插入位置后面的数据全部往后移动一个位置
        for(int i=this.array.length-1;i>index;i--){
            this.array[i]=this.array[i-1];//前一个赋值给后一个
        }

        this.array[index]=o;
        length++;
    }

    @Override
    public void delete(int index) {

        //将后面的数据全部往前移动一个位置
        for(int i=index;i<this.array.length-1;i++){
            this.array[i]=this.array[i+1];
        }

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

        for(int i=0;i<this.length;i++){
            if((int)this.array[i]==(int)o){
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

        return this.array[index];
    }


    //测试
    public static void main(String[] args) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.init(10);

        //连续插入5个数据
        for(int i=0;i<5;i++){
            arrayList.insert(i,i);
        }

        //单纯插入一个数据
        arrayList.insert(2,10);

        //打印数组数据
        Util.printf(arrayList);
        //打印数据长度
        System.out.println("数组长度:"+arrayList.getLength());


        //删除一个数据
        arrayList.delete(3);
        //打印数组数据
        Util.printf(arrayList);
        //打印数据长度
        System.out.println("数组长度:"+arrayList.getLength());

        //查找数据为3的索引
        int i = arrayList.locateElem(3);
        System.out.println("查找到的索引为:"+i);
        //获取对应的数据
        if(i!=-1){
            System.out.println("获取到的数据为:"+arrayList.getElem(i));
        }

        //清除数据
        arrayList.clearList();
        //打印数组数据
        Util.printf(arrayList);
        //打印数据长度
        System.out.println("数组长度:"+arrayList.getLength());
        //判断是否为空
        System.out.println("数组是否为空:"+arrayList.isEmpty());


    }


}
