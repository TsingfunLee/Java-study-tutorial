import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

public class CAD extends JFrame implements ActionListener,KeyListener {
	JMenuBar menuBar; // 菜单栏
	JToolBar toolBar; // 工具栏
	PainterPanel painter; // 绘图板
	
    // 菜单栏
	JMenu fileMenu; // 文件
	JMenu editMenu; // 编辑
	JMenu imageMenu;// 图像
	JMenu helpMenu; // 帮助
	
	// 文件菜单
    JMenuItem newFileMenu;       //新建
    JMenuItem openFileMenu;      //打开
    JMenuItem saveFileMenu;      //保存
    JMenuItem exitMenu;          //退出   
    // 编辑菜单
    JMenuItem cutMenu;           //剪切         
    JMenuItem copyMenu;          //复制
    JMenuItem pasteMenu;         //粘贴
    JMenuItem deleteMenu;        //删除
    // 图像菜单
    JMenuItem shunRotateMenu;    //顺时针
    JMenuItem niRotateMenu;      //逆时针
    JMenuItem rotateMenu;        //自定义角度旋转
    JMenuItem suoxiaoMenu,fangdaMenu;   // 缩小、放大
    JMenuItem scaleMenu;         //缩放
    JMenuItem leftShearMenu,rightShearMenu,  // 左倾、右倾
    upShearMenu,downShearMenu;     // 上倾、下倾  
    // 帮助菜单
    JMenuItem aboutCADMenu;      //关于CAD

    // 工具栏按钮
    JButton penButton; //画笔
	JButton lineButton; // 直线
	JButton ovalButton; // 椭圆
	JButton soOvalButton; // 实心椭圆
	JButton rectButton; // 矩形
	JButton soRectButton; //实心矩形
	JButton suoxiaoButton,fangdaButton;   // 缩小、放大
	//JButton scaleButton;    // 缩放
	JButton shunRotateButton,niRotateButton;   // 顺时针、逆时针旋转
	//JButton leftShearButton,rightShearButton,  // 左倾、右倾
	        //upShearButton,downShearButton;     // 上倾、下倾
	JButton clearButton;   //清空

