import java.awt.Color;
import java.awt.Graphics;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Line;
import javax.swing.JPanel;

//����һ���࣬�̳�Jpanel
//�Լ�����һ���࣬MyLine����㡢�յ㡢��ȡ���ɫ

public class PainterPanel extends JPanel implements MouseListener{

	MyLine[] line=new MyLine[10];
	MyOval[] oval=new MyOval[10];
	MyRect[] rect=new MyRect[10];
	int lineCount=0;
	int ovalCount=0;
	int rectCount=0;
	public int typeInt=0;
	
	public PainterPanel(){
		this.setBackground(Color.white);          //���ñ�����ɫ
		//��ʼ��ֱ������
		for (int i = 0; i < line.length; i++) {
			line[i]=new MyLine();
			line[i].startPoint=new Point(-1,-1);
			line[i].endPoint=new Point(-1,-1);
		}
		//��ʼ����Բ����
		for (int i = 0; i < oval.length; i++) {
			oval[i]=new MyOval();
			oval[i].yuanxin=new Point(-1,-1);
			oval[i].width=0;
			oval[i].height=0;
		}
		//��ʼ����������
	    for (int i = 0; i < rect.length; i++) {
			rect[i]=new MyRect();
			rect[i].leftPoint=new Point(-1,-1);
			rect[i].width=0;
			rect[i].height=0;
		}
		//��������
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//��ֱ��
		for (int i = 0; i < line.length; i++) {
			g.drawLine(line[i].startPoint.x, line[i].startPoint.y, line[i].endPoint.x, line[i].endPoint.y);
		}
		//��Բ
		for (int i = 0; i < oval.length; i++) {
			g.drawOval(oval[i].yuanxin.x, oval[i].yuanxin.y, oval[i].width,oval[i].height);
		}
		//������
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
		    line[lineCount].startPoint.x=e.getX();        //��ȡ�������λ�õ�X����
		    line[lineCount].startPoint.y=e.getY();        //��ȡ�������λ�õ�Y����
		}else if(typeInt==2){
			oval[ovalCount].yuanxin.x=e.getX();
			oval[ovalCount].yuanxin.y=e.getY();
		}else if(typeInt==3){
			rect[lineCount].leftPoint.x=e.getX();        //��ȡ�������λ�õ�X����
			rect[lineCount].leftPoint.y=e.getY();        //��ȡ�������λ�õ�Y����
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(typeInt==1){
		    line[lineCount].endPoint.x=e.getX();        //��ȡ�������λ�õ�X����
		    line[lineCount].endPoint.y=e.getY();        //��ȡ�������λ�õ�Y����
	        lineCount++;
		}else if(typeInt==2){
			oval[ovalCount].width=Math.abs(oval[ovalCount].yuanxin.x-e.getX());
			oval[ovalCount].height=Math.abs(oval[ovalCount].yuanxin.y-e.getY());
			ovalCount++;
		}else if(typeInt==3){
			rect[rectCount].width=Math.abs(e.getX()-rect[rectCount].leftPoint.x);   //��ȡ��
			rect[rectCount].height=Math.abs(e.getY()-rect[rectCount].leftPoint.y);  //��ȡ��
		    rectCount++;
		}
		repaint();	
	}

	

}
