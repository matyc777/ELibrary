package services.api;

import model.Book;

import java.util.List;

public interface IBookService {
    void updateBookInfo(Book book);

    void addBook(Book book);

    Book getById(Integer id);

    List<Book> getAllBooks();

    List<Book> getAllFreeBooks();

    List<Book> getAllLeasedBooks();
}
