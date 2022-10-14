package com.mockito_junit_05.mockito.test_doubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

	//in memory database,Hashmap or List
	Map<String, Book> bookStore=new HashMap<>();
	
	@Override
	public void save(Book book) {
		bookStore.put(book.getBookId(), book);
	}

	@Override
	
	public	Collection<Book> findAll() {

		return bookStore.values();
	}
}
