package com.ssafy.dto;

public class Emp {
	// id,name,mailid,start_date,manager_id,title,dept_id,salary,commission_pct
	// int, String,String,String,int,String,int, double, double

	int id, manager_id, dept_id;
	String name, mailid, title, start_date;
	double salary, commission_pct;

	public Emp() {	}

	public Emp(String name, String mailid, String start_date, int manager_id, String title, int dept_id, double salary,
			double commission_pct) {
		this.name = name;
		this.mailid = mailid;
		this.start_date = start_date;
		this.manager_id = manager_id;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
	}

	public Emp(int id, String name, String mailid, String start_date, int manager_id, String title, int dept_id,
			double salary, double commission_pct) {
		this.id = id;
		this.name = name;
		this.mailid = mailid;
		this.start_date = start_date;
		this.manager_id = manager_id;
		this.title = title;
		this.dept_id = dept_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", manager_id=" + manager_id + ", dept_id=" + dept_id + ", name=" + name + ", mailid="
				+ mailid + ", title=" + title + ", start_date=" + start_date + ", salary=" + salary
				+ ", commission_pct=" + commission_pct + "]";
	}

}
