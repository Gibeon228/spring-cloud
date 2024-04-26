package ru.api;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
public class BookController {

    private final Faker faker;
    private final List<Book> books;

    public BookController() {
        final List<Book> books = new ArrayList<>();
        this.faker = new Faker();
        for (int i = 0; i < 15; i++) {
            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setName(faker.book().title());

            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());
            book.setAuthor(author);

            books.add(book);
        }

        this.books = List.copyOf(books);
    }

    @GetMapping
    public List<Book> getAll() {
        return books;
    }

    @GetMapping("/random")
    public Book getRandom() {
        final int randomIndex = faker.number().numberBetween(0, books.size());
        return books.get(randomIndex);
    }


    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable long id) {
        BookResponse book = new BookResponse();
        book.setId(id);
        book.setName("Book #" + id);
        return book;
    }

    @PostConstruct
    void init() {

    }
}
