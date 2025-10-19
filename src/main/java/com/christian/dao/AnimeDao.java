package com.christian.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.christian.database.DataBaseConnection;
import com.christian.models.Anime;

public class AnimeDao {

    public void create(Anime anime) {
        String sql = "INSERT INTO animes (title, episodes_count, synopsis, image_url, rating, release_date, studio_id) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, anime.getTitle());
            stmt.setInt(2, anime.getEpisodesCount());
            stmt.setString(3, anime.getSynopsis());
            stmt.setString(4, anime.getImageUrl());
            stmt.setDouble(5, anime.getRating());
            stmt.setDate(6, java.sql.Date.valueOf(anime.getReleaseDate()));
            stmt.setLong(7, anime.getStudio().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Anime anime) {
        String sql = "UPDATE animes SET title = ?, episodes_count = ?, synopsis = ?, image_url = ?, rating = ?, release_date = ?, studio_id = ? WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, anime.getTitle());
            stmt.setInt(2, anime.getEpisodesCount());
            stmt.setString(3, anime.getSynopsis());
            stmt.setString(4, anime.getImageUrl());
            stmt.setDouble(5, anime.getRating());
            stmt.setDate(6, java.sql.Date.valueOf(anime.getReleaseDate()));
            stmt.setLong(7, anime.getStudio().getId());
            stmt.setLong(8, anime.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM animes WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Anime findById(int id) {
        String sql = "SELECT * FROM animes WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToAnime(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Anime> findAll() {
        String sql = "SELECT * FROM animes";
        List<Anime> animes = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                animes.add(mapResultSetToAnime(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }

    public List<Anime> findByTitle(String title) {
        String sql = "SELECT * FROM animes WHERE LOWER(title) LIKE LOWER(?)";
        List<Anime> animes = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                animes.add(mapResultSetToAnime(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }

    private Anime mapResultSetToAnime(ResultSet rs) throws SQLException {
        Anime anime = new Anime();
        anime.setId(rs.getLong("id"));
        anime.setTitle(rs.getString("title"));
        anime.setEpisodesCount(rs.getInt("episodes_count"));
        anime.setSynopsis(rs.getString("synopsis"));
        anime.setImageUrl(rs.getString("image_url"));
        anime.setRating(rs.getDouble("rating"));

        java.sql.Date releaseDate = rs.getDate("release_date");
        if (releaseDate != null) {
            anime.setReleaseDate(releaseDate.toLocalDate());
        }

        return anime;
    }
}
