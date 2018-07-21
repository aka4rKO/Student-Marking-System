package lk.UGNiP;

import java.awt.*;
import javax.swing.*;

//Extending a new frame from the JFrame super class
public class VerticalHistogram extends JFrame {
	
	public VerticalHistogram() {
		JLabel lbl = new JLabel("0-29  30-39  40-69  70-100");
		JLabel lbl1 = new JLabel(StudentMarks.list.size() + " student(s) in total.");
		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		VerticalPanel pnl3 = new VerticalPanel();
		
		//Setting the frame's look and feel
		setTitle("Vertical Histogram");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		//Adding the panels and labels to the frame
		pnl1.add(lbl);
		pnl2.add(lbl1);
		add(pnl1, BorderLayout.NORTH);
		add(pnl2, BorderLayout.SOUTH);
		add(pnl3, BorderLayout.CENTER);
	}
}

//Extending a new panel from the JPanel super class
class VerticalPanel extends JPanel{
	Student std = new Student();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		
		//Displaying the stars in between the ranges vertically 
		for(int i = 0, j = 20; i < Student.count0to29; i++, j += 5) {
			g.drawString("*", 77, j);
		}
		for(int i = 0, j = 20; i < Student.count30to39; i++, j += 5) {
			g.drawString("*", 117, j);
		}
		for(int i = 0, j = 20; i < Student.count40to69; i++, j += 5) {
			g.drawString("*", 157, j);
		}
		for(int i = 0, j = 20; i < Student.count70to100; i++, j += 5) {
			g.drawString("*", 197, j);
		}
		
		
	}
}
