package jp.co.sss.crud.service;

import java.io.IOException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeDeleteService {

	public static void execute() throws IOException {
		// 削除する社員の社員IDを入力
		ConsoleWriter.showdelete();
		String empId = EmployeeEmpIdReader.inputEmpId();
		
		// EmployeeDAO のメソッドを呼び出し
		EmployeeDAO.deleteEmp(empId);
		ConsoleWriter.showCompleteDelete();
	}

}
