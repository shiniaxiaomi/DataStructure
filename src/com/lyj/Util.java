package com.lyj;

import com.lyj.list.List;

public class Util {


    //打印list的工具
    public static void printf(List list){
        for(int i=0;i<list.getLength();i++){
            System.out.println(list.getElem(i));
        }
    }

}
