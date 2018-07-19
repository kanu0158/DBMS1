package command;

import javax.servlet.http.HttpServletRequest;

import enums.MemberAction;

//invoker 명령처리해주는 명령처리자
public class Commander {
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch (MemberAction.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			System.out.println("3.커맨더 무브진입");
			cmd = new MoveCommand(request);
			break;
		case JOIN:
			System.out.println("3.커맨더 조인진입");
			cmd = new CreateCommand(request);
			break;
		case LIST:
			System.out.println("3.커맨더 리스트진입");
			cmd = new ListCommand(request);
			break;
		case RETRIEVE:
			System.out.println("3.커맨더 리트리브진입");
			cmd = new RetrieveCommand(request);
			break;
		case SEARCH:
			System.out.println("3.커맨더 SEARCH진입");
			cmd = new SelectCommand(request);
			break;
		case UPDATE:
			System.out.println("3.커맨더 UPDATE진입");
			cmd = new UpdateCommand(request);
			break;
		case DELETE:
			System.out.println("3.커맨더 DELETE진입");
			cmd = new DeleteCommand(request);
			break;	
		case LOGIN:
			System.out.println("3.커맨더 LOGIN진입");
			cmd = new LoginCommand(request);
			break;		
		case COUNT:
			System.out.println("3.커맨더 COUNT진입");
			cmd = new CountCommand(request);
			break;		
		}
		return cmd;
	}
}