	public CAD() {
		this.setSize(600, 500); // 设置窗口尺寸
		this.setTitle("LittleCAD"); // 设置窗口标题
		// this.setLayout(new BorderLayout()); // 设置布局
		// 初始化
		menuBar = new JMenuBar(); // 菜单栏
		toolBar = new JToolBar(1); // 工具栏Y方向
		painter = new PainterPanel(); // 绘图板

		fileMenu = new JMenu("文件"); // 文件
		editMenu = new JMenu("编辑"); // 编辑
		imageMenu = new JMenu("图像");// 图像
		helpMenu = new JMenu("帮助"); // 帮助
		
		// 文件菜单
		newFileMenu = new JMenuItem("新建(N)…           Ctrl+N");        
		openFileMenu = new JMenuItem("打开(O)…           Ctrl+O");
		saveFileMenu = new JMenuItem("保存(S)…           Ctrl+S");
		exitMenu = new JMenuItem("退出(X）");
		// 编辑菜单
		cutMenu = new JMenuItem("剪切(T）…           Ctrl+X");
		copyMenu = new JMenuItem("复制(C）…           Ctrl+C");
		pasteMenu = new JMenuItem("粘贴(P）…           Ctrl+V");
		deleteMenu = new JMenuItem("删除(L）…              DeL");
		// 图像菜单
		shunRotateMenu = new JMenuItem("旋转90°（顺时针）");
		niRotateMenu = new JMenuItem("旋转90°（逆时针）");
		rotateMenu=new JMenuItem("自定义角度旋转");
		fangdaMenu = new JMenuItem("放大");
		suoxiaoMenu = new JMenuItem("缩小");
		scaleMenu = new JMenuItem("按比例缩放");
	    leftShearMenu = new JMenuItem("左倾");
	    rightShearMenu = new JMenuItem("右倾");
	    upShearMenu = new JMenuItem("上倾");
	    downShearMenu = new JMenuItem("下倾");
		// 帮助菜单
		aboutCADMenu=new JMenuItem("关于LittleCAD(A）");

		//工具栏
		penButton=new JButton(new ImageIcon("pen.png")); //画笔
		penButton.setToolTipText("画笔");
		lineButton = new JButton(new ImageIcon("Line.png")); // 直线
		lineButton.setToolTipText("直线");
		ovalButton = new JButton(new ImageIcon("Oval.png")); // 椭圆
		ovalButton.setToolTipText("椭圆");
		soOvalButton=new JButton(new ImageIcon("soOval.png")); // 实心椭圆
		soOvalButton.setToolTipText("实心椭圆");
		rectButton = new JButton(new ImageIcon("Rect.png")); // 矩形
		rectButton.setToolTipText("矩形");
		soRectButton=new JButton(new ImageIcon("soRect.png"));  //实心矩形
		soRectButton.setToolTipText("实心矩形");
		shunRotateButton = new JButton(new ImageIcon("shunRotate.png")); // 顺时针
		shunRotateButton.setToolTipText("顺时针");
		niRotateButton = new JButton(new ImageIcon("niRotate.png"));     // 逆时针
		niRotateButton.setToolTipText("逆时针");
		suoxiaoButton = new JButton(new ImageIcon("suoxiao.png"));       // 缩小
		suoxiaoButton.setToolTipText("缩小");
		fangdaButton = new JButton(new ImageIcon("fangda.png"));         // 放大
		fangdaButton.setToolTipText("放大");
		clearButton = new JButton(new ImageIcon("clear.png"));
		clearButton.setToolTipText("清空");
		//leftShearButton=new JButton();
		//rightShearButton=new JButton();
		//upShearButton=new JButton();
		//downShearButton=new JButton();

		// 添加到窗口中
		fileMenu.add(newFileMenu);   // 新建
		fileMenu.add(openFileMenu);  // 打开
		fileMenu.add(saveFileMenu);  // 保存
		fileMenu.add(exitMenu);      // 退出
		editMenu.add(cutMenu);       // 剪贴
		editMenu.add(copyMenu);      // 复制
		editMenu.add(pasteMenu);     // 粘贴
		editMenu.add(deleteMenu);    // 删除
		//imageMenu.setLayout();
		imageMenu.add(shunRotateMenu); // 顺时针
		imageMenu.add(niRotateMenu);   // 逆时针
		imageMenu.add(rotateMenu);     // 自定义角度旋转
		imageMenu.add(fangdaMenu);     // 放大
		imageMenu.add(suoxiaoMenu);    // 缩小
		imageMenu.add(scaleMenu);      // 缩放
		imageMenu.add(leftShearMenu);  // 左倾
		imageMenu.add(rightShearMenu); // 右倾
		imageMenu.add(upShearMenu);    // 上倾
		imageMenu.add(downShearMenu);  // 下倾
		helpMenu.add(aboutCADMenu);    // 关于CAD
		
		menuBar.add(fileMenu); // 文件
		menuBar.add(editMenu); // 编辑
		menuBar.add(imageMenu);// 图像
		menuBar.add(helpMenu); // 帮助

		toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.Y_AXIS));  //设置布局
		toolBar.add(penButton);
		toolBar.add(lineButton); // 直线
		toolBar.add(ovalButton); // 椭圆
		toolBar.add(soOvalButton); //实心椭圆
		toolBar.add(rectButton); // 矩形
		toolBar.add(soRectButton);  // 实心矩形
		toolBar.add(shunRotateButton); // 顺时针
		toolBar.add(niRotateButton);   // 逆时针
		toolBar.add(fangdaButton);    // 放大
		toolBar.add(suoxiaoButton);   // 缩小
		toolBar.add(clearButton);

		this.setJMenuBar(menuBar);              // 菜单栏
		this.add(toolBar, BorderLayout.WEST);   // 工具栏
		this.add(painter, BorderLayout.CENTER); // 绘图板
		
		//绑定侦听器
		penButton.addActionListener(this);
		lineButton.addActionListener(this);
		ovalButton.addActionListener(this);
		soOvalButton.addActionListener(this);
		rectButton.addActionListener(this);
		soRectButton.addActionListener(this);
		shunRotateButton.addActionListener(this);
		niRotateButton.addActionListener(this);
		fangdaButton.addActionListener(this);
		suoxiaoButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		newFileMenu.addActionListener(this);
		saveFileMenu.addActionListener(this);
		openFileMenu.addActionListener(this);
		exitMenu.addActionListener(this);
		
		cutMenu.addActionListener(this);
		copyMenu.addActionListener(this);
		pasteMenu.addActionListener(this);
		
		shunRotateMenu.addActionListener(this);
		niRotateMenu.addActionListener(this);
		rotateMenu.addActionListener(this);
		fangdaMenu.addActionListener(this);
		suoxiaoMenu.addActionListener(this);
		scaleMenu.addActionListener(this);
		leftShearMenu.addActionListener(this);
		rightShearMenu.addActionListener(this);
		upShearMenu.addActionListener(this);
		downShearMenu.addActionListener(this);
		
		aboutCADMenu.addActionListener(this);
		
		addKeyListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//各个按钮的响应事件
		// TODO Auto-generated method stub
		if (e.getSource()==lineButton){
			painter.typeInt=1;
		}else if(e.getSource()==ovalButton){
			painter.typeInt=2;
		}else if(e.getSource()==soOvalButton){
			painter.typeInt=5;
		}else if(e.getSource()==rectButton){
			painter.typeInt=3;
		}else if(e.getSource()==soRectButton){
			painter.typeInt=4;
		}else if(e.getSource()==penButton){
			painter.typeInt=6;
		}
		else if(e.getSource()==shunRotateButton){
			painter.typeInt=0;
			painter.jiaodu=painter.jiaodu+45;
			painter.repaint();
		}else if(e.getSource()==niRotateButton){
			painter.typeInt=0;
			painter.jiaodu=painter.jiaodu-45;
			painter.repaint();
		}else if(e.getSource()==fangdaButton||e.getSource()==fangdaMenu){
			painter.typeInt=0;
			painter.bili=(float) (painter.bili*1.1);
			painter.repaint();
		}else if(e.getSource()==suoxiaoButton||e.getSource()==suoxiaoMenu){
			painter.typeInt=0;
			painter.bili=(float) (painter.bili*0.9);
			painter.repaint();
		}else if (e.getSource()==clearButton){
			painter.clearImage();
			painter.typeInt=0;
		}else if(e.getSource()==newFileMenu){
			newImage();
		}else if(e.getSource()==saveFileMenu){
			saveImage();
		}else if(e.getSource()==openFileMenu){
			openImage();
		}else if(e.getSource()==exitMenu){
			System.exit(0);
		}
		else if(e.getSource()==cutMenu){
		

		}else if(e.getSource()==copyMenu){
			painter.copyImage();
		}else if(e.getSource()==pasteMenu){
			try {
				painter.pasteImage();
			} catch (UnsupportedFlavorException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==deleteMenu){
			painter.clearImage();
		}
		else if(e.getSource()==shunRotateMenu){
			painter.typeInt=0;
			painter.jiaodu=painter.jiaodu+90;
			painter.repaint();
		}else if(e.getSource()==niRotateMenu){
			painter.typeInt=0;
			painter.jiaodu=painter.jiaodu-90;
			painter.repaint();
		}else if(e.getSource()==rotateMenu){
			String inputValue=JOptionPane.showInputDialog("请输入旋转角度，正数顺时针，负数逆时针：");
			float f=Float.parseFloat(inputValue);
			painter.jiaodu=painter.jiaodu+f;  //旋转f度
			painter.repaint();
		}
		else if(e.getSource()==scaleMenu){
			String inputValue=JOptionPane.showInputDialog("请输入缩放比例：");
			float f=Float.parseFloat(inputValue);
			painter.bili=(float) (painter.bili*f);   //比例变为原来的f倍
			painter.repaint(); 
		}else if(e.getSource()==leftShearMenu){
			painter.qingdux=(float) (painter.qingdux-0.1);
			painter.repaint();
		}else if(e.getSource()==rightShearMenu){
			painter.qingdux=(float) (painter.qingdux+0.1);
			painter.repaint();
		}else if(e.getSource()==upShearMenu){
			painter.qingduy=(float) (painter.qingduy+0.1);
			painter.repaint();
		}else if(e.getSource()==downShearMenu){
			painter.qingduy=(float) (painter.qingduy-0.1);
			painter.repaint();
		}
		else if(e.getSource()==aboutCADMenu){
			JOptionPane.showMessageDialog(this, "CAD绘图程序1.0版\n——By 111300521 李庆芳","关于",JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void newImage(){
		Object[] options={"确定","取消"};   //弹出选项对话框
		int select=JOptionPane.showOptionDialog(this, "是否要保存图像？", "提示", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null,
				options, options[0]);
		if(select==0){       //点确定，保存图像，然后清空图像
			saveImage();
			painter.clearImage();
		}else if(select==1){  //点取消，清空图像
			painter.clearImage();
		}
	}
	
	public void saveImage(){        //定义一个保存函数
		try{
			JFileChooser fc=new JFileChooser();  //定义一个文件选择器，并初始化
			JpgFileFilter tff=new JpgFileFilter();
			fc.addChoosableFileFilter(tff);
			fc.showSaveDialog(this);             //显示文件选择器
			File file=fc.getSelectedFile();      //获取所选择的文件
			File fileJpg=new File(file.getAbsolutePath()+".jpg");
			BufferedImage bi = (BufferedImage)painter.createImage(painter.getWidth(),
					painter.getHeight());   
			painter.paint(bi.getGraphics());  
			javax.imageio.ImageIO.write(bi,"jpg",fileJpg);   
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void openImage(){
		JFileChooser fc=new JFileChooser();  //定义一个文件选择器，并初始化
		JpgFileFilter tff=new JpgFileFilter();
		fc.addChoosableFileFilter(tff);
		fc.showOpenDialog(this);             //显示文件选择器
		File file=fc.getSelectedFile();      //获取所选择的文件
		try{
			javax.imageio.ImageIO.read(file);
			String fileName=file.getPath();
			//System.out.println(fileName);
			painter.imageName=fileName;
			painter.repaint();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	class JpgFileFilter extends FileFilter{

		@Override
		public boolean accept(File f) {
			// TODO Auto-generated method stub
			String filename=f.getName();    //获取初始的文件名
			return filename.toLowerCase().endsWith(".jpg");
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "图像文件*.jpg";
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CAD cad = new CAD();
		cad.setVisible(true);
		JOptionPane.showMessageDialog(cad, 
				"使用说明：\n可以绘制简单几何体，并对图像进行缩放\n旋转倾斜等功能（只有打开的图像可以）。\n\n"
				+ "作者：111300521    李庆芳",
				"欢迎",JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_CONTROL&&e.getKeyChar()=='N'){
			newImage();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
