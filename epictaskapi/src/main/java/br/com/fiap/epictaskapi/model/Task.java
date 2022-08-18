package br.com.fiap.epictaskapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "titulo é obrigatório")
    private String title;
    private String description;

    @Min(1)
    private int score;
    private int status;

    public Task() {
    }

    public Task(@NotBlank(message = "titulo é obrigatório") String title, String description, @Min(1) int score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }

    public Task(Long id, String title, String description, int score, int status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.score = score;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task [description=" + description + ", id=" + id + ", score=" + score + ", status=" + status
                + ", title=" + title + "]";
    }

}
