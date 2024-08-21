package enity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
	private Integer id;
	private String name;
	private Boolean gender;
	private Date birthday;
	private String address;
	private String phone;
	private String className;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, Boolean gender, Date birthday, String address, String phone,
			String className) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.className = className;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên sinh viên: ");
		name = sc.nextLine();
		System.out.println("Nhập giới tính sinh viên: ");
		gender = Boolean.parseBoolean(sc.nextLine());
		System.out.println("Nhập ngày sinh của sinh viên: ");
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			birthday = sf.parse(sc.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Nhập địa chỉ sinh viên: ");
		address = sc.nextLine();
		System.out.println("Nhập số điện thoại sinh viên: ");
		phone = sc.nextLine();
		System.out.println("Nhập tên lớp học: ");
		className = sc.nextLine();
	}
	
	public void display() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("\n\tHiển thị thông tin sinh viên: ");
		System.out.println("Mã số sinh viên: " + id);
		System.out.println("Tên sinh viên: " + name);
		System.out.println("Giới tính sinh viên: " + (gender ? "Nam" : "Nữ"));
		System.out.println("Ngày sinh của sinh viên: " + sf.format(birthday));
		System.out.println("Địa chỉ của sinh viên: " + address);
		System.out.println("Số điện thoại của sinh viên: " + phone);
		System.out.println("Lớp học: " + className);	
	}
}
