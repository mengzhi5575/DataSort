package test.data.struct.algorithm;

public class Honota {

	private int count = 1;

	/**
	 * ��ŵ��---�ݹ鷨 
	 */
	public void honota(int n, char from, char dependon, char to) {
		if(n == 1) {
			move(1,from,to);//ֻ��һ������ʱ��ֱ�Ӵ�from�ƶ���to
		}else {
			honota(n-1,from,to,dependon);//n-1�����ӽ���to�ƶ���dependon
			move(n, from, to);//ֱ�ӽ���n�����Ӵ�from�ƶ���to
			honota(n-1,dependon,from,to);//n-1�����ӽ���from�ƶ���to
		}
	}

	private void move(int n, char from, char to) {
		System.out.println("��"+count+++"��:"+from+"--->"+to);
	}
}
