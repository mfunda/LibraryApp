package pl.mfunda.app.library;

public class Loan {
	private int idBook;
	private int idReader;
	
	public Loan(){}
	public Loan(int idBook, int idReader){
		this.idBook=idBook;
		this.idReader=idReader;
	}
	
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public int getIdReader() {
		return idReader;
	}
	public void setIdReader(int idReader) {
		this.idReader = idReader;
	}
}
