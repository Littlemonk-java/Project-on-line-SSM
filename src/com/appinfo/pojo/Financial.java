package com.appinfo.pojo;

public class Financial {
	private int id;
	private String income;
	private String incomepeojectid;
	private String incometime;
	private String projectname;
	private String num; 
	private String one;
	
	public Financial(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getIncomepeojectid() {
		return incomepeojectid;
	}

	public void setIncomepeojectid(String incomepeojectid) {
		this.incomepeojectid = incomepeojectid;
	}

	public String getIncometime() {
		return incometime;
	}

	public void setIncometime(String incometime) {
		this.incometime = incometime;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public Financial(int id, String income, String incomepeojectid,
			String incometime, String projectname, String num, String one) {
		super();
		this.id = id;
		this.income = income;
		this.incomepeojectid = incomepeojectid;
		this.incometime = incometime;
		this.projectname = projectname;
		this.num = num;
		this.one = one;
	}



	
	

}
