package com.niit.GetMeSocialbackend.testcase;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.GetMeSocialbackend.dao.BlogDAO;
import com.niit.GetMeSocialbackend.model.Blog;

import junit.framework.Assert;

public class BlogTestCase {
	
	@Autowired
	static Blog blog;
	
	@Autowired
	static BlogDAO blogDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.GetMeSocialbackend");
		context.refresh();
		blog = (Blog) context.getBean("blog");
		blogDAO = (BlogDAO) context.getBean("blogDAO");
	}
	
	//@Test
	public void createBlogTestCase()
	{
		blog.setBlogName("Welcome to GMS");
		blog.setBlogCreatorId("US001");
		blog.setBlogData("Hello welcome to Get Me Socail , a place where you can share your passions with fellow User. Get started by creating a blog or joining a chat, apply for jobs that suite you, and share your exciting ideas in our forums. And once again WELCOME");
		blog.setBlogDescription("For the new Users of GMS");
		boolean flag=blogDAO.createBlog(blog);
		Assert.assertEquals("createBlogTestCase",true,flag);
	}

	//@Test
	public void updateAndGetBlogByIdTestCase()
	{
		blog=blogDAO.getBlogById(1);
		blog.setBlogDescription("For the users who are new to GMS");
		boolean flag=blogDAO.updateBlog(blog);
		Assert.assertEquals("updateAndGetBlogByIdTestCase",true,flag);
	}
	
	//@Test
	public void removeBlogTestCase()
	{
		blog=blogDAO.getBlogById(2);
		boolean flag=blogDAO.removeBlog(blog);
		Assert.assertEquals("removeBlogTestCase",true,flag);
	}
	
	//@Test
	public void removeBlogByIdTestCase(){
		boolean flag=blogDAO.removeBlog(3);
		Assert.assertEquals("removeBlogByIdTestCase",true,flag);
	}
	
	//@Test
	public void getAllBlogsTestCase()
	{
		int flag=blogDAO.getAllBlogs().size();
		Assert.assertEquals("getAllBlogsTestCase",1,flag);
	}
	
}
