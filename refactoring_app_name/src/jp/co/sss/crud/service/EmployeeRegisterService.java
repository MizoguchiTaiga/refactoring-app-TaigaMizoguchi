package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeRegisterService {

	public static void execute()
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		// 登録する値を入力
		ConsoleWriter.showInsertEmpName();
		String empName = EmployeeNameReader.inputEmpName();
		ConsoleWriter.showInsertGender();
		String gender = EmployeeGenderReader.inputGender();
		ConsoleWriter.showInsertBirthday();
		String birthday = EmployeeBirthdayReader.inputBirthday();
		ConsoleWriter.showInsertDeptId();
		String deptId = EmployeeDeptIdReader.inputDeptId();
		
		// EmployeeDAO のメソッドを呼び出し
		EmployeeDAO.insertEmp(empName, gender, birthday, deptId);
		ConsoleWriter.showCompleteInsert();
	}

}
