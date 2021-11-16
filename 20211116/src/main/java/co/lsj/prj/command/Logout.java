package co.lsj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.lsj.prj.comm.Command;

public class Logout implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 처리
		HttpSession session = request.getSession();
		session.invalidate(); //서버가 가지고 있는 세션객체 자체를 삭제함.
		return "home.do";
	}

}
