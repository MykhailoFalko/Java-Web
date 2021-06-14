package com.example.FinalProject.web.command;

import com.example.FinalProject.db.DBException;
import com.example.FinalProject.db.SlotManager;
import com.example.FinalProject.db.entity.Slot;
import com.example.FinalProject.db.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.Time;


public class TakeSlotCommand implements Command{
    private static final Logger log= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        log.debug("Command starts");
        String address = "userInfo.jsp";
        Date date =Date.valueOf(req.getParameter("date"));
        log.trace("date ==> " + date);
        Time time = Time.valueOf(req.getParameter("time"));
        log.trace("time ==> " + time);
        SlotManager slotManager = SlotManager.getInstance();
        User client=(User) req.getSession().getAttribute("loggedUser");
        Slot slot=new Slot(date,time,Integer.parseInt( req.getParameter("service")),client.getId(),Integer.parseInt( req.getParameter("worker")),0);
        log.trace("slot ==> " + slot);
        slotManager.setSlot(slot);
        log.debug("Command ends");
        return address;
    }
}
