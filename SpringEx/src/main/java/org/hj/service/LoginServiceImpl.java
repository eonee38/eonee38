package org.hj.service;

//import org.hj.mapper.ArrayList;
import org.hj.mapper.LoginMapper;
import org.hj.model.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList; // ★

@Service
public class LoginServiceImpl implements LoginService { // 인터페이스(설계하는 것)를 참고해서 구현하겠다.
	
	@Autowired
	LoginMapper lm; // lm 참조변수
	
	public void memreg(LoginVO member) { // memreg메서드선언(구현)
		lm.memreg(member); 
	};
	
	public LoginVO login (LoginVO member) {
		System.out.println("service="+member);
		System.out.println("service return="+lm.login(member));
		return lm.login(member);
	}
	
	//public void memlist() {
		//lm.memlist(); // coding1
	//}
	
	public ArrayList<LoginVO> memlist(){
		return lm.memlist();  // import까지 해줘야함
	}
	
	// "public class LoginServiceImpl implements LoginService {" => (상단에)로그인 서비스를 참고해서 구현하겠다.
	// 3월 30일(목요일) 실습 풀이
	//public void memdetail(String id) {
		public LoginVO memdetail(LoginVO login) {
		// mapper 포함시켜주기!(DB와 연결?)
		//lm.memdetail(id); // The method memdetail() is undefined for the type LoginMapper => 맵퍼로 가서 만들거나, 맞춰주기
			return lm.memdetail(login);
		}
	
		// 회원정보 수정
		public void memberModify(LoginVO login) {
			lm.memberModify(login);
			
		}
		
		//회원 정보 삭제
		public void memberRemove(LoginVO login) {
			lm.memberRemove(login);
			
		}
	
	
	
	
	
	
	
}
