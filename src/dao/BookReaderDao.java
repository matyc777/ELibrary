package dao;

import dao.api.IBookReaderDao;
import model.BookReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookReaderDao implements IBookReaderDao {
    private Properties properties;

    private static final String PROPERTIES_PATH = "src/conf/book_readers.properties";

    public BookReaderDao() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES_PATH)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Boolean update(BookReader bookReader) {
        if (properties.getProperty(bookReader.getId().toString()) == null) {
            return false;
        } else {
            properties.setProperty(bookReader.getId().toString(), bookReader.toString());
            updateProperties();
            return true;
        }
    }

    @Override
    public Boolean create(BookReader bookReader) {
        if (properties.getProperty(bookReader.getId().toString()) != null) {
            return false;
        } else {
            properties.setProperty(bookReader.getId().toString(), bookReader.toString());
            updateProperties();
            return true;
        }
    }

    @Override
    public List<BookReader> getAll() {
        List<BookReader> bookReaders = new ArrayList<>();
        for (String bookReaderId : properties.stringPropertyNames()) {
            bookReaders.add(getById(Integer.parseInt(bookReaderId)));
        }
        return bookReaders;
    }

    @Override
    public BookReader getById(Integer id) {
        String bookReaderInfo = properties.getProperty(id.toString());
        if (bookReaderInfo != null) {
            String[] bookReaderInfoArray = bookReaderInfo.split(",", 2);
            return new BookReader(id, bookReaderInfoArray[0], bookReaderInfoArray[1]);
        } else return null;
    }

    private void updateProperties() {
        try (OutputStream outputStream = new FileOutputStream(PROPERTIES_PATH)) {
            properties.store(outputStream, null);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
