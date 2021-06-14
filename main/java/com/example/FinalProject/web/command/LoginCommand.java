package com.example.FinalProject.web.command;

import com.example.FinalProject.db.*;
import com.example.FinalProject.db.entity.Procedure;
import com.example.FinalProject.db.entity.Slot;
import com.example.FinalProject.db.entity.User;
import com.example.FinalProject.db.entity.Worker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand implements Command {
	private static final Logger log= LogManager.getLogger();

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
		log.debug("Command starts");
		String address = "login.jsp"; 
		
		String login = req.getParameter("login");
		log.trace("login ==> " + login);

		String password = req.getParameter("password");
		
		UserManager userManager = UserManager.getInstance();
		User user = userManager.getUser(login);

		log.trace("user ==> " + user);
		
		if (user != null && user.getPassword().equals(password)) {
			if(user.getRole().equals("admin")){
				address = "admininfo.jsp";
				SlotManager slotManager=SlotManager.getInstance();
				List<Slot> slots=slotManager.getSlots();
				log.trace("list ==> " + slots);
				req.getSession().setAttribute("listSlot", slots);
			}
			if(user.getRole().equals("user")){
				address = "userInfo.jsp";
				List<Time> times = new ArrayList<>();
				Time start=Time.valueOf("08:00:00");
				Time end=Time.valueOf("18:00:00");
				long dif = start.getTime();
				while (dif < end.getTime()) {
					Time slot = new Time(dif);
					dif +=3600000;
					times.add(slot);
				}
				req.getSession().setAttribute("listTime", times);
			}
			if(user.getRole().equals("worker")){
				address = "workerInfo.jsp";
				SlotManager slotManager=SlotManager.getInstance();
				List<Slot> slots=slotManager.getSlotsByWorker(user.getId());
				log.trace("list ==> " + slots);
				req.getSession().setAttribute("listSlot", slots);
			}
			req.getSession().setAttribute("loggedUser", user);
		}
		WorkerManager workerManager = WorkerManager.getInstance();
		List<Worker> list;
		list = workerManager.getWorkers();
		log.trace("list ==> " + list);
		req.getSession().setAttribute("listSpec", list);

		ProcManager procManager = ProcManager.getInstance();
		List<Procedure> procedures;
		procedures = procManager.getProcedures();
		log.trace("list ==> " + procedures);
		req.getSession().setAttribute("listProc", procedures);


		log.debug("Command ends");
		return address;
	}

}
