package services.api;

import exceptions.NotExistException;
import model.Book;

import java.util.List;

public interface IBookService {
    void updateBookInfo(Book book) throws NotExistException;

    void addBook(Book book);

    Book getById(Integer id) throws NotExistException;

    List<Book> getAllBooks();

    List<Book> getAllFreeBooks();

    List<Book> getAllLeasedBooks();
}
