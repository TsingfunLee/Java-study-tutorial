import java.util.Scanner;


public class T005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);//����һ�����ʵ��
        System.out.println("������һ���ַ�����");
        String aStr=scanner.nextLine();
        System.out.println("������Ҫ���еĲ�����1-ת���ɴ�д��2-ת����Сд");
        String cStr=scanner.nextLine();
        int a=Integer.parseInt(cStr);
        String bStr = null;
		if(a==1)
            bStr=aStr.toUpperCase();
        if(a==2)
            bStr=aStr.toLowerCase();
        if(a!=1&a!=2)
        	System.out.println("Error!������Ҫ���еĲ�����");
        System.out.println(bStr);
//        String bStr=scanner.nextLine();
//        int a=Integer.parseInt(aStr);
//        int b=Integer.parseInt(bStr);
//        int max=a;
//        if(b>max)
//        	max=b;
//        System.out.println("���ֵ�ǣ�"+max);
	}

}
