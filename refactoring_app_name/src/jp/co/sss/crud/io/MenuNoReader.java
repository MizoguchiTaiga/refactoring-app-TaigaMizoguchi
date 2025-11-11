package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuNoReader {
	
	/** インスタンス化を禁止 */
	private MenuNoReader() {
	}
	
	public static int inputMenuNo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String menuNoStr = br.readLine();
		int menuNo = Integer.parseInt(menuNoStr);
		return menuNo;
	}

}
