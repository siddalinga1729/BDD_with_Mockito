package com.mockito_junit_05.mockito.test_doubles.fake;

public class BookService {
 private BookRepository bookRepo;
 public BookService(BookRepository bookRepo){
	 this.bookRepo=bookRepo;
 }
 
 public void addBook(Book book) {
	 bookRepo.save(book);
 }
 public int findNumberOfBooks() {
	 return bookRepo.findAll().size(); 
 }
}
