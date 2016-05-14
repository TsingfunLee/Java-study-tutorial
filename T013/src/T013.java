import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

/*鼠标的事件*/

public class T013 extends JFrame implements ActionListener{
	
	public PainterPanel painter=new PainterPanel();     //定义绘图板
	public JToolBar     toolBar=new JToolBar();         //定义工具栏
	//定义按钮
	public JButton lineButton,ovalButton,rectButton; //直线，圆形，矩形  
	
	public T013(){
		this.setSize(600,450);       //设置窗口尺寸
		this.setTitle("绘图");       //设置窗口标题
		//初始化按钮
		lineButton=new JButton("直线");                  //直线
		ovalButton=new JButton("圆形");                  //圆形
		rectButton=new JButton("矩形");                  //矩形
		//把按钮添加到工具栏
		toolBar.add(lineButton);
		toolBar.add(ovalButton);
		toolBar.add(rectButton);
		//窗口布局
		this.setLayout(new BorderLayout());            
		this.add(toolBar,BorderLayout.NORTH);            //把工具栏添加到窗口中
		this.add(painter,BorderLayout.CENTER);           //把绘图面板添加到窗口中
		//绑定侦听器
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
