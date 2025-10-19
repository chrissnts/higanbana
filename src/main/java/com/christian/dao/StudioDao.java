package com.christian.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.christian.database.DataBaseConnection;
import com.christian.models.Studio;

public class StudioDao {

    // CREATE
    public void create(Studio studio) {
        String sql = "INSERT INTO studios (name) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, studio.getName());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void update(Studio studio) {
        String sql = "UPDATE studios SET name = ? WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, studio.getName());
            stmt.setLong(2, studio.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(int id) {
        String sql = "DELETE FROM studios WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // FIND BY ID
    public Studio findById(int id) {
        String sql = "SELECT * FROM studios WHERE id = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToStudio(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // FIND BY NAME
    public Studio findByName(String name) {
        String sql = "SELECT * FROM studios WHERE name = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToStudio(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // EXISTS BY NAME
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM studios WHERE name = ?";
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
    public List<Studio> findAll() {
        String sql = "SELECT * FROM studios ORDER BY name ASC";
        List<Studio> studios = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                studios.add(mapResultSetToStudio(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studios;
    }

    // MAP RESULTSET
    private Studio mapResultSetToStudio(ResultSet rs) throws SQLException {
        Studio studio = new Studio();
        studio.setId(rs.getInt("id"));
        studio.setName(rs.getString("name"));
        return studio;
    }
}
