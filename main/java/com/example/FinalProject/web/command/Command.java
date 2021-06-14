package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
	
	String execute(HttpServletRequest req,
				   HttpServletResponse resp) throws DBException;

}
