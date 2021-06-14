package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBException;
import com.example.FinalProject.db.WorkerManager;
import com.example.FinalProject.db.entity.Worker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FindWorkerByNameCommand implements Command{
    private static final Logger log= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("Command starts");
        String address = "specialists.jsp";
        String name = req.getParameter("name");
        log.trace("name ==> " + name);
        WorkerManager workerManager = WorkerManager.getInstance();
        List<Worker> list= new ArrayList<>();
        list.add( workerManager.getWorker(name));
        log.trace("list ==> " + list);
        req.getSession().setAttribute("listSpec", list);
        log.debug("Command ends");
        return address;
    }
}
