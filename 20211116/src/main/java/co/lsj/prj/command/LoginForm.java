package co.lsj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.lsj.prj.comm.Command;

public class LoginForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 단순 폼 호출
		return "member/loginForm";
	}

}
