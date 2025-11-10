package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = ConstantValue.MENU_DEFAULT;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.MENU_TITLE);
			System.out.println(ConstantMsg.MENU_1);
			System.out.println(ConstantMsg.MENU_2);
			System.out.println(ConstantMsg.MENU_3);
			System.out.println(ConstantMsg.MENU_4);
			System.out.println(ConstantMsg.MENU_5);
			System.out.println(ConstantMsg.MENU_6);
			System.out.println(ConstantMsg.MENU_7);
			System.out.print(ConstantMsg.MSG_ENTER_MENU_NUMBER);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL_EMP:
				// 全件表示機能の呼出
				DBController.findAllEmp();
				break;

			case ConstantValue.MENU_FIND_EMP_BY_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.ENTER_EMP_NAME);

				// 検索機能の呼出
				DBController.findEmpByName();
				break;

			case ConstantValue.MENU_FIND_EMP_BY_DEPT_ID:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.MSG_ENTER_DEPT_ID);
				String deptIdForSearch = br.readLine();

				// 検索機能の呼出
				DBController.findEmpByDeptId(deptIdForSearch);
				break;

			case ConstantValue.MENU_INSERT_EMP:
				// 登録する値を入力
				System.out.print(ConstantMsg.ENTER_EMP_NAME);
				String empName = br.readLine();
				System.out.print(ConstantMsg.ENTER_GENDER);
				String gender = br.readLine();
				System.out.print(ConstantMsg.ENTER_BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.ENTER_DEPT_ID);
				String deptIdForRegist = br.readLine();

				// 登録機能の呼出
				DBController.insertEmp(empName, gender, birthday, deptIdForRegist);
				break;

			case ConstantValue.MENU_UPDATE_EMP:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MSG_ENTER_EMP_ID_FOR_UPDATE);

				// 更新する値を入力する
				String empId = br.readLine();
				Integer.parseInt(empId);

				// 更新機能の呼出
				DBController.updateEmp(empId);
				System.out.println(ConstantMsg.MSG_COMPLETE_UPDATE);

				break;

			case ConstantValue.MENU_DELETE_EMP:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MSG_ENTER_EMP_ID_FOR_DELETE);

				// 削除機能の呼出
				DBController.deleteEmp();
				break;

			}
		} while (menuNo != ConstantValue.MENU_END_SYSTEM);
		System.out.println(ConstantMsg.MSG_END_SYSTEM);
	}
}
