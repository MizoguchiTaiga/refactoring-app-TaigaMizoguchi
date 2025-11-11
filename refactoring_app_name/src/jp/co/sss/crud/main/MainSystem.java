package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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

		int menuNo = ConstantValue.MENU_DEFAULT;

		do {
			// メニューの表示
			ConsoleWriter.showMenu();

			// メニュー番号の入力
			menuNo = MenuNoReader.inputMenuNo();

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL_EMP:
				// 全件表示機能の呼出
				EmployeeAllFindService.execute();
				break;

			case ConstantValue.MENU_FIND_EMP_BY_NAME:
				// 検索機能の呼出
				EmployeeFindByEmpNameService.execute();
				break;

			case ConstantValue.MENU_FIND_EMP_BY_DEPT_ID:
				// 検索機能の呼出
				EmployeeFindByDeptIdService.execute();
				break;

			case ConstantValue.MENU_INSERT_EMP:
				// 登録機能の呼出
				EmployeeRegisterService.execute();
				break;

			case ConstantValue.MENU_UPDATE_EMP:
				// 更新機能の呼出
				EmployeeUpdateService.execute();
				break;

			case ConstantValue.MENU_DELETE_EMP:
				// 削除機能の呼出
				EmployeeDeleteService.execute();
				break;

			}
		} while (menuNo != ConstantValue.MENU_END_SYSTEM);
		ConsoleWriter.showEndSystem();
	}
}
