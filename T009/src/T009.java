import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class T009 extends JFrame {
	
	 private JTextField nText,mText,kText;              //���������ı���Ķ���
	 private JButton okButton;                               //����һ����ť����

	 public T009(){                                                //�������캯��
	 this.setSize(400, 300);                                   //���ô��ڳߴ�
	 this.setLayout(new BorderLayout());           //���ô��ڵĲ���
	    	    
	 mText=new JTextField(6);                           //��ʼ����һ���ı��򣬿��Ϊ6���ַ���
	 mText.setSize(50,25);                                   //���óߴ�
	 this.add(mText,BorderLayout.NORTH);      //���ı�����ӵ�������
	 nText=new JTextField(6);                            //��ʼ���ڶ����ı��򣬿��Ϊ6���ַ���
	 nText.setSize(50,25);                                    //���óߴ�
	 this.add(nText,BorderLayout.WEST);          //���ı�����ӵ�������
	    	    
	 okButton=new JButton("ȷ��");                       //��ʼ����ȷ������ť
	 okButton.setSize(50, 25);                                  //���ð�ť�ߴ�
	 this.add(okButton,BorderLayout.CENTER);     //�Ѱ�ť��ӵ�������
	 okButton.addActionListener(new ButtonListener());               //��ť��������
	    	    
	 kText=new JTextField(6);                              //��ʼ���ڶ����ı���
	 kText.setSize(100,25);                                    //���óߴ�
	 this.add(kText,BorderLayout.SOUTH);         //���ı�����ӵ�������
	 }
	    
	    class ButtonListener implements ActionListener{     //����һ��������

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("�㰴���˰�ť");
				String nStr=nText.getText();                   //��ȡ�ı�����ַ���
				String mStr=mText.getText();                 //��ȡ�ı�����ַ���
				//System.out.println("��������ǣ�"+nStr);
				int n=Integer.parseInt(nStr);                  //���ַ���ת��������
				int m=Integer.parseInt(mStr);                //���ַ���ת��������
				if(m>n){
					kText.setText("����");
				}
				else {
					int sum=0;                                            //���ڴ洢��ӵĺ�
				    for (int i = m; i <=n; i++) {                 //��m�ӵ�n
					sum=sum+i;
				    }
				//System.out.println("�ܺ��ǣ�"+sum);
				   kText.setText("�ܺ��ǣ�"+sum);
				}
			}
	    	
	    }
	    
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
        T009 t009=new T009();                              //�������ڶ���
        t009.setVisible(true);                                  //���ô���Ϊ�ɼ�
	}

}
