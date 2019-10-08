package services;

import dao.BookDao;
import dao.api.IBookDao;
import model.Book;
import services.api.IBookService;

import java.util.List;
import java.util.stream.Collectors;

public class BookService implements IBookService {
    private IBookDao bookDao;

    public BookService() {
        bookDao = new BookDao();
    }

    @Override
    public void updateBookInfo(Book book) {
        bookDao.update(book);
    }

    @Override
    public void addBook(Book book) {
        bookDao.create(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getAllFreeBooks() {
        return bookDao.getAll().stream().filter(x -> x.getBookReaderId() == null).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllLeasedBooks() {
        return bookDao.getAll().stream().filter(x -> x.getBookReaderId() != null).collect(Collectors.toList());
    }
}
