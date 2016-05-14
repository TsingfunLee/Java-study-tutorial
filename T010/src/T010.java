import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class T010 extends JFrame {
	
	private JTextField resultText;  //定义一个文本框，输出计算结果
	private JPanel buttonPanel;     //定义一个面板，存放按钮
	private JButton[] numButton;    //定义一个数组，只有名称，没有分配内存
	private JButton plusButton;     //按钮+
	private JButton minusButton;    //按钮-
	private JButton multiplyButton; //按钮x
	private JButton divideButton;   //按钮/
	private JButton equalButton;    //按钮=
	private JButton dotButton;      //按钮.
	private JButton clearButton;    //按钮c
	private String o1Str="";
	private String o2Str="";
	private int oppInt=0;           //用来判断执行什么操作
	private int oppInt2=0;
	
	public T010(){          //构造函数
		resultText=new JTextField();       //初始化文本框
		buttonPanel=new JPanel();          //初始化面板

		numButton=new JButton[10];         //数组分配内存，共有10个按钮
		
		buttonPanel.setLayout(new GridLayout(5,4,5,5));     //设置网格布局
		
		for (int i = 7; i < 10; i++) {
			numButton[i]=new JButton(""+i);             //初始化数字按钮
			buttonPanel.add(numButton[i]);              //把按钮添加到面板上
		}
		plusButton=new JButton("+");
		buttonPanel.add(plusButton); 
		for (int i = 4; i < 7; i++) {
			numButton[i]=new JButton(""+i);             //初始化数字按钮
			buttonPanel.add(numButton[i]);              //把按钮添加到面板上
		}
		minusButton=new JButton("-");
		buttonPanel.add(minusButton); 
		for (int i = 1; i < 4; i++) {
			numButton[i]=new JButton(""+i);             //初始化数字按钮
			buttonPanel.add(numButton[i]);              //把按钮添加到面板上
		}
		multiplyButton=new JButton("x");
		buttonPanel.add(multiplyButton);
		
		dotButton=new JButton(".");	                    //初始化按钮
		divideButton=new JButton("/");
		equalButton=new JButton("=");
		clearButton=new JButton("C");
		numButton[0]=new JButton("0");
		
		buttonPanel.add(dotButton); 
		buttonPanel.add(numButton[0]);
		buttonPanel.add(equalButton);                                       
		buttonPanel.add(divideButton);
		buttonPanel.add(clearButton);
		
		ButtonListener bl=new ButtonListener();        //侦听器变量bl
		
		for (int j = 0; j < numButton.length; j++) {
			numButton[j].addActionListener(bl);        //绑定侦听器
		}
		plusButton.addActionListener(bl);              //绑定侦听器
		minusButton.addActionListener(bl);
		multiplyButton.addActionListener(bl);
		divideButton.addActionListener(bl);
		equalButton.addActionListener(bl);             //绑定侦听器
		dotButton.addActionListener(bl);
		clearButton.addActionListener(bl);
		
		this.setLayout(new BorderLayout());          //设置布局
		this.add(resultText,BorderLayout.NORTH);     //往窗口添加文本框
		this.add(buttonPanel,BorderLayout.CENTER);   //网窗口添加面板
		this.setSize(300,450);
	}
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton jbt=(JButton)e.getSource();      
			if(jbt==numButton[1]){
				if(oppInt==0){
				o1Str=o1Str+"1";
				resultText.setText(o1Str);
				}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
					o2Str=o2Str+"1";
					resultText.setText(o2Str);
				}
			}else if(jbt==numButton[2]){
				if(oppInt==0){
					o1Str=o1Str+"2";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"2";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[3]){
				if(oppInt==0){
					o1Str=o1Str+"3";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"3";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[4]){
				if(oppInt==0){
					o1Str=o1Str+"4";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"4";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[5]){
				if(oppInt==0){
					o1Str=o1Str+"5";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"5";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[6]){
				if(oppInt==0){
					o1Str=o1Str+"6";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"6";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[7]){
				if(oppInt==0){
					o1Str=o1Str+"7";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"7";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[8]){
				if(oppInt==0){
					o1Str=o1Str+"8";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"8";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[9]){
				if(oppInt==0){
					o1Str=o1Str+"9";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"9";
						resultText.setText(o2Str);
					}
			}else if(jbt==numButton[0]){
				if(oppInt==0){
					o1Str=o1Str+"0";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+"0";
						resultText.setText(o2Str);
					}
			}else if(jbt==plusButton){
				oppInt=1;
				resultText.setText(o1Str);
			}else if(jbt==minusButton){
				oppInt=2;
				resultText.setText(o1Str);
			}else if(jbt==multiplyButton){
				oppInt=3;
				resultText.setText(o1Str);
			}else if(jbt==divideButton){
				oppInt=4;
				resultText.setText(o1Str);
			}else if(jbt==dotButton){
				if(oppInt==0){
					o1Str=o1Str+".";
					resultText.setText(o1Str);
					}else if(oppInt==1||oppInt==2||oppInt==3||oppInt==4){
						o2Str=o2Str+".";
						resultText.setText(o2Str);
					}
				oppInt2=1;
			}else if(jbt==equalButton){
				if(oppInt2!=1){
					int o1Float=Integer.parseInt(o1Str);
					int o2Float=Integer.parseInt(o2Str);
					int resultFloat=0;
					if(oppInt==1){
						resultFloat=o1Float+o2Float;
						}else if(oppInt==2){
							resultFloat=o1Float-o2Float;
						}else if(oppInt==3){
							resultFloat=o1Float*o2Float;
						}else if(oppInt==4){
							resultFloat=o1Float/o2Float;
						}
						resultText.setText(""+resultFloat);
						o1Str=String.valueOf(resultFloat);
						o2Str="";
						oppInt=5;
					}else{
					float o1Float=Float.parseFloat(o1Str);
					float o2Float=Float.parseFloat(o2Str);
					float resultFloat=0;
					if(oppInt==1){
						resultFloat=o1Float+o2Float;
						}else if(oppInt==2){
							resultFloat=o1Float-o2Float;
						}else if(oppInt==3){
							resultFloat=o1Float*o2Float;
						}else if(oppInt==4){
							resultFloat=o1Float/o2Float;
						}
						resultText.setText(""+resultFloat);
						o1Str=String.valueOf(resultFloat);
						o2Str="";
						oppInt=5;
					}
			}else if(jbt==clearButton){
						o1Str="";
						o2Str="";
						oppInt=0;
						resultText.setText(null);
				        }
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T010 t010=new T010();         //声明窗口的对象
		t010.setVisible(true);        //显示窗口

	}

}
