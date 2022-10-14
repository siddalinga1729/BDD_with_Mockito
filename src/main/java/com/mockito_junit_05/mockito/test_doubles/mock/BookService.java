package com.mockito_junit_05.mockito.test_doubles.mock;

public class BookService {
 private BookRepository bookRepo;
 public BookService(BookRepository bookRepo){
	 this.bookRepo=bookRepo;
 }
 
 public void addBook(Book book){
		if(book.getPrice() > 400){
			return;
		}
		bookRepo.save(book);
	}
 public int findNumberOfBooks() {
	 return bookRepo.findAll().size(); 
 }
}
