package lk.UGNiP;
import java.io.*;
import java.util.*;

public class StudentMarks {
	
	static List<Student> list = new ArrayList<Student>(); //Created a list to store the Student objects
	static int overallClassAverage; //Global variable to store overall class average after calculation 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean stop = false; //Boolean variable to stop asking for details from user
		
		
		//Initializing instance variables of the Student objects
		do {
			System.out.println("Enter registration number :");
			String regNo = sc.next();
		
			System.out.println("Enter first name :");
			String fName = sc.next();
		
			System.out.println("Enter last name :");
			String lName = sc.next();
		
			int ict1Marks = Student.validateMarks(sc,"Enter ICT 1 marks :");
			int ict2Marks = Student.validateMarks(sc,"Enter ICT 2 marks :");
			int totIctMarks = (int)((ict1Marks + ict2Marks) * 0.5);
			int cw1Marks = Student.validateMarks(sc,"Enter Coursework 1 marks :");
			int cw2Marks = Student.validateMarks(sc,"Enter Coursework 2 marks :");
			
			//Creating and setting student object values by sending the info. gathered by the user inputs through a constructor
			Student obj = new Student(regNo,fName,lName,ict1Marks,ict2Marks,totIctMarks,cw1Marks,cw2Marks);
			list.add(obj); //Storing the Student objects in a list
			
			System.out.println("Do you want to continue? (Type 'No' to stop / any other to continue)");
			String action = sc.next();
			if (action.equalsIgnoreCase("No")) {
				stop = true;
			} 
		} while (!stop);
		
		
		//Displaying the class averages of each component
		System.out.println("\nClass average for ICT(ICT 1 and 2) = " + Student.classAverageIct(list));
		System.out.println("Class average for Course Work 1 = " + Student.classAverageCw1(list));
		System.out.println("Class average for Course Work 2 = " + Student.classAverageCw2(list));
		overallClassAverage = Student.overallClassAverage(list);
		System.out.println("Overall class average = " + overallClassAverage);
		
		
		
		//Displaying the number of students who have got below 30 for each component
		System.out.println("\n" + Student.ictBelow30(list) + " student(s) has/have obtained marks below 30 for ICT");
		System.out.println(Student.cw1Below30(list) + " student(s) has/have obtained marks below 30 for Course Work 1");
		System.out.println(Student.cw2Below30(list) + " student(s) has/have obtained marks below 30 for Course Work 2");
		
		//Creating a new student object using the default constructor 
		Student std = new Student();
		std.separateAverage(list); //Separating the students into 2 lists (below and above class average) 
		System.out.println("\nStudents whose total module marks fall below the overall class average");
		System.out.println("----------------------------------------------------------------------");
		System.out.println(std.toString(std.tempLow));
		System.out.println("\nStudents whose total module marks fall above the overall class average");
		System.out.println("----------------------------------------------------------------------");
		
		//Sorting the students who got overall marks above the overall class average in descending order
		
		Student[] arr = new Student[std.tempHigh.size()];
		std.tempHigh.toArray(arr);
		System.out.println(std.toString(std.bubbleSort(arr)));
		
		//Highest student for ICT
		System.out.println("Highest student for ICT");
		System.out.println("-----------------------");
		System.out.println(std.toString(std.highest(list, "ict")));
		
		//Highest student for course work 1
		System.out.println("\nHighest student for Course Work 1");
		System.out.println("---------------------------------");
		System.out.println(std.toString(std.highest(list, "cw1")));
		
		//Highest student for course work 2
		System.out.println("\nHighest student for Course Work 2");
		System.out.println("---------------------------------");
		System.out.println(std.toString(std.highest(list, "cw2")));
		
		//Students who obtained the highest and lowest marks for the overall module marks
		System.out.println("\nHighest student for the module");
		System.out.println("--------------------------------");
		System.out.println(std.toString(std.highestAndLowest(list, "high")));
		
		System.out.println("\nLowest student for the module");
		System.out.println("-------------------------------");
		System.out.println(std.toString(std.highestAndLowest(list, "low")));		
		
		//Adding the re-sit and re-take students to separate lists
		std.resitRetakeDetails(list);
		
		//Details of the re-sit students
		System.out.println("\nRe-Sit students");
		System.out.println("-----------------");
		System.out.println(std.toString(std.reSit));
		
		//Details of the re-take students
		System.out.println("\nRe-Take students");
		System.out.println("------------------");
		
		//Sorting the re-take students in ascending order of their last name
		Student[] reTakeArr = new Student[std.reTake.size()];
		std.reTake.toArray(reTakeArr);
		System.out.println(std.toString(std.bubbleSortLName(reTakeArr)));
		
		std.horizontalHistogram(list);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Students_Details.txt"));
			
			for(int i = 0; i < list.size(); i++) {
				bw.write("Registration number : " + list.get(i).getRegNo()); bw.newLine();
				bw.write("First Name : " + list.get(i).getfName()); bw.newLine();
				bw.write("Last Name : " + list.get(i).getlName()); bw.newLine();
				bw.write("ICT marks : " + list.get(i).getTotIctMarks()); bw.newLine();
				bw.write("Course Work 1 marks : " + list.get(i).getCw1Marks()); bw.newLine();
				bw.write("Course Work 2 marks : " + list.get(i).getCw2Marks()); bw.newLine();
				bw.write("Overall marks : " + list.get(i).getOverallMarks()); bw.newLine();
				bw.write("Grade : " + list.get(i).getGrade()); bw.newLine();
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GUI frame = new GUI();
	}
	
	
}


