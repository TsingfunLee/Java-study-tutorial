import java.util.Scanner;


public class T004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);//定义一个类的实例
        System.out.println("请输入第一个数：");
        String aStr=scanner.nextLine();
        System.out.println("请输入第二个数：");
        String bStr=scanner.nextLine();
        int a=Integer.parseInt(aStr);
        int b=Integer.parseInt(bStr);
        int max=a;
        if(b>max)
        	max=b;
        System.out.println("最大值是："+max);
	}

}
