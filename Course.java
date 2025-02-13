import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Course implements java.io.Serializable {
	String courseName;
	String courseID;
	int maxStudents;
	int currentStudents;
	ArrayList<Student> studentList;
	String instructorName;
	int courseSection;
	String courseLocation;
	static ArrayList<Course> courseList = new ArrayList<Course>();

	Course() {

	}

	Course(String courseName, String courseID, int maxStudents, int currentStudents, String instructorName,
			int courseSection, String courseLocation) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.maxStudents = maxStudents;
		this.currentStudents = currentStudents;
		this.studentList = new ArrayList<Student>();
		this.instructorName = instructorName;
		this.courseSection = courseSection;
		this.courseLocation = courseLocation;
	}

	public String print() {
		String names = "";

		if (studentList != null) {
			for (int i = 0; i < studentList.size(); i++) {
				String addFirst = studentList.get(i).getFirstName();
				String addLast = studentList.get(i).getLastName();
				names = names + addFirst + " " + addLast + ", ";
			}
			System.out.println("Course: " + courseName + "\n" + "Course ID: " + courseID + "\n"
					+ "Maximum # of Students: " + maxStudents + "\n" + "Current # of Students: " + currentStudents
					+ "\n" + "Registered Students: " + names + "\n" + "Instructor: " + instructorName + "\n"
					+ "Section: " + courseSection + "\n" + "Location: " + courseLocation);
			System.out.println("==========");
			String text1 = "Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
					+ maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
					+ names + "\n" + "Instructor: " + instructorName + "\n" + "Section: " + courseSection + "\n"
					+ "Location: " + courseLocation;
			return (text1);
		} else {
			System.out.println("Course: " + courseName + "\n" + "Course ID: " + courseID + "\n"
					+ "Maximum # of Students: " + maxStudents + "\n" + "Current # of Students: " + currentStudents
					+ "\n" + "Registered Students: " + studentList + "\n" + "Instructor: " + instructorName + "\n"
					+ "Section: " + courseSection + "\n" + "Location: " + courseLocation);
			System.out.println("==========");
			String text2 = "Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
					+ maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
					+ studentList + "\n" + "Instructor: " + instructorName + "\n" + "Section: " + courseSection + "\n"
					+ "Location: " + courseLocation;
			return (text2);
		}
	}

	public String studentPrint() {
		System.out.println("Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
				+ maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
				+ "\n" + "Instructor: " + instructorName + "\n" + "Section: " + courseSection + "\n" + "Location: "
				+ courseLocation);
		System.out.println("==========");
		String text = "Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
				+ maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
				+ "\n" + "Instructor: " + instructorName + "\n" + "Section: " + courseSection + "\n" + "Location: "
				+ courseLocation;
		return (text);
	}

	//Getters and Setters

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getCurrentStudents() {
		return currentStudents;
	}

	public void setCurrentStudents(int currentStudents) {
		this.currentStudents = currentStudents;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public int getCourseSection() {
		return courseSection;
	}

	public void setCourseSection() {
		this.courseSection = courseSection;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}

	// public static void deSerialization() {
	// 	try {
	// 		FileInputStream fis = new FileInputStream("CRSData.ser");
	// 		ObjectInputStream ois = new ObjectInputStream(fis);

	// 		courseList = (ArrayList<Course>) ois.readObject();
	// 		ois.close();
	// 		fis.close();
	// 		System.out.println("Deserialization complete");
	// 	} catch (IOException ioe) {
	// 		ioe.printStackTrace();
	// 	} catch (ClassNotFoundException c) {
	// 		System.out.println("Class not found");
	// 		c.printStackTrace();
	// 	}
	// }

	// public static void serialization() {
	// 	try {
	// 		FileOutputStream fos = new FileOutputStream("CRSData.ser");
	// 		ObjectOutputStream oos = new ObjectOutputStream(fos);

	// 		oos.writeObject(courseList);
	// 		oos.close();
	// 		fos.close();
	// 		System.out.println("Serialization complete");
	// 	} catch (IOException ioe) {
	// 		ioe.printStackTrace();
	// 	}
	// }

}
