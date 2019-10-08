package dao;

import dao.api.IBookLeaserDao;
import model.BookLeaser;
import utils.ParseUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookLeaserDao implements IBookLeaserDao {
    private Properties properties;

    private static final String PROPERTIES_PATH = "src/conf/book_leasers.properties";

    public BookLeaserDao() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES_PATH)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Boolean update(BookLeaser bookLeaser) {
        if (properties.getProperty(bookLeaser.getId().toString()) == null) {
            return false;
        } else {
            properties.setProperty(bookLeaser.getId().toString(), bookLeaser.toString());
            updateProperties();
            return true;
        }
    }

    @Override
    public Boolean create(BookLeaser bookLeaser) {
        if (properties.getProperty(bookLeaser.getId().toString()) != null) {
            return false;
        } else {
            properties.setProperty(bookLeaser.getId().toString(), bookLeaser.toString());
            updateProperties();
            return true;
        }
    }

    @Override
    public List<BookLeaser> getAll() {
        List<BookLeaser> bookLeasers = new ArrayList<>();
        for (String bookLeaserId : properties.stringPropertyNames()) {
            bookLeasers.add(getById(ParseUtil.tryParse(bookLeaserId)));
        }
        return bookLeasers;
    }

    @Override
    public BookLeaser getById(Integer id) {
        String bookLeaserInfo = properties.getProperty(id.toString());
        if (bookLeaserInfo != null) {
            String[] bookLeaserInfoArray = bookLeaserInfo.split(",", 2);
            return new BookLeaser(id, bookLeaserInfoArray[0], bookLeaserInfoArray[1]);
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
