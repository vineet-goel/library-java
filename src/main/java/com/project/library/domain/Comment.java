package com.project.library.domain;

import java.time.Instant;

public class Comment {
    private String comment;
    private String username;
    private Instant creationDate;

    public Comment(String comment, String username) {
        this.comment = comment;
        this.username = username;
        this.creationDate = Instant.now();
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public Instant getCreationDate() {
        return creationDate;
    }
}
