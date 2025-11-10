package jp.co.sss.crud.util;

public class ConstantValue {

	/** インスタンス化を禁止 */
	private ConstantValue() {
	}

	// メニュー番号
	public static final short MENU_DEFAULT = 0;
	public static final short MENU_FIND_ALL_EMP = 1;
	public static final short MENU_FIND_EMP_BY_NAME = 2;
	public static final short MENU_FIND_EMP_BY_DEPT_ID = 3;
	public static final short MENU_INSERT_EMP = 4;
	public static final short MENU_UPDATE_EMP = 5;
	public static final short MENU_DELETE_EMP = 6;
	public static final short MENU_END_SYSTEM = 7;

	// 性別
	public static final short GENDER_NO_ANSWER = 0;
	public static final short GENDER_MALE = 1;
	public static final short GENDER_FEMALE = 2;
	public static final short GENDER_OTHER = 9;

	// 部署ID
	public static final short DEPT_ID_EIGYOU = 1;
	public static final short DEPT_ID_KEIRI = 2;
	public static final short DEPT_ID_SOUMU = 3;

	// プレースホルダ
	public static final short PLACEHOLDER_1 = 1;
	public static final short PLACEHOLDER_2 = 2;
	public static final short PLACEHOLDER_3 = 3;
	public static final short PLACEHOLDER_4 = 4;
	public static final short PLACEHOLDER_5 = 5;
	
	
}
