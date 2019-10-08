package services.api;

import exceptions.NotExistException;
import model.BookLeaser;

import java.util.List;

public interface IBookLeaserService {
    void updateBookLeaserInfo(BookLeaser bookLeaser) throws NotExistException;

    void addBookLeaser(BookLeaser bookLeaser);

    BookLeaser getById(Integer id) throws NotExistException;

    List<BookLeaser> getAllBookLeasers();
}
