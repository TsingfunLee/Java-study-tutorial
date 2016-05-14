import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.sound.sampled.Line;
import javax.swing.JPanel;

//构建一个类，继承Jpanel
//自己定义一个类，MyLine：起点、终点、宽度、颜色

public class PainterPanel extends JPanel implements MouseListener,MouseMotionListener {

	MyLine[] biji=new MyLine[5000];
	MyLine[] line = new MyLine[10];
	MyOval[] oval = new MyOval[10];
	MyOval[] soOval=new MyOval[10];
	MyRect[] rect = new MyRect[10];
	MyRect[] soRect=new MyRect[10];
	int bijiCount=0;
	int lineCount = 0;
	int ovalCount = 0;
	int rectCount = 0;
	int soRectCount=0;
	int soOvalCount=0;
	public int typeInt = 0;   //判断按钮操作类型
	Image img1;      //图片
	String imageName = "";
	float bili = 1;  //图像的比例
	float qingdux=0,qingduy=0;  //图像的倾度
	float jiaodu = 0;    //图像的角度

	public PainterPanel() {
		this.setBackground(Color.white); // 设置背景颜色
		//初始化画笔数组
		for (int i=0;i<biji.length;++i){
			biji[i]=new MyLine();
			biji[i].startPoint=new Point(-1,-1);
			biji[i].endPoint=new Point(-1,-1);
		}
		// 初始化直线数组
		for (int i = 0; i < line.length; i++) {
			line[i] = new MyLine();
			line[i].startPoint = new Point(-1, -1);
			line[i].endPoint = new Point(-1, -1);
		}
		// 初始化椭圆数组
		for (int i = 0; i < oval.length; i++) {
			oval[i] = new MyOval();
			oval[i].yuanxin = new Point(-1, -1);
			oval[i].width = 0;
			oval[i].height = 0;
		}
		// 初始化矩形数组
		for (int i = 0; i < rect.length; i++) {
			rect[i] = new MyRect();
			rect[i].leftPoint = new Point(-1, -1);
			rect[i].width = 0;
			rect[i].height = 0;
		}
		// 初始化实心矩形数组
		for (int i = 0; i < soRect.length; i++) {
			soRect[i] = new MyRect();
			soRect[i].leftPoint = new Point(-1, -1);
			soRect[i].width = 0;
			soRect[i].height = 0;
		}
		// 初始化实心椭圆数组
		for (int i = 0; i < soOval.length; i++) {
			soOval[i] = new MyOval();
			soOval[i].yuanxin = new Point(-1, -1);
			soOval[i].width = 0;
			soOval[i].height = 0;
		}		
		// 绑定侦听器
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;                    //获取画板的2D对象
		// 随意画
		for(int i=0;i<biji.length;++i){
			g2.drawLine(biji[i].startPoint.x, biji[i].startPoint.y,
					biji[i].endPoint.x, biji[i].endPoint.y);
		}
		// 画直线
		for (int i = 0; i < line.length; i++) {
			g2.drawLine(line[i].startPoint.x, line[i].startPoint.y,
					line[i].endPoint.x, line[i].endPoint.y);
		}
		// 画圆
		for (int i = 0; i < oval.length; i++) {
			g2.drawOval(oval[i].yuanxin.x, oval[i].yuanxin.y, oval[i].width,
					oval[i].height);
		}
		// 画矩形
		for (int i = 0; i < rect.length; i++) {
			g2.drawRect(rect[i].leftPoint.x, rect[i].leftPoint.y, rect[i].width,
					rect[i].height);
		}
		// 画实心矩形
		for(int i=0;i<soRect.length;++i){
			g2.fillRect(soRect[i].leftPoint.x, soRect[i].leftPoint.y, soRect[i].width,
					soRect[i].height);
		}
		// 画实心椭圆
		for (int i = 0; i < soOval.length; i++) {
			g2.fillOval(soOval[i].yuanxin.x, soOval[i].yuanxin.y, soOval[i].width,
					soOval[i].height);
		}
		
		img1=Toolkit.getDefaultToolkit().getImage(imageName);
		int w=(int) (img1.getWidth(this)*bili);        //图片的宽
		int h=(int) (img1.getHeight(this)*bili);       //图片的高
	    g2.rotate(Math.toRadians(jiaodu),w/2,h/2);
	    g2.shear(qingdux, qingduy);
		g2.drawImage(img1, 0, 0,w,h,this);               //显示图片
		
	}
	
