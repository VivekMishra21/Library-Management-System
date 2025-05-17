package dao;

import model.Book;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }


    //create

    public void addUser(User user) throws SQLException {
        String sql="INSERT INTO user (name,phone_number,address) VALUES(?,?,?)";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getphone_number());
        ps.setString(3,user.getAddress());
        ps.executeUpdate();
    }

    //Read
    public List<User> getAllUser()throws SQLException{
        List<User> list=new ArrayList<>();
        String sql="SELECT * FROM user";
        Statement s=connection.createStatement();
        ResultSet rs=s.executeQuery(sql);

        while (rs.next()){
            User user=new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone_number"),
                    rs.getString("address")

            );
            list.add(user);
        }
        return list;

    }

    // UPDATE User Address and Phone
    public void updateUser(int id, String newPhone, String newAddress) throws SQLException {
        String sql = "UPDATE user SET phone_number = ?, address = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, newPhone);
        ps.setString(2, newAddress);
        ps.setInt(3, id);
        ps.executeUpdate();
    }

    // DELETE User
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

}
