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

    private int num = 0; //累计方案

    private int[] cols = new int[MAXQUEEN]; //记录放置八皇后的位置下标
    /**
     * 八皇后问题
     * 在8*8的棋盘中,每行每列，斜对角都不允许有重复的八皇后
     */
    public void Queen(int n){
        //定义每个方格是否可以放置八皇后，true 不允许放置，false 允许放置
        boolean[] rows = new boolean[MAXQUEEN];
        for(int m = 0; m < n; m++){
            rows[cols[m]] = true;   //放置八皇后的位置被记录
            //被放置八皇后的位置的斜对角也要被记录
            int d = n - m;
            //正斜对角
            if(cols[m]-d >= 0){
                rows[cols[m]-d] = true;
            }
            //反斜对角
            if(cols[m]+d < MAXQUEEN){
                rows[cols[m]+d] = true;
            }
        }

        for(int i = 0; i < MAXQUEEN; i++){
            if(rows[i]){
                continue;
            }
            //可以放置八皇后的位置
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
        System.out.println("第"+num+"种方案:");
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
