/**
 * 
 */
package test.data.struct.algorithm;

/**
 * @author YMZ
 *
 * @return the 
 */
public class KillNode {

    private static final int PEOPLE = 20;   //20个人玩游戏

    private static final int COUNT = 5;     //每数5下，kill掉第5人

    /**
     * 约瑟夫杀人法
     */
    private class Node{
        int val;
        Node next;
        /**
         * @param i
         */
        public Node(int val) {
            this.val = val;
        }
    }

    public void killPerson(){
        int n = 1;
        Node header = new Node(1);
        Node x = header;
        for(int i = 2; i <= PEOPLE; i++){
            x = x.next = new Node(i);
        }
        //头尾相接，形成环形
        x.next = header;
        while(x != x.next){ //不是最后一人
            for(int i = 1; i < COUNT; i++){
                x = x.next; //x为数到的第4人
            }
            System.out.println("第"+n+++"个被kill的人是: "+x.next.val);
            x.next = x.next.next;   //把数到的下一位kill掉，即第五位
        }
        System.out.println("最后的幸运儿: "+x.val);
    }
}
