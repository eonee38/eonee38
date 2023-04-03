package org.hj.service; //패키지는 해당 파일이 어디에 있는지를 알려주는 역할

//import org.hj.mapper.ArrayList;
import org.hj.model.LoginVO;
import java.util.ArrayList; // ★

public interface LoginService {// memreg추상메서드 (설계)
	
	public void memreg(LoginVO member); //memreg메소드
	public LoginVO login(LoginVO member); // login메소드
	//public void memlist(); // DB로 던져줄것 없으니 매개변수 없이!
	public ArrayList<LoginVO> memlist();   // import까지 해줘야함
	
	//service 단계에서 if문 가공 등을 하고 SQL로 넘겨줌(mapper)
	
	
	// 3월 30일(목요일) 실습 풀이
	//public void memdetail(String id);// 리턴타입이 뭔지 잘 모르겠으면 일단 void로 하고 나중에 바꿔주면 됨(리턴타입은 무조건 있어야 함. 리턴으로 연결하니까)
	public LoginVO memdetail(LoginVO login);
	// memdetail 설계 끝. 무조건 클래스로 구현해내야함(설계만 하는 것은 없음)
	
	
	// 회원정보 수정
	public void memberModify(LoginVO login);
	
	
	//회원 정보 삭제
	public void memberRemove(LoginVO login);
	
}
