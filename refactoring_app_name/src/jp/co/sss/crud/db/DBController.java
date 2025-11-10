package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class DBController {

	/** インスタンス化を禁止 */
	private DBController() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void findAllEmp() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NO_TARGET_PERSON);
				return;
			}

			// レコードを出力
			System.out.println(ConstantMsg.RECORD_COLUMNS);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_EMP_ID) + ConstantMsg.TAB);
				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_EMP_NAME) + ConstantMsg.TAB);

				int gender = Integer.parseInt(resultSet.getString(ConstantMsg.EMPLOYEE_GENDER));
				if (gender == ConstantValue.GENDER_NO_ANSWER) {
					System.out.print(ConstantMsg.NO_ANSWER + ConstantMsg.TAB);
				} else if (gender == ConstantValue.GENDER_MALE) {
					System.out.print(ConstantMsg.MALE + ConstantMsg.TAB);

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					System.out.print(ConstantMsg.FEMALE + ConstantMsg.TAB);

				} else if (gender == ConstantValue.GENDER_OTHER) {
					System.out.print(ConstantMsg.OTHER + ConstantMsg.TAB);

				}

				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_BIRTHDAY) + ConstantMsg.TAB);
				System.out.println(resultSet.getString(ConstantMsg.DEPARTMENT_DEPT_NAME));
			}

			System.out.println(ConstantMsg.BLANK);
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findEmpByName() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(ConstantValue.PLACEHOLDER_1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NO_TARGET_PERSON);
				return;
			}

			System.out.println(ConstantMsg.RECORD_COLUMNS);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_EMP_ID));
				System.out.print(ConstantMsg.TAB);

				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_EMP_NAME));
				System.out.print(ConstantMsg.TAB);

				String genderStr = resultSet.getString(ConstantMsg.EMPLOYEE_GENDER);
				int gender = Integer.parseInt(genderStr);
				if (gender == ConstantValue.GENDER_NO_ANSWER) {
					System.out.print(ConstantMsg.NO_ANSWER);
				} else if (gender == ConstantValue.GENDER_MALE) {
					System.out.print(ConstantMsg.MALE);

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					System.out.print(ConstantMsg.FEMALE);

				} else if (gender == ConstantValue.GENDER_OTHER) {
					System.out.print(ConstantMsg.OTHER);

				}

				System.out.print(ConstantMsg.TAB);
				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_BIRTHDAY));
				System.out.print(ConstantMsg.TAB);

				System.out.println(resultSet.getString(ConstantMsg.DEPARTMENT_DEPT_NAME));
			}

			System.out.println(ConstantMsg.BLANK);

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void findEmpByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_1, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.MSG_NO_TARGET_PERSON);
				return;
			}

			System.out.println(ConstantMsg.RECORD_COLUMNS);
			while (resultSet.next()) {
				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_EMP_ID));
				System.out.print(ConstantMsg.TAB);

				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_EMP_NAME));
				System.out.print(ConstantMsg.TAB);

				String genderStr = resultSet.getString(ConstantMsg.EMPLOYEE_GENDER);
				int gender = Integer.parseInt(genderStr);
				if (gender == ConstantValue.GENDER_NO_ANSWER) {
					System.out.print(ConstantMsg.NO_ANSWER);
				} else if (gender == ConstantValue.GENDER_MALE) {
					System.out.print(ConstantMsg.MALE);

				} else if (gender == ConstantValue.GENDER_FEMALE) {
					System.out.print(ConstantMsg.FEMALE);

				} else if (gender == ConstantValue.GENDER_OTHER) {
					System.out.print(ConstantMsg.OTHER);

				}

				System.out.print(ConstantMsg.TAB);
				System.out.print(resultSet.getString(ConstantMsg.EMPLOYEE_BIRTHDAY));
				System.out.print(ConstantMsg.TAB);

				String deptIdStr = resultSet.getString(ConstantMsg.DEPARTMENT_DEPT_ID);
				int deptIdInt = Integer.parseInt(deptIdStr);
				if (deptIdInt == ConstantValue.DEPT_ID_EIGYOU) {
					System.out.println(ConstantMsg.DEPT_NAME_EIGYOU);
				} else if (deptIdInt == ConstantValue.DEPT_ID_KEIRI) {
					System.out.println(ConstantMsg.DEPT_NAME_KEIRI);
				} else if (deptIdInt == ConstantValue.DEPT_ID_SOUMU) {
					System.out.println(ConstantMsg.DEPT_NAME_SOUMU);

				}
			}

			System.out.println(ConstantMsg.BLANK);
		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insertEmp(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.PLACEHOLDER_1, empName);
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantMsg.DEFAULT_DATE_FORMAT);
			preparedStatement.setObject(ConstantValue.PLACEHOLDER_3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_4, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.MSG_COMPLETE_INSERT);
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void updateEmp(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print(ConstantMsg.ENTER_EMP_NAME);
			String empName = br.readLine();
			// 性別を入力
			System.out.print(ConstantMsg.ENTER_GENDER);
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print(ConstantMsg.ENTER_BIRTHDAY);
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print(ConstantMsg.ENTER_DEPT_ID);
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.PLACEHOLDER_1, empName);
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_2, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantMsg.DEFAULT_DATE_FORMAT);
			preparedStatement.setObject(ConstantValue.PLACEHOLDER_3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_4, Integer.parseInt(deptId));
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_5, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void deleteEmp() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.PLACEHOLDER_1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.MSG_COMPLETE_DELETE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
