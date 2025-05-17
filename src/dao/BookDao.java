package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private Connection connection;

    public BookDao(Connection connection){
        this.connection = connection;
    }

    // ADD Book
    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO book (book_name,book_author,price,is_borrowed) VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getbook_name());
        ps.setString(2, book.getbook_author ());
        ps.setInt(3, book.getPrice());
        ps.setBoolean(4, book.is_borrowed ());
        ps.executeUpdate();
    }

    // READ all book
    public List<Book> getAllbook() throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book";
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Book b = new Book(
                    rs.getInt("id"),
                    rs.getString("book_name"),
                    rs.getString("book_author"),     // ✅ fixed
                    rs.getInt("price"),
                    rs.getBoolean("is_borrowed")     // ✅ fixed
            );
            list.add(b);
        }
        return list;
    }


    // UPDATE book (borrow)
    public void borrowBook(int id) throws SQLException {
        String sql = "UPDATE book SET  is_borrowed  = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setBoolean(1, true);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    // DELETE book
    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM book WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}
