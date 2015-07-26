package pl.mfunda.app.library.lib;

import pl.mfunda.app.library.model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import pl.mfunda.app.library.model.Reader;

public class Library {
	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:library.db";
	
	private Connection conn;
	private Statement stat;
	
	public Library(){
		try{
			Class.forName(Library.DRIVER);
		} catch (ClassNotFoundException e){
			System.err.println("No JDBC controller");
			e.printStackTrace();
		}
		try{
			conn=DriverManager.getConnection(DB_URL);
			stat= conn.createStatement();
		} catch (SQLException e){
			System.err.println("Problem with opening connection");
			e.printStackTrace();
		}
		createTables();
	}
	
	public boolean createTables(){
		String createReader = "CREATE TABLE IF NOT EXISTS readers (id_reader INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), surname varchar(255), pesel int)";
        String createBook = "CREATE TABLE IF NOT EXISTS books (id_book INTEGER PRIMARY KEY AUTOINCREMENT, title varchar(255), author varchar(255))";
        String createLoan = "CREATE TABLE IF NOT EXISTS loans (id_loan INTEGER PRIMARY KEY AUTOINCREMENT, id_reader int, id_book int)";
		try{
			stat.execute(createReader);
			stat.execute(createBook);
			stat.execute(createLoan);
		} catch (SQLException e){
			System.err.println("Error while creating tables");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertReader(String name, String surname, String pesel){
		PreparedStatement prepStmt;
		try {
			prepStmt = conn.prepareStatement("insert into readers values (NULL,?,?,?);");
			prepStmt.setString(1, name);
			prepStmt.setString(2, surname);
			prepStmt.setString(3, pesel);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Error while insertion Reader");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertBook(String title, String author){
		try{
			PreparedStatement prepStmt = conn.prepareStatement("insert into books values (NULL, ?, ?);");
			prepStmt.setString(1, title);
			prepStmt.setString(2, author);
			prepStmt.execute();
		} catch (SQLException e){
			System.err.println("Error while insertion books");
			return false;
		}
		return true;
	}
	
	public boolean insertLoan(int idReader, int idBook){
		try{
			PreparedStatement prepStmt = conn.prepareStatement("insert into loans values (NULL, ?, ?);");
			prepStmt.setInt(1, idReader);
			prepStmt.setInt(2, idBook);
			prepStmt.execute();
		} catch (SQLException e){
			System.err.println("Error while loan");
			return false;
		}
		return true;
	}
	public List<Book> selectBook(){
		List<Book> books = new LinkedList<Book>();
		try{
			ResultSet result = stat.executeQuery("SELECT * FROM books");
			int id;
			String title, author;
			while(result.next()){
				id = result.getInt("id_book");
				title = result.getString("title");
				author = result.getString("author");
				books.add(new Book(id, title, author));
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return books;
	}
	public List<Reader> selectReader(){
		List<Reader> readers = new LinkedList<Reader>();
		try{
			ResultSet result = stat.executeQuery("SELECT * FROM readers");
			int id;
			String name, surname, pesel;
			while(result.next()){
				id = result.getInt("id_reader");
				name = result.getString("name");
				surname = result.getString("surname");
				pesel = result.getString("pesel");
				readers.add(new Reader(id, name, surname, pesel));
			}
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		return readers;
	}
	public void closeConnection(){
		try{
			conn.close();
		} catch (SQLException e){
			System.err.println("Problem while closing connection");
			e.printStackTrace();
		}
	}
}
