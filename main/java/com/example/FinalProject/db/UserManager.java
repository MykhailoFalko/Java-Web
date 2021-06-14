package com.example.FinalProject.db;

import com.example.FinalProject.db.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
	
	private DBManager dbManager;
	
	////////////////////////////////
	
	private static UserManager instance;

	private static final Logger log= LogManager.getLogger();
	
	public static synchronized UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	private UserManager() {
		dbManager = DBManager.getInstance();
	}

	////////////////////////////////

	public User getUser(String login) throws DBException {
		User user = null;
		Connection con = null;
		try {
			con = dbManager.getConnection();
			user = dbManager.getUser(con, login);
			con.commit();
		} catch (SQLException ex) {
			log.error("cannot do getUser", ex);

			dbManager.rollback(con);

			throw new DBException("Cannot do getUser", ex);
		} finally {
			dbManager.close(con);
		}
		return user;
	}
	public List<User> getUsersByRole(String role) throws DBException {
		List <User> list;
		Connection con = null;
		try {
			con = dbManager.getConnection();
			list = dbManager.getUsersByRole(con, role);
			con.commit();
		} catch (SQLException ex) {
			log.error("cannot do getUserByRole", ex);

			dbManager.rollback(con);

			throw new DBException("Cannot do getUser", ex);
		} finally {
			dbManager.close(con);
		}
		return list ;
	}

	public void setUser(User user,String email) throws DBException {
		Connection con = null;
		try {
			con = dbManager.getConnection();
			dbManager.setUser(con, user,email);
			con.commit();
		} catch (SQLException ex) {
			log.error("cannot do setUser", ex);

			dbManager.rollback(con);

			throw new DBException("Cannot do setUser", ex);
		} finally {
			dbManager.close(con);
		}
	}
	
	/////////////////////////////////////

}
