package entity;

import java.io.Serializable;
import java.util.Date;

public class CommentBean implements Serializable {
    private Integer commentID;
    private AccountBean accountBean;
    private DiscussionBean discussionBean;
    private String comment;
    private Date date;
    public CommentBean(){}
    public CommentBean(Integer commentID, AccountBean accountBean, DiscussionBean discussionBean, String comment, Date date) {
        this.commentID = commentID;
        this.accountBean = accountBean;
        this.discussionBean = discussionBean;
        this.comment = comment;
        this.date = date;
    }
    public CommentBean(AccountBean accountBean, DiscussionBean discussionBean, String comment, Date date){
        this(null, accountBean, discussionBean, comment, date);
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    public DiscussionBean getDiscussionBean() {
        return discussionBean;
    }

    public void setDiscussionBean(DiscussionBean discussionBean) {
        this.discussionBean = discussionBean;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
