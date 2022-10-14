package com.mockito_junit_05.mockito.test_double.behavior.verification;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
	Book findBookByBookId(String bookId);
	void save(Book book);
	List<Book> findAllBooks();
}
