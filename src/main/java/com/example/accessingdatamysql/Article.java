package com.example.accessingdatamysql;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // This tells Hibernate to make a table out of this class
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime publishedDate;

    @Column(nullable = true)
    private LocalDateTime lastModifiedDate;

    public Article() {
    }

    public Article(User author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.publishedDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author=" + author.getUsername() +
                ", title='" + title + '\'' +
                ", publishedDate=" + publishedDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
