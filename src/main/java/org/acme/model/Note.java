package org.acme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.logging.Log;

public class Note implements Cloneable {

    // private static final Logger log;

    private Long id;
    private String title;
    private String content;

    public Note() {
    };

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonIgnore
    public Note getClone() {
        try {
            return (Note) this.clone();
        } catch (CloneNotSupportedException e) {
            Log.warn("Cloning not allowed!");
            return this;
        }
    }

}
