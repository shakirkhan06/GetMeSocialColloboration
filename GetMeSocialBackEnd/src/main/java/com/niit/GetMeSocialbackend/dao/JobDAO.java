package com.niit.GetMeSocialbackend.dao;

import java.util.List;

import com.niit.GetMeSocialbackend.model.Job;

public interface JobDAO {
	
	public boolean createJob(Job job);
	
	public boolean removeJob(Job job);
	
	public boolean updateJob(Job job);
		
	public Job getJobById(long jobId);
	
	public List<Job> getAllJobs();
	
	public void closeJob(long jobId);

}
