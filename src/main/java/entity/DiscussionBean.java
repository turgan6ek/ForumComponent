package entity;

import java.io.Serializable;
import java.util.Date;

public class DiscussionBean implements Serializable {
    private Integer discussionID;
    private AccountBean accountBean;
    private String body;
    private String title;
    private Date date;
    private int likes;
    private int dislikes;

    public DiscussionBean() {

    }

    public DiscussionBean(Integer discussionID, AccountBean accountBean, String body, String title, Date date, int likes, int dislikes) {
        this.discussionID = discussionID;
        this.accountBean = accountBean;
        this.body = body;
        this.title = title;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
    }
    public DiscussionBean(AccountBean accountBean, String body, String title, Date date, int likes, int dislikes){
        this(null, accountBean, body, title, date, likes, dislikes);
    }
    public int getDiscussionID() {
        return discussionID;
    }

    public void setDiscussionID(int discussionID) {
        this.discussionID = discussionID;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(AccountBean accountBean) {
        this.accountBean = accountBean;
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
