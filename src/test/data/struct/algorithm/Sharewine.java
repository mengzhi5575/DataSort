package test.data.struct.algorithm;

public class Sharewine {

    private int b1 = 12;

    private int b2 = 8;

    private int b3 = 5;

    private int target = 6;
/**
 * ���ɷ־� --- ��ٷ�
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
                //��ƿ��2 ---> 3,�ҵ�����ƿ��3
                backBottle(bb1, 0, bb2+bb3);
            }else {
                //��ƿ��2 ---> 3,���Ե���ƿ��3
                backBottle(bb1, bb2-(b3-bb3), b3);
            }
        }else if(bb3 == b3) {
            if(bb1+bb3 <= b1) {
                //��ƿ��3 ---> 1,�ҵ�����ƿ��1
                backBottle(bb1+bb3, bb2, 0);
            }else {
                //��ƿ��3 ---> 1,���Ե���ƿ��1
                backBottle(b1, bb2, bb3-(b1-bb1));
            }
        }else if(bb2 == 0) {
            if(bb1 <= b2) {
                //��ƿ��1 ---> 2,�ҵ�����ƿ��2
                backBottle(0, bb1, bb3);
                
            }else {
                //��ƿ��1 ---> 2,���Ե���ƿ��2
                backBottle(bb1-b2, b2, bb3);
            }
        }
    }
}
