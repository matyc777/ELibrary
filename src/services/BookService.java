package services;

import dao.BookDao;
import dao.api.IBookDao;
import exceptions.NotExistException;
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
    public void updateBookInfo(Book book) throws NotExistException {
        if (!bookDao.update(book)) {
            throw new NotExistException(String.format("Book with id: %d does not exist", book.getId()));
        }
    }

    @Override
    public void addBook(Book book) {
        bookDao.create(book);
    }

    @Override
    public Book getById(Integer id) throws NotExistException {
        Book book = bookDao.getById(id);
        if (book == null) {
            throw new NotExistException("Book with specified id does not exist");
        } else {
            return book;
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getAllFreeBooks() {
        return bookDao.getAll().stream().filter(x -> x.getBookLeaserId() == null).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllLeasedBooks() {
        return bookDao.getAll().stream().filter(x -> x.getBookLeaserId() != null).collect(Collectors.toList());
    }
}
