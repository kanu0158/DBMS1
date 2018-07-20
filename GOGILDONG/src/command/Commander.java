package command;

import javax.servlet.http.HttpServletRequest;

import enums.Action;


public class Commander {
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		case JOIN:
			cmd = new CreateCommand(request);
			break;
		case LIST:
			cmd = new ListCommand(request);
			break;
		case SEARCH:
			cmd = new SearchCommand(request);
			break;
		}
		return cmd;
	}
}