	public void copyImage(){
		Rectangle rect = getBounds();
        BufferedImage bufImage = new BufferedImage(rect.width,
        rect.height,
        BufferedImage.TYPE_INT_RGB);
          Graphics g = bufImage.getGraphics();
        //g.translate(-rect.x+TabbedPaneW, -rect.y+ToolBarH);
        paint(g);
        g.dispose(); 

		final Image img=bufImage;
		Transferable trans = new Transferable() {
			public DataFlavor[] getTransferDataFlavors() {
				return new DataFlavor[] { DataFlavor.imageFlavor };
			}

			public boolean isDataFlavorSupported(DataFlavor flavor) {
				return DataFlavor.imageFlavor.equals(flavor);
			}

			public Object getTransferData(DataFlavor flavor)
					throws UnsupportedFlavorException, IOException {
				if (isDataFlavorSupported(flavor))
					return img;
				throw new UnsupportedFlavorException(flavor);
			}

		};
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(trans,
				null);
	}
	
	public void pasteImage() throws UnsupportedFlavorException, IOException{
		Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable cc = sysc.getContents(null);
		if (cc.isDataFlavorSupported(DataFlavor.imageFlavor))
	    {
			
			img1=(Image) cc.getTransferData(DataFlavor.imageFlavor);
			repaint();
		}
	}
	
	public void clearImage(){
		//初始化画笔数组
				for (int i=0;i<biji.length;++i){
					biji[i]=new MyLine();
					biji[i].startPoint=new Point(-1,-1);
					biji[i].endPoint=new Point(-1,-1);
				}
		// 初始化直线数组
	    for (int i = 0; i < line.length; i++) {
					line[i] = new MyLine();
					line[i].startPoint = new Point(-1, -1);
					line[i].endPoint = new Point(-1, -1);
	    }
		// 初始化椭圆数组
	    for (int i = 0; i < oval.length; i++) {
					oval[i] = new MyOval();
					oval[i].yuanxin = new Point(-1, -1);
					oval[i].width = 0;
					oval[i].height = 0;
		}
		// 初始化矩形数组
		for (int i = 0; i < rect.length; i++) {
					rect[i] = new MyRect();
					rect[i].leftPoint = new Point(-1, -1);
					rect[i].width = 0;
					rect[i].height = 0;
		}
		// 初始化实心矩形数组
		for (int i = 0; i < soRect.length; i++) {
			soRect[i] = new MyRect();
			soRect[i].leftPoint = new Point(-1, -1);
			soRect[i].width = 0;
			soRect[i].height = 0;
        }
		// 初始化实心椭圆数组
		for (int i = 0; i < soOval.length; i++) {
			soOval[i] = new MyOval();
			soOval[i].yuanxin = new Point(-1, -1);
			soOval[i].width = 0;
			soOval[i].height = 0;
		}	
		
		typeInt=0;
		imageName="";
		repaint();
	}

	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(typeInt==6){
			biji[bijiCount].startPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
			biji[bijiCount].startPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
			biji[bijiCount].endPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
			biji[bijiCount].endPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
			bijiCount++;
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		if(typeInt==6){
//			biji[bijiCount].endPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
//			biji[bijiCount].endPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
//			bijiCount++;
//		}
//		repaint();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (typeInt == 1) {
			line[lineCount].startPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
			line[lineCount].startPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
		} else if (typeInt == 2) {
			oval[ovalCount].yuanxin.x = e.getX();
			oval[ovalCount].yuanxin.y = e.getY();
		} else if (typeInt == 3) {
			rect[rectCount].leftPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
			rect[rectCount].leftPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
		} else if(typeInt==4){
			soRect[soRectCount].leftPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
			soRect[soRectCount].leftPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
		} else if(typeInt==5){
			soOval[soOvalCount].yuanxin.x = e.getX();
			soOval[soOvalCount].yuanxin.y = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (typeInt == 1) {
			line[lineCount].endPoint.x = e.getX(); // 获取鼠标所在位置的X坐标
			line[lineCount].endPoint.y = e.getY(); // 获取鼠标所在位置的Y坐标
			lineCount++;
		} else if (typeInt == 2) {
			oval[ovalCount].width = Math.abs(oval[ovalCount].yuanxin.x
					- e.getX());
			oval[ovalCount].height = Math.abs(oval[ovalCount].yuanxin.y
					- e.getY());
			ovalCount++;
		} else if (typeInt == 3) {
			rect[rectCount].width = Math.abs(e.getX()-
					 rect[rectCount].leftPoint.x); // 获取宽
			rect[rectCount].height = Math.abs(e.getY()-
					 rect[rectCount].leftPoint.y); // 获取高
			rectCount++;
		}else if (typeInt == 4) {
			soRect[soRectCount].width = Math.abs(e.getX()-
					 soRect[soRectCount].leftPoint.x); // 获取宽
			soRect[soRectCount].height = Math.abs(e.getY()-
					 soRect[soRectCount].leftPoint.y); // 获取高
			soRectCount++;
		}else if (typeInt == 5) {
			soOval[soOvalCount].width = Math.abs(soOval[soOvalCount].yuanxin.x
					- e.getX());
			soOval[soOvalCount].height = Math.abs(soOval[soOvalCount].yuanxin.y
					- e.getY());
			soOvalCount++;
		}
		repaint();
	}

}
