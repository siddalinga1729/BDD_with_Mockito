package com.mockito_junit_05.mockito.test_doubles.dummy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class DummyTest {
	@Test
	public void demoDummy() {
		BookRepository bookRepo = new FakeBookRepository();
		EmailService emailService = new DummyEmailService();
		BookService bookService = new BookService(bookRepo, emailService);
		bookService.addBook(new Book("1234", "Mockito", 250, LocalDate.now()));
		bookService.addBook(new Book("1235", "JUnit", 350, LocalDate.now()));
		assertEquals(2, bookService.findNumberOfBooks());
	}
	@Test
	public void dummyTestWithMockito() {
		BookRepository bookRepo = Mockito.mock(BookRepository.class);
		EmailService emailService = Mockito.mock(EmailService.class);
		BookService bookService = new BookService(bookRepo,emailService);
		
		Book book1 = new Book("1234", "Mockito", 250, LocalDate.now());
		Book book2 = new Book("1235", "JUnit", 350, LocalDate.now());
		//what we have done in Bookreopsitory by mannually
		Collection<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		Mockito.when(bookRepo.findAll()).thenReturn(books);
		
		assertEquals(2, bookService.findNumberOfBooks());
	}
}
