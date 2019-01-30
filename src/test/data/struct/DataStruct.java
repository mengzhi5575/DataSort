package test.data.struct;

import test.data.struct.sort.TestSort;


public class DataStruct {

    public static void main(String[] args){
        System.out.println("Hello world!");

        //算法运算
        TestSort sort = new TestSort();
        sort.selectSort();
        sort.bubbleSort();
        sort.inserSort1();
        sort.insetSort2();
        sort.quickSort();
        sort.heerSort();
        sort.stackSOrt();
        sort.megerSort();
        sort.basicSort();
        sort.negBasicSort();
        //算法运算 End
    }

}
