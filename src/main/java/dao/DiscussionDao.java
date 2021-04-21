package dao;

import entity.DiscussionBean;

import java.util.List;

public interface DiscussionDao {
    public void insertDiscussion(DiscussionBean discussionBean);
    public List<DiscussionBean> getDiscussions();
    public void like(DiscussionBean discussionBean);
    public void dislike(DiscussionBean discussionBean);
    public DiscussionBean getDiscussion(Integer id);
    public void updateDiscussion(DiscussionBean discussionBean);
    public void deleteDiscussion(DiscussionBean discussionBean);
}
