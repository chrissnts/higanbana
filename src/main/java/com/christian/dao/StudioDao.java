package com.christian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.christian.database.DataBaseConnection;
import com.christian.models.Studio;

public class StudioDao {

    public List<Studio> findAll() {
        String sql = "SELECT * FROM studios";
        List<Studio> studios = new java.util.ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                studios.add(mapResultSetToStudio(rs));
            }
            return studios;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studios;
    }

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

    private Studio mapResultSetToStudio(ResultSet rs) throws SQLException {
        Studio studio = new Studio();
        studio.setId(rs.getInt("id"));
        studio.setName(rs.getString("name"));
        return studio;
    }

}
