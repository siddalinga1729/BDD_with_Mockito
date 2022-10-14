package com.mockito_junit_05.mockito.test_doubles.exception_handling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito_junit_05.mockito.test_double.exception_handling.Book;
import com.mockito_junit_05.mockito.test_double.exception_handling.BookRepository;
import com.mockito_junit_05.mockito.test_double.exception_handling.BookService;
import com.mockito_junit_05.mockito.test_double.exception_handling.DatabaseReadException;
import com.mockito_junit_05.mockito.test_double.exception_handling.DatabaseWriteException;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	
	@Test
	public void testTotalPriceOfBooks() throws SQLException {
		when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
		assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
	@Test
	public void testTotalPriceOfBooks3() throws SQLException {
//		when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
		given(bookRepository.findAllBooks()).willThrow(SQLException.class);
		assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
	@Test
	public void testTotalPriceOfBooks1() throws SQLException {//for non void methods
		when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));
		assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}
	
	@Test
	public void testAddBook() throws SQLException {//for void methods
		Book book = new Book(null, "Mockito In Action", 600, LocalDate.now());
		doThrow(SQLException.class).when(bookRepository).save(book);
		assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book));
	}
	
	@Test
	public void testTotalPriceOfBooks2() throws SQLException {
		when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database not available"));
		assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
	}

}