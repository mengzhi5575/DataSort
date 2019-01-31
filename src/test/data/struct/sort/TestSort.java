/**
 * 
 */
package test.data.struct.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author YMZ
 *
 * @return the 
 */
public class TestSort {

    private static final int SELECT_TYPE = 0x01;    //简单选择排序

    private static final int BUBBLE_TYPE = 0x02;    //冒泡排序

    private static final int INSERT1_TYPE = 0x03;   //直接插入排序

    private static final int INSERT2_TYPE = 0x04;   //直接插入排序

    private static final int QUICK_TYPE = 0x05;     //快速排序

    private static final int HEER_TYPE = 0x06;      //希尔排序

    private static final int STACK_TYPE = 0x07;     //堆排序

    private static final int MEGER_TYPE = 0x08;     //归并排序

    private static final int BASIC_TYPE = 0x09;     //基数排序

    private int[] array = new int[]{34, 5, 3, 2, 78, 5, 88, 9, 12, 10, 5, 5};

    private int count = 0;  //记录每种算法执行的次数，比较算法的时间复杂度
    /**
     * 选择排序
     * 思想:选择一个元素作为参考值，其余元素与之相比较，如果小于它，则把小的替换进来
     */
    public void selectSort(){
        int[] newarray = array.clone();
        count = 0;
        int min = 0;
        int len = newarray.length;
        for(int i = 0; i < len; i++){
            min = newarray[i];
            for(int j = i+1; j < len; j++){
                count++;
                if(newarray[j] < min){
                    swapArrayNum(newarray, i, j);
                }
            }
        }
        print(newarray,SELECT_TYPE,true);
    }

    /**
     * 冒泡排序--降序
     * 思想:前后两个元素比较，如果前面的比后面的大，则调换位置，后面的元素变成了最大的
     */
    public void bubbleSort(){
        int[] newarray = array.clone();
        count = 0;
        int len = newarray.length;
        for(int i = 0; i < len ; i++){
            for(int j = 0; j < len-i-1; j++){
                count++;
                if(newarray[j] > newarray[j+1]){
                    swapArrayNum(newarray, j, j+1);
                }
            }
        }
        print(newarray,BUBBLE_TYPE,true);
    }

    /**
     * 直接插入排序
     * 思想:前面排好序，后一个元素往前面排好序的数组中插入，从最后开始判断插入位置
     */
    public void inserSort1(){
        count = 0;
        int[] newarray = array.clone();
        for(int i = 1; i < newarray.length; i++){
            for(int j = i; j >= 1; j--){
                count++;
                if(newarray[j] < newarray[j-1]){
                    swapArrayNum(newarray, j-1, j);
                }else{
                    break;
                }
            }
        }
        print(newarray,INSERT1_TYPE,true);
    }

