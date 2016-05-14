import java.awt.Color;
import java.awt.Graphics;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Line;
import javax.swing.JPanel;

//构建一个类，继承Jpanel
//自己定义一个类，MyLine：起点、终点、宽度、颜色

public class PainterPanel extends JPanel implements MouseListener{

	MyLine[] line=new MyLine[10];
	MyOval[] oval=new MyOval[10];
	MyRect[] rect=new MyRect[10];
	int lineCount=0;
	int ovalCount=0;
	int rectCount=0;
	public int typeInt=0;
	
	public PainterPanel(){
		this.setBackground(Color.white);          //设置背景颜色
		//初始化直线数组
		for (int i = 0; i < line.length; i++) {
			line[i]=new MyLine();
			line[i].startPoint=new Point(-1,-1);
			line[i].endPoint=new Point(-1,-1);
		}
		//初始化椭圆数组
		for (int i = 0; i < oval.length; i++) {
			oval[i]=new MyOval();
			oval[i].yuanxin=new Point(-1,-1);
			oval[i].width=0;
			oval[i].height=0;
		}
		//初始化矩形数组
	    for (int i = 0; i < rect.length; i++) {
			rect[i]=new MyRect();
			rect[i].leftPoint=new Point(-1,-1);
			rect[i].width=0;
			rect[i].height=0;
		}
		//绑定侦听器
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//画直线
		for (int i = 0; i < line.length; i++) {
			g.drawLine(line[i].startPoint.x, line[i].startPoint.y, line[i].endPoint.x, line[i].endPoint.y);
		}
		//画圆
		for (int i = 0; i < oval.length; i++) {
			g.drawOval(oval[i].yuanxin.x, oval[i].yuanxin.y, oval[i].width,oval[i].height);
		}
		//画矩形
		for (int i = 0; i < rect.length; i++) {
		    g.drawRect(rect[i].leftPoint.x, rect[i].leftPoint.y, rect[i].width, rect[i].height);
		}
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
		if(typeInt==1){
		    line[lineCount].startPoint.x=e.getX();        //获取鼠标所在位置的X坐标
		    line[lineCount].startPoint.y=e.getY();        //获取鼠标所在位置的Y坐标
		}else if(typeInt==2){
			oval[ovalCount].yuanxin.x=e.getX();
			oval[ovalCount].yuanxin.y=e.getY();
		}else if(typeInt==3){
			rect[lineCount].leftPoint.x=e.getX();        //获取鼠标所在位置的X坐标
			rect[lineCount].leftPoint.y=e.getY();        //获取鼠标所在位置的Y坐标
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(typeInt==1){
		    line[lineCount].endPoint.x=e.getX();        //获取鼠标所在位置的X坐标
		    line[lineCount].endPoint.y=e.getY();        //获取鼠标所在位置的Y坐标
	        lineCount++;
		}else if(typeInt==2){
			oval[ovalCount].width=Math.abs(oval[ovalCount].yuanxin.x-e.getX());
			oval[ovalCount].height=Math.abs(oval[ovalCount].yuanxin.y-e.getY());
			ovalCount++;
		}else if(typeInt==3){
			rect[rectCount].width=Math.abs(e.getX()-rect[rectCount].leftPoint.x);   //获取宽
			rect[rectCount].height=Math.abs(e.getY()-rect[rectCount].leftPoint.y);  //获取高
		    rectCount++;
		}
		repaint();	
	}

	

}
