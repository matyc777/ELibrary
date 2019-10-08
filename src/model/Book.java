package model;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private Integer bookLeaserId;

    public Book(Integer id, String name, String author, Integer bookLeaserId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.bookLeaserId = bookLeaserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBookLeaserId() {
        return bookLeaserId;
    }

    public void setBookLeaserId(Integer bookLeaserId) {
        this.bookLeaserId = bookLeaserId;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%d", name, author, bookLeaserId);
    }
}
