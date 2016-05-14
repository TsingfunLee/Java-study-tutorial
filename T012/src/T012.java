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

/*图片的显示
 * 1.导入图片，硬盘->内存
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
		this.setSize(600,450);                   //设置窗口的大小
		suoxiaoButton=new JButton("缩小");       //初始化按钮
		fangdaButton=new JButton("放大");
		scaleButton=new JButton("缩放");
		shunRotateBotton=new JButton("顺时针");
		niRotateButton=new JButton("逆时针");
		leftShearButton=new JButton("左倾");
		rightShearButton=new JButton("右倾");
		upShearButton=new JButton("上倾");
		downShearButton=new JButton("下倾");
		toolBar=new JToolBar();                  //初始化工具栏
		toolBar.add(suoxiaoButton);               //把按钮添加到工具栏上面
		toolBar.add(fangdaButton);
		toolBar.add(scaleButton);
		toolBar.add(shunRotateBotton);
		toolBar.add(niRotateButton);
		toolBar.add(leftShearButton);
		toolBar.add(rightShearButton);
		toolBar.add(upShearButton);
		toolBar.add(downShearButton);
		this.setLayout(new BorderLayout());      //设置布局
		this.add(toolBar,BorderLayout.NORTH);
		ip=new ImagePanel();                     //初始化画板
		this.add(ip,BorderLayout.CENTER);        //把画板放在中间
		suoxiaoButton.addActionListener(this);   //绑定侦听器
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
			int w=(int) (img1.getWidth(this)*bili);        //图片的宽
			int h=(int) (img1.getHeight(this)*bili);       //图片的高
			Graphics2D g2=(Graphics2D)g;                    //获取画板的2D对象
		    g2.rotate(Math.toRadians(jiaodu),w/2,h/2);
		    g2.shear(qingdux, qingduy);
			g2.drawImage(img1, 0, 0,w,h,this);               //显示图片
		}		
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==suoxiaoButton){                   //如果点击缩小
			bili=(float) (bili*0.8);                          //比例变为原来的0.8
			ip.repaint();                                   //刷新
		}
		if(e.getSource()==fangdaButton){                    //如果点击放大
			bili=(float) (bili*1.1);                        //比例变为原来的1.1
			ip.repaint();                                   //刷新
		}
		if(e.getSource()==scaleButton){
			String inputValue=JOptionPane.showInputDialog("请输入一个数值");
			float f=Float.parseFloat(inputValue);
			bili=(float) (bili*f);                          //比例变为原来的f倍
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
