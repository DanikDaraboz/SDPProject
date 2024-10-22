public class Main {
    public static void main(String[] args) {
        LibraryCollection library = new LibraryCollection();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("Moby Dick", "Herman Melville"));
        library.addBook(new Book("1984", "George Orwell"));

        LibraryIterator iterator = library.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
