package com.niit.GetMeSocialbackend.dao;

import java.util.List;

import com.niit.GetMeSocialbackend.model.Forum;

public interface ForumDAO {
	
	public boolean createForum(Forum forum);
	
	public boolean updateForum(Forum forum);
	
	public List<Forum> getAllForum();
	
	public Forum getForumbyID(long forumID);
	
	public boolean removeForum(Forum forum);
	
	public boolean removeForum(long forumId);

}
