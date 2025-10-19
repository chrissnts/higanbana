package com.christian.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.christian.database.DataBaseConnection;
import com.christian.models.Genre;

public class GenreDao {

    // CREATE
    public void create(Genre genre) {
        String sql = "INSERT INTO genres (name) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, genre.getName());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(Genre genre) {
        String sql = "UPDATE genres SET name = ? WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, genre.getName());
            stmt.setLong(2, genre.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM genres WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND BY ID
    public Genre findById(int id) {
        String sql = "SELECT * FROM genres WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToGenre(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // FIND BY NAME
    public Genre findByName(String name) {
        String sql = "SELECT * FROM genres WHERE name = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToGenre(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // EXISTS BY NAME
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM genres WHERE name = ?";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // FIND ALL
    public List<Genre> findAll() {
        String sql = "SELECT * FROM genres ORDER BY name ASC";
        List<Genre> genres = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                genres.add(mapResultSetToGenre(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    // MAP RESULTSET
    private Genre mapResultSetToGenre(ResultSet rs) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name"));
        return genre;
    }
}
