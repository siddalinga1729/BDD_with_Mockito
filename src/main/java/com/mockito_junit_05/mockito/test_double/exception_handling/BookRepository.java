package com.mockito_junit_05.mockito.test_double.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
	List<Book> findAllBooks() throws SQLException;
	void save(Book book) throws SQLException;
}
