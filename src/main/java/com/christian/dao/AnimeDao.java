package com.christian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.christian.database.DataBaseConnection;
import com.christian.models.Anime;

public class AnimeDao {

    // Buscar anime por ID
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
        List<Anime> animes = new java.util.ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                animes.add(mapResultSetToAnime(rs));
            }
            return animes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }


    // Salvar novo anime
    public void save(Anime anime) {
        String sql = "INSERT INTO animes (title, episodes_count, synopsis, image_url, rating, release_date) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, anime.getTitle());
            stmt.setInt(2, anime.getEpisodesCount());
            stmt.setString(3, anime.getSynopsis());
            stmt.setString(4, anime.getImageUrl());
            stmt.setDouble(5, anime.getRating());
            stmt.setDate(6, java.sql.Date.valueOf(anime.getReleaseDate()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Atualizar anime
    public void update(Anime anime) {
        String sql = "UPDATE animes SET title = ?, episodes_count = ?, synopsis = ?, image_url = ?, rating = ?, release_date = ? WHERE id = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, anime.getTitle());
            stmt.setInt(2, anime.getEpisodesCount());
            stmt.setString(3, anime.getSynopsis());
            stmt.setString(4, anime.getImageUrl());
            stmt.setDouble(5, anime.getRating());
            stmt.setDate(6, java.sql.Date.valueOf(anime.getReleaseDate()));
            stmt.setLong(7, anime.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Deletar anime por ID
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


    // Converter resultado SQL em objeto Anime
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
