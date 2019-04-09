package com.xhsf.bean;

public class Content {

	private int id;
	private String content;
	private int commandId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommandId() {
		return commandId;
	}
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	
	private Command command;
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return "Content [id=" + id + ", content=" + content + ", commandId=" + commandId + "]";
	}
	
}
