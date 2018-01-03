package com.scp.bookservice;

import java.util.List;

/**
 * 
 * @author Progvaltion_11
 *
 */
public interface BookService {
	
	public boolean addBook(Book book) throws DuplicateBookException;
	public boolean updateBook(Book book) throws BookWithGivenIdNotPresent;
	public boolean deleteBook(int bookId);
	public Book searchBook(int bookId);
	public boolean searchBookWithMultipleParams(Book book);
	public List<Book> getListOfBooks();

}
