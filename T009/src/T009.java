import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class T009 extends JFrame {
	
	 private JTextField nText,mText,kText;              //声明两个文本框的对象
	 private JButton okButton;                               //声明一个按钮对象

	 public T009(){                                                //声明构造函数
	 this.setSize(400, 300);                                   //设置窗口尺寸
	 this.setLayout(new BorderLayout());           //设置窗口的布局
	    	    
	 mText=new JTextField(6);                           //初始化第一个文本框，宽度为6（字符）
	 mText.setSize(50,25);                                   //设置尺寸
	 this.add(mText,BorderLayout.NORTH);      //把文本框添加到窗口中
	 nText=new JTextField(6);                            //初始化第二个文本框，宽度为6（字符）
	 nText.setSize(50,25);                                    //设置尺寸
	 this.add(nText,BorderLayout.WEST);          //把文本框添加到窗口中
	    	    
	 okButton=new JButton("确定");                       //初始化“确定”按钮
	 okButton.setSize(50, 25);                                  //设置按钮尺寸
	 this.add(okButton,BorderLayout.CENTER);     //把按钮添加到窗口中
	 okButton.addActionListener(new ButtonListener());               //按钮绑定侦听器
	    	    
	 kText=new JTextField(6);                              //初始化第二个文本框
	 kText.setSize(100,25);                                    //设置尺寸
	 this.add(kText,BorderLayout.SOUTH);         //把文本框添加到窗口中
	 }
	    
	    class ButtonListener implements ActionListener{     //创建一个侦听器

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("你按下了按钮");
				String nStr=nText.getText();                   //获取文本框的字符串
				String mStr=mText.getText();                 //获取文本框的字符串
				//System.out.println("你输入的是："+nStr);
				int n=Integer.parseInt(nStr);                  //把字符串转换成整数
				int m=Integer.parseInt(mStr);                //把字符串转换成整数
				if(m>n){
					kText.setText("错误！");
				}
				else {
					int sum=0;                                            //用于存储相加的和
				    for (int i = m; i <=n; i++) {                 //从m加到n
					sum=sum+i;
				    }
				//System.out.println("总和是："+sum);
				   kText.setText("总和是："+sum);
				}
			}
	    	
	    }
	    
	    public static void main(String[] args) {
		// TODO Auto-generated method stub
        T009 t009=new T009();                              //声明窗口对象
        t009.setVisible(true);                                  //设置窗口为可见
	}

}
