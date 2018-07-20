package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/member.do")
public class MemberController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request);
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			Carrier.forward(request, response);
			break;
		case JOIN:
			Carrier.forward(request, response);
			break;
		case LIST:
			Carrier.forward(request, response);
			break;
		case SEARCH:
			Carrier.forward(request, response);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
