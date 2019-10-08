package services;

import dao.BookLeaserDao;
import dao.api.IBookLeaserDao;
import exceptions.NotExistException;
import model.BookLeaser;
import services.api.IBookLeaserService;

import java.util.List;

public class BookLeaserService implements IBookLeaserService {
    private IBookLeaserDao bookLeaserDao;

    public BookLeaserService() {
        bookLeaserDao = new BookLeaserDao();
    }

    @Override
    public void updateBookLeaserInfo(BookLeaser bookLeaser) throws NotExistException {
        if (!bookLeaserDao.update(bookLeaser)) {
            throw new NotExistException(String.format("Book leaser with id: %d does not exist", bookLeaser.getId()));
        }
    }

    @Override
    public void addBookLeaser(BookLeaser bookLeaser) {
        bookLeaserDao.create(bookLeaser);
    }

    @Override
    public BookLeaser getById(Integer id) throws NotExistException {
        BookLeaser bookLeaser = bookLeaserDao.getById(id);
        if (bookLeaser == null) {
            throw new NotExistException("Book leaser with specified id does not exist");
        } else {
            return bookLeaser;
        }
    }

    @Override
    public List<BookLeaser> getAllBookLeasers() {
        return bookLeaserDao.getAll();
    }
}