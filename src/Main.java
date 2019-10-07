import dao.BookDao;
import dao.BookReaderDao;
import dao.api.IBookDao;
import dao.api.IBookReaderDao;
import model.Book;
import model.BookReader;

public class Main {
    public static void main(String[] args) {
        IBookReaderDao bookReaderDao = new BookReaderDao();
        BookReader bookReader = new BookReader(0, "Nikita Matusevich", "+375336208360");
        IBookDao bookDao = new BookDao();
        for (Book book : bookDao.getAll()) {
            System.out.println(book);
        }
        Book updatedBook = new Book(1, "The witcher", "A.Sapkowski", 0);
        bookDao.update(updatedBook);
    }
}
