import java.util.Scanner;

public class T006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个数字：");
		String aStr=scanner.nextLine();
		int j=Integer.parseInt(aStr);
		int sum=0;
        for(int i=2;i<=j;i=i+2){
        	sum=sum+i;
        }
        System.out.println("总和为："+sum);
	}

}
