
public class Class {
    public static void main(String[] args) {
        Magazine magazine = new Magazine("Tech Today", "Tech Publishers", "September 2024", 5.99);

        magazine.displayInfo();
    }
}

class Magazine {
    private String title;
    private String publisher;
    private String releaseDate;
    private double price;

    public Magazine(String title, String publisher, String releaseDate, double price) {
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("Price: $" + price);
    }
}










