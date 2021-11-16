package co.lsj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.lsj.prj.comm.Command;
import co.lsj.prj.member.service.MemberService;
import co.lsj.prj.member.serviceImpl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//멤버 목록
		MemberService memberDao = new MemberServiceImpl();
		request.setAttribute("members", memberDao.memberSelectList());
		
		return "member/memberList";
	}

}
