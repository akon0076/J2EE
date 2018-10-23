package entity;

public class Employee {
	Integer id;
    String name;
    String number;
    Integer age;

    public Employee(String name, String number, Integer age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }
    public Employee() {
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
    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", number = " + number + "]";
	}
}
