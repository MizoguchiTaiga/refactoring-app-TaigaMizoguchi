package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService {

	public static void execute() throws ClassNotFoundException, SQLException {
		// EmployeeDAO のメソッドを呼び出し
		List<Employee> searchedEmployees = EmployeeDAO.findAllEmp();
		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
