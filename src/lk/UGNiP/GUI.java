package lk.UGNiP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame {
	
	JPanel panel;
	JPanel panel1;
	JButton btn1;
	JButton btn2;
	JLabel lbl;
	
	public GUI() {
		//Creating a new student object to access it's attributes and methods
		Student tempStd = new Student();
		tempStd.resitRetakeDetails(StudentMarks.list);
		tempStd.separateAverage(StudentMarks.list);
		panel = new JPanel();
		panel1 = new JPanel();
		lbl = new JLabel("<html>Class average for ICT(ICT 1 and 2) = " + Student.classAverageIct(StudentMarks.list) + 
				"<br>Class average for Course Work 1 = " + Student.classAverageCw1(StudentMarks.list) + 
				"<br>Class average for Course Work 2 = " + Student.classAverageCw2(StudentMarks.list) + 
				"<br>Overall class average = " + StudentMarks.overallClassAverage + 
				"<br><br>Number of students below 30 for each componenet" + 
				"<br>ICT = " + Student.ictBelow30(StudentMarks.list) + 
				"<br>Course Work 1 = " + Student.cw1Below30(StudentMarks.list) + 
				"<br>Course Work 2 = " + Student.cw2Below30(StudentMarks.list) + "<br><br>" + 
				tempStd.tempLow.size() + " student(s) total module marks fall below class average<br>" + 
				tempStd.tempHigh.size() + " student(s) total module marks fall above class average<br><br>" + 
				tempStd.reSit.size() + " Re-Sit student(s)<br>" + tempStd.reTake.size() + " Re-Take student(s)</html>");
		btn1 = new JButton("Histogram (Vertical)");
		btn2 = new JButton("Histogram (Horizontal)");
		
		//Setting the main frame's look and feel
		setTitle("Students Statistics");
		setSize(600,330);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		//Adding buttons and labels to the panels and adding panels to the frame
		panel.add(lbl);
		panel1.add(btn1);
		panel1.add(btn2);
		add(panel, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);
		
		//When clicked on the "Histogram (Horizontal)" button the horizontal histogram frame will appear
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				HorizontalHistogram horiHist = new HorizontalHistogram();
			}
			
		});
		
		//When clicked on the "Histogram (Vertical)" button the horizontal histogram frame will appear
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				VerticalHistogram vertiHist = new VerticalHistogram();
				
			}
			
		});
	}
	

}
