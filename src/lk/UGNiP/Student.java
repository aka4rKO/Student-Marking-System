package lk.UGNiP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student implements Comparable<Student> {
	//Creating instance variables
	private String regNo;
	private String fName;
	private String lName;
	private int ict1Marks;
	private int ict2Marks;
	private int totIctMarks;
	private int cw1Marks;
	private int cw2Marks;
	private int overallMarks;
	private Grade grade;
	List<Student> tempLow = new ArrayList<Student>(); //List of students whose overall marks fall below the total class average
	List<Student> tempHigh = new ArrayList<Student>(); //List of students whose overall marks fall above the total class average 
	List<Student> reTake = new ArrayList<Student>(); //List to store the details of the re-take student details
	List<Student> reSit = new ArrayList<Student>(); //List to store the details of the re-sit student details
	static int count0to29;
	static int count30to39;
	static int count40to69;
	static int count70to100;
	
	//Default constructor
	public Student() {
		
	}
	
	//Creating a constructor with 7 parameters
	public Student(String regNo, String fName, String lName, int ict1Marks, int ict2Marks, int totIctMarks,
			int cw1Marks, int cw2Marks) {
		super();
		this.regNo = regNo;
		this.fName = fName;
		this.lName = lName;
		this.ict1Marks = ict1Marks;
		this.ict2Marks = ict2Marks;
		this.totIctMarks = totIctMarks;
		this.cw1Marks = cw1Marks;
		this.cw2Marks = cw2Marks;
		this.overallMarks = calculateOverall(this.totIctMarks,this.cw1Marks,this.cw2Marks);
		this.grade = calGradeRetakeResit(this.overallMarks,this.totIctMarks,this.cw1Marks,this.cw2Marks);
	}

	//Defining getters for the instance variables
	public String getRegNo() {
		return regNo;
	}


	public String getfName() {
		return fName;
	}


	public String getlName() {
		return lName;
	}


	public int getIct1Marks() {
		return ict1Marks;
	}


	public int getIct2Marks() {
		return ict2Marks;
	}
	
	public int getTotIctMarks() {
		return totIctMarks;
	}

	public int getCw1Marks() {
		return cw1Marks;
	}


	public int getCw2Marks() {
		return cw2Marks;
	}


	public int getOverallMarks() {
		return overallMarks;
	}


	public Grade getGrade() {
		return grade;
	}
	
	//Method to check if the marks fall in the range of 0 to 100, checks if the data type is an integer 
	//and returns the validated marks to the variables which are passed through the constructor  
	static int validateMarks(Scanner sc, String label) {
		int marks;
		System.out.println(label);
		do{
			while(!sc.hasNextInt()){
				System.err.println("Invalid input! please enter a mark within the range of 0 to 100");
				sc.next();
			}
			marks = sc.nextInt();
			if (!(marks >= 0 && marks <= 100)){
				System.err.println("Invalid marks! input a mark within the range of 0 to 100");
			}
		}while (!(marks >= 0 && marks <= 100));
		
		return marks; 
	}
	
	//Method to calculate the overall marks
	int calculateOverall(int totIctMarks,int cw1Marks,int cw2Marks ){
		int overallMarks = (int)((totIctMarks * 0.4) + (cw1Marks * 0.3) + (cw2Marks * 0.3));
		return overallMarks;
	}
	
	//Method to determine the grade
	Grade calGradeRetakeResit(int overallMarks, int totIctMarks, int cw1Marks, int cw2Marks){
		Grade gradeTemp = null;
		if (overallMarks >= 40 && totIctMarks >= 30 && cw1Marks >= 30 && cw2Marks >= 30) {
			if (overallMarks >= 70) {
				gradeTemp = Grade.First_Class;
			} else if (overallMarks >= 60) {
				gradeTemp = Grade.Second_Upper_Class;
			} else if (overallMarks >= 50) {
				gradeTemp = Grade.Second_Lower_Class;
			} else if (overallMarks >= 40) {
				gradeTemp = Grade.General_Pass;
			}
		} else if (overallMarks < 30) {
			gradeTemp = Grade.Fail_Retake;
		} else {
			gradeTemp = Grade.Fail_Resit;
		}
		return gradeTemp;	
	} 
	
	//Method to find the class average of ICT
	static int classAverageIct(List<Student> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++ ) {
			sum += list.get(i).getTotIctMarks();
		} return sum / list.size();
	}

	//Method to find the class average of course work 1
	static int classAverageCw1(List<Student> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++ ) {
			sum += list.get(i).getCw1Marks();
		} return sum / list.size();
	}
	
	//Method to find the class average of course work 2
	static int classAverageCw2(List<Student> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++ ) {
			sum += list.get(i).getCw2Marks();
		} return sum / list.size();
	}
	
	//Method to find the overall class average
	static int overallClassAverage(List<Student> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++ ) {
			sum += list.get(i).getOverallMarks();
		} return sum / list.size();
	}
	
	//Method to find the number of students who have scored below 30 for ICT
	static int ictBelow30(List<Student> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++ ) {
			if (list.get(i).getTotIctMarks() < 30) {
				count += 1;
			}
		} 
		return count;
	}
	
	//Method to find the number of students who have scored below 30 for course work 1
	static int cw1Below30(List<Student> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++ ) {
			if (list.get(i).getCw1Marks() < 30) {
				count += 1;
			}
		} 
		return count;
	}
	
	//Method to find the number of students who have scored below 30 for course work 2
	static int cw2Below30(List<Student> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++ ) {
			if (list.get(i).getCw2Marks() < 30) {
				count += 1;
			}
		} 
		return count;
	}
	
	//Method to calculate the highest for each component
	Student highest(List<Student> list, String str) {
		Student highest = list.get(0);
		switch(str) {
			case "ict": 
				for(int i = 0; i < list.size(); i++) {
					if (list.get(i).getTotIctMarks() > highest.getTotIctMarks()) {
						highest = list.get(i);
					}
				}
				break;
			case "cw1": 
				for(int i = 0; i < list.size(); i++) {
					if (list.get(i).getCw1Marks() > highest.getCw1Marks()) {
						highest = list.get(i);
					}
				}
				break;
			case "cw2": 
				for(int i = 0; i < list.size(); i++) {
					if (list.get(i).getCw2Marks() > highest.getCw2Marks()) {
						highest = list.get(i);
					}
				}
				break;
		}
		return highest;
	}
	
	//Method to find the highest and the lowest student based on the overall marks
	Student highestAndLowest(List<Student> list, String str) {
		Student highLow = list.get(0);
		switch(str) {
		case "high":
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i).getOverallMarks() > highLow.getOverallMarks()) {
					highLow = list.get(i);
				}
			}
			break;
		case "low":
			for(int i = 0; i < list.size(); i++) {
				if (list.get(i).getOverallMarks() < highLow.getOverallMarks()) {
					highLow = list.get(i);
				}
			}
			break;
		}
		return highLow;
	}
	
	//Method to display the details of a student list 
	public String toString(List<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\nRegistration number : " + list.get(i).getRegNo() + "\nFirst Name : " + list.get(i).getfName() + "\nLast Name : "
					+ list.get(i).getlName() + "\nICT marks : " + list.get(i).getTotIctMarks() + "\nCourse Work 1 marks : "
					+ list.get(i).getCw1Marks() + "\nCourse Work 2 marks : " + list.get(i).getCw2Marks() + "\nOverall marks : " 
					+ list.get(i).getOverallMarks() + "\nGrade : " + list.get(i).getGrade());
		}
		return "\n";
	}
	
	//Method to display the details of a student object
	public String toString(Student st1) {
		return "\nRegistration number : " + st1.getRegNo() + "\nFirst Name : " + st1.getfName() + "\nLast Name : "
					+ st1.getlName() + "\nICT marks : " + st1.getTotIctMarks() + "\nCourse Work 1 marks : " 
				+ st1.getCw1Marks() + "\nCourse Work 2 marks : " + st1.getCw2Marks() +"\nOverall marks : " 
					+ st1.getOverallMarks() + "\nGrade : " + st1.getGrade();
		
		
	}
	
	//Method to add the details of students whose total module marks fall below/above the class average to the respective lists
	void separateAverage(List<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOverallMarks() < StudentMarks.overallClassAverage) {
				tempLow.add(list.get(i));
			} else {
				tempHigh.add(list.get(i));
			}
		} 
	}
	
	//Method to add the details of re-sit and re-take students to a list
	void resitRetakeDetails(List<Student> list){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getGrade() == Grade.Fail_Resit) {
				reSit.add(list.get(i));
			} else if (list.get(i).getGrade() == Grade.Fail_Retake) {
				reTake.add(list.get(i));
			}
		}
		
	}
	
	//Method to bubble sort the students whose overall mark fall above the overall class average in 
	//descending order of their overall marks
	List<Student> bubbleSort(Student[] arr) {
		int n = arr.length;
		Student temp;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < (n-i); j++) {
				if(arr[j-1].getOverallMarks() < arr[j].getOverallMarks()) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		List<Student> list = Arrays.asList(arr);
		return list;
	}
	
	//sorting the re-take students by their last name
	List<Student> bubbleSortLName(Student[] arr) {
		int n = arr.length;
		Student temp;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < (n-i); j++) {
				if(arr[j-1].compareTo(arr[j]) > 0) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		List<Student> list = Arrays.asList(arr);
		return list;
	}
	
	//Comparing students by their last name 
	@Override
	public int compareTo(Student std1) {
		return this.lName.compareTo(std1.lName);
	}
		
	//Method to count the number of stars for the histogram
	void horizontalHistogram(List<Student> list) {
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getOverallMarks() >= 0 && list.get(i).getOverallMarks() < 30) {
				count0to29++;
			} else if (list.get(i).getOverallMarks() >= 30 && list.get(i).getOverallMarks() < 40) {
				count30to39++;
			} else if (list.get(i).getOverallMarks() >= 40 && list.get(i).getOverallMarks() < 70) {
				count40to69++;
			} else {
				count70to100++;
			}
		}
	}
	
	//Method to print the stars to the histogram
	String histogram(int num) {	
		StringBuilder builder=new StringBuilder();
		for(int j=0; j < num; j++) {
			builder.append('*');
		}
		return builder.toString();
	}

}
