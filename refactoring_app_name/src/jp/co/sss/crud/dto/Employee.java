package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantMsg;

public class Employee {

	// 社員ID
	private int empId;
	// 社員名
	private String empName;
	// 性別
	private int gender;
	// 生年月日
	private String birthday;
	// 部署ID
	private Department department;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		String gender_ja = ConstantMsg.BLANK;
		if (this.gender == 0) {
			gender_ja = ConstantMsg.OTHER;
		} else if (this.gender == 1) {
			gender_ja = ConstantMsg.MALE;
		} else if (this.gender == 2) {
			gender_ja = ConstantMsg.FEMALE;
		} else if (this.gender == 9) {
			gender_ja = ConstantMsg.NO_ANSWER;
		}

		return empId + ConstantMsg.TAB + empName + ConstantMsg.TAB + gender_ja
				+ ConstantMsg.TAB + birthday + ConstantMsg.TAB + department.getDeptName();
	}

}
