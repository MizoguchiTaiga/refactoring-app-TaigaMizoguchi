package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByEmpNameService {
	
	public static void execute() throws ClassNotFoundException, SQLException, IOException{
		// 検索する社員名を入力
		ConsoleWriter.showSearchEmpByName();
		
		// EmployeeDAO のメソッドを呼び出し
		List<Employee> searchedEmployees = EmployeeDAO.findEmpByName();
		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
