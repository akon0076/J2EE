package entity;

public class Student {
	Integer id;
	String classes;
	String name;
	String number;
	Integer age;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Student() {
	}
	
	public Student(Integer id, String classes, String number, String name, Integer age) {
		super();
		this.id = id;
		this.classes = classes;
		this.number = number;
		this.name = name;
		this.age = age;
	}
	

	

}
