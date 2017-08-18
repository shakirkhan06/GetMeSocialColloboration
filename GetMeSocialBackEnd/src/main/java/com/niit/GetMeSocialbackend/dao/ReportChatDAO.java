package com.niit.GetMeSocialbackend.dao;

import java.util.List;

import com.niit.GetMeSocialbackend.model.ReportUserChat;

public interface ReportChatDAO {
	
	public boolean createReportChat(ReportUserChat reportUserChat);
	
	public boolean removeReportChat(ReportUserChat reportUserChat);
	
	public boolean removeReportChat(long chat_reportId);
	
	public boolean removeByReportChat(long chat_reportId);
	
	public List<ReportUserChat> getAllReportsChat();
	
	public ReportUserChat getReportChatById(long chat_reportId);

}
