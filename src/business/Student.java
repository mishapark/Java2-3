package business;

public class Student {
	String ID, Program, Semester, Course;
	
	public Student (String id, String program, String semester, String course) {
		this.setID(id);
		this.setProgram(program);
		this.setSemester(semester);
		this.setCourse(course);
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		this.ID = id;
	}
	
	public String getProgram() {
		return Program;
	}
	public void setProgram(String program) {
		this.Program = program;
	}
	
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		this.Semester = semester;
	}
	
	public String getCourse() {
		return Course;
	}
	public void setCourse(String semester) {
		this.Course = semester;
	}
}
