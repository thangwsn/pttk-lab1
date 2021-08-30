package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {
	private String userName = "root";
	private String password = "00023011";
	private final String GET_ALL_BOOKS = "SELECT * FROM book;";
	private final String INSERT_BOOK = "INSERT INTO book(title, author, price) VALUES (?,?,?);";
	private final String GET_BOOK = "SELECT * FROM book WHERE book_id = ?;";
	private final String UPDATE_BOOK = "UPDATE book SET title = ?, author = ?, price = ? WHERE book_id = ?";
	private final String DELETE_BOOK = "DELETE FROM book WHERE book_id = ?";
	
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://localhost:3306/bookstore";
		Connection connection = DriverManager.getConnection(connectionURL, this.userName, this.password);
		System.out.println(connection);
		return connection;
	}
	
	protected void disconnect(Connection connection) throws SQLException {
		if (connection != null || !connection.isClosed()){
			connection.close();
		}
	}
	
	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
		List<Book> list = new ArrayList<Book>();
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_BOOKS);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int book_id = rs.getInt(1);
			String title = rs.getString(2);
			String author = rs.getString(3);
			float price = rs.getFloat(4);
			list.add(new Book(book_id, title, author, price));
		}
		disconnect(connection);
		return list;
	}
	
	public void insertBook(Book book) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
		preparedStatement.setString(1, book.getTitle());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setFloat(3, book.getPrice());
		preparedStatement.executeUpdate();
		disconnect(connection);
	}
	
	public Book getBook(int book_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK);
		preparedStatement.setInt(1, book_id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String title = rs.getString(2);
			String author = rs.getString(3);
			Float price = rs.getFloat(4);
			return new Book(book_id, title, author, price);
		}
		disconnect(connection);
		return null;
	}
	
	public boolean updateBook(Book book) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK);
		preparedStatement.setString(1, book.getTitle());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setFloat(3,book.getPrice());
		preparedStatement.setInt(4, book.getBook_id());
		boolean rowUpdated = preparedStatement.executeUpdate() > 0;
		disconnect(connection);
		return rowUpdated;
	}
	
	public boolean deleteBook(int book_id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);
		preparedStatement.setInt(1, book_id);
		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		disconnect(connection);
		return rowDeleted;
	}
		
}
