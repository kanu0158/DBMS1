package command;

import javax.servlet.http.HttpServletRequest;

public class Command implements Order {
	protected HttpServletRequest request;
	protected String domain,action,page,view;
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public void execute() {
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}

}
