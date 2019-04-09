package com.xhsf.bean;

/**
 * 消息表实体类
 */
public class Message {
	
	private int id;
	private String command;
	private String description;
	private String content;
	
	public Message() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", command=" + command + ", description=" + description + ", content=" + content
				+ "]";
	}

}
