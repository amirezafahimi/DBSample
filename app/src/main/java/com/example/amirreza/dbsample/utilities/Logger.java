package com.example.amirreza.dbsample.utilities;


import android.content.Context;
import android.util.Log;

import com.example.amirreza.dbsample.AppDatabase;
import com.example.amirreza.dbsample.entity.Comment;
import com.example.amirreza.dbsample.entity.User;

import java.util.List;

/**
 * Created by husaynhakeem on 6/12/17.
 */

public class Logger {

    AppDatabase database;

    public Logger(AppDatabase database) {
        this.database=database;
    }

    public void displayUserListByPostId(int postId) {

        List<User> users = database.DBDao().findUserListByPostId(postId);

        if (users == null)
            return;

        for (User user: users) {
            Log.d("Users", "User id: " + user.getId() + ", User firstName: "
                    + user.getFirstName() + ", User lastName: " + user.getLastName()
                    + ", User avatrLink: " + user.getAvatarLink() + ",User nationlCode:" + user.getNationalCode());
        }
    }


    public void displayCommentsByPostId(int postId) {

        List<Comment> comments = database.DBDao().findCommentsByPostId(postId);

        if (comments == null)
            return;

        for (Comment comment: comments) {
            Log.d("Comments", "Comment id: " + comment.getId() + ", Comment userId: "
                    + comment.getUserId() + ", Comment postId: " + comment.getPostId()
                    + ", Comment body: " + comment.getCommentBody());
        }
    }

    public void displayCommentsByUserId(int userId) {

        List<Comment> comments = database.DBDao().findCommentsByUserId(userId);

        if (comments == null)
            return;

        for (Comment comment: comments) {
            Log.d("Comments", "Comment id: " + comment.getId() + ", Comment userId: "
                    + comment.getUserId() + ", Comment postId: " + comment.getPostId()
                    + ", Comment body: " + comment.getCommentBody());
        }
    }

    public void displayCommentsNumberByUserId(int userId) {
        int num = database.DBDao().countCommentsByUserId(userId);
        Log.d("Comments number", num+"");

    }
}