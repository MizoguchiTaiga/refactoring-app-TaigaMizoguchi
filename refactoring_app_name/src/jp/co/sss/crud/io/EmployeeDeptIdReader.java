package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeDeptIdReader {
	
	/** インスタンス化を禁止 */
	private EmployeeDeptIdReader() {
	}
	
	public static String inputDeptId() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String deptId = br.readLine();
		return deptId;
	}

}
