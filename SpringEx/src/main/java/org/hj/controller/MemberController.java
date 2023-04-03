
package org.hj.controller;

import javax.servlet.http.HttpSession;

import org.hj.model.LoginVO;
import org.hj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // ctrl + shift + O 


@Controller
public class MemberController {

	@Autowired
	LoginService ls; // LoginService ls = new LoginService(); // 클래스를 객체화!       참조클래스(인터페이스 타입임에도 불구하고 new 할 수 있게 스프링이 해줌) 참조변수 
	
	// 회원가입 화면 실행
	@RequestMapping(value = "/member", method = RequestMethod.GET)	// 화면실행을 위한 member -> 값이 같아도 메소드방식이 다르기 때문에 가능!
	public String member () {	// 실행할 메소드를 호출
		return "member/memberin";	// 리턴한 값이 서버 URL로 가게되면서 memberin.jsp를 실행하게 됨 
	}
	
	// 회원가입서버 (가입하기 버튼 클릭시 발동!  / insert - DB연결 필요해서 Service도 필요)
	@RequestMapping(value = "/member", method = RequestMethod.POST) // 가입을 위한 member -> 값이 같아도 메소드방식이 다르기 때문에 가능! (value랑 method 둘 다 동일하면 문제 발생. 서버가 혼란해서 실행 안됨. 무조건 하나는 구분할 수 있게 해야함)
	//							int   a
	//							(주소를 저장하는)클래스타입.참조타입  참조변수
	public String memberPost (LoginVO member) { //memberPost메소드 호출 	//LoginVO <= Model (모델은 필수가 아님.[org.hj.model -> LoginVO.java에서 확인가능! 필드에 접근제어자도 있고, 필드도 일치하고]
//public String memberPost (String id, String password, String name){	// 자바처럼 가능하지만 비효율적(메모리 소모 큼 & 매개변수 내 접근제어자도 쓸수 없어서 데이터 안전성 확보 불가!) 자동으로 데이터를 수집해줘서 request.getParameter안해도 됨	
//								String은 참조타입(메모리 더 효율) , 기본타입은 다 8바이트
		System.out.println(member);										
		//System.out.println(member.toString()); toString()이 생략되어있음. // 메소드 호출부
		ls.memreg(member);	//참조변수ls로 LoginService(인터페이스)의 memreg메서드를 호출 // member라는 데이터를(매개변수를 통해 실어서) MemberController에서 Login Service로 넘겨주려고!!!!
		return "board/list";
	}
	
	
	
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login () {
		System.out.println("aaaa");
		return "member/login"; // 로그인화면을 띄움
	}
	
	// 로그인 서버
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost (HttpSession session, LoginVO member) {
		//HttpSession session = new HttpSession();
/*		System.out.println("controller="+member);
		System.out.println(ls.login(member));*/
		
		
		if (ls.login(member)==null) {
			return "member/login";	// DB에 없어서 null값이면  (null == null) true -> 회원이 아니면 로그인페이지로 가도록
			} else {	
				session.setAttribute("login", ls.login(member)); // DB에서 끌고온 LoginVO 데이터를 login 변수에 저장하고 이를 세션에 최종저장 
				return "redirect:/list";	// 리스트로 가도록(지금은 list없어서 오류나는것.)
			}
		
		
		}
	// 4교시 실습
	// 회원관리페이지(관리자용)
	/*@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String memberlist() { // 1. 메소드 선언
		ls.memlist();			// 3. 로그인서비스로 가서 멤버리스트(memlist)만들어주면 됨
		return "member/list";	// 2. member폴더에 list.jsp를 실행하라(폴더에 만들어주면됨)
	}*/
	// 회원관리페이지(관리자용)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String memberlist(Model model) { // 여기서 Model은 객체임!! (MVC의 모델이 아님) 컨트롤러에 있는 데이터를 jsp로 보내주기 위해 사용하는 객체임!!!!
		model.addAttribute("memlist", ls.memlist());
		return "member/list";	// 스프링이     /WEB-INF/views/member/list.jsp 이렇게 최종경로를 인식하고 list.jsp를 실행하게 되는 원리임.(spring 폴더에 appServlet -> servlet-context.xml) // 자바는 호출한 곳으로 값을 리턴.
	}
	
	
	// 3월 30일(목요일) 실습 풀이
	// 회원 상세 내용 페이지(관리자용)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	//public String memberDetail(String id) {
	public String memberDetail(LoginVO login, Model model) {
		//ls.memdetail(id); 	// ls(로그인)서비스를 이용하겠다! / 에러-로그인서비스에 있는 memdetail()메소드와 일치하지 않으면 발생하니 맞춰주는 작업 필요 // 결론=> memdetail()선언된 게 없어서 에러발생하니까 가서 만들어주면 됨
	  //ls.memdetail(String id);XXXXX
		model.addAttribute("detail", ls.memdetail(login));
		//ls.memdetail(login);
		return "member/detail";	// /WEB-INF/views/member/detail.jsp
	}
	
	// 브라우저에서 사용자가 선택한 아이디를 어떻게 컨트롤러로 가져오느냐? -> 방법 두 가지 (form태그로 혹은 a태그로)
	// 방법1. <form action="detail">
	// 		아이디<input type="text" name="id" >
	//		</form>
	
	// 방법2. <a href="detail?id=아이디값">아이디</a>
	
	// 참고) button태그 submit구현은 자바스크립트로!
	// --------------------------------------------------------
	
	// 1)매개변수 통해서 데이터 주기 - (매개변수)로 넘겨줌 (사진 있음)
	//    -> 데이터를 저장할 공간이 매개변수! url주소 뒤에 ?선택한 아이디 오도록 => 선택된 아이디를 매개변수에 저장!
	// 2) LoginVO - 접근제한자 있어서 더 좋음
	
	
	// --------------------------------------------------------
	// 회원정보 수정 
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	//public String memberModify(String name, String id, String password, String phone) { -- 폼태그-input태그의 name속성의 값이 일치하면 스프링은 자동 수집해줌. 이와 같은 방법도 가능은 하나, 메모리 소모8*4=32바이트 소모(비효율) /LoginVO는 8바이트만 소모, private 데이터 보호도 가능
		public String memberModify(LoginVO login, RedirectAttributes rttr) { // RedirectAttributes import 필요!
		ls.memberModify(login);
		rttr.addAttribute("id", login.getId());
		return "redirect:/detail"; // 수정 후 어떤 화면으로 이동
	}
	
	/*  수정 후 리스트로 이동
	 * @RequestMapping(value = "/modify", method = RequestMethod.POST) { -- 폼태그-input태그의 name속성의 값이 일치하면 스프링은 자동 수집해줌. 이와 같은 방법도 가능은 하나, 메모리 소모8*4=32바이트 소모(비효율) /LoginVO는 8바이트만 소모, private 데이터 보호도 가능
	public String memberModify(LoginVO login) { // RedirectAttributes import 필요!
		ls.memberModify(login);
		return "redirect:/list"; // 수정 후 어떤 화면으로 이동
	}*/
	
	
	
	
	
	// 회원정보 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String memberRemove(LoginVO login) {
		ls.memberRemove(login);
		return "redirect:/list"; // select하지 않아서 리다이렉트함?
	}
	
	
	
	
	
	
}
