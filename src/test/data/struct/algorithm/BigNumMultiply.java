/**
 * 
 */
package test.data.struct.algorithm;

/**
 * @author YMZ
 *
 * @return the 
 */
public class BigNumMultiply {

    private String A = "123";//"1234567890987654321";

    private String B = "999";//"9876543210123456789";
    /**
     * 两个大数相乘--方法一
     */
    public void multiply(){
        //将两个大数转换成字符数组
        char[] num1 = A.toCharArray();
        char[] num2 = B.toCharArray();

        int asize = num1.length + num2.length;
        int[] save = new int[asize];    //保存结果的数组

        //首先将两个大数进行高低位对调
        swap(num1,num1.length);
        swap(num2,num2.length);

        //进行两个大数的相乘运算
        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num2.length; j++){
                /**
                 * 最经典的部分
                 * eg:求123*999 百位上的数
                 * C[2,0] C[0,2] C[1,1]
                 * 进位值暂时不管
                 * 
                 */
                save[i+j] += Integer.valueOf(String.valueOf(num1[i])) * Integer.valueOf(String.valueOf(num2[j]));
            }
        }

        //获取每个位上的值
        int m = 0;
        for(; m < asize-1; m++){
            int temp = save[m] / 10;
            save[m] %= 10;
            if(temp > 0){
                save[m+1] += temp;
            }
        }
        for(; m > 0;){
            if(save[m] > 0){
                break;
            }
            m--;
        }

        for(int n = m; n >= 0; n--){
            System.out.print(save[n]);
        }
    }

    private void swap(char[] array, int len){
        for(int i = 0; i < len/2; i++){
            array[i] += array[len-1-i];
            array[len-1-i] = (char) (array[i] - array[len-1-i]);
            array[i] = (char) (array[i] - array[len-1-i]);
        }
        System.out.println(String.valueOf(array));
    }

    /**
     * 大数相乘--方法二
     * 
     */
    public void multiply2(){
        //将两个大数转换成字符数组
        char[] num1 = A.toCharArray();
        char[] num2 = B.toCharArray();

        int asize = num1.length + num2.length;
        int[] save = new int[asize];    //保存结果的数组

        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num2.length; j++){
                save[i+j+1] += Integer.valueOf(String.valueOf(num1[i])) * Integer.valueOf(String.valueOf(num2[j]));
            }
        }

        //进位处理
        for(int i = asize-1; i > 0; i--){
            if(save[i] > 10){
                save[i-1] += save[i] / 10;
                save[i] %= 10;
            }
        }
        for(int i = 0; i < asize; i++){
            System.out.print(save[i]);
        }
    }

    public static void main(String[] args){
        BigNumMultiply mul = new BigNumMultiply();
        mul.multiply();
        mul.multiply2();
    }
}
