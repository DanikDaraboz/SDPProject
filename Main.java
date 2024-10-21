import java.util.*;

class Book {
    private final String title;
    private final String author;

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

interface Observer {
    void update(String message);
}

class EmailListener implements Observer {
    private final String email;

    public EmailListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Sending email to " + email + ": " + message);
    }
}

class NotificationService {
    private final List<Observer> observers;

    public NotificationService() {
        observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}

interface Command {
    void execute();
}

class AddBookCommand implements Command {
    private final Library library;
    private final Book book;

    public AddBookCommand(Library library, Book book) {
        this.library = library;
        this.book = book;
    }

    @Override
    public void execute() {
        library.addBook(book);
    }
}

class RemoveBookCommand implements Command {
    private final Library library;
    private final String bookTitle;

    public RemoveBookCommand(Library library, String bookTitle) {
        this.library = library;
        this.bookTitle = bookTitle;
    }

    @Override
    public void execute() {
        library.removeBook(bookTitle);
    }
}

interface BookStorageStrategy {
    void addBook(Book book);
    void removeBook(String title);
    List<Book> listBooks();
}

class ListStorageStrategy implements BookStorageStrategy {
    private final List<Book> books;

    public ListStorageStrategy() {
        books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    @Override
    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }
}

class SetStorageStrategy implements BookStorageStrategy {
    private final Set<Book> books;

    public SetStorageStrategy() {
        books = new HashSet<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    @Override
    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }
}

class Library {
    private final NotificationService notificationService;
    private BookStorageStrategy bookStorageStrategy;

    public Library(BookStorageStrategy bookStorageStrategy) {
        this.notificationService = new NotificationService();
        this.bookStorageStrategy = bookStorageStrategy;
    }

    public void addObserver(Observer observer) {
        notificationService.subscribe(observer);
    }

    public void removeObserver(Observer observer) {
        notificationService.unsubscribe(observer);
    }

    public void addBook(Book book) {
        bookStorageStrategy.addBook(book);
        notificationService.notifyObservers("New book added: " + book.getTitle());
    }

    public void removeBook(String bookTitle) {
        bookStorageStrategy.removeBook(bookTitle);
        notificationService.notifyObservers("Book removed: " + bookTitle);
    }

    public List<Book> listBooks() {
        return bookStorageStrategy.listBooks();
    }

    public void setBookStorageStrategy(BookStorageStrategy strategy) {
        this.bookStorageStrategy = strategy;
    }
}

public class Main {
    public static void main(String[] args) {
        BookStorageStrategy listStrategy = new ListStorageStrategy();
        Library library = new Library(listStrategy);

        EmailListener user1 = new EmailListener("user1@example.com");
        EmailListener user2 = new EmailListener("user2@example.com");

        library.addObserver(user1);
        library.addObserver(user2);

        Command addBook1 = new AddBookCommand(library, new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        Command addBook2 = new AddBookCommand(library, new Book("1984", "George Orwell"));

        addBook1.execute();
        addBook2.execute();

        System.out.println("Books in the library (using List strategy):");
        library.listBooks().forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));

        BookStorageStrategy setStrategy = new SetStorageStrategy();
        library.setBookStorageStrategy(setStrategy);

        addBook1.execute();
        addBook2.execute();

        System.out.println("\nBooks in the library (after switching to Set strategy):");
        library.listBooks().forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
    }
}
