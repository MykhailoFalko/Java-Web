package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBException;
import com.example.FinalProject.db.ProcManager;
import com.example.FinalProject.db.entity.Procedure;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FindProcByName implements Command {
    private static final Logger log= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("Command starts");
        String address = "procedures.jsp";
        String name = req.getParameter("name");
        log.trace("name ==> " + name);
        ProcManager procManager = ProcManager.getInstance();
        List<Procedure> list= new ArrayList<>();
        list.add( procManager.getProcedure(name));
        log.trace("list ==> " + list);
        req.getSession().setAttribute("listProc", list);
        log.debug("Command ends");
        return address;
    }
}
