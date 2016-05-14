import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class T010 extends JFrame {
	
	private JTextField resultText;  //����һ���ı������������
	private JPanel buttonPanel;     //����һ����壬��Ű�ť
	private JButton[] numButton;    //����һ�����飬ֻ�����ƣ�û�з����ڴ�
	private JButton plusButton;     //��ť+
	private JButton minusButton;    //��ť-
	private JButton multiplyButton; //��ťx
	private JButton divideButton;   //��ť/
	private JButton equalButton;    //��ť=
	private JButton dotButton;      //��ť.
	private JButton clearButton;    //��ťc
	private String o1Str="";
	private String o2Str="";
	private int oppInt=0;           //�����ж�ִ��ʲô����
	private int oppInt2=0;
	
	public T010(){          //���캯��
		resultText=new JTextField();       //��ʼ���ı���
		buttonPanel=new JPanel();          //��ʼ�����

		numButton=new JButton[10];         //��������ڴ棬����10����ť
		
		buttonPanel.setLayout(new GridLayout(5,4,5,5));     //�������񲼾�
		
		for (int i = 7; i < 10; i++) {
			numButton[i]=new JButton(""+i);             //��ʼ�����ְ�ť
			buttonPanel.add(numButton[i]);              //�Ѱ�ť��ӵ������
		}
		plusButton=new JButton("+");
		buttonPanel.add(plusButton); 
		for (int i = 4; i < 7; i++) {
			numButton[i]=new JButton(""+i);             //��ʼ�����ְ�ť
			buttonPanel.add(numButton[i]);              //�Ѱ�ť��ӵ������
		}
		minusButton=new JButton("-");
		buttonPanel.add(minusButton); 
		for (int i = 1; i < 4; i++) {
			numButton[i]=new JButton(""+i);             //��ʼ�����ְ�ť
			buttonPanel.add(numButton[i]);              //�Ѱ�ť��ӵ������
		}
		multiplyButton=new JButton("x");
		buttonPanel.add(multiplyButton);
		
		dotButton=new JButton(".");	                    //��ʼ����ť
		divideButton=new JButton("/");
		equalButton=new JButton("=");
		clearButton=new JButton("C");
		numButton[0]=new JButton("0");
		
		buttonPanel.add(dotButton); 
		buttonPanel.add(numButton[0]);
		buttonPanel.add(equalButton);                                       
		buttonPanel.add(divideButton);
		buttonPanel.add(clearButton);
		
		ButtonListener bl=new ButtonListener();        //����������bl
		
		for (int j = 0; j < numButton.length; j++) {
			numButton[j].addActionListener(bl);        //��������
		}
		plusButton.addActionListener(bl);              //��������
		minusButton.addActionListener(bl);
		multiplyButton.addActionListener(bl);
		divideButton.addActionListener(bl);
		equalButton.addActionListener(bl);             //��������
		dotButton.addActionListener(bl);
		clearButton.addActionListener(bl);
		
		this.setLayout(new BorderLayout());          //���ò���
		this.add(resultText,BorderLayout.NORTH);     //����������ı���
		this.add(buttonPanel,BorderLayout.CENTER);   //������������
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
		T010 t010=new T010();         //�������ڵĶ���
		t010.setVisible(true);        //��ʾ����

	}

}
