import dao.BookDao;
import dao.BookLeaserDao;
import dao.api.IBookDao;
import dao.api.IBookLeaserDao;
import model.Book;
import model.BookLeaser;
import services.BookService;
import services.api.IBookService;
import ui.ConsoleUserInterface;

public class Main {
    public static void main(String[] args) {
//        IBookLeaserDao bookReaderDao = new BookLeaserDao();
//        BookLeaser bookLeaser = new BookLeaser(0, "Nikita Matusevich", "+375336208360");
//        IBookDao bookDao = new BookDao();
//        IBookService bookService = new BookService();
//        for (Book book : bookService.getAllLeasedBooks()) {
//            System.out.println(book);
//        }
//        for (Book book : bookDao.getAll()) {
//            System.out.println(book);
//        }
//        Book updatedBook = new Book(1, "The witcher", "A.Sapkowski", 0);
        //bookDao.update(updatedBook);
        //Integer number = null;
        //System.out.println(number.toString());
        //BookDao bookDao = new BookDao();
        //System.out.println(bookDao.getById(null));
        ConsoleUserInterface userInterface = new ConsoleUserInterface();
        userInterface.start();
    }
}
