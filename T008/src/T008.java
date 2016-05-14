import java.util.Scanner;

public class T008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个数字：");
		String aStr=scanner.nextLine();
		int n=Integer.parseInt(aStr);
		for(int i=0;i<=n;i++){
			for(int j=n;j>i;j--){
				System.out.print(" ");
			}
			System.out.print("*");
			for(int k=0;k<2*i-1;k++){
				System.out.print(" ");
			}
			if(i!=0)
			System.out.print("*");
			System.out.println();
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(" ");
			}
			System.out.print("*");
			for(int k=((n-1)*2-1);k>=2*i-1;k--){
				System.out.print(" ");
			}
			if(i!=n)
			System.out.print("*");
			System.out.println();
		}

	}

}
