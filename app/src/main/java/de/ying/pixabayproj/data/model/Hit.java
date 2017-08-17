package de.ying.pixabayproj.data.model;

/**
 * Created by yingli on 7/29/17.
 *
 * Hit represent a result of query
 */

public class Hit {
    private int id;
    private String user;
    private String tags;
    private int likes;
    private int favorites;
    private int comments;
    private String pageURL;
    private String previewURL;
    private String webformatURL;

    public Hit() {
    }

    public Hit(int id, String user, String tags, int likes, int favorites, int comments, String previewURL, String webformatURL) {
        this.id = id;
        this.user = user;
        this.tags = tags;
        this.likes = likes;
        this.favorites = favorites;
        this.comments = comments;
        this.previewURL = previewURL;
        this.webformatURL = webformatURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }
}

