package com.mockito_junit_05.bdd.behavior_verifying;

public class BookService {
	
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void updatePrice(String bookId, int updatedPrice){
		Book book = bookRepository.findBookByBookId(bookId);
		book.setPrice(updatedPrice);
		bookRepository.save(book);
	}
}