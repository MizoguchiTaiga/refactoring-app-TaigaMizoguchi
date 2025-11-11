package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeBirthdayReader {
	
	/** インスタンス化を禁止 */
	private EmployeeBirthdayReader() {
	}
	
	public static String inputBirthday() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String birthday = br.readLine();
		return birthday;
	}

}
