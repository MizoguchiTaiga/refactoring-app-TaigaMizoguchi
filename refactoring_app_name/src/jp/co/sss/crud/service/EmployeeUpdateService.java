package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeUpdateService {

	public static void execute()
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		// 更新する社員の社員IDを入力
		ConsoleWriter.showupdate();
		String empId = EmployeeEmpIdReader.inputEmpId();
		
		// 更新する値を入力
		ConsoleWriter.showInsertEmpName();
		String empName = EmployeeNameReader.inputEmpName();
		ConsoleWriter.showInsertGender();
		String gender = EmployeeGenderReader.inputGender();
		ConsoleWriter.showInsertBirthday();
		String birthday = EmployeeBirthdayReader.inputBirthday();
		ConsoleWriter.showInsertDeptId();
		String deptId = EmployeeDeptIdReader.inputDeptId();
		
		// EmployeeDAO のメソッドを呼び出し
		EmployeeDAO.updateEmp(empId, empName, gender, birthday, deptId);
		ConsoleWriter.showCompleteUpdate();
	}
}
