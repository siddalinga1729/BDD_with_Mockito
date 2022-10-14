package com.mockito_junit_05.mockito.test_doubles.stub;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
}
