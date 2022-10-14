	package com.mockito_junit_05.mockito.test_doubles.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class StubTest {
	@Test
	public void demoStub() {
		BookRepository bookRepo = new BookRepositoryStub();
		BookService bookService = new BookService(bookRepo);

		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
	@Test
	public void demoStubWithMockito() {
		BookRepository bookRepo = Mockito.mock(BookRepository.class);
		BookService bookService = new BookService(bookRepo);

		Book book1 = new Book("1234", "Mockito", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit", 400, LocalDate.now());
		//what we have done in Bookreopsitory by mannually
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		Mockito.when(bookRepo.findNewBooks(7)).thenReturn(books);
		
		List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

		assertEquals(2, newBooksWithAppliedDiscount.size());
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
	}
}
