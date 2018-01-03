package com.scp.bookservice;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService{
	
	List<Book> listOfBooks = new ArrayList<>();
	
	@Override
	public boolean addBook(Book book) throws DuplicateBookException {
		boolean returnVal=false;
		if(!checkForDuplicate(book.getBookId())){
			listOfBooks.add(book);
			returnVal=true;
		}else
			throw new DuplicateBookException("Book with same is already exist");;
		
			return returnVal;
	}

	private boolean checkForDuplicate(int bookId) {
		for (Book bItem : listOfBooks) {
			if(bItem.getBookId()==bookId)
				return true;
		}
		return false;
		
	}

	@Override
	public boolean updateBook(Book book) throws BookWithGivenIdNotPresent {
	//	if(checkForDuplicate(book.getBookId())){
			for (Book bItem : listOfBooks) {
				if(bItem.getBookId()==book.getBookId()){
					bItem.setBookName(book.getBookName());
					bItem.setBookPrice(book.getBookPrice());
					bItem.setAuthorNames(book.getAuthorNames());
					bItem.setPublication(book.getPublication());
					return true;
				}
					
			}
		//}else throw new BookWithGivenIdNotPresent("For update books should be already present");
		
		return false;
	}

	@Override
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		
		for (Book book : listOfBooks)
		{
			//System.out.println(book.getBookId());
			//System.out.println(bookId);
			if(book.getBookId()==bookId)
			{
				//System.out.println(bookId);
				//System.out.println(book.getBookId());
				listOfBooks.remove(book);
				return true;
			}
			//return true;
		}
		return false;
		
		
		
	}

	@Override
	public Book searchBook(int bookId) {
		for (Book book : listOfBooks) {
			if(book.getBookId()==bookId)
				return book;
		}
		return null;
	}

	@Override
	public boolean searchBookWithMultipleParams(Book book) {
		boolean returnVal=false;
		for (Book bItem : listOfBooks) {
			if(book.getBookName().equals(bItem.getBookName())
			  && bItem.getPublication().equals(book.getPublication()))		
					{
				for(String authorName : bItem.getAuthorNames()){
					if(book.getAuthorNames().contains(authorName))
						returnVal=true;
					else{
						returnVal=false;
						break;
					}
				}
			}
				
		}
		
		return returnVal;
	}

	@Override
	public List<Book> getListOfBooks() {
		return listOfBooks;
	}

}
