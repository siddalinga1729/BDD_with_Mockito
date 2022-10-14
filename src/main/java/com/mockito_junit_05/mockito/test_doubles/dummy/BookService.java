package com.mockito_junit_05.mockito.test_doubles.dummy;

public class BookService {
	private BookRepository bookRepo;
	private EmailService emailService;

	public BookService(BookRepository bookRepo, EmailService emailService) {
		super();
		this.bookRepo = bookRepo;
		this.emailService = emailService;
	}

	public void addBook(Book book) {
		bookRepo.save(book);
	}

	public int findNumberOfBooks() {
		return bookRepo.findAll().size();
	}
}
