package services;

import dao.BookReaderDao;
import dao.api.IBookReaderDao;
import model.BookReader;
import services.api.IBookReaderService;

import java.util.List;

public class BookReaderService implements IBookReaderService {
    private IBookReaderDao bookReaderDao;

    public BookReaderService() {
        bookReaderDao = new BookReaderDao();
    }

    @Override
    public void updateBookReaderInfo(BookReader bookReader) {
        bookReaderDao.update(bookReader);
    }

    @Override
    public void addBookReader(BookReader bookReader) {
        bookReaderDao.create(bookReader);
    }

    @Override
    public BookReader getById(Integer id) {
        return bookReaderDao.getById(id);
    }

    @Override
    public List<BookReader> getAllBookReaders() {
        return bookReaderDao.getAll();
    }
}