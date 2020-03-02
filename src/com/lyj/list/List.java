package com.lyj.list;

/**
 * 定义list接口
 */
public interface List {

    void init(int size);

    void clearList();

    //在指定的位置插入数据
    void insert(int index,Object o) throws Exception;

    //删除指定位置的数据
    void delete(int index);

    boolean isEmpty();

    int getLength();

    int locateElem(Object o);

    Object getElem(int i);
}
