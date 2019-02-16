/**
 * 
 */
package test.data.struct.algorithm;

/**
 * @author YMZ
 * 动态规划问题 
 */
public class DynamicProblem {



    /**
     * 求解最长子序列
     */
    public void Lsc(String A, String B){
        StringBuffer sb = new StringBuffer();
        int m = A.length();
        int n = B.length();
        int x = 1;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] db = new int[m][n];
        for(int i = 0; i < m; i++){ //第一列
            if(a[i] == b[0]){
                db[i][0] = 1;
                for(int j = i+1; j < m; j++){
                    db[j][0] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){ //第一行
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

        System.out.println("最长子序列长度为: "+db[m-1][n-1]);
        System.out.println("最长子序列为: "+sb.toString());
    }

}
