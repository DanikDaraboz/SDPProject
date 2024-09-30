import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
}

class Library {
    private List<Book> books;
    public Library() {
        this.books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(String bookTitle) {
        books.removeIf(book -> book.getTitle().equals(bookTitle));
    }
    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("book1", "author1");
        Book book2 = new Book("book2", "author2");

        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Books:");
        for (Book book : library.listBooks()) {
            System.out.println(book.getTitle() + " written by " + book.getAuthor());
        }

        // Remove a book
        library.removeBook("book2");
        System.out.println("\nBooks:");
        for (Book book : library.listBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}
