package com.mockito_junit_05.mockito.test_doubles.annotation.support;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito_junit_05.mockito.test_doubles.annotations.support.Book;
import com.mockito_junit_05.mockito.test_doubles.annotations.support.BookRepository;
import com.mockito_junit_05.mockito.test_doubles.annotations.support.BookService;
@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

	@Mock
	private BookRepository bookRepo;
	@InjectMocks
	private BookService bookService;

	@Test
	public void demoCreateWithAnnotations() {

		Book book1 = new Book("1234", "Mockito", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit", 400, LocalDate.now());
		// what we have done in Bookreopsitory by mannually
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
