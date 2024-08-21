package run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import daoimpl.StudentDAOImpl;
import enity.Student;

public class Main {
	public static void main(String[] args) {
		int luachon;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n============MENU============");
			System.out.println("1. Thêm mới sinh viên.");
			System.out.println("2. In ra tất cả sinh viên.");
			System.out.println("3. Sửa thông tin sinh viên.");
			System.out.println("4. Xóa thông tin sinh viên.");
			System.out.println("5. In ra thông tin sinh viên theo ID.");
			System.out.println("6. In ra thông tin sinh viên theo Name.");
			System.out.println("7. Thoát");
			System.out.print("Mời bạn chọn chương trình: ");
			luachon = Integer.parseInt(sc.nextLine());
			switch (luachon) {
			case 1: 
				Student students = new Student();
				System.out.println("Nhập thông tin sinh viên: ");
				students.input();
				boolean bool = new StudentDAOImpl().addStudent(students);
				if(bool) {
					System.out.println("Thêm mới thành công");
				} else {
					System.out.println("Thêm mới thất bại");
				}
				break;
			case 2: 
				List<Student> list = new StudentDAOImpl().getStudents();
				for(Student student : list) {
					System.out.println("Sinh viên: ");
					student.display();
				}
				break;
			case 3: 
				int id;
				System.out.println("Nhập mã sinh viên muốn sửa: ");
				id = Integer.parseInt(sc.nextLine());
				Student student = new Student();
				System.out.println("Nhập thông tin mới của nhân viên: ");
				student.input();
				boolean bool1 = new StudentDAOImpl().updateStudent(id, student);
				if(bool1) System.out.println("Cập nhật thành công");
				else System.out.println("Cập nhật thất bại");
				break;
			case 4: 
				int id1;
				System.out.println("Nhập mã sinh viên muốn xóa: ");
				id1 = Integer.parseInt(sc.nextLine());
				boolean bool2 = new StudentDAOImpl().deleteStudent(id1);
				if(bool2) System.out.println("Xóa thành công");
				else System.out.println("Xóa thất bại");
				break;
			case 5: 
				int id2;
				System.out.println("Nhập ID muốn tìm: ");
				id2 = Integer.parseInt(sc.nextLine());
				Student student1 = new StudentDAOImpl().getStudentbyId(id2);
				System.out.println("Các sinh viên tìm thấy: ");
				student1.display();
				break;
			case 6: 
				String name;
				System.out.println("Nhập tên sinh viên cần tìm: ");
				name = sc.nextLine();
				List<Student> listname = new StudentDAOImpl().getStudentByName(name);
				System.out.println("Thông tin các sinh viên có tên " + name +" là: " );
				for(Student student3 : listname) {
					student3.display();
				}
				break;
			case 7: 
				System.exit(0);
				break;
			default:
				System.out.println("Bạn chỉ nhập từ 1 đến 8");
			}
		}
	}
	
}
