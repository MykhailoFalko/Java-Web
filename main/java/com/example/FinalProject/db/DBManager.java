package com.example.FinalProject.db;

import com.example.FinalProject.db.entity.Procedure;
import com.example.FinalProject.db.entity.Slot;
import com.example.FinalProject.db.entity.User;
import com.example.FinalProject.db.entity.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {

    private static final String FIND_USER_BY_LOGIN =
            "SELECT * FROM final.users WHERE login=?";
    private static final String FIND_All_USERS_BY_ROLE =
            "SELECT * FROM final.users WHERE role=?";
    private static final String FIND_WORKERS =
            "SELECT * FROM final.masters";
    private static final String FIND_WORKERS_ORDER_BY_NAME =
            "SELECT * FROM final.masters order by mastername";
    private static final String FIND_WORKERS_ORDER_BY_RATE =
            "SELECT * FROM final.masters order by rate";
    private static final String FIND_WORKER_BY_NAME =
            "SELECT * FROM final.masters WHERE mastername=?";
    private static final String FIND_PROCEDURE_BY_NAME =
            "SELECT * FROM final.services WHERE name=?";
    private static final String FIND_ALL_PROCEDURES =
            "SELECT * FROM final.services";
    private static final String INSERT_SLOT =
            "INSERT INTO final.attendance ( date, time, services_service_id, clients_user_user_id, masters_user_user_id) VALUES(?,?,?,?,?)";
    private static final String INSERT_USER =
            "INSERT INTO final.users ( login, password, role) VALUES(?,?,?)";
    private static final String INSERT_CLIENT =
            "INSERT INTO final.clients ( user_user_id, email) VALUES(?,?)";
    private static final String FIND_SLOTS =
            "SELECT * FROM final.attendance";
    private static final String FIND_SLOTS_BY_WORKER =
            "SELECT * FROM final.attendance WHERE masters_user_user_id=?";
    private static final String UPDATE_SLOT =
            "Update final.attendance SET isDone = 1 Where id = ?";

    private DataSource ds;


    /////////////////////////////////

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            ds = (DataSource)envContext.lookup("jdbc/final");
        } catch (NamingException ex) {
            throw new IllegalStateException("Cannot init DBManager");
        }
    }

    /////////////////////////////////

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public User getUser(Connection con, String login) throws SQLException {
        User user = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } finally {
            close(rs);
            close(pstmt);
        }
        return user;
    }

    public List<Procedure> getProcedures(Connection con) throws SQLException {
        List <Procedure> list=new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        Procedure procedure = null;
        try {
            stmt= con.createStatement();
            rs = stmt.executeQuery(FIND_ALL_PROCEDURES);
            while (rs.next()) {
                procedure = extractProcedure(rs);
                list.add(procedure);
            }
        } finally {
            close(rs);
            close(stmt);
        }
        return list;
    }

    public Procedure getProcedure(Connection con, String name) throws SQLException {
        Procedure procedure = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(FIND_PROCEDURE_BY_NAME);
            pstmt.setString(1, name);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                procedure = extractProcedure(rs);
            }
        } finally {
            close(rs);
            close(pstmt);
        }
        return procedure;
    }

    public List<User> getUsersByRole(Connection con, String role) throws SQLException {
        List <User> list=new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            pstmt = con.prepareStatement(FIND_All_USERS_BY_ROLE);
            pstmt.setString(1, role);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = extractUser(rs);
                list.add(user);
            }
        } finally {
            close(rs);
            close(pstmt);
        }
        return list;
    }

    public List<Worker> getWorkers(Connection con) throws SQLException {
        List <Worker> list=new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        Worker worker = null;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(FIND_WORKERS);
            while (rs.next()) {
                worker = extractWorker(rs);
                list.add(worker);
            }
        } finally {
            close(rs);
            close(statement);
        }
        return list;
    }

    public List<Worker> getWorkersByName(Connection con) throws SQLException {
        List <Worker> list=new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        Worker worker = null;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(FIND_WORKERS_ORDER_BY_NAME);
            while (rs.next()) {
                worker = extractWorker(rs);
                list.add(worker);
            }
        } finally {
            close(rs);
            close(statement);
        }
        return list;
    }

    public List<Worker> getWorkersByRate(Connection con) throws SQLException {
        List <Worker> list=new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        Worker worker = null;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(FIND_WORKERS_ORDER_BY_RATE);
            while (rs.next()) {
                worker = extractWorker(rs);
                list.add(worker);
            }
        } finally {
            close(rs);
            close(statement);
        }
        return list;
    }

    public Worker getWorker(Connection con, String name) throws SQLException {
        Worker worker = null;

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(FIND_WORKER_BY_NAME);
            pstmt.setString(1, name);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                worker = extractWorker(rs);
            }
        } finally {
            close(rs);
            close(pstmt);
        }
        return worker;
    }
    public void setUser(Connection con, User user,String email) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(INSERT_USER,Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            pstmt.setString(k++, user.getLogin());
            pstmt.setString(k++, user.getPassword());
            pstmt.setObject(k, user.getRole());
            pstmt.executeUpdate();
            ResultSet rs=pstmt.getGeneratedKeys();
            int id=0;
            if(rs.next()){
                id=rs.getInt(1);
            }
            setClient(con,id,email);
        } finally {
            close(pstmt);
        }
    }
    private void setClient(Connection con, int id,String email) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(INSERT_CLIENT);
            int k = 1;
            pstmt.setInt(k++, id);
            pstmt.setString(k, email);
            pstmt.executeUpdate();

        } finally {
            close(pstmt);
        }
    }
    public void setSlot(Connection con, Slot slot) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(INSERT_SLOT);
            int k = 1;
            pstmt.setDate(k++, slot.getDate());
            pstmt.setTime(k++, slot.getTime());
            pstmt.setInt(k++, slot.getServiceId());
            pstmt.setInt(k++, slot.getClientId());
            pstmt.setInt(k, slot.getWorkerId());
            pstmt.executeUpdate();
        } finally {
            close(pstmt);
        }
    }
    public List<Slot> getSlots(Connection con) throws SQLException {
        List <Slot> list=new ArrayList<>();
        Statement statement = null;
        ResultSet rs = null;
        Slot slot = null;
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(FIND_SLOTS);
            while (rs.next()) {
                slot = extractSlot(rs);
                list.add(slot);
            }
        } finally {
            close(rs);
            close(statement);
        }
        return list;
    }

    public List<Slot> getSlotsByWorker(Connection con,int id) throws SQLException {
        List <Slot> list=new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Slot slot;
        try {
            preparedStatement = con.prepareStatement(FIND_SLOTS_BY_WORKER);
            preparedStatement.setInt(1,id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                slot = extractSlot(rs);
                list.add(slot);
            }
        } finally {
            close(rs);
            close(preparedStatement);
        }
        return list;
    }

    public void updateSlot(Connection con, int id) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(UPDATE_SLOT);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            close(pstmt);
        }
    }

    public void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }
    private Procedure extractProcedure(ResultSet rs) throws SQLException {
        Procedure procedure = new Procedure();
        procedure.setId(rs.getInt("service_id"));
        procedure.setName(rs.getString("name"));
        procedure.setPrice(rs.getInt("price"));
        return procedure;
    }
    private Worker extractWorker(ResultSet rs) throws SQLException {
        Worker worker = new Worker();
        worker.setId(rs.getInt("user_user_id"));
        worker.setName(rs.getString("mastername"));
        worker.setRate(rs.getInt("rate"));
        return worker;
    }
    private Slot extractSlot(ResultSet rs) throws SQLException {
        Slot slot = new Slot();
        slot.setId(rs.getInt("id"));
        slot.setDate(rs.getDate("date"));
        slot.setTime(rs.getTime("time"));
        slot.setServiceId(rs.getInt("services_service_id"));
        slot.setClientId(rs.getInt("clients_user_user_id"));
        slot.setWorkerId(rs.getInt("masters_user_user_id"));
        slot.setIsDone(rs.getInt("isDone"));
        return slot;
    }
}