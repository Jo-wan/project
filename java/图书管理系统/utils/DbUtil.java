package bookmanage.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接数据库工具类
 */
public class DbUtil {
	
	//把几个用于连接数据库的字符串定义成常量
	private static final String USER = "root";				//数据库用户名
	private static final String UPWD = "1234";				//数据库密码
	
	private static final String URL = "jdbc:mysql://localhost:3306/db_book?useSSL=false";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	//加载驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 得到数据库连接对象Connection的函数
	public static Connection connection(){
		try {
			return DriverManager.getConnection(URL, USER, UPWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//关闭连接和执行打开的资源
	public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//关闭所有打开的资源
	public static void close(Connection connection, Statement statement, ResultSet rs) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
