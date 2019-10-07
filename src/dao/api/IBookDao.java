package dao.api;

import model.Book;

import java.util.List;

public interface IBookDao {
    Boolean update(Book book);

    Boolean create(Book book);

    List<Book> getAll();

    Book getById(Integer id);
}
