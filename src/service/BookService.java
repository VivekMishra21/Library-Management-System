package service;

import dao.BookDao;
import model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(Book book) {
        try {
            bookDao.addBook(book);
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Error while adding book: " + e.getMessage());
        }
    }

    public void viewAllBooks() {
        try {
            List<Book> books = bookDao.getAllbook();
            books.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error fetching books: " + e.getMessage());
        }
    }

    public void borrowBook(int id) {
        try {
            bookDao.borrowBook(id);
            System.out.println("Book borrowed.");
        } catch (SQLException e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    public void deleteBook(int id) {
        try {
            bookDao.deleteBook(id);
            System.out.println("Book deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        }
    }
}
