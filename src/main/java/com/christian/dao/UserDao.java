package com.christian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.christian.database.DataBaseConnection;
import com.christian.models.Role;
import com.christian.models.User;

public class UserDao {

    
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users WHERE role_id != 1";
        List<User> users = new java.util.ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

        
    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    public void save(User user) {
        String sql = "INSERT INTO users (user_name, email, password, role_id, profile_image) VALUES (?,?,?,?,?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getRole().getId()); 
            stmt.setString(5, user.getProfileImage());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void update(User user) {
        String sql = "UPDATE users SET user_name = ?, email = ?, role_id = ?, profile_image = ? WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getEmail());
            stmt.setInt(3, user.getRole().getId()); // atualiza role
            stmt.setString(4, user.getProfileImage());
            stmt.setLong(5, user.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUserName(rs.getString("user_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setProfileImage(rs.getString("profile_image"));

        
        int roleId = rs.getInt("role_id");
        user.setRole(Role.fromId(roleId));

        return user;
    }
}
