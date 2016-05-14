import java.util.Scanner;


public class T005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);//定义一个类的实例
        System.out.println("请输入一个字符串：");
        String aStr=scanner.nextLine();
        System.out.println("请输入要进行的操作，1-转换成大写，2-转换成小写");
        String cStr=scanner.nextLine();
        int a=Integer.parseInt(cStr);
        String bStr = null;
		if(a==1)
            bStr=aStr.toUpperCase();
        if(a==2)
            bStr=aStr.toLowerCase();
        if(a!=1&a!=2)
        	System.out.println("Error!请输入要进行的操作！");
        System.out.println(bStr);
//        String bStr=scanner.nextLine();
//        int a=Integer.parseInt(aStr);
//        int b=Integer.parseInt(bStr);
//        int max=a;
//        if(b>max)
//        	max=b;
//        System.out.println("最大值是："+max);
	}

}
