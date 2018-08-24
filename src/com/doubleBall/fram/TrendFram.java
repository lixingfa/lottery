package com.doubleBall.fram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import com.doubleBall.method.BaseMethod;
import com.doubleBall.number.Bull;
import com.doubleBall.number.Number1;
import com.doubleBall.number.Number1Y;
import com.doubleBall.number.Number2;
import com.doubleBall.number.Number2Y;
import com.doubleBall.number.Number3;
import com.doubleBall.number.Number3Y;
import com.doubleBall.number.Number4;
import com.doubleBall.number.Number4Y;
import com.doubleBall.number.Number5;
import com.doubleBall.number.Number5Y;
import com.doubleBall.number.Number6;
import com.doubleBall.number.Number6Y;
/**
 * 专门用来分析趋势的窗体
 * @author lixingfa
 *
 */
public class TrendFram extends JFrame{
	JPanel cPane;
	JComboBox comboBox;
	JCheckBox originalCheckBox;//原来的值
	JCheckBox qishuCheckBox;//期数
	JCheckBox simpCheckBox;//简化（走势）
	JTextField xTextField;//x轴间距
	JTextField yTextField;//y轴间距
	JSpinner nowSpinner;//当前期数
	JTextField consultTextField;//简化标尺
	int[] nums = Number1Y.getAscNum();//默认第一个红球
	/**
	 * 构造方法，初始化界面
	 */
	public TrendFram() {		
		super("纹理分析");
		setSize(1300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);// 设置窗体可见
		
		final JPanel contenpPane = (JPanel)getContentPane();
		contenpPane.setLayout(new BorderLayout());//北、南、东、西、中布局
		
		//顶部区域，主要是菜单
		JPanel northPane = new JPanel();
		northPane.setBackground(Color.white);
		comboBox = new JComboBox(new String[]{"红球1","红球2","红球3","红球4","红球5","红球6","红球均值","篮球"});
		northPane.add(comboBox);
		originalCheckBox = new JCheckBox("原值", true);
		northPane.add(originalCheckBox);
		qishuCheckBox = new JCheckBox("期数线",false);
		northPane.add(qishuCheckBox);
		northPane.add(new JTextArea(" 当前期数"));
		nowSpinner = new JSpinner();
		nowSpinner.setValue(1000);
		northPane.add(nowSpinner);
		simpCheckBox = new JCheckBox("走势",false);
		northPane.add(simpCheckBox);
		northPane.add(new JTextArea(" 简化标尺"));
		consultTextField = new JTextField("1",3);
		northPane.add(consultTextField);
		northPane.add(new JTextArea(" X"));
		xTextField = new JTextField("10",3);
		northPane.add(xTextField);
		northPane.add(new JTextArea(" Y"));
		yTextField = new JTextField("10",3);
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
		//选择原值事件
		originalCheckBox.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				getNums();
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
			int height = this.getHeight() - 60;
			int x = Integer.parseInt(xTextField.getText());
			int y = Integer.parseInt(yTextField.getText());
			int now = Integer.parseInt(nowSpinner.getValue().toString());
			
			//绘制号码线
			drawNumLine(nums, now, height, width, x, y, g, null);
			if (simpCheckBox.isSelected()) {
				int consult = Integer.parseInt(consultTextField.getText());
				//绘制走势线
				SimplifyBight.vertical(nums, consult, x, y, height,now, g,Color.red);
				
			}
			if (qishuCheckBox.isSelected()) {
				drawXLine(nums, now, height, width, x, y, g, null);				
			}
			//drawNumLine(Number1.num, now, height, width, x, y, g, Color.black);
			//drawNumLine(Number2.num, now, height, width, x, y, g, Color.blue);
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
		if (color != null) {
			g.setColor(color);
		}
		int nowWidthold = 0;
		int nowHeightold = height;
		int nowWidth = 0;
		int nowHeight = 0;
		if (now - 1 >= 0) {
			nowWidthold = 0;
			nowHeightold = (int)(height - nums[now - 1] * y);
			g.drawString(nums[now - 1]+"", nowWidthold, nowHeightold);
		}
		int length = nums.length;
		for (int i = 1; nowWidth < width && now < length; i++) {//屏幕走势
			nowWidth = i * x;
			nowHeight = height - nums[now] * y;
			g.drawLine(nowWidthold,nowHeightold, nowWidth, nowHeight);
			g.drawString(nums[now]+"", nowWidth, nowHeight);
			nowWidthold = nowWidth;
			nowHeightold = nowHeight;
			now++;
		}
	}
	//
	private void drawXLine(int[] nums,int now,int height,int width,int x,int y,Graphics g,Color color){
		if (color != null) {
			g.setColor(color);
		}
		int length = nums.length;
		int nowWidth = 0;
		int nowHeight = 0;
		for (int i = 1; nowWidth < width && now < length; i++) {//屏幕走势
			nowWidth = i * x;
			nowHeight = height - nums[now] * y;
			g.drawLine(nowWidth,nowHeight, nowWidth, height);
			int temp = now;//如果已经超出界限，是需要增加1的
			int cheng = 4;
			while (temp > 0) {
				g.drawString(temp % 10 + "", nowWidth - x, height + cheng * 12);					
				temp = temp / 10;
				cheng--;
			}
			now++;
		}
	}
	
	//获取红球总值
	private int[] getTotle(){
		int[] totles = new int[Number6.num.length];
		for (int i = 0; i < totles.length; i++) {
			totles[i] = Number6.num[i] + Number5.num[i] + Number4.num[i] + Number3.num[i] + Number2.num[i] + Number1.num[i];
		}
		return totles;
	}
	
	private void getNums(){
		boolean isOriginal = originalCheckBox.isSelected();
		switch (comboBox.getSelectedIndex()) {
		case 0:
			if (isOriginal) {
				nums = Number1Y.num;
			}else {
				nums = Number1.num;
			}
			break;
		case 1:
			if (isOriginal) {
				nums = Number2Y.num;
			}else {
				nums = Number2.num;
			}
			break;
		case 2:
			if (isOriginal) {
				nums = Number3Y.num;	
			}else {
				nums = Number3.num;						
			}
			break;
		case 3:
			if (isOriginal) {
				nums = Number4Y.num;
			}else {
				nums = Number4.num;						
			}
			break;
		case 4:
			if (isOriginal) {
				nums = Number5Y.num;
			}else {
				nums = Number5.num;						
			}
			break;
		case 5:
			if (isOriginal) {
				nums = Number6Y.num;	
			}else {
				nums = Number6.num;
			}
			break;
		case 6:
			nums = getTotle();
			break;
		default:
			nums = Bull.num;
			break;
		}
		nums = BaseMethod.desc(nums);
	}
	
	/**
	 * 主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TrendFram();
	}	
}
