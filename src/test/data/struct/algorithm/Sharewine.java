package test.data.struct.algorithm;

public class Sharewine {

    private int b1 = 12;

    private int b2 = 8;

    private int b3 = 5;

    private int target = 6;
/**
 * 泊松分酒 --- 穷举法
 * @param target
 */
    public Sharewine(int target) {
        this.target = target;
    }
    public void backBottle(int bb1, int bb2, int bb3) {
        System.out.println("bb1:"+bb1+" bb2:"+bb2+" bb3:"+bb3);
        if(bb1 == target || bb2 == target || bb3 == target) {
            System.out.println("find the target.");
            return;
        }
        if(bb2 != 0 && bb3 != b3) {
            if(bb2+bb3 <= b3) {
                //从瓶子2 ---> 3,且倒不满瓶子3
                backBottle(bb1, 0, bb2+bb3);
            }else {
                //从瓶子2 ---> 3,可以倒满瓶子3
                backBottle(bb1, bb2-(b3-bb3), b3);
            }
        }else if(bb3 == b3) {
            if(bb1+bb3 <= b1) {
                //从瓶子3 ---> 1,且倒不满瓶子1
                backBottle(bb1+bb3, bb2, 0);
            }else {
                //从瓶子3 ---> 1,可以倒满瓶子1
                backBottle(b1, bb2, bb3-(b1-bb1));
            }
        }else if(bb2 == 0) {
            if(bb1 <= b2) {
                //从瓶子1 ---> 2,且倒不满瓶子2
                backBottle(0, bb1, bb3);
                
            }else {
                //从瓶子1 ---> 2,可以倒满瓶子2
                backBottle(bb1-b2, b2, bb3);
            }
        }
    }
}
