import dao.BookDao;
import dao.UserDao;
import model.Book;
import model.User;
import service.BookService;
import service.UserService;
import db.DBConnection;

import javax.swing.*;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        try {
            Connection connection = DBConnection.getConnection();

            UserDao userDao = new UserDao(connection);
            BookDao bookDao = new BookDao(connection);

            UserService userService = new UserService(userDao);
            BookService bookService = new BookService(bookDao);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n===== Library System =====");
                System.out.println("1. Add User");
                System.out.println("2. View All Users");
                System.out.println("3. Delete User");
                System.out.println("4. Add Book");
                System.out.println("5. View All Books");
                System.out.println("6. Borrow Book");
                System.out.println("7. Delete Book");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("PhoneNumber: ");
                        String phone = scanner.nextLine();
                        System.out.print("Address: ");
                        String address = scanner.nextLine();
                        userService.addUser(new User(name, phone, address));
                    }
                    case 2 -> userService.viewAllUsers();
                    case 3 -> {
                        System.out.print("Enter user ID to delete: ");
                        int id = scanner.nextInt();
                        userService.deleteUser(id);
                    }
                    case 4 -> {
                        System.out.print("Book Name: ");
                        String bookName = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Price: ");
                        int price = scanner.nextInt();
                        scanner.nextLine();
                        bookService.addBook(new Book(bookName, author, price, false));
                    }
                    case 5 -> bookService.viewAllBooks();
                    case 6 -> {
                        System.out.print("Enter book ID to borrow: ");
                        int id = scanner.nextInt();
                        bookService.borrowBook(id);
                    }
                    case 7 -> {
                        System.out.print("Enter book ID to delete: ");
                        int id = scanner.nextInt();
                        bookService.deleteBook(id);
                    }
                    case 0 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
