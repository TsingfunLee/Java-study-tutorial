import java.util.Scanner;


public class T004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);//����һ�����ʵ��
        System.out.println("�������һ������");
        String aStr=scanner.nextLine();
        System.out.println("������ڶ�������");
        String bStr=scanner.nextLine();
        int a=Integer.parseInt(aStr);
        int b=Integer.parseInt(bStr);
        int max=a;
        if(b>max)
        	max=b;
        System.out.println("���ֵ�ǣ�"+max);
	}

}
