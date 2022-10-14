package com.mockito_junit_05.mockito.test_doubles.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

public class BookRepositoryMock implements BookRepository {
	
	int saveCalled = 0;
	Book lastAddedBook = null;
	
	@Override
	public void save(Book book) {
		saveCalled++;
		lastAddedBook = book;
	}
	
	public void verify(Book book, int times){
		assertEquals(times, saveCalled);
		assertEquals(book, lastAddedBook);
	}

	@Override
	public Collection<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
