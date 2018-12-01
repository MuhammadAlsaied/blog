package com.muhammadalsaied.blog.backend.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@Entity
@Table
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 10, message = "Must be not less than 20 characters")
    private String title;


    @Length(min = 400, message = "Must be not less than 400 characters")
    @Type(type = "text")
    private String content;

    @NotBlank(message = "Image Is required")
    private String imageUrl;

    @ManyToOne
    @NotNull(message = "User is requied")
    private User user;

    private Long views = 0l;

    @NotNull(message = "Date created is required")
    private Date dateCreated;

    private boolean active= false;

    @ManyToMany
    @NotNull(message = "Article must have tags")
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    @NotNull(message = "Category is requierd")
    private Category category;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public User getUser() {
        return user;
    }

    public Long getViews() {
        return views;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
