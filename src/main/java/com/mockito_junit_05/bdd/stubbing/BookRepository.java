package com.mockito_junit_05.bdd.stubbing;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
}
