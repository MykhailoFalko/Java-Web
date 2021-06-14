package com.example.FinalProject.db;

import com.example.FinalProject.db.entity.Procedure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProcManager {
    private DBManager dbManager;

    ////////////////////////////////

    private static ProcManager instance;

    private static final Logger log= LogManager.getLogger();

    public static synchronized ProcManager getInstance() {
        if (instance == null) {
            instance = new ProcManager();
        }
        return instance;
    }

    private ProcManager() {
        dbManager = DBManager.getInstance();
    }

    ////////////////////////////////

    public Procedure getProcedure(String name) throws DBException {
        Procedure procedure = null;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            procedure = dbManager.getProcedure(con, name);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getProcedure", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getProcedure", ex);
        } finally {
            dbManager.close(con);
        }
        return procedure;
    }
    public List<Procedure> getProcedures() throws DBException {
        List <Procedure> list;
        Connection con = null;
        try {
            con = dbManager.getConnection();
            list = dbManager.getProcedures(con);
            con.commit();
        } catch (SQLException ex) {
            log.error("cannot do getProcedures", ex);

            dbManager.rollback(con);

            throw new DBException("Cannot do getProcedures", ex);
        } finally {
            dbManager.close(con);
        }
        return list ;
    }


    /////////////////////////////////////
}
