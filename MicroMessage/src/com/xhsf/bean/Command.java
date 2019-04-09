package com.xhsf.bean;

import java.util.List;

public class Command {
	
	private int id;
	private String name;
	private String description;
	private List<Content> contentList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	public List<Content> getContentList() {
		return contentList;
	}
	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}
	@Override
	public String toString() {
		return "Command [id=" + id + ", name=" + name + ", description=" + description + ", contentList=" + contentList
				+ "]";
	}
	
	
	
	
}