    /**
     * 二分法插入排序
     * 思想:前面排好序，后一个元素往前面排好序的数组中插入，从中间开始判断插入位置,找到位置之后，开始移位操作
     * 数组演示，需要进行数组移位操作，所以时间复杂度较高
     */
    public void insetSort2(){
        count = 0;
        int mid = 0, left, right;
        int[] newarray = array.clone();
        for(int i = 1; i < newarray.length; i ++){
            int temp = newarray[i];
            left = 0;
            right = i-1;
            while(left <= right){
                count++;
                mid = (left+right)/2;
                if(temp < newarray[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            for(int j = i; j > left; j--){
                count++;
                newarray[j] = newarray[j-1];
            }
            if(left != i){
                newarray[left] = temp;
            }
        }
        print(newarray, INSERT2_TYPE, true);
    }

    /**
     * 
     * 快速排序
     * 思想:选择一个基数，将比它大的数放在右侧，比它小的或者等于它的，放在左侧，依次递归
     */
    public void quickSort(){
        count = 0;
        int[] newarray = array.clone();
        if(newarray == null || newarray.length <= 1){
            return;
        }
        QuickSort(newarray,0,newarray.length-1);
        print(newarray, QUICK_TYPE, true);
    }

    private void QuickSort(int[] array, int left, int right){
        if(left < right){
//            int i = division(array, left, right);
            int i = RandomNum(array,left,right);
            QuickSort(array, left, i-1);
            QuickSort(array,i+1,right);
        }
    }

    private int division(int[] array, int left, int right){
        int baseNum = array[left];
        while(left < right){
            count++;
            while((left < right) && (array[right] > baseNum)){
                count++;
                right -= 1;
            }
            array[left] = array[right];
            while((left < right) && array[left] <= baseNum){
                count++;
                left += 1;
            }
            array[right] = array[left];
        }
        array[left] = baseNum;
        return left;
    }

    /**
     * 随机选择一个基数,将此基数交换到数组left位置进行快速排序
     */
    private int RandomNum(int[] array, int left, int right){
        Random random = new Random();
        int random_index = random.nextInt(right-left+1)+left;
        if(random_index != left){
            swapArrayNum(array, random_index, left);
        }
        return division(array,left,right);
    }

    /**
     * 数组中的两个变量的交换函数
     * int[] a b
     */
    private void swapArrayNum(int[] array, int a, int b){
        if(a == b){
            return;
        }
        array[a] = array[a] + array[b];
        array[b] = array[a] - array[b];
        array[a] = array[a] - array[b];
    }

    /**
     * 希尔排序
     * 思想:属于不稳定排序，根据不同的增量进行数据比较，增量密度越小，排序越稳定
     */
    public void heerSort(){
        count = 0;
        int[] newarray = array.clone();
        int inc = newarray.length / 2;
        while(inc > 0){
            for(int i = 0; i + inc < newarray.length; i++){
                count++;
                if(newarray[i] > newarray[i+inc]){
                    swapArrayNum(newarray, i , i+inc);
                }
            }
            inc--;
        }
        print(newarray, HEER_TYPE, true);
    }

    /**
     * 堆排序
     * 时间复杂度 nlog2^n
     * 说明:结点不小于其左右孩子为大堆，结点不大于左右孩子为小堆
     * 思想:借助完全二叉树，大堆的根节点肯定为最大值，将其放到序列的尾部，依次构建大堆，拿到根节点，完成排序
     */
    public void stackSOrt(){
        count = 0;
        int[] newarray = array.clone();
        if(newarray == null || newarray.length <= 1){
            return;
        }
        int[] stackArray = buildMaxStack(newarray);
        for(int i = stackArray.length-1; i > 1; i--){
            swapArrayNum(stackArray, 0, i);
            adjustMaxParent(stackArray, 0, i);
        }
        print(newarray, STACK_TYPE, true);
    }

    /**
     * 构建大堆
     * 
     */
    private int[] buildMaxStack(int[] array) {
        for(int i = (array.length - 2)/2; i >= 0; i--){  //查找当前二叉树中的最大值到root结点
            adjustMaxParent(array, i, array.length);
        }
        return array;
    }

    /**
     * @param array2
     * @param i
     * @param length
     */
    private void adjustMaxParent(int[] array, int k, int length) {
        int temp = array[k];    //保存当前父结点
        for(int i = 2*k + 1; i < length-1; i = 2*i+1){
            count++;
            if(i < length && array[i] < array[i+1]){  //当前结点的左右孩子进行比较
                i++;
            }
            if(temp < array[i]){    //当前结点小于右孩子
                swapArrayNum(array, k, i);
                k = i;
            }else{
                break;
            }
        }
    }

    /**
     * 归并排序
     * 思想:将一个数组不断地二分，然后将无数个被二分的数组，两两比较合并，最后得出一个新的有序数组
     * 
     */
    public void megerSort(){
        count = 0;
        int[] newArray = array.clone();
        if(newArray.length < 1){
            return;
        }
        MegerSort(newArray,0,newArray.length-1);
        print(newArray, MEGER_TYPE, true);
    }

    /**
     * @param newArray
     * @param i
     * @param j
     */
    private void MegerSort(int[] newArray, int left, int right) {
        if(left < right){
            int middle = (left + right)/2;
            MegerSort(newArray, left, middle);  //被分为左侧的数组
            MegerSort(newArray, middle+1, right);   //被分为右侧的数组
            meger(newArray,left,middle,right);  //将左右数组进行合并操作
        }
    }

    /**
     * @param newArray
     * @param left
     * @param right
     */
    private void meger(int[] newArray, int left, int middle, int right) {
        int[] tmpArray = new int[newArray.length];
        int rightStart = middle+1;  //记录第二个数组的起点下标，left为第一个数组的起点下标
        int temp = left;    //新数组被赋值时所用的下标
        int index = left;   //新数组copy回原数组，定义的下标
        while(left <= middle && rightStart <= right){   //防止左右数组下标越界
            count++;
            if(newArray[left] < newArray[rightStart]){  //如果左侧元素小于右侧元素，则将左侧元素先放入新数组
                tmpArray[temp++] = newArray[left++];
            }else{      //如果右侧元素小于左侧元素，则将右侧元素放入新数组
                tmpArray[temp++] = newArray[rightStart++];
            }
        }
        while(left <= middle && temp <= right){ //如果左侧数组依然有数据，则将后续元素直接copy到新数组
            count++;
            tmpArray[temp++] = newArray[left++];
        }
        while(rightStart <= right && temp <= right){ //如果右侧数组依然有数据，则将后续元素直接copy到新数组
            count++;
            tmpArray[temp++] = newArray[rightStart++];
        }
        while(index <= right){  //将排序好的数组重新赋值回原数组
            newArray[index] = tmpArray[index++];
        }
    }

    /**
     * 基数排序
     * 思想:将数据按照个位，十位，百位的顺序一次进行排序
     * 34, 5, 3, 2, 78, 5, 88, 9, 12, 10, 5, 5
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void basicSort(){
        count = 0;
        int[] newArray = array.clone();
        if(newArray.length <= 1 || newArray == null){
            return;
        }
        List<ArrayList> list = new ArrayList<ArrayList>();
        int max = newArray[0];
        for(int e : newArray){  //拿到数组中的最大值
            if(max < e){
                max = e;
            }
        }
        int times = 0;
        while(max > 0){     //根据最大值计算需要进行几次基数排列
            max = max / 10;
            times++;
        }
        for(int i = 0; i < 10; i++){    //创建一个添加10个动态数组
            ArrayList array = new ArrayList<>();
            list.add(array);
        }
        for(int exp = 0; exp < times; exp++){     //进行基数排序
            //根据对应计算的基数，将其按位置进行安放
            for(int i = 0; i < newArray.length; i++){
                //获取对应的位数，exp为0获取个位，为1获取十位，为2获取千位
                int x = newArray[i]%(int)Math.pow(10, exp+1)/(int)Math.pow(10,exp);
                ArrayList array = list.get(x);    //获取对应位数的存放的动态数组
                array.add(newArray[i]); //根据对应位数上的数字，存放到对应的位置
                list.set(x, array); //为何动态数组的元素是动态数组要进行此操作？
            }
          //依次从对应的动态数组中获取对应的值，重新放回数组中
            int count = 0;
            for(int k = 0; k < 10; k++){
                while(list.get(k).size() > 0){
                    newArray[count++] = (int) list.get(k).get(0);
                    list.get(k).remove(0);
                }
            }
        }
        print(newArray,BASIC_TYPE,true);
    }

    /**
     * 基数排序
     * 负数依然可以正常排序
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void negBasicSort(){
        count = 0;
        int[] newArray = array.clone();
        if(newArray.length <= 1 || newArray == null){
            return;
        }
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        int m = 0, n = 0;
        //划分数组，区分负数和正数
        for(int i = 0; i < newArray.length; i++){
            if(newArray[i] < 0){
                neg.add(newArray[i]);
            }else{
                pos.add(newArray[i]);
            }
        }
        int[] negArray = new int[neg.size()],posArray = new int[pos.size()];
        for(int i = 0; i < neg.size(); i++){
            negArray[i] = neg.get(i);
        }
        for(int i = 0; i < pos.size(); i++){
            posArray[i] = pos.get(i);
        }
        //获取数组中的最大值
        int posMax = 0;
        if(posArray.length > 0) {
            posMax = posArray[0];
        }
        for(int i = 0; i < posArray.length; i ++){
            if(posMax < posArray[i]){
                posMax = posArray[i];
            }
        }
        int negMax = 0;
        if(negArray.length > 0) {
           negMax = negArray[0];
        }
         
        for(int i = 0; i < negArray.length; i++){
            if(negMax < Math.abs(newArray[i])){
                negMax = Math.abs(newArray[i]);
            }
        }
        //获取需要进行基数遍历的次数
        int posTimes = 0, negTimes = 0;
        while(posMax > 0){
            posMax /= 10;
            posTimes++;
        }
        while(negMax > 0){
            negMax /= 10;
            negTimes++;
        }
        //创建二维数组
        ArrayList<ArrayList> posList = new ArrayList<ArrayList>();
        ArrayList<ArrayList> negList = new ArrayList<ArrayList>();
        for(int i = 0; i < 10; i++){
            ArrayList<Integer> array = new ArrayList<>();
            posList.add(array);
            negList.add(array);
        }
        //正数进行基数
        for(int i = 0; i < posTimes; i++){
            for(int j = 0; j < posArray.length; j++){
                int x = posArray[j] % (int)(Math.pow(10, i+1)) / (int)(Math.pow(10, i));
                ArrayList q = posList.get(x);
                q.add(posArray[j]);
                posList.set(x, q);
            }
            int count = 0;
            for(int k = 0; k < 10; k++){
                while(posList.get(k).size() > 0){
                    posArray[count++] = (int) posList.get(k).get(0);
                    posList.get(k).remove(0);
                }
            }
        }
        //负数排序
        for(int i = 0; i < negTimes; i++){
            for(int j = 0; j < negArray.length; j++){
                int x = Math.abs(negArray[j]) % (int)(Math.pow(10, i+1)) / (int)(Math.pow(10, i));
                ArrayList q = negList.get(x);
                q.add(negArray[j]);
                negList.set(x,q);
            }
            int count = 0;
            for(int k = 0; k < 10; k++){
                while(negList.get(k).size() > 0){
                    negArray[count++] = (int) negList.get(k).get(0);
                    negList.get(k).remove(0);
                }
            }
        }
            int temp = 0;
            for(int x = negArray.length; x > 0;x--){
                newArray[temp++] = negArray[x-1];
            }
            for(int y = 0; y < posArray.length; y++){
                newArray[temp++] = posArray[y];
        }
        print(newArray, BASIC_TYPE, true);
    }
    /**
     * 遍历排序
     * h: true
     * v: false
     */
    private void print(int[] array, int type, boolean hv){
        System.out.println();
        switch (type) {
        case SELECT_TYPE:
            print(array, "select", hv);
            break;
        case BUBBLE_TYPE:
            print(array,"bubble",hv);
            break;
        case INSERT1_TYPE:
            print(array,"insert1",hv);
            break;
        case INSERT2_TYPE:
            print(array,"insert2",hv);
            break;
        case QUICK_TYPE:
            print(array,"quick",hv);
            break;
        case HEER_TYPE:
            print(array,"heer",hv);
            break;
        case STACK_TYPE:
            print(array,"stack",hv);
            break;
        case MEGER_TYPE:
            print(array,"meger",hv);
            break;
        case BASIC_TYPE:
            print(array,"basic",hv);
            break;
        default:
            break;
        }
    }

    /**
     * 打印遍历
     */
    private void print(int[] array,String type,boolean hv){
        if(hv){
            System.out.println(type+" count = "+count);
            for(int e:array){
                System.out.print(" "+e);
            }
        }else{
            System.out.println(type+" count = "+count);
            for(int e:array){
                System.out.println(" "+e);
            }
        }
    }
}
