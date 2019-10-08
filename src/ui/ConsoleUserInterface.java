package ui;

import exceptions.IncorrectInputException;
import exceptions.NotExistException;
import model.*;
import services.BookLeaserService;
import services.BookService;
import services.api.IBookLeaserService;
import services.api.IBookService;
import utils.ParseUtil;

import java.util.Scanner;

public class ConsoleUserInterface {
    private Scanner reader;
    private IBookService bookService;
    private IBookLeaserService bookLeaserService;

    public ConsoleUserInterface() {
        reader = new Scanner(System.in);
        bookService = new BookService();
        bookLeaserService = new BookLeaserService();
    }

    public void start() {
        try {
            Book book;
            BookLeaser bookLeaser;
            while (true) {
                System.out.print("1. Lease a book\n" +
                        "2. Return a book\n" +
                        "3. Show list of leased books\n" +
                        "4. Show list of free books\n" +
                        "5. Add new book\n" +
                        "6. Add new book leaser\n" +
                        "7. Show book leaser info\n" +
                        "Enter operation number:");
                String operationNumber = reader.nextLine();
                switch (operationNumber) {
                    case "1":
                        book = showBookDialog();
                        if (book.getBookLeaserId() != null) {
                            System.out.println("Book is already leased");
                            break;
                        }
                        bookLeaser = showBookLeaserDialog();
                        book.setBookLeaserId(bookLeaser.getId());
                        bookService.updateBookInfo(book);
                        break;
                    case "2":
                        book = showBookDialog();
                        book.setBookLeaserId(null);
                        bookService.updateBookInfo(book);
                        break;
                    case "3":
                        for (Book leasedBook : bookService.getAllLeasedBooks()) {
                            System.out.println(leasedBook);
                        }
                        break;
                    case "4":
                        for (Book freeBook : bookService.getAllFreeBooks()) {
                            System.out.println(freeBook);
                        }
                        break;
                    case "5":
                        book = showAddNewBookDialog();
                        bookService.addBook(book);
                        break;
                    case "6":
                        bookLeaser = showAddNewBookLeaserDialog();
                        bookLeaserService.addBookLeaser(bookLeaser);
                        break;
                    case "7":
                        System.out.println(showBookLeaserDialog());
                        break;
                    default:
                        System.out.printf("There is no operation with number: %s%n", operationNumber);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private Book showBookDialog() throws NotExistException, IncorrectInputException {
        System.out.print("Enter the book id: ");
        Integer bookId = ParseUtil.tryParse(reader.nextLine());
        if (bookId != null) {
            return bookService.getById(bookId);
        } else {
            throw new IncorrectInputException();
        }
    }

    private BookLeaser showBookLeaserDialog() throws NotExistException, IncorrectInputException {
        System.out.print("Enter the book leaser id: ");
        Integer bookLeaserId = ParseUtil.tryParse(reader.nextLine());
        if (bookLeaserId != null) {
            return bookLeaserService.getById(bookLeaserId);
        } else {
            throw new IncorrectInputException();
        }
    }

    private Book showAddNewBookDialog() throws IncorrectInputException {
        System.out.print("Enter the book id: ");
        Integer bookId = ParseUtil.tryParse(reader.nextLine());
        System.out.print("Enter the book name: ");
        String bookName = reader.nextLine();
        System.out.print("Enter the book author: ");
        String bookAuthor = reader.nextLine();
        if (bookId != null) {
            return new Book(bookId, bookName, bookAuthor, null);
        } else {
            throw new IncorrectInputException();
        }
    }

    private BookLeaser showAddNewBookLeaserDialog() throws IncorrectInputException {
        System.out.print("Enter the book leaser id: ");
        Integer bookLeaserId = ParseUtil.tryParse(reader.nextLine());
        System.out.print("Enter the book leaser name: ");
        String bookLeaserName = reader.nextLine();
        System.out.print("Enter the book leaser phone number: ");
        String bookLeaserPhoneNumber = reader.nextLine();
        if (bookLeaserId != null) {
            return new BookLeaser(bookLeaserId, bookLeaserName, bookLeaserPhoneNumber);
        } else {
            throw new IncorrectInputException();
        }
    }
}
