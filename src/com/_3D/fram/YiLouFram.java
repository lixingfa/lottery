package com._3D.fram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com._3D.number.Number1;
import com._3D.number.Number2;
import com._3D.number.Number3;
import com._3D.number.Periods;


/**
 * 
 * @author lixingfa
 *
 */
public class YiLouFram extends JFrame{
	JPanel cPane;
	JComboBox comboBox;
	JCheckBox qishuCheckBox;//期数
	JCheckBox simpCheckBox;//简化（走势）
	JTextField xTextField;//x轴间距
	JTextField yTextField;//y轴间距
	JSpinner nowSpinner;//当前期数
	int[] nums = Number1.num;//默认
	String[] periods = Periods.periods;
	/**
	 * 构造方法，初始化界面
	 */
	public YiLouFram() {		
		super("趋势分析");
		setSize(1300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);// 设置窗体可见
		
		final JPanel contenpPane = (JPanel)getContentPane();
		contenpPane.setLayout(new BorderLayout());//北、南、东、西、中布局
		
		//顶部区域，主要是菜单
		JPanel northPane = new JPanel();
		northPane.setBackground(Color.white);
		comboBox = new JComboBox(new String[]{"百","十","个"});
		northPane.add(comboBox);
		qishuCheckBox = new JCheckBox("期数线",false);
		northPane.add(qishuCheckBox);
		northPane.add(new JTextArea(" 当前期数"));
		nowSpinner = new JSpinner();
		nowSpinner.setValue(50);
		northPane.add(nowSpinner);
		simpCheckBox = new JCheckBox("走势",false);
		northPane.add(simpCheckBox);
		northPane.add(new JTextArea(" 简化标尺"));
		northPane.add(new JTextArea(" X"));
		xTextField = new JTextField("15",3);
		northPane.add(xTextField);
		northPane.add(new JTextArea(" Y"));
		yTextField = new JTextField("15",3);
		northPane.add(yTextField);
		
		JButton darwButton = new JButton("绘图");
		northPane.add(darwButton);
		contenpPane.add(BorderLayout.NORTH,northPane);
		
		
		//中部区域，画板
		JPanel centerPane = new DrawPanel();
		contenpPane.add(BorderLayout.CENTER,centerPane);
		centerPane.setBackground(Color.WHITE);
		
		/**事件绑定***********************************************/
		//下拉按钮事件
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getNums();
				contenpPane.repaint();
			}
		});
		nowSpinner.addChangeListener(new ChangeListener() {			
			@Override
			public void stateChanged(ChangeEvent e) {
				contenpPane.repaint();
			}
		});
		//绘画按钮事件
		darwButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenpPane.repaint();				
			}
		});
		//显示期数
		qishuCheckBox.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenpPane.repaint();
			}
		});
		//走势线
		simpCheckBox.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				contenpPane.repaint();
			}
		});
	}

	class DrawPanel extends JPanel {
		// 重绘方法
		public void paint(Graphics g) {
			super.paint(g);
			
			int width = this.getWidth();
			int height = this.getHeight() - 80;
			int x = Integer.parseInt(xTextField.getText());
			int y = Integer.parseInt(yTextField.getText());
			int now = Integer.parseInt(nowSpinner.getValue().toString());
			
			//绘制号码线
			drawNumLine(nums, now, height, width, x, y, g, null);
			if (qishuCheckBox.isSelected()) {
				drawXLine(nums, now, height, width, x, y, g, null);				
			}
		}
	}

	/**
	 * 绘制号码线
	 * @param nums 数据
	 * @param now 当前期数
	 * @param height 画布高
	 * @param width 画布宽
	 * @param x x增量
	 * @param y y增量
	 * @param g
	 * @param color
	 */
	private void drawNumLine(int[] nums,int now,int height,int width,int x,int y,Graphics g,Color color){
		Set<Integer> set = new HashSet();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);
		set.add(9);
		
		if (color != null) {
			g.setColor(color);
		}
		int nowWidthold = 0;
		int nowHeightold = height;
		int nowWidth = 0;
		int nowHeight = 0;
		if (now - 1 >= 0) {
			nowWidthold = 0;
			int gailv = how(nums, now, set);
			nowHeightold = (int)(height - gailv * y);//坐标是从左上角开始的，所以值越小越高
			//g.drawString(gailv+"", nowWidthold, nowHeightold);
		}
		int length = nums.length;
		for (int i = 1; nowWidth < width && now < length; i++) {//屏幕走势
			nowWidth = i * x;
			int gailv = how(nums, now, set);
			nowHeight = height - gailv * y;//坐标是从左上角开始的，所以值越小越高
			g.drawLine(nowWidthold,nowHeightold, nowWidth, nowHeight);
			g.drawString(gailv+"", nowWidth, nowHeight);
			nowWidthold = nowWidth;
			nowHeightold = nowHeight;
			now++;
		}
	}
	
	private int how(int[] num,int now,Set<Integer> set){
		float total = 0;
		for (int i = 0; i < 50; i++) {
			if (set.contains(num[now - i])) {
				total++;
			}
		}
		return (int)(total / 50 * 100);
	}
	
	//
	private void drawXLine(int[] nums,int now,int height,int width,int x,int y,Graphics g,Color color){
		if (color != null) {
			g.setColor(color);
		}
		int length = nums.length;
		int nowWidth = 0;
		int nowHeight = 400;
		for (int i = 1; nowWidth < width && now < length; i++) {//屏幕走势
			nowWidth = i * x;
			nowHeight = height - (nums[now] + 3) * y;
			g.drawLine(nowWidth,nowHeight, nowWidth, height);
			g.drawString(i + "",nowWidth - x, height);
//			char[] temps = periods[now].toCharArray();//如果已经超出界限，是需要增加1的
//			for (int j = 0; j < temps.length; j++) {
//				g.drawString(String.valueOf(temps[j]), nowWidth - x, height + j * 12);
//			}
			now++;
		}
	}
	
	private void getNums(){
		switch (comboBox.getSelectedIndex()) {
		case 0:
			nums = Number1.num;
			break;
		case 1:
			nums = Number2.num;
			break;
		case 2:
			nums = Number3.num;
			break;
		}
	}
	
	/**
	 * 主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new YiLouFram();
	}	
}
