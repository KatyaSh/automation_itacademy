package repository;

import connector.Connect;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository {

    public final static String INSERT_USER = " INSERT INTO Users (name ,address)\n" +
            "VALUES(?,?);";
    public final static String SELECT_USER = "SELECT userId, name, address "
            + "FROM Users WHERE name = ?";
    private Connect connector = new Connect();

    public void insertUser(User user) throws SQLException {
        Connection conn = connector.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(INSERT_USER);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getAddress());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
           conn.close();
        }
    }

    public User selectUserDataByName(String name) throws SQLException {
        Connection conn = connector.connect();
        try (PreparedStatement pstmt  = conn.prepareStatement(SELECT_USER)){
            pstmt.setString(1, name);
            ResultSet result  = pstmt.executeQuery();

            while (result.next()) {
                User user = new User();
               user.setId(result.getInt("userId"));
               user.setName(result.getString("name"));
                user.setAddress(result.getString("address"));
               return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
        }
        return null;
    }


}
