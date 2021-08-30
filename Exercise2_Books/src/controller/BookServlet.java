package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import model.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet(urlPatterns="/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	bookDAO = new BookDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBooks(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBooks(request, response);
				break;
			case "/delete":
				deleteBooks(request, response);
				break;
			default:
				listBooks(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		List<Book> list = bookDAO.getAllBooks();
		request.setAttribute("listBooks", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Float price = Float.parseFloat(request.getParameter("price"));
		bookDAO.insertBook(new Book(title, author, price));
		response.sendRedirect(request.getContextPath() + "/list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		Book book = bookDAO.getBook(book_id);
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Float price = Float.parseFloat(request.getParameter("price"));
		bookDAO.updateBook(new Book(book_id, title, author, price));
		response.sendRedirect(request.getContextPath() + "/list");
	}
	
	private void deleteBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		bookDAO.deleteBook(book_id);
		response.sendRedirect(request.getContextPath() + "/list");
	}
}
