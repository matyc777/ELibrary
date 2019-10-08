package dao.api;

import model.BookLeaser;

import java.util.List;

public interface IBookLeaserDao {
    Boolean update(BookLeaser bookLeaser);

    Boolean create(BookLeaser bookLeaser);

    List<BookLeaser> getAll();

    BookLeaser getById(java.lang.Integer id);
}
