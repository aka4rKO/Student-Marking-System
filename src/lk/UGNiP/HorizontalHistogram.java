package lk.UGNiP;

import java.awt.*;
import javax.swing.*;

//Extending a new frame from the JFrame super class
public class HorizontalHistogram extends JFrame {
	
	public HorizontalHistogram() {
		JLabel lbl = new JLabel("<html>0-29<br>30-39<br>40-69<br>70-100");
		JLabel lbl1 = new JLabel(StudentMarks.list.size() + " student(s) in total.");
		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		HorizontalPanel pnl3 = new HorizontalPanel();
		
		//Setting the frame's look and feel
		setTitle("Horizontal Histogram");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		//Adding the panels and labels to the frame
		pnl1.add(lbl);
		pnl2.add(lbl1);
		add(pnl1, BorderLayout.WEST);
		add(pnl2, BorderLayout.SOUTH);
		add(pnl3, BorderLayout.CENTER);
	}
}

//Extending a new panel from the JPanel super class
class HorizontalPanel extends JPanel{
	Student std = new Student();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		//Storing the stars in string variables after converting the numbers into stars
		String str1 = std.histogram(Student.count0to29);
		String str2 = std.histogram(Student.count30to39);
		String str3 = std.histogram(Student.count40to69);
		String str4 = std.histogram(Student.count70to100);
		
		//Displaying the stars in between the ranges horizontally 
		g.drawString(str1, 10, 20);
		g.drawString(str2, 10, 36);
		g.drawString(str3, 10, 54);
		g.drawString(str4, 10, 73);
		
		
	}
}


