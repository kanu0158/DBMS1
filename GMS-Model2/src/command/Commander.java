package command;

import enums.MemberAction;

//invoker 명령처리해주는 명령처리자
public class Commander {
	public static Command order(
			String domain,String action,String page) {
		Command cmd = null;
		switch (MemberAction.valueOf(action.toUpperCase())) {
		case MOVE:
			System.out.println("커맨더 무브진입");
			cmd = new MoveCommand(domain,action,page);
			break;
		case JOIN:
			System.out.println("커맨더 조인진입");
			cmd = new CreateCommand(domain, action, page);
			break;
		case LIST:
			System.out.println("커맨더 리스트진입");
			cmd = new ListCommand(domain, action, page);
			break;
		case RETRIEVE:
			System.out.println("커맨더 리트리브진입");
			cmd = new RetrieveCommand(domain, action, page);
			break;
		case SEARCH:
			System.out.println("커맨더 SEARCH진입");
			cmd = new SelectCommand(domain, action, page);
			break;
		case UPDATE:
			System.out.println("커맨더 UPDATE진입");
			cmd = new UpdateCommand(domain, action, page);
			break;
		case DELETE:
			System.out.println("커맨더 DELETE진입");
			cmd = new DeleteCommand(domain, action, page);
			break;	
		case LOGIN:
			System.out.println("커맨더 LOGIN진입");
			cmd = new LoginCommand(domain, action, page);
			break;		
		case COUNT:
			System.out.println("커맨더 COUNT진입");
			cmd = new CountCommand(domain, action, page);
			break;		
		}
		return cmd;
	}
}
