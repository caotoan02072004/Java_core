package dao;

import java.util.List;

import enity.Student;

public interface StudentDAO {
	public boolean addStudent(Student student);
	public boolean updateStudent(Integer id, Student student);
	public boolean deleteStudent(Integer id);
	public Student getStudentbyId(Integer id);
	public List<Student> getStudents();
	public List<Student> getStudentByName(String name);
}
