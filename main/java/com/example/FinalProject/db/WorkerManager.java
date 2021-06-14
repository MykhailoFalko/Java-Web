package com.example.FinalProject.db;

import com.example.FinalProject.db.entity.User;
import com.example.FinalProject.db.entity.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class WorkerManager {
    private DBManager dbManager;

    ////////////////////////////////

    private static WorkerManager instance;

    private static final Logger log= LogManager.getLogger();

    public static synchronized WorkerManager getInstance() {
        if (instance == null) {
            instance = new WorkerManager();
        }
        return instance;
    }

    private WorkerManager() {
        dbManager = DBManager.getInstance();
    }

    ////////////////////////////////

    public Worker getWorker(String name) throws DBException {
        Worker worker = null;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            worker = dbManager.getWorker(con, name);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getWorker", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getWorker", ex);
        } finally {
            dbManager.close(con);
        }
        return worker;
    }
    public List<Worker> getWorkers() throws DBException {
        List <Worker> list;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            list = dbManager.getWorkers(con);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getWorkers", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getWorkers", ex);
        } finally {
            dbManager.close(con);
        }
        return list ;
    }

    public List<Worker> getWorkersByName() throws DBException {
        List <Worker> list;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            list = dbManager.getWorkersByName(con);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getWorkersByName", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getWorkersByName", ex);
        } finally {
            dbManager.close(con);
        }
        return list ;
    }
    public List<Worker> getWorkersByRate() throws DBException {
        List <Worker> list;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            list = dbManager.getWorkersByRate(con);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getWorkersByRate", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getWorkersByRate", ex);
        } finally {
            dbManager.close(con);
        }
        return list ;
    }

}
