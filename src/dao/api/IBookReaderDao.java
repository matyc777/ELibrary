package dao.api;

import model.BookReader;

import java.util.List;

public interface IBookReaderDao {
    Boolean update(BookReader bookReader);

    Boolean create(BookReader bookReader);

    List<BookReader> getAll();

    BookReader getById(java.lang.Integer id);
}
