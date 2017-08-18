package com.niit.GetMeSocialbackend.dao;

import java.util.List;

import com.niit.GetMeSocialbackend.model.Comment;

public interface CommentDAO {

	public List<Comment> getAllComments(long blogID);
	
	public boolean addComment(long blogID,String comment_UserId,String commentData);
	
	public boolean reportComment(long commentID);
	
	public boolean removeComment(long commentID);
	
	public List<Comment> getAllReportedComments(long blogID);
	
	public List<Comment> getReportedComment();
	
	public Comment getComment(long commentID);

}
