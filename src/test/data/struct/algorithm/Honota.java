package test.data.struct.algorithm;

public class Honota {

	private int count = 1;

	/**
	 * 汉诺塔---递归法 
	 */
	public void honota(int n, char from, char dependon, char to) {
		if(n == 1) {
			move(1,from,to);//只有一个盘子时，直接从from移动到to
		}else {
			honota(n-1,from,to,dependon);//n-1个盘子借助to移动到dependon
			move(n, from, to);//直接将第n个盘子从from移动到to
			honota(n-1,dependon,from,to);//n-1个盘子借助from移动到to
		}
	}

	private void move(int n, char from, char to) {
		System.out.println("第"+count+++"步:"+from+"--->"+to);
	}
}
