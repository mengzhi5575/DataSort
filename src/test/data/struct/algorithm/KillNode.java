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

    private static final int PEOPLE = 20;   //20��������Ϸ

    private static final int COUNT = 5;     //ÿ��5�£�kill����5��

    /**
     * Լɪ��ɱ�˷�
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
        //ͷβ��ӣ��γɻ���
        x.next = header;
        while(x != x.next){ //�������һ��
            for(int i = 1; i < COUNT; i++){
                x = x.next; //xΪ�����ĵ�4��
            }
            System.out.println("��"+n+++"����kill������: "+x.next.val);
            x.next = x.next.next;   //����������һλkill����������λ
        }
        System.out.println("�������˶�: "+x.val);
    }
}
