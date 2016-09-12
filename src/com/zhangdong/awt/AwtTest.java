package com.zhangdong.awt;


import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AwtTest {
	
	
	static Button button;
	static DDPanel panel;
	public static void main(String[] args) throws NullPointerException{
		// TODO Auto-generated method stub
		 Frame frame = new Frame("产生验证码");
		 panel = new DDPanel();
		 button = new Button("换一个");
		frame.add(panel);
		frame.setSize(300,300);
		// 将frame窗口居中
		frame.setLocation(300,400);
		
		frame.addWindowListener(new WindowListener() {
			
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);// 直接退出程序
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		frame.setVisible(true);	
	}

}


class DDPanel extends Panel{
	
	public void paint(Graphics graphics){
	
		int width = 200; //定义验证码的宽度
		int height = 60; //定义验证码的高度
		graphics.setColor(Color.lightGray);// 定义上下文颜色
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.BLACK);
		graphics.drawRect(0, 0, width-1, height-1);//绘制边框
		
		// 绘制干扰点
		Random random = new Random();
		for (int i = 0 ; i<100; i++){
			
			int x = random.nextInt(width)-2;
			int y = random.nextInt(height)-2;
			graphics.drawOval(x, y, 2, 2);
			
		}
		
		graphics.setFont(new Font("黑体", Font.BOLD, 30)); //设置验证码的字体
		graphics.setColor(Color.BLUE);  // 设置验证码的颜色
		
		drawRandomBuffer(random, graphics);
		
	}
	
	private void  drawRandomBuffer (Random random,Graphics graphics){
		//产生随机的验证码
				char [] chars = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
				
				StringBuilder sBuilder = new StringBuilder();
				for (int i = 0; i < 4; i++) {
					int pos = random.nextInt(chars.length);
				    char ch = chars[pos];
				    sBuilder.append(ch+" ");
				}
				
				//写入验证码
				graphics.drawString(sBuilder.toString(), 20, 30);
	}
	
	
	
	
	
	
	
	
	
	
}
