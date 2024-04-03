public class Book { private String bookTitle;
    private double bookPrice;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }
}

class Main {
    public static Book createBooks(String title, double price) {
        Book book = new Book();
        book.setBookTitle(title);
        book.setBookPrice(price);
        return book;
    }

    public static void showBooks(Book book) {
        System.out.println("Book Title: " + book.getBookTitle() + " and Price: " + book.getBookPrice());
    }

    public static void main(String[] args) {
        String title = "Java Programming";
        double price = 350.00;
        Book book = createBooks(title, price);
        showBooks(book);
    }
}
