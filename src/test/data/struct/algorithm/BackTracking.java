/**
 * 
 */
package test.data.struct.algorithm;

/**
 * @author YMZ
 *
 * @return the 
 */
public class BackTracking {

    private static final int MAXQUEEN = 8;

    private int num = 0; //�ۼƷ���

    private int[] cols = new int[MAXQUEEN]; //��¼���ð˻ʺ��λ���±�
    /**
     * �˻ʺ�����
     * ��8*8��������,ÿ��ÿ�У�б�ԽǶ����������ظ��İ˻ʺ�
     */
    public void Queen(int n){
        //����ÿ�������Ƿ���Է��ð˻ʺ�true ��������ã�false �������
        boolean[] rows = new boolean[MAXQUEEN];
        for(int m = 0; m < n; m++){
            rows[cols[m]] = true;   //���ð˻ʺ��λ�ñ���¼
            //�����ð˻ʺ��λ�õ�б�Խ�ҲҪ����¼
            int d = n - m;
            //��б�Խ�
            if(cols[m]-d >= 0){
                rows[cols[m]-d] = true;
            }
            //��б�Խ�
            if(cols[m]+d < MAXQUEEN){
                rows[cols[m]+d] = true;
            }
        }

        for(int i = 0; i < MAXQUEEN; i++){
            if(rows[i]){
                continue;
            }
            //���Է��ð˻ʺ��λ��
            cols[n] = i;
            if(n<MAXQUEEN-1){
                Queen(n+1);
            }else{
                num++;
                PrintQueen();
            }
        }
    }
    /**
     * 
     */
    private void PrintQueen() {
        System.out.println("��"+num+"�ַ���:");
        for(int i = 0; i < MAXQUEEN; i++){
            for(int j = 0; j < MAXQUEEN; j++){
                if(cols[j] == i){
                    System.out.print("8 ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

}
