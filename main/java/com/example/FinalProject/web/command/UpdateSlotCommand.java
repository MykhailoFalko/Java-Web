package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBException;
import com.example.FinalProject.db.SlotManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UpdateSlotCommand implements Command {
    private static final Logger log= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("Command starts");
        String address = "workerInfo.jsp";
        SlotManager slotManager = SlotManager.getInstance();
        int id =Integer.parseInt( req.getParameter("id"));
        log.trace("id ==> " + id);
        slotManager.updateSlot(id);
        log.debug("Command ends");
        return address;
    }
}
