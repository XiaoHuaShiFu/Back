package com.xhsf.service;

import java.util.List;
import java.util.Random;

import com.xhsf.bean.Command;
import com.xhsf.bean.Content;
import com.xhsf.dao.CommandDao;
import com.xhsf.util.Iconst;

public class QueryService implements Iconst{
	
	private CommandDao commandDao;
	
	public QueryService() {
		this.commandDao = new CommandDao();
	}
	
	/**
	 * 
	 * @param command
	 * @return content
	 */
	@SuppressWarnings("unused")
	public String queryByCommand(String command) {
		List<Command> commandList;
		if (Iconst.HELP_COMMAND.equals(command.trim())) {
			commandList = commandDao.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < commandList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName()
						+"]可以查看：" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryCommandList(command, null);
		if (commandList.size() > 0 && commandList.get(0).getContentList().size() > 0) {
			List<Content> contentList = commandList.get(0).getContentList();
			int random = new Random().nextInt(contentList.size());
			return contentList.get(random).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
	
}
