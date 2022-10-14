package com.mockito_junit_05.mockito.test_doubles.dummy;

import java.util.Collection;

public interface BookRepository {
void save(Book book);
Collection<Book> findAll();  
}
