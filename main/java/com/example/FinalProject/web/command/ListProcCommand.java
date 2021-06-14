package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBException;
import com.example.FinalProject.db.ProcManager;
import com.example.FinalProject.db.UserManager;
import com.example.FinalProject.db.entity.Procedure;
import com.example.FinalProject.db.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListProcCommand implements Command {
    private static final Logger log= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("Command starts");
        String address = "procedures.jsp";
        ProcManager procManager = ProcManager.getInstance();
        List<Procedure> procedures;
        procedures = procManager.getProcedures();
        log.trace("list ==> " + procedures);
        req.getSession().setAttribute("listProc", procedures);
        log.debug("Command ends");
        return address;
    }
}
