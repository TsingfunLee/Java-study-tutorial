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
    private JMenuBar  mb;                         //菜单栏
    private JToolBar  toolBar;                    //工具栏
    
    private JButton   saveButton,openButton;                 //工具栏按钮
    
    private JMenu     fileMenu;                   //菜单
    private JMenu     editMenu;
    private JMenu     geshiMenu;
    private JMenu     viewMenu;
    private JMenu     helpMenu;
    
    private JMenuItem newFileMenu;                //文件
    private JMenuItem openFileMenu;
    private JMenuItem saveFileMenu;
    private JMenuItem exitMenu;
    
    private JMenuItem cutMenu;                    //编辑
    private JMenuItem copyMenu;
    private JMenuItem pasteMenu;
    private JMenuItem deleteMenu;
    
    private JMenuItem fontMenu;                   //格式
    
    private JMenuItem ZhuangTaiLanMenu;           //查看
    
    private JMenuItem aboutNoteMenu;              //帮助
    
    private JTextArea editor;                     //定义文本区域
    
	public T011(){
		this.setTitle("记事本");      //添加窗口标题
		this.setSize(600,450);        //设置窗口尺寸
		
		//菜单栏
		mb=new JMenuBar();                     //初始化菜单栏
		fileMenu=new JMenu("文件(F)");         //初始化菜单
		editMenu=new JMenu("编辑(E)"); 
		geshiMenu=new JMenu("格式(O)");
		viewMenu=new JMenu("查看(V)"); 
		helpMenu=new JMenu("帮助(H)"); 
		
		newFileMenu=new JMenuItem("新建(N)…           Ctrl+N");        //初始化菜单项
		openFileMenu=new JMenuItem("打开(O)…           Ctrl+O");
		saveFileMenu=new JMenuItem("保存(S)…           Ctrl+S");
		exitMenu=new JMenuItem("退出(X）");
		
		cutMenu=new JMenuItem("剪切(T）…           Ctrl+X");
		copyMenu=new JMenuItem("复制(C）…           Ctrl+C");
		pasteMenu=new JMenuItem("粘贴(P）…           Ctrl+V");
		deleteMenu=new JMenuItem("删除(L）…              DeL");
		
		fontMenu=new JMenuItem("字体(F）…");
		
		ZhuangTaiLanMenu=new JMenuItem("状态栏(S）");
		
		aboutNoteMenu=new JMenuItem("关于记事本(A）");
		
		fileMenu.add(newFileMenu);         //把菜单项添加到菜单中
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
		
		mb.add(fileMenu);                 //把菜单添加到菜单栏中
		mb.add(editMenu);
		mb.add(geshiMenu);
		mb.add(viewMenu);
		mb.add(helpMenu);
		
		this.setJMenuBar(mb);
		
		MenuListener ml=new MenuListener();    //初始化侦听器
		saveFileMenu.addActionListener(ml);    //把侦听器与saveFileMenu绑定
		openFileMenu.addActionListener(ml);
		
        //工具栏
		this.setLayout(new BorderLayout());       //设置布局
		toolBar=new JToolBar();
		saveButton=new JButton(new ImageIcon("open.gif"));
		openButton=new JButton(new ImageIcon("save.gif"));
		toolBar.add(saveButton);
		toolBar.add(openButton);
		this.add(toolBar,BorderLayout.NORTH);
		
		openButton.addActionListener(ml);      //绑定侦听器
		saveButton.addActionListener(ml);
		
		//文本区域
		editor=new JTextArea();                                    //初始化文件区域
		this.add(editor);                //把文本区域添加到窗口中	
	}
	
	public void saveFile(){        //定义一个保存函数
		JFileChooser fc=new JFileChooser();  //定义一个文件选择器，并初始化
		TxtFileFilter tff=new TxtFileFilter();
		fc.addChoosableFileFilter(tff);
		fc.showSaveDialog(this);             //显示文件选择器
		File file=fc.getSelectedFile();      //获取所选择的文件
		File fileTxt=new File(file.getAbsolutePath()+".txt");
		try{
			editor.write(new FileWriter(fileTxt));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void openFile(){
		JFileChooser fc=new JFileChooser();  //定义一个文件选择器，并初始化
		TxtFileFilter tff=new TxtFileFilter();
		fc.addChoosableFileFilter(tff);
		fc.showOpenDialog(this);             //显示文件选择器
		File file=fc.getSelectedFile();      //获取所选择的文件
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
			String filename=f.getName();    //获取初始的文件名
			return filename.toLowerCase().endsWith(".txt");
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "文本文档*.txt";
		}
		
	}
	
	class MenuListener implements ActionListener{      //侦听器

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==saveFileMenu||e.getSource()==saveButton){            //判断是否按下保存菜单项
				//System.out.println("保存文件");
				saveFile();                             //调用保存函数
			}
			if(e.getSource()==openFileMenu||e.getSource()==openButton){            //判断是否按下打开菜单项
				//System.out.println("打开文件");
				openFile();                             //调用打开函数
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T011 t011=new T011();
		t011.setVisible(true);

	}

}
