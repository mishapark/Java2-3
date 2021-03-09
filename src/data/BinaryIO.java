package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import business.Student;

public class BinaryIO {
	private static File myFile = new File("Student.txt");
	
	public static void writeStudent(Student student) throws IOException {
		try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream(myFile, true))){
			dOut.writeUTF(student.getID());
			dOut.writeUTF(student.getProgram());
			dOut.writeUTF(student.getSemester());
			dOut.writeUTF(student.getCourse());
		} 
	}
	
	public static Object[] readStudents() throws IOException {
		ArrayList<String> students = new ArrayList<String>();
		try(DataInputStream dIn = new DataInputStream(new FileInputStream(myFile))) {
			while(dIn.available() > 0)
				students.add(dIn.readUTF());
		}
		return students.toArray();
	}
}