package com.niit.GetMeSocialbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CHATREPORTS")
public class ReportUserChat extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long chat_reportId;
	
	private long chatID;
	
	private String userID;
	/*
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date msgDate;
	
	private String chatMsg;
*/
	public long getChat_reportId() {
		return chat_reportId;
	}

	public void setChat_reportId(long chat_reportId) {
		this.chat_reportId = chat_reportId;
	}

	public long getChatID() {
		return chatID;
	}

	public void setChatID(long chatID) {
		this.chatID = chatID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
/*
	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}

	public String getChatMsg() {
		return chatMsg;
	}

	public void setChatMsg(String chatMsg) {
		this.chatMsg = chatMsg;
	}
*/
}
