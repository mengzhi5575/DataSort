/**
 * 
 */
package test.data.struct.algorithm;

/**
 * @author YMZ
 * ��̬�滮���� 
 */
public class DynamicProblem {



    /**
     * ����������
     */
    public void Lsc(String A, String B){
        StringBuffer sb = new StringBuffer();
        int m = A.length();
        int n = B.length();
        int x = 1;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] db = new int[m][n];
        for(int i = 0; i < m; i++){ //��һ��
            if(a[i] == b[0]){
                db[i][0] = 1;
                for(int j = i+1; j < m; j++){
                    db[j][0] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){ //��һ��
            if(b[i] == a[0]){
                db[0][i] = 1;
                for(int j = i+1; j < n; j++){
                    db[0][j] = 1;
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(a[i] == b[j]){
                    db[i][j] = db[i-1][j-1] + 1;
                }else{
                    db[i][j] = Math.max(db[i-1][j], db[i][j-1]);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(db[i][j] == x){
                    x++;
                    sb.append(a[i]);
                }
                System.out.print(db[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("������г���Ϊ: "+db[m-1][n-1]);
        System.out.println("�������Ϊ: "+sb.toString());
    }

}
