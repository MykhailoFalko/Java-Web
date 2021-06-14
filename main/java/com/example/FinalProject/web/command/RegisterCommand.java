package com.example.FinalProject.web.command;

import com.example.FinalProject.db.*;
import com.example.FinalProject.db.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RegisterCommand implements Command {
    private static final Logger log= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("Command starts");
        String address = "userInfo.jsp";

        String login = req.getParameter("login");
        log.trace("login ==> " + login);

        String email = req.getParameter("email");
        log.trace("login ==> " + login);

        String password = req.getParameter("password");

        User user=new User();
        user.setLogin(login);
        user.setRole("user");
        user.setPassword(password);
        UserManager userManager = UserManager.getInstance();
        userManager.setUser(user,email);
        log.trace("user ==> " + user);

        log.debug("Command ends");
        return address;
    }
}

