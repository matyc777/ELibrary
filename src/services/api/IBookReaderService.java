package services.api;

import model.BookReader;

import java.util.List;

public interface IBookReaderService {
    void updateBookReaderInfo(BookReader bookReader);

    void addBookReader(BookReader bookReader);

    BookReader getById(Integer id);

    List<BookReader> getAllBookReaders();
}
