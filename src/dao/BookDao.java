package dao;

import dao.api.IBookDao;
import model.Book;
import utils.ParseUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookDao implements IBookDao {
    private Properties properties;

    private static final String PROPERTIES_PATH = "src/conf/books.properties";

    public BookDao() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES_PATH)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Boolean update(Book book) {
        if (properties.getProperty(book.getId().toString()) == null) {
            return false;
        } else {
            properties.setProperty(book.getId().toString(), book.toString());
            updateProperties();
            return true;
        }
    }

    @Override
    public Boolean create(Book book) {
        if (properties.getProperty(book.getId().toString()) != null) {
            return false;
        } else {
            properties.setProperty(book.getId().toString(), book.toString());
            updateProperties();
            return true;
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        for (String bookReaderId : properties.stringPropertyNames()) {
            books.add(getById(Integer.parseInt(bookReaderId)));
        }
        return books;
    }

    @Override
    public Book getById(Integer id) {
        String bookInfo = properties.getProperty(id.toString());
        if (bookInfo != null) {
            String[] bookInfoArray = bookInfo.split(",", 3);
            return new Book(id, bookInfoArray[0], bookInfoArray[1],
                    ParseUtil.tryParse(bookInfoArray[2]));
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
