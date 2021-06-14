package com.example.FinalProject.db;

import com.example.FinalProject.db.entity.Slot;
import com.example.FinalProject.db.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SlotManager {
    private DBManager dbManager;

    ////////////////////////////////

    private static SlotManager instance;

    private static final Logger log= LogManager.getLogger();

    public static synchronized SlotManager getInstance() {
        if (instance == null) {
            instance = new SlotManager();
        }
        return instance;
    }

    private SlotManager() {
        dbManager = DBManager.getInstance();
    }

    ////////////////////////////////

    public void setSlot(Slot slot) throws DBException {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            dbManager.setSlot(con, slot);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do setSlot", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do setSlot", ex);
        } finally {
            dbManager.close(con);
        }
    }
    public List<Slot> getSlots() throws DBException {
        List <Slot> list;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            list = dbManager.getSlots(con);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getSlots", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getSlots", ex);
        } finally {
            dbManager.close(con);
        }
        return list ;
    }

    public void updateSlot(int id) throws DBException {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            dbManager.updateSlot(con, id);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do setSlot", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do setSlot", ex);
        } finally {
            dbManager.close(con);
        }
    }

    public List<Slot> getSlotsByWorker(int id) throws DBException {
        List <Slot> list;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            list = dbManager.getSlotsByWorker(con,id);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getSlotsByWorker", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getSlotsByWorker", ex);
        } finally {
            dbManager.close(con);
        }
        return list ;
    }
}

