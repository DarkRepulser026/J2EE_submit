import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String msg =
            "\nChuong trinh quan ly sach\n" +
            "1. Them 1 cuon sach\n" +
            "2. Xoa 1 cuon sach\n" +
            "3. Thay doi sach\n" +
            "4. Xuat thong tin\n" +
            "5. Tim sach Lap trinh\n" +
            "6. Lay sach toi da theo gia\n" +
            "7. Tim kiem theo tac gia\n" +
            "0. Thoat\n" +
            "Chon chuc nang: ";

        int chon = 0;
        do {
            System.out.printf(msg);
            chon = x.nextInt();
            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                }
                case 2 -> {
                    System.out.print("Nhap vao ma sach can xoa: ");
                    int bookid = x.nextInt();
                    try {
                        Book find = listBook.stream()
                            .filter(p -> p.getId() == bookid)
                            .findFirst()
                            .orElseThrow();
                        listBook.remove(find);
                        System.out.println("Da xoa sach thanh cong");
                    } catch (NoSuchElementException e) {
                        System.out.println("Khong tim thay ma sach!");
                    }
                }
                case 3 -> {
                    System.out.print("Nhap vao ma sach can dieu chinh: ");
                    int bookid = x.nextInt();
                    try {
                        Book find = listBook.stream()
                            .filter(p -> p.getId() == bookid)
                            .findFirst()
                            .orElseThrow();
                        System.out.println("Nhap thong tin moi:");
                        find.input();
                        System.out.println("Cap nhat thanh cong!");
                    } catch (NoSuchElementException e) {
                        System.out.println("Khong tim thay ma sach!");
                    }
                }
                case 4 -> {
                    System.out.println("\nXuat thong tin danh sach ");
                    listBook.forEach(b -> b.output());
                }
                case 5 -> {
                    List<Book> list5 = listBook.stream()
                        .filter(u -> u.getTitle().toLowerCase().contains("lap trinh"))
                        .toList();
                    list5.forEach(b -> b.output());
                }
                case 6 -> {
                    System.out.print("Nhap so luong K sach toi da: ");
                    int K = x.nextInt();
                    System.out.print("Nhap muc gia P toi da: ");
                    double P = x.nextDouble();
                    listBook.stream()
                        .filter(b -> b.getPrice() <= P)
                        .limit(K)
                        .forEach(b -> b.output());
                }
                case 7 -> {
                    x.nextLine();
                    System.out.print("Nhap danh sach tac gia (cach nhau boi dau phay): ");
                    String input = x.nextLine();
                    Set<String> authorSet = Arrays.stream(input.split(","))
                        .map(s -> s.trim())
                        .collect(Collectors.toSet());
                    listBook.stream()
                        .filter(b -> authorSet.contains(b.getAuthor().toLowerCase()))
                        .forEach(b -> b.output());
                }
            }
        } while (chon != 0);
    }
}
