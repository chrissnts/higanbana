package com.christian.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.christian.database.DataBaseConnection;
import com.christian.models.Anime;
import com.christian.models.Genre;

public class GenreDao {

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

    public int count() {
        String sql = "SELECT COUNT(*) AS total FROM genres";
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

    public Genre findByIdWithAnimes(int id) {
        String sqlGenre = "SELECT * FROM genres WHERE id = ?";
        String sqlAnimes = "SELECT a.* " +
                "FROM animes a " +
                "JOIN anime_genres ag ON a.id = ag.anime_id " +
                "WHERE ag.genre_id = ? " +
                "ORDER BY a.title ASC";

        Genre genre = null;

        try (Connection conn = DataBaseConnection.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement(sqlGenre)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    genre = mapResultSetToGenre(rs);
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

                    Date sqlDate = rs.getDate("release_date");
                    if (sqlDate != null) {
                        anime.setReleaseDate(sqlDate.toLocalDate());
                    }

                    anime.setRating(rs.getDouble("rating"));
                    anime.setImageUrl(rs.getString("image_url"));
                    animes.add(anime);
                }

                genre.setAnimes(animes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genre;
    }

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

    private Genre mapResultSetToGenre(ResultSet rs) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name"));
        return genre;
    }
}
