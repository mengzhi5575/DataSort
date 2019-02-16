package test.data.struct;

import test.data.struct.sort.TestSort;


public class DataStruct {

    public static void main(String[] args){
        System.out.println("Hello world!");

        //算法运算
//        TestSort sort = new TestSort();
//        sort.selectSort();
//        sort.bubbleSort();
//        sort.inserSort1();
//        sort.insetSort2();
//        sort.quickSort();
//        sort.heerSort();
//        sort.stackSOrt();
//        sort.megerSort();
//        sort.basicSort();
//        sort.negBasicSort();
        //算法运算 End

        //动态规划Begin
//        DynamicProblem dynamic = new DynamicProblem();
//        dynamic.Lsc("android", "random");
        //动态规划End
        //回溯法Begin
//        BackTracking backtrack = new BackTracking();
//        backtrack.Queen(0);
        //回溯法End
        //约瑟夫杀人法Begin
        KillNode kill = new KillNode();
        kill.killPerson();
        //约瑟夫杀人法
    }

}
