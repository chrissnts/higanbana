package com.christian.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.christian.database.DataBaseConnection;
import com.christian.models.Anime;
import com.christian.models.Studio;

public class StudioDao {

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

    public int count() {
        String sql = "SELECT COUNT(*) AS total FROM studios";
        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

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

    public Studio findByIdWithAnimes(int id) {
        String sqlStudio = "SELECT * FROM studios WHERE id = ?";
        String sqlAnimes = "SELECT * FROM animes WHERE studio_id = ? ORDER BY title ASC";

        Studio studio = null;

        try (Connection conn = DataBaseConnection.getConnection()) {


            try (PreparedStatement stmt = conn.prepareStatement(sqlStudio)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    studio = mapResultSetToStudio(rs);
                } else {
                    return null; 
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement(sqlAnimes)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                List<Anime> animes = new ArrayList<>();
                while (rs.next()) {
                    Anime anime = new Anime();
                    anime.setId(rs.getInt("id"));
                    anime.setTitle(rs.getString("title"));
                    anime.setEpisodesCount(rs.getInt("episodes_count"));

                    java.sql.Date sqlDate = rs.getDate("release_date");
                    if (sqlDate != null) {
                        anime.setReleaseDate(sqlDate.toLocalDate());
                    }

                    anime.setRating(rs.getDouble("rating"));
                    anime.setImageUrl(rs.getString("image_url"));
                    animes.add(anime);
                }

                studio.setAnimes(animes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studio;
    }

    private Studio mapResultSetToStudio(ResultSet rs) throws SQLException {
        Studio studio = new Studio();
        studio.setId(rs.getInt("id"));
        studio.setName(rs.getString("name"));
        return studio;
    }
}
