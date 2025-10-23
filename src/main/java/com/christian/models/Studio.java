package com.christian.models;

import java.time.LocalDateTime;
import java.util.List;

public class Studio {
    private Long id;
    private String name;
    private List<Anime> animes;
    private LocalDateTime deletedAt;

    public Studio(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Studio() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }

    @Override
    public String toString() {
        return "Studio [id=" + id + ", name=" + name + ", deletedAt=" + deletedAt + "]";
    }
}
