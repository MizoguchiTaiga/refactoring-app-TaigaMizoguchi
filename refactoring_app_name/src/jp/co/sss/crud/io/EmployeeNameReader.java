package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeNameReader {
	
	/** インスタンス化を禁止 */
	private EmployeeNameReader() {
	}
	
	public static String inputEmpName() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String empName = br.readLine();
		return empName;
	}

}
