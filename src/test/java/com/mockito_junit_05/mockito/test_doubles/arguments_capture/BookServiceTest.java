package com.mockito_junit_05.mockito.test_doubles.arguments_capture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito_junit_05.mockito.test_double.argument_capture.Book;
import com.mockito_junit_05.mockito.test_double.argument_capture.BookRepository;
import com.mockito_junit_05.mockito.test_double.argument_capture.BookRequest;
import com.mockito_junit_05.mockito.test_double.argument_capture.BookService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@InjectMocks
	private BookService bookService;
	
//	@Mock
//	private BookRepository bookRepository;
	
	@Spy
	private BookRepository bookRepository;
	
	@Captor
	private ArgumentCaptor<Book> argumentsCaptore;
	
	@Test
	public void testSaveBook() {
		BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
		bookService.addBook(bookRequest);
		verify(bookRepository).save(argumentsCaptore.capture());
		Book book=argumentsCaptore.getValue();
		assertEquals("Mockito In Action", book.getTitle());
	}
}