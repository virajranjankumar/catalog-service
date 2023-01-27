package com.ravramas.catalogservice.demo;

import com.ravramas.catalogservice.domain.Book;
import com.ravramas.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567891", "Northern Lights", "Viraj Ranjankumar", 9.90, "A Publisher");
        var book2 = Book.of("1234567892", "Polar Journey", "Rakesh Ranjankumar", 12.90, "A Publisher");
        bookRepository.saveAll(List.of(book1,book2));
    }
}
