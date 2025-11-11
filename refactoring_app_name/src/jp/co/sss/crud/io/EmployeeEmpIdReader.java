package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeEmpIdReader {
	
	/** インスタンス化を禁止 */
	private EmployeeEmpIdReader() {
	}
	
	public static String inputEmpId() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String empId = br.readLine();
		return empId;
	}

}
