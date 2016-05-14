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
	JMenuBar menuBar; // �˵���
	JToolBar toolBar; // ������
	PainterPanel painter; // ��ͼ��
	
    // �˵���
	JMenu fileMenu; // �ļ�
	JMenu editMenu; // �༭
	JMenu imageMenu;// ͼ��
	JMenu helpMenu; // ����
	
	// �ļ��˵�
    JMenuItem newFileMenu;       //�½�
    JMenuItem openFileMenu;      //��
    JMenuItem saveFileMenu;      //����
    JMenuItem exitMenu;          //�˳�   
    // �༭�˵�
    JMenuItem cutMenu;           //����         
    JMenuItem copyMenu;          //����
    JMenuItem pasteMenu;         //ճ��
    JMenuItem deleteMenu;        //ɾ��
    // ͼ��˵�
    JMenuItem shunRotateMenu;    //˳ʱ��
    JMenuItem niRotateMenu;      //��ʱ��
    JMenuItem rotateMenu;        //�Զ���Ƕ���ת
    JMenuItem suoxiaoMenu,fangdaMenu;   // ��С���Ŵ�
    JMenuItem scaleMenu;         //����
    JMenuItem leftShearMenu,rightShearMenu,  // ���㡢����
    upShearMenu,downShearMenu;     // ���㡢����  
    // �����˵�
    JMenuItem aboutCADMenu;      //����CAD

    // ��������ť
    JButton penButton; //����
	JButton lineButton; // ֱ��
	JButton ovalButton; // ��Բ
	JButton soOvalButton; // ʵ����Բ
	JButton rectButton; // ����
	JButton soRectButton; //ʵ�ľ���
	JButton suoxiaoButton,fangdaButton;   // ��С���Ŵ�
	//JButton scaleButton;    // ����
	JButton shunRotateButton,niRotateButton;   // ˳ʱ�롢��ʱ����ת
	//JButton leftShearButton,rightShearButton,  // ���㡢����
	        //upShearButton,downShearButton;     // ���㡢����
	JButton clearButton;   //���

	public CAD() {
		this.setSize(600, 500); // ���ô��ڳߴ�
		this.setTitle("LittleCAD"); // ���ô��ڱ���
		// this.setLayout(new BorderLayout()); // ���ò���
		// ��ʼ��
		menuBar = new JMenuBar(); // �˵���
		toolBar = new JToolBar(1); // ������Y����
		painter = new PainterPanel(); // ��ͼ��

		fileMenu = new JMenu("�ļ�"); // �ļ�
		editMenu = new JMenu("�༭"); // �༭
		imageMenu = new JMenu("ͼ��");// ͼ��
		helpMenu = new JMenu("����"); // ����
		
		// �ļ��˵�
		newFileMenu = new JMenuItem("�½�(N)��           Ctrl+N");        
		openFileMenu = new JMenuItem("��(O)��           Ctrl+O");
		saveFileMenu = new JMenuItem("����(S)��           Ctrl+S");
		exitMenu = new JMenuItem("�˳�(X��");
		// �༭�˵�
		cutMenu = new JMenuItem("����(T����           Ctrl+X");
		copyMenu = new JMenuItem("����(C����           Ctrl+C");
		pasteMenu = new JMenuItem("ճ��(P����           Ctrl+V");
		deleteMenu = new JMenuItem("ɾ��(L����              DeL");
		// ͼ��˵�
		shunRotateMenu = new JMenuItem("��ת90�㣨˳ʱ�룩");
		niRotateMenu = new JMenuItem("��ת90�㣨��ʱ�룩");
		rotateMenu=new JMenuItem("�Զ���Ƕ���ת");
		fangdaMenu = new JMenuItem("�Ŵ�");
		suoxiaoMenu = new JMenuItem("��С");
		scaleMenu = new JMenuItem("����������");
	    leftShearMenu = new JMenuItem("����");
	    rightShearMenu = new JMenuItem("����");
	    upShearMenu = new JMenuItem("����");
	    downShearMenu = new JMenuItem("����");
		// �����˵�
		aboutCADMenu=new JMenuItem("����LittleCAD(A��");

		//������
		penButton=new JButton(new ImageIcon("pen.png")); //����
		penButton.setToolTipText("����");
		lineButton = new JButton(new ImageIcon("Line.png")); // ֱ��
		lineButton.setToolTipText("ֱ��");
		ovalButton = new JButton(new ImageIcon("Oval.png")); // ��Բ
		ovalButton.setToolTipText("��Բ");
		soOvalButton=new JButton(new ImageIcon("soOval.png")); // ʵ����Բ
		soOvalButton.setToolTipText("ʵ����Բ");
		rectButton = new JButton(new ImageIcon("Rect.png")); // ����
		rectButton.setToolTipText("����");
		soRectButton=new JButton(new ImageIcon("soRect.png"));  //ʵ�ľ���
		soRectButton.setToolTipText("ʵ�ľ���");
		shunRotateButton = new JButton(new ImageIcon("shunRotate.png")); // ˳ʱ��
		shunRotateButton.setToolTipText("˳ʱ��");
		niRotateButton = new JButton(new ImageIcon("niRotate.png"));     // ��ʱ��
		niRotateButton.setToolTipText("��ʱ��");
		suoxiaoButton = new JButton(new ImageIcon("suoxiao.png"));       // ��С
		suoxiaoButton.setToolTipText("��С");
		fangdaButton = new JButton(new ImageIcon("fangda.png"));         // �Ŵ�
		fangdaButton.setToolTipText("�Ŵ�");
		clearButton = new JButton(new ImageIcon("clear.png"));
		clearButton.setToolTipText("���");
		//leftShearButton=new JButton();
		//rightShearButton=new JButton();
		//upShearButton=new JButton();
		//downShearButton=new JButton();

		// ��ӵ�������
		fileMenu.add(newFileMenu);   // �½�
		fileMenu.add(openFileMenu);  // ��
		fileMenu.add(saveFileMenu);  // ����
		fileMenu.add(exitMenu);      // �˳�
		editMenu.add(cutMenu);       // ����
		editMenu.add(copyMenu);      // ����
		editMenu.add(pasteMenu);     // ճ��
		editMenu.add(deleteMenu);    // ɾ��
		//imageMenu.setLayout();
		imageMenu.add(shunRotateMenu); // ˳ʱ��
		imageMenu.add(niRotateMenu);   // ��ʱ��
		imageMenu.add(rotateMenu);     // �Զ���Ƕ���ת
		imageMenu.add(fangdaMenu);     // �Ŵ�
		imageMenu.add(suoxiaoMenu);    // ��С
		imageMenu.add(scaleMenu);      // ����
		imageMenu.add(leftShearMenu);  // ����
		imageMenu.add(rightShearMenu); // ����
		imageMenu.add(upShearMenu);    // ����
		imageMenu.add(downShearMenu);  // ����
		helpMenu.add(aboutCADMenu);    // ����CAD
		
		menuBar.add(fileMenu); // �ļ�
		menuBar.add(editMenu); // �༭
		menuBar.add(imageMenu);// ͼ��
		menuBar.add(helpMenu); // ����

		toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.Y_AXIS));  //���ò���
		toolBar.add(penButton);
		toolBar.add(lineButton); // ֱ��
		toolBar.add(ovalButton); // ��Բ
		toolBar.add(soOvalButton); //ʵ����Բ
		toolBar.add(rectButton); // ����
		toolBar.add(soRectButton);  // ʵ�ľ���
		toolBar.add(shunRotateButton); // ˳ʱ��
		toolBar.add(niRotateButton);   // ��ʱ��
		toolBar.add(fangdaButton);    // �Ŵ�
		toolBar.add(suoxiaoButton);   // ��С
		toolBar.add(clearButton);

		this.setJMenuBar(menuBar);              // �˵���
		this.add(toolBar, BorderLayout.WEST);   // ������
		this.add(painter, BorderLayout.CENTER); // ��ͼ��
		
		//��������
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
	public void actionPerformed(ActionEvent e) {//������ť����Ӧ�¼�
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
			String inputValue=JOptionPane.showInputDialog("��������ת�Ƕȣ�����˳ʱ�룬������ʱ�룺");
			float f=Float.parseFloat(inputValue);
			painter.jiaodu=painter.jiaodu+f;  //��תf��
			painter.repaint();
		}
		else if(e.getSource()==scaleMenu){
			String inputValue=JOptionPane.showInputDialog("���������ű�����");
			float f=Float.parseFloat(inputValue);
			painter.bili=(float) (painter.bili*f);   //������Ϊԭ����f��
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
			JOptionPane.showMessageDialog(this, "CAD��ͼ����1.0��\n����By 111300521 ���췼","����",JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void newImage(){
		Object[] options={"ȷ��","ȡ��"};   //����ѡ��Ի���
		int select=JOptionPane.showOptionDialog(this, "�Ƿ�Ҫ����ͼ��", "��ʾ", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.OK_CANCEL_OPTION, null,
				options, options[0]);
		if(select==0){       //��ȷ��������ͼ��Ȼ�����ͼ��
			saveImage();
			painter.clearImage();
		}else if(select==1){  //��ȡ�������ͼ��
			painter.clearImage();
		}
	}
	
	public void saveImage(){        //����һ�����溯��
		try{
			JFileChooser fc=new JFileChooser();  //����һ���ļ�ѡ����������ʼ��
			JpgFileFilter tff=new JpgFileFilter();
			fc.addChoosableFileFilter(tff);
			fc.showSaveDialog(this);             //��ʾ�ļ�ѡ����
			File file=fc.getSelectedFile();      //��ȡ��ѡ����ļ�
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
		JFileChooser fc=new JFileChooser();  //����һ���ļ�ѡ����������ʼ��
		JpgFileFilter tff=new JpgFileFilter();
		fc.addChoosableFileFilter(tff);
		fc.showOpenDialog(this);             //��ʾ�ļ�ѡ����
		File file=fc.getSelectedFile();      //��ȡ��ѡ����ļ�
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
			String filename=f.getName();    //��ȡ��ʼ���ļ���
			return filename.toLowerCase().endsWith(".jpg");
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "ͼ���ļ�*.jpg";
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CAD cad = new CAD();
		cad.setVisible(true);
		JOptionPane.showMessageDialog(cad, 
				"ʹ��˵����\n���Ի��Ƽ򵥼����壬����ͼ���������\n��ת��б�ȹ��ܣ�ֻ�д򿪵�ͼ����ԣ���\n\n"
				+ "���ߣ�111300521    ���췼",
				"��ӭ",JOptionPane.INFORMATION_MESSAGE);
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
