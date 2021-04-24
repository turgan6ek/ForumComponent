package dao;

import ConfigDB.ConnProvider;
import entity.AccountBean;
import entity.DiscussionBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscussionDaoImpl implements DiscussionDao{
    static Connection conn;
    static PreparedStatement pst;
    AccountBean accountBean = new AccountBean();
    private  static String INSERT_SQL = "INSERT INTO discussion(user_id, title, body, grant_date) values(?, ?, ?, now())";
    @Override
    public void insertDiscussion(DiscussionBean discussionBean) {
        if (discussionBean != null) {
            try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, discussionBean.getUserID());
                ps.setString(2, discussionBean.getTitle());
                ps.setString(3, discussionBean.getBody());
                int numRowsAffected = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        discussionBean.setDiscussionID(rs.getInt(2));
                    }
                } catch (Exception s) {
                    s.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<DiscussionBean> getDiscussions() {
        List<DiscussionBean> list = new ArrayList<>();
        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("SELECT * FROM discussion ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DiscussionBean discussion = new DiscussionBean();
                discussion.setUserID(rs.getInt(1));
                discussion.setDiscussionID(rs.getInt(2));
                discussion.setTitle(rs.getString(3));
                discussion.setBody(rs.getString(4));
                discussion.setDate(rs.getTimestamp(5));
                discussion.setLikes(rs.getInt(6));
                discussion.setDislikes(rs.getInt(7));
                list.add(discussion);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void like(Integer id) {
        DiscussionBean discussionBean = this.getDiscussion(id);
        String query = "UPDATE public.discussion SET likes = " + discussionBean.getLikes() + 1 +  " WHERE discussion_id = " + discussionBean.getDiscussionID();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void dislike(Integer id) {
        DiscussionBean discussionBean = this.getDiscussion(id);
        String query = "UPDATE public.discussion SET dislikes = " + discussionBean.getDislikes() + 1 +  " WHERE discussion_id = " + discussionBean.getDiscussionID();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public DiscussionBean getDiscussion(Integer id) {
        DiscussionBean discussion = new DiscussionBean();
        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("SELECT * FROM discussion WHERE discussion_id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                discussion.setUserID(rs.getInt(1));
                discussion.setDiscussionID(rs.getInt(2));
                discussion.setTitle(rs.getString(3));
                discussion.setBody(rs.getString(4));
                discussion.setDate(rs.getTimestamp(5));
                discussion.setLikes(rs.getInt(6));
                discussion.setDislikes(rs.getInt(7));
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return discussion;
    }

    @Override
    public void updateDiscussion(DiscussionBean discussionBean) {
        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("UPDATE discussion SET title = ?, body = ?, grant_date = now() WHERE discussion_id = ?");
            pst.setString(1, discussionBean.getTitle());
            pst.setString(2, discussionBean.getBody());
            pst.setInt(3, discussionBean.getDiscussionID());
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteDiscussion(Integer id) {
        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("DELETE FROM discussion WHERE discussion_id = ?");
            pst.setInt(1, id);
            pst.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
