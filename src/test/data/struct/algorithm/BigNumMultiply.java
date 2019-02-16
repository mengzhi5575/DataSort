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
     * �����������--����һ
     */
    public void multiply(){
        //����������ת�����ַ�����
        char[] num1 = A.toCharArray();
        char[] num2 = B.toCharArray();

        int asize = num1.length + num2.length;
        int[] save = new int[asize];    //������������

        //���Ƚ������������иߵ�λ�Ե�
        swap(num1,num1.length);
        swap(num2,num2.length);

        //���������������������
        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num2.length; j++){
                /**
                 * ���Ĳ���
                 * eg:��123*999 ��λ�ϵ���
                 * C[2,0] C[0,2] C[1,1]
                 * ��λֵ��ʱ����
                 * 
                 */
                save[i+j] += Integer.valueOf(String.valueOf(num1[i])) * Integer.valueOf(String.valueOf(num2[j]));
            }
        }

        //��ȡÿ��λ�ϵ�ֵ
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
     * �������--������
     * 
     */
    public void multiply2(){
        //����������ת�����ַ�����
        char[] num1 = A.toCharArray();
        char[] num2 = B.toCharArray();

        int asize = num1.length + num2.length;
        int[] save = new int[asize];    //������������

        for(int i = 0; i < num1.length; i++){
            for(int j = 0; j < num2.length; j++){
                save[i+j+1] += Integer.valueOf(String.valueOf(num1[i])) * Integer.valueOf(String.valueOf(num2[j]));
            }
        }

        //��λ����
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
