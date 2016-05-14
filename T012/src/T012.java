import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

/*ͼƬ����ʾ
 * 1.����ͼƬ��Ӳ��->�ڴ�
 */
public class T012 extends JFrame implements ActionListener{
	private JToolBar   toolBar;                      
	private JButton    suoxiaoButton,fangdaButton;
	private JButton    scaleButton;
	private JButton    shunRotateBotton,niRotateButton;
	private JButton    leftShearButton,rightShearButton,
	                    upShearButton,downShearButton;
	private ImagePanel ip;
	private float     bili=1;
	private int       jiaodu=0;
	private float     qingdux=0,qingduy=0;
	public T012(){
		this.setSize(600,450);                   //���ô��ڵĴ�С
		suoxiaoButton=new JButton("��С");       //��ʼ����ť
		fangdaButton=new JButton("�Ŵ�");
		scaleButton=new JButton("����");
		shunRotateBotton=new JButton("˳ʱ��");
		niRotateButton=new JButton("��ʱ��");
		leftShearButton=new JButton("����");
		rightShearButton=new JButton("����");
		upShearButton=new JButton("����");
		downShearButton=new JButton("����");
		toolBar=new JToolBar();                  //��ʼ��������
		toolBar.add(suoxiaoButton);               //�Ѱ�ť��ӵ�����������
		toolBar.add(fangdaButton);
		toolBar.add(scaleButton);
		toolBar.add(shunRotateBotton);
		toolBar.add(niRotateButton);
		toolBar.add(leftShearButton);
		toolBar.add(rightShearButton);
		toolBar.add(upShearButton);
		toolBar.add(downShearButton);
		this.setLayout(new BorderLayout());      //���ò���
		this.add(toolBar,BorderLayout.NORTH);
		ip=new ImagePanel();                     //��ʼ������
		this.add(ip,BorderLayout.CENTER);        //�ѻ�������м�
		suoxiaoButton.addActionListener(this);   //��������
		fangdaButton.addActionListener(this);
		scaleButton.addActionListener(this);
		shunRotateBotton.addActionListener(this);
		niRotateButton.addActionListener(this);
		leftShearButton.addActionListener(this);
		rightShearButton.addActionListener(this);
		upShearButton.addActionListener(this);
		downShearButton.addActionListener(this);
	}
	public class ImagePanel extends JComponent{//Alt+Shift+S

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//g.drawLine(0, 0, 100, 100);
			Image img1=Toolkit.getDefaultToolkit().getImage("tupian.jpg");
			int w=(int) (img1.getWidth(this)*bili);        //ͼƬ�Ŀ�
			int h=(int) (img1.getHeight(this)*bili);       //ͼƬ�ĸ�
			Graphics2D g2=(Graphics2D)g;                    //��ȡ�����2D����
		    g2.rotate(Math.toRadians(jiaodu),w/2,h/2);
		    g2.shear(qingdux, qingduy);
			g2.drawImage(img1, 0, 0,w,h,this);               //��ʾͼƬ
		}		
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==suoxiaoButton){                   //��������С
			bili=(float) (bili*0.8);                          //������Ϊԭ����0.8
			ip.repaint();                                   //ˢ��
		}
		if(e.getSource()==fangdaButton){                    //�������Ŵ�
			bili=(float) (bili*1.1);                        //������Ϊԭ����1.1
			ip.repaint();                                   //ˢ��
		}
		if(e.getSource()==scaleButton){
			String inputValue=JOptionPane.showInputDialog("������һ����ֵ");
			float f=Float.parseFloat(inputValue);
			bili=(float) (bili*f);                          //������Ϊԭ����f��
			ip.repaint(); 
		}
		if(e.getSource()==shunRotateBotton){
			jiaodu=jiaodu+45;
			ip.repaint();
		}
		if(e.getSource()==niRotateButton){
			jiaodu=jiaodu-45;
			ip.repaint();
		}
		if(e.getSource()==leftShearButton){
			qingdux=(float) (qingdux-0.5);
			ip.repaint();
		}
		if(e.getSource()==rightShearButton){
			qingdux=(float) (qingdux+0.5);
			ip.repaint();
		}
		if(e.getSource()==upShearButton){
			qingduy=(float) (qingduy+0.5);
			ip.repaint();
		}
		if(e.getSource()==downShearButton){
			qingduy=(float) (qingduy-0.5);
			ip.repaint();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        T012 t012=new T012();
        t012.setVisible(true);
	}

}
