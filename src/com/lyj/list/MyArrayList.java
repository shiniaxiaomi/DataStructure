package com.lyj.list;

/**
 * 使用数组实现list
 */
public class MyArrayList implements List {

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
    }

    @Override
    public void insert(int index,Object o) throws Exception {
        if(array==null){
            throw new Exception("请先初始化");
        }

        if(length==size){
            throw new Exception("数组已满");
        }

        //将插入位置后面的数据全部往后移动
        for(int i=this.array.length;)

        for(int i=index+1;i<this.array.length;i++){


        }

        this.array[length]=o;
        length++;
    }

    @Override
    public void delete(int index) {
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

        for(int i=0;i<this.array.length;i++){
            if(this.array[i]==o){
                return i;
            }
        }

        return -1;
    }

    @Override
    public Object getElem(int i) {
        return this.array[i];
    }


    public static void main(String[] args) throws Exception {
        MyArrayList arrayList = new MyArrayList();
        arrayList.init(10);

        for(int i=0;i<10;i++){
            arrayList.insert(i);
        }

        Util.printf(arrayList);




    }


}
