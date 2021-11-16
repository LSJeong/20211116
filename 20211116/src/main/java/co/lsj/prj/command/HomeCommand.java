package co.lsj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.lsj.prj.comm.Command;

public class HomeCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 처음 접근했을때 돌려주는 페이지
		return "home/home";
	}

}
