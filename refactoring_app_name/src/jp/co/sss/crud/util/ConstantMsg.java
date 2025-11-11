package jp.co.sss.crud.util;

public class ConstantMsg {
	
	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	/** メニューの表示 */
	public static final String MENU_TITLE = "=== 社員管理システム ===";
	public static final String MENU_1 = "1.全件表示";
	public static final String MENU_2 = "2.社員名検索";
	public static final String MENU_3 = "3.部署ID検索";
	public static final String MENU_4 = "4.新規登録";
	public static final String MENU_5 = "5.更新";
	public static final String MENU_6 = "6.削除";
	public static final String MENU_7 = "7.終了";
	public static final String MSG_ENTER_MENU_NUMBER = "メニュー番号を入力してください：";

	/** 社員検索 */
	public static final String MSG_ENTER_EMP_NAME = "社員名を入力してください:";
	public static final String MSG_ENTER_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	public static final String MSG_NO_TARGET_PERSON = "該当者はいませんでした";

	/** 社員登録 */
	public static final String ENTER_EMP_NAME = "社員名:";
	public static final String ENTER_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	public static final String ENTER_BIRTHDAY = "生年月日(西暦年/月/日):";
	public static final String ENTER_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";
	public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";	
	public static final String MSG_COMPLETE_INSERT = "社員情報を登録しました";	

	/** 社員情報更新 */
	public static final String MSG_ENTER_EMP_ID_FOR_UPDATE = "更新する社員の社員IDを入力してください：";
	public static final String MSG_COMPLETE_UPDATE = "社員情報を更新しました";

	/** 社員情報削除 */
	public static final String MSG_ENTER_EMP_ID_FOR_DELETE = "削除する社員の社員IDを入力してください：";
	public static final String MSG_COMPLETE_DELETE = "社員情報を削除しました";
	
	/** システム終了 */
	public static final String MSG_END_SYSTEM = "システムを終了します。";

	/** レコード出力 */
	public static final String RECORD_COLUMNS = "社員ID\t社員名\t性別\t生年月日\t部署名";
	public static final String NO_ANSWER = "回答なし";
	public static final String OTHER = "その他";
	/** 性別 */
	public static final String MALE = "男性";
	public static final String FEMALE = "女性";
	/** 部署 */
	public static final String DEPT_NAME_EIGYOU = "営業部";
	public static final String DEPT_NAME_KEIRI = "経理部";
	public static final String DEPT_NAME_SOUMU = "総務部";

	/** テーブル情報 */
	public static final String EMPLOYEE_EMP_ID = "emp_id";
	public static final String EMPLOYEE_EMP_NAME = "emp_name";
	public static final String EMPLOYEE_GENDER = "gender";
	public static final String EMPLOYEE_BIRTHDAY = "birthday";
	
	public static final String DEPARTMENT_DEPT_ID = "dept_id";
	public static final String DEPARTMENT_DEPT_NAME = "dept_name";

	/** レイアウト */
	/** 水平タブ */
	public static final String TAB = "\t";
	/** 空白 */
	public static final String BLANK = "";
}
