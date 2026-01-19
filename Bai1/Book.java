import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    public Book() {}

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap ten sach: ");
        this.title = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        this.author = sc.nextLine();
        System.out.print("Nhap don gia: ");
        this.price = Double.parseDouble(sc.nextLine());
    }

    public void output() {
        System.out.printf("Ma: %d | Ten: %s | Tac gia: %s | Gia: %.2f\n", id, title, author, price);
    }
}
