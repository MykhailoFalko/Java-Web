package com.example.FinalProject.web.command;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
	
	private static final Map<String, Command> commands;
	
	static {
		commands = new HashMap<>();
		commands.put("login", new LoginCommand());
		commands.put("listSpec", new ListSpecCommand());
		commands.put("listProc", new ListProcCommand());
		commands.put("makeOrderByName", new MakeOrderByNameCommand());
		commands.put("makeOrderByRate", new MakeOrderByRateCommand());
		commands.put("findWorkerByName", new FindWorkerByNameCommand());
		commands.put("findProcByName", new FindProcByName());
		commands.put("takeSlot", new TakeSlotCommand());
		commands.put("register", new RegisterCommand());
		commands.put("updateSlot", new UpdateSlotCommand());
	}

	public static Command getCommand(String commandName) {
		return commands.get(commandName);
	}
	
	

}
