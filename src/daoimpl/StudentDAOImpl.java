package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import database.Database;
import enity.Student;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public boolean addStudent(Student student) {
		boolean bool = false;
		Connection con;
		PreparedStatement ps;
		
		con = Database.getConnection();
		
		try {
			String sql = "INSERT INTO Student VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setBoolean(2, student.getGender());
			ps.setDate(3, new Date(student.getBirthday().getTime()));
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getPhone());
			ps.setString(6, student.getClassName());
			int i = ps.executeUpdate();
				if(i > 0) bool = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return bool;
	}

	@Override
	public boolean updateStudent(Integer id, Student student) {
		boolean bool = false;
		Connection con = null;
		PreparedStatement ps;
		
		con = Database.getConnection();
		
		try {
			String sql = "UPDATE Student SET name = ?, gender = ?, birthday = ?, address = ?, phone = ?, className = ? WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setBoolean(2, student.getGender());
			ps.setDate(3, new Date(student.getBirthday().getTime()));
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getPhone());
			ps.setString(6, student.getClassName());
			ps.setInt(7, id);
			int i = ps.executeUpdate();
			if(i > 0)
				bool = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bool;
	}

	@Override
	public boolean deleteStudent(Integer id) {
		boolean bool = false;
		Connection con;
		PreparedStatement ps;
		
		con = Database.getConnection();
		try {
			String sql = "DELETE FROM Student WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i > 0) bool = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bool;
	}

	@Override
	public Student getStudentbyId(Integer id) {
		Student student = new Student();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		
		con = Database.getConnection();
		
		try {
			String sql = "SELECT * FROM Student WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getBoolean("gender"));
				student.setBirthday(rs.getDate("birthday"));
				student.setAddress(rs.getString("address"));
				student.setPhone(rs.getString("phone"));
				student.setClassName(rs.getString("className"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		
		con = Database.getConnection();
		
		try {
			String sql = "SELECT * FROM Student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getBoolean("gender"));
				student.setBirthday(rs.getDate("birthday"));
				student.setAddress(rs.getString("address"));
				student.setPhone(rs.getString("phone"));
				student.setClassName(rs.getString("className"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Student> getStudentByName(String name) {
		List<Student> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		
		con = Database.getConnection();
		try {
			ps = con.prepareStatement("SELECT * FROM Student WHERE name like ?");
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getBoolean("gender"));
				student.setBirthday(rs.getDate("birthday"));
				student.setAddress(rs.getString("address"));
				student.setPhone(rs.getString("phone"));
				student.setClassName(rs.getString("className"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
