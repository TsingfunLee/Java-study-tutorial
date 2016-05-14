import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;


public class T011 extends JFrame {
    private JMenuBar  mb;                         //�˵���
    private JToolBar  toolBar;                    //������
    
    private JButton   saveButton,openButton;                 //��������ť
    
    private JMenu     fileMenu;                   //�˵�
    private JMenu     editMenu;
    private JMenu     geshiMenu;
    private JMenu     viewMenu;
    private JMenu     helpMenu;
    
    private JMenuItem newFileMenu;                //�ļ�
    private JMenuItem openFileMenu;
    private JMenuItem saveFileMenu;
    private JMenuItem exitMenu;
    
    private JMenuItem cutMenu;                    //�༭
    private JMenuItem copyMenu;
    private JMenuItem pasteMenu;
    private JMenuItem deleteMenu;
    
    private JMenuItem fontMenu;                   //��ʽ
    
    private JMenuItem ZhuangTaiLanMenu;           //�鿴
    
    private JMenuItem aboutNoteMenu;              //����
    
    private JTextArea editor;                     //�����ı�����
    
	public T011(){
		this.setTitle("���±�");      //��Ӵ��ڱ���
		this.setSize(600,450);        //���ô��ڳߴ�
		
		//�˵���
		mb=new JMenuBar();                     //��ʼ���˵���
		fileMenu=new JMenu("�ļ�(F)");         //��ʼ���˵�
		editMenu=new JMenu("�༭(E)"); 
		geshiMenu=new JMenu("��ʽ(O)");
		viewMenu=new JMenu("�鿴(V)"); 
		helpMenu=new JMenu("����(H)"); 
		
		newFileMenu=new JMenuItem("�½�(N)��           Ctrl+N");        //��ʼ���˵���
		openFileMenu=new JMenuItem("��(O)��           Ctrl+O");
		saveFileMenu=new JMenuItem("����(S)��           Ctrl+S");
		exitMenu=new JMenuItem("�˳�(X��");
		
		cutMenu=new JMenuItem("����(T����           Ctrl+X");
		copyMenu=new JMenuItem("����(C����           Ctrl+C");
		pasteMenu=new JMenuItem("ճ��(P����           Ctrl+V");
		deleteMenu=new JMenuItem("ɾ��(L����              DeL");
		
		fontMenu=new JMenuItem("����(F����");
		
		ZhuangTaiLanMenu=new JMenuItem("״̬��(S��");
		
		aboutNoteMenu=new JMenuItem("���ڼ��±�(A��");
		
		fileMenu.add(newFileMenu);         //�Ѳ˵�����ӵ��˵���
		fileMenu.add(openFileMenu);
		fileMenu.add(saveFileMenu);
		fileMenu.add(exitMenu);
		
		editMenu.add(cutMenu);
		editMenu.add(copyMenu);
		editMenu.add(pasteMenu);
		editMenu.add(deleteMenu);
		
		geshiMenu.add(fontMenu);
		
		viewMenu.add(ZhuangTaiLanMenu);
		
		helpMenu.add(aboutNoteMenu);
		
		mb.add(fileMenu);                 //�Ѳ˵���ӵ��˵�����
		mb.add(editMenu);
		mb.add(geshiMenu);
		mb.add(viewMenu);
		mb.add(helpMenu);
		
		this.setJMenuBar(mb);
		
		MenuListener ml=new MenuListener();    //��ʼ��������
		saveFileMenu.addActionListener(ml);    //����������saveFileMenu��
		openFileMenu.addActionListener(ml);
		
        //������
		this.setLayout(new BorderLayout());       //���ò���
		toolBar=new JToolBar();
		saveButton=new JButton(new ImageIcon("open.gif"));
		openButton=new JButton(new ImageIcon("save.gif"));
		toolBar.add(saveButton);
		toolBar.add(openButton);
		this.add(toolBar,BorderLayout.NORTH);
		
		openButton.addActionListener(ml);      //��������
		saveButton.addActionListener(ml);
		
		//�ı�����
		editor=new JTextArea();                                    //��ʼ���ļ�����
		this.add(editor);                //���ı�������ӵ�������	
	}
	
	public void saveFile(){        //����һ�����溯��
		JFileChooser fc=new JFileChooser();  //����һ���ļ�ѡ����������ʼ��
		TxtFileFilter tff=new TxtFileFilter();
		fc.addChoosableFileFilter(tff);
		fc.showSaveDialog(this);             //��ʾ�ļ�ѡ����
		File file=fc.getSelectedFile();      //��ȡ��ѡ����ļ�
		File fileTxt=new File(file.getAbsolutePath()+".txt");
		try{
			editor.write(new FileWriter(fileTxt));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void openFile(){
		JFileChooser fc=new JFileChooser();  //����һ���ļ�ѡ����������ʼ��
		TxtFileFilter tff=new TxtFileFilter();
		fc.addChoosableFileFilter(tff);
		fc.showOpenDialog(this);             //��ʾ�ļ�ѡ����
		File file=fc.getSelectedFile();      //��ȡ��ѡ����ļ�
		try{
			editor.read(new FileReader(file),null);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	class TxtFileFilter extends FileFilter{

		@Override
		public boolean accept(File f) {
			// TODO Auto-generated method stub
			String filename=f.getName();    //��ȡ��ʼ���ļ���
			return filename.toLowerCase().endsWith(".txt");
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "�ı��ĵ�*.txt";
		}
		
	}
	
	class MenuListener implements ActionListener{      //������

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==saveFileMenu||e.getSource()==saveButton){            //�ж��Ƿ��±���˵���
				//System.out.println("�����ļ�");
				saveFile();                             //���ñ��溯��
			}
			if(e.getSource()==openFileMenu||e.getSource()==openButton){            //�ж��Ƿ��´򿪲˵���
				//System.out.println("���ļ�");
				openFile();                             //���ô򿪺���
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T011 t011=new T011();
		t011.setVisible(true);

	}

}
