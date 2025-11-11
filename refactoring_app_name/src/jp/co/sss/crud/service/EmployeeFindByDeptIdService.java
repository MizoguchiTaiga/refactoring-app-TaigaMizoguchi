package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService {
	public static void execute() throws ClassNotFoundException, SQLException, IOException{
		// 検索条件の部署IDを入力
		ConsoleWriter.showSearchEmpByDeptId();
		String deptId = EmployeeDeptIdReader.inputDeptId();
		
		// EmployeeDAO のメソッドを呼び出し
		List<Employee> searchedEmployees = EmployeeDAO.findEmpByDeptId(deptId);
		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
