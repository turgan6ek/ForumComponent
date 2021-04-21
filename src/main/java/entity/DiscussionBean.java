package entity;

import java.io.Serializable;
import java.util.Date;

public class DiscussionBean implements Serializable {
    private Integer discussionID;
    private Integer userID;
    private String body;
    private String title;
    private Date date;
    private int likes;
    private int dislikes;

    public DiscussionBean() {

    }

    public DiscussionBean(Integer discussionID, Integer userID, String body, String title, Date date, int likes, int dislikes) {
        this.discussionID = discussionID;
        this.userID = userID;
        this.body = body;
        this.title = title;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
    }
    public DiscussionBean(AccountBean accountBean, String body, String title, Date date, int likes, int dislikes){
        this(null, userID, body, title, date, likes, dislikes);
    }
    public int getDiscussionID() {
        return discussionID;
    }

    public void setDiscussionID(int discussionID) {
        this.discussionID = discussionID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
