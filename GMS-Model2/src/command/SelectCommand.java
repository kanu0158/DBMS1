package command;

public class SelectCommand extends Command{
	public SelectCommand(String domain,String action,String page) {
		setDomain(domain);
		setAction(action);
		setPage(page);
		execute();
	}
}
