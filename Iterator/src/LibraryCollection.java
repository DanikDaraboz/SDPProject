import java.util.ArrayList;
import java.util.List;

public class LibraryCollection {
    private List<Book> books;

    public LibraryCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public LibraryIterator iterator() {
        return new BookIterator(books);
    }
}

