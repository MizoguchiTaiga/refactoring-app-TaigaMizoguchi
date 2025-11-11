package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {

	/** インスタンス化を禁止 */
	private ConsoleWriter() {
	}

	// メニューの表示
	public static void showMenu() {
		System.out.println(ConstantMsg.MENU_TITLE);
		System.out.println(ConstantMsg.MENU_1);
		System.out.println(ConstantMsg.MENU_2);
		System.out.println(ConstantMsg.MENU_3);
		System.out.println(ConstantMsg.MENU_4);
		System.out.println(ConstantMsg.MENU_5);
		System.out.println(ConstantMsg.MENU_6);
		System.out.println(ConstantMsg.MENU_7);
		System.out.print(ConstantMsg.MSG_ENTER_MENU_NUMBER);
	}

	// レコードのカラムを表示
	public static void showHeader() {
		System.out.println(ConstantMsg.RECORD_COLUMNS);
	}

	// 検索の該当者がいない場合の表示
	public static void showNonExistTarget() {
		System.out.println(ConstantMsg.MSG_NO_TARGET_PERSON);
	}

	// レコードの出力
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

	// 社員名検索
	public static void showSearchEmpByName() {
		System.out.print(ConstantMsg.MSG_ENTER_EMP_NAME);
	}
	
	// 部署ID検索
	public static void showSearchEmpByDeptId() {
		System.out.print(ConstantMsg.MSG_ENTER_DEPT_ID);
	}
	
	// 新規登録用メッセージ
	// 社員名
	public static void showInsertEmpName() {
		System.out.print(ConstantMsg.ENTER_EMP_NAME);
	}
	// 性別
	public static void showInsertGender() {
		System.out.print(ConstantMsg.ENTER_GENDER);
	}
	// 生年月日
	public static void showInsertBirthday() {
		System.out.print(ConstantMsg.ENTER_BIRTHDAY);
	}
	// 部署
	public static void showInsertDeptId() {
		System.out.print(ConstantMsg.ENTER_DEPT_ID);
	}
	
	// 更新する社員IDを入力
	public static void showupdate() {
		System.out.print(ConstantMsg.MSG_ENTER_EMP_ID_FOR_UPDATE);
	}
	
	// 削除する社員IDを入力
	public static void showdelete() {
		System.out.print(ConstantMsg.MSG_ENTER_EMP_ID_FOR_DELETE);
	}

	// 登録完了メッセージを表示
	public static void showCompleteInsert() {
		System.out.println(ConstantMsg.MSG_COMPLETE_INSERT);
	}

	// 更新完了メッセージを表示
	public static void showCompleteUpdate() {
		System.out.println(ConstantMsg.MSG_COMPLETE_UPDATE);
	}

	// 削除完了メッセージを表示
	public static void showCompleteDelete() {
		System.out.println(ConstantMsg.MSG_COMPLETE_DELETE);
	}

	// システム終了メッセージを表示
	public static void showEndSystem() {
		System.out.println(ConstantMsg.MSG_END_SYSTEM);
	}
}
