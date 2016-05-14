import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

/*�����¼�*/

public class T013 extends JFrame implements ActionListener{
	
	public PainterPanel painter=new PainterPanel();     //�����ͼ��
	public JToolBar     toolBar=new JToolBar();         //���幤����
	//���尴ť
	public JButton lineButton,ovalButton,rectButton; //ֱ�ߣ�Բ�Σ�����  
	
	public T013(){
		this.setSize(600,450);       //���ô��ڳߴ�
		this.setTitle("��ͼ");       //���ô��ڱ���
		//��ʼ����ť
		lineButton=new JButton("ֱ��");                  //ֱ��
		ovalButton=new JButton("Բ��");                  //Բ��
		rectButton=new JButton("����");                  //����
		//�Ѱ�ť��ӵ�������
		toolBar.add(lineButton);
		toolBar.add(ovalButton);
		toolBar.add(rectButton);
		//���ڲ���
		this.setLayout(new BorderLayout());            
		this.add(toolBar,BorderLayout.NORTH);            //�ѹ�������ӵ�������
		this.add(painter,BorderLayout.CENTER);           //�ѻ�ͼ�����ӵ�������
		//��������
		lineButton.addActionListener(this);
		ovalButton.addActionListener(this);
		rectButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lineButton){
			painter.typeInt=1;
		}
		if(e.getSource()==ovalButton){
			painter.typeInt=2;
		}
		if(e.getSource()==rectButton){
			painter.typeInt=3;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        T013 t013=new T013();
        t013.setVisible(true);
	}

	

}
