/**
 * 
 */
package test.data.struct.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author YMZ
 *
 * @return the 
 */
public class TestSort {

    private static final int SELECT_TYPE = 0x01;    //��ѡ������

    private static final int BUBBLE_TYPE = 0x02;    //ð������

    private static final int INSERT1_TYPE = 0x03;   //ֱ�Ӳ�������

    private static final int INSERT2_TYPE = 0x04;   //ֱ�Ӳ�������

    private static final int QUICK_TYPE = 0x05;     //��������

    private static final int HEER_TYPE = 0x06;      //ϣ������

    private static final int STACK_TYPE = 0x07;     //������

    private static final int MEGER_TYPE = 0x08;     //�鲢����

    private int[] array = new int[]{34, 5, 3, 2, 78, 5, 88, 9, 12, 10, 5, 5};

    private int count = 0;  //��¼ÿ���㷨ִ�еĴ������Ƚ��㷨��ʱ�临�Ӷ�
    /**
     * ѡ������
     * ˼��:ѡ��һ��Ԫ����Ϊ�ο�ֵ������Ԫ����֮��Ƚϣ����С���������С���滻����
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
     * ð������--����
     * ˼��:ǰ������Ԫ�رȽϣ����ǰ��ıȺ���Ĵ������λ�ã������Ԫ�ر��������
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
     * ֱ�Ӳ�������
     * ˼��:ǰ���ź��򣬺�һ��Ԫ����ǰ���ź���������в��룬�����ʼ�жϲ���λ��
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
     * ���ַ���������
     * ˼��:ǰ���ź��򣬺�һ��Ԫ����ǰ���ź���������в��룬���м俪ʼ�жϲ���λ��,�ҵ�λ��֮�󣬿�ʼ��λ����
     * ������ʾ����Ҫ����������λ����������ʱ�临�ӶȽϸ�
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
     * ��������
     * ˼��:ѡ��һ������������������������Ҳ࣬����С�Ļ��ߵ������ģ�������࣬���εݹ�
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
     * ���ѡ��һ������,���˻�������������leftλ�ý��п�������
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
     * �����е����������Ľ�������
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
     * ϣ������
     * ˼��:���ڲ��ȶ����򣬸��ݲ�ͬ�������������ݱȽϣ������ܶ�ԽС������Խ�ȶ�
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
     * ������
     * ʱ�临�Ӷ� nlog2^n
     * ˵��:��㲻С�������Һ���Ϊ��ѣ���㲻�������Һ���ΪС��
     * ˼��:������ȫ����������ѵĸ��ڵ�϶�Ϊ���ֵ������ŵ����е�β�������ι�����ѣ��õ����ڵ㣬�������
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
     * �������
     * 
     */
    private int[] buildMaxStack(int[] array) {
        for(int i = (array.length - 2)/2; i >= 0; i--){  //���ҵ�ǰ�������е����ֵ��root���
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
        int temp = array[k];    //���浱ǰ�����
        for(int i = 2*k + 1; i < length-1; i = 2*i+1){
            count++;
            if(i < length && array[i] < array[i+1]){  //��ǰ�������Һ��ӽ��бȽ�
                i++;
            }
            if(temp < array[i]){    //��ǰ���С���Һ���
                swapArrayNum(array, k, i);
                k = i;
            }else{
                break;
            }
        }
    }

    /**
     * �鲢����
     * ˼��:��һ�����鲻�ϵض��֣�Ȼ�������������ֵ����飬�����ȽϺϲ������ó�һ���µ���������
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
            MegerSort(newArray, left, middle);  //����Ϊ��������
            MegerSort(newArray, middle+1, right);   //����Ϊ�Ҳ������
            meger(newArray,left,middle,right);  //������������кϲ�����
        }
    }

    /**
     * @param newArray
     * @param left
     * @param right
     */
    private void meger(int[] newArray, int left, int middle, int right) {
        int[] tmpArray = new int[newArray.length];
        int rightStart = middle+1;  //��¼�ڶ������������±꣬leftΪ��һ�����������±�
        int temp = left;    //�����鱻��ֵʱ���õ��±�
        int index = left;   //������copy��ԭ���飬������±�
        while(left <= middle && rightStart <= right){   //��ֹ���������±�Խ��
            count++;
            if(newArray[left] < newArray[rightStart]){  //������Ԫ��С���Ҳ�Ԫ�أ������Ԫ���ȷ���������
                tmpArray[temp++] = newArray[left++];
            }else{      //����Ҳ�Ԫ��С�����Ԫ�أ����Ҳ�Ԫ�ط���������
                tmpArray[temp++] = newArray[rightStart++];
            }
        }
        while(left <= middle && temp <= right){ //������������Ȼ�����ݣ��򽫺���Ԫ��ֱ��copy��������
            count++;
            tmpArray[temp++] = newArray[left++];
        }
        while(rightStart <= right && temp <= right){ //����Ҳ�������Ȼ�����ݣ��򽫺���Ԫ��ֱ��copy��������
            count++;
            tmpArray[temp++] = newArray[rightStart++];
        }
        while(index <= right){  //������õ��������¸�ֵ��ԭ����
            newArray[index] = tmpArray[index++];
        }
    }

    /**
     * ��������
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
        default:
            break;
        }
    }

    /**
     * ��ӡ����
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
