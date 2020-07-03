package bookmanage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmanage.model.User;
import bookmanage.utils.DbUtil;

/**
 * 连接数据库工具类
 */
public class UserDao {
	
	/**
	 * 根据用户账号查询用户
	 */
	public User getUserByAccout(String accout) {
		Connection connection = DbUtil.connection();
		String sql = "select accout,pass from t_user where accout=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, accout);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {						
				User user = new User(rs.getString("accout"), rs.getString("pass"));
				DbUtil.close(connection, ps);						// 关闭连接
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser(User user) {
		Connection connection = DbUtil.connection();			// 获得数据库连接对象
		String sql = "insert into t_user(accout,pass)values(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getAccout());
			ps.setString(2, user.getPass());
			if (!ps.execute()) {// 成功
				DbUtil.close(connection, ps);					// 关闭连接
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;									// 失败
	}
}
