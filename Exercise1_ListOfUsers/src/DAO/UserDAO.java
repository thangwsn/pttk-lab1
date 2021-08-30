package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	private String userName = "root";
	private String password = "00023011";

	private final String SELECT_ALL_USERS = "SELECT * FROM users;";
	private final String INSERT_USER = "INSERT INTO users(name, email, country) VALUES (?,?,?);";
	private final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
	private final String UPDATE_USER = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?;";
	private final String DELETE_USER = "DELETE FROM users WHERE id = ?";

	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://localhost:3306/demo_users";
		Connection connection = DriverManager.getConnection(connectionURL, this.userName, this.password);
		System.out.println(connection);
		return connection;
	}

	public List<User> selectAllUsers() throws ClassNotFoundException, SQLException {
		List<User> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String email = rs.getString(3);
			String country = rs.getString(4);
			list.add(new User(id, name, email, country));
		}
		return list;
	}

	public void insertUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getCountry());
		preparedStatement.executeUpdate();
	}

	public User selectUser(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String name = rs.getString(2);
			String email = rs.getString(3);
			String country = rs.getString(4);
			return new User(id,name, email, country);
		}
		return null;
	}

	public boolean updateUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getCountry());
		preparedStatement.setInt(4, user.getId());
		boolean rowUpdated = preparedStatement.executeUpdate() > 0;
		return rowUpdated;
	}

	public boolean deleteUser(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
		preparedStatement.setInt(1, id);
		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		return rowDeleted;
		
	}

}
