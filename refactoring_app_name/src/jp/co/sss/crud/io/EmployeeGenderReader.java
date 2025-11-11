package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeGenderReader {
	
	/** インスタンス化を禁止 */
	private EmployeeGenderReader() {
	}
	
	public static String inputGender() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String gender = br.readLine();
		return gender;
	}

}
