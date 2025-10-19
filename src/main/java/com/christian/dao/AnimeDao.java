package com.christian.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.christian.database.DataBaseConnection;
import com.christian.models.Anime;
import com.christian.models.Genre;
import com.christian.models.Studio;

public class AnimeDao {

    public void create(Anime anime) {
        String sql = "INSERT INTO animes (title, episodes_count, synopsis, image_url, rating, release_date, studio_id) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, anime.getTitle());
            stmt.setInt(2, anime.getEpisodesCount());
            stmt.setString(3, anime.getSynopsis());
            stmt.setString(4, anime.getImageUrl());
            stmt.setDouble(5, anime.getRating());
            stmt.setDate(6, java.sql.Date.valueOf(anime.getReleaseDate()));
            stmt.setLong(7, anime.getStudio().getId());

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                anime.setId(generatedKeys.getLong(1));
            }

            insertAnimeGenres(anime);

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

            deleteAnimeGenres(anime.getId());
            insertAnimeGenres(anime);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        deleteAnimeGenres(id);

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
        String sql = "SELECT a.*, s.id AS studio_id, s.name AS studio_name " +
                "FROM animes a " +
                "LEFT JOIN studios s ON a.studio_id = s.id " +
                "WHERE a.id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Anime anime = mapResultSetToAnime(rs);
                anime.setGenres(findGenresByAnimeId(anime.getId()));
                return anime;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Anime> findAll() {
        String sql = "SELECT a.*, s.id AS studio_id, s.name AS studio_name " +
                "FROM animes a " +
                "LEFT JOIN studios s ON a.studio_id = s.id";
        List<Anime> animes = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Anime anime = mapResultSetToAnime(rs);
                anime.setGenres(findGenresByAnimeId(anime.getId()));
                animes.add(anime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }

    public List<Anime> findByTitle(String title) {
        String sql = "SELECT a.*, s.id AS studio_id, s.name AS studio_name " +
                "FROM animes a " +
                "LEFT JOIN studios s ON a.studio_id = s.id " +
                "WHERE LOWER(a.title) LIKE LOWER(?)";
        List<Anime> animes = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + title + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Anime anime = mapResultSetToAnime(rs);
                anime.setGenres(findGenresByAnimeId(anime.getId()));
                animes.add(anime);
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

        Studio studio = new Studio();
        studio.setId(rs.getLong("studio_id"));
        studio.setName(rs.getString("studio_name"));
        anime.setStudio(studio);

        return anime;
    }

    private List<Genre> findGenresByAnimeId(long animeId) {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT g.id, g.name " +
                "FROM genres g " +
                "JOIN anime_genres ag ON g.id = ag.genre_id " +
                "WHERE ag.anime_id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, animeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getLong("id"));
                genre.setName(rs.getString("name"));
                genres.add(genre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    private void insertAnimeGenres(Anime anime) {
        if (anime.getGenres() == null)
            return;
        String sql = "INSERT INTO anime_genre (anime_id, genre_id) VALUES (?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Genre genre : anime.getGenres()) {
                stmt.setLong(1, anime.getId());
                stmt.setLong(2, genre.getId());
                stmt.addBatch();
            }
            stmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteAnimeGenres(long animeId) {
        String sql = "DELETE FROM anime_genre WHERE anime_id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, animeId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
