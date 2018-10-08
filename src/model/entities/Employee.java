package model.entities;

public class Employee implements Comparable<Employee> {
	private String name;
	private Double salary;

	public Employee() {
	}

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee: " + getName() + String.format(" - Salary: $%.2f", getSalary());
	}

	@Override
	public int compareTo(Employee other) {
		// TODO Auto-generated method stub
		// Ordenando por name
		// return name.compareTo(other.getName());
		// Ordenando por salary
		return -salary.compareTo(other.getSalary());
	}

}
