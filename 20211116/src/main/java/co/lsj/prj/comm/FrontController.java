package co.lsj.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.lsj.prj.command.HomeCommand;
import co.lsj.prj.command.LoginCommand;
import co.lsj.prj.command.LoginForm;
import co.lsj.prj.command.Logout;
import co.lsj.prj.command.MemberList;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();   
    public FrontController() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		//초기값 설정(ex: "/login.do", new LoginCommand()) key:value형식
		map.put("/home.do", new HomeCommand());  //홈 페이지를 보여주는 Command
		map.put("/login.do", new LoginCommand()); //로그인 처리
		map.put("/memberList.do", new MemberList()); //멤버 목록 보기
		map.put("/loginForm.do", new LoginForm()); //로그인 폼 호출
		map.put("/logout.do", new Logout()); //로그아웃 처리
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청을 분석하고 처리하는 부분
		request.setCharacterEncoding("UTF-8"); //한글 깨짐 방지
		String uri = request.getRequestURI(); //URI를 구한다
		String contextPath = request.getContextPath(); //contextPath 구함
		String page = uri.substring(contextPath.length());  //실제 요청
		
		//System.out.println(request.getRemoteAddr()+"======");
		
		Command command = map.get(page); //요청에 대한 command를 찾음
		String viewPage = command.run(request, response);
		
		//WEB-INF에 접근할 수 있도록 viewResolve를 만듬
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		//(ex: A->B->C 일때 jsp:forward, response.sendRedirect는 핸드폰(A의 request객체) 안실어보내고 그냥 갔다오라함,  requestDispatcher는 실어보냄)
		//응답을 처리한다. 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
