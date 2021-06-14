package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DBManager dbManager = DBManager.getInstance();
	}

}
