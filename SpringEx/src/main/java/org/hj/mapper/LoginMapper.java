package org.hj.mapper;

import java.util.ArrayList; 

import org.hj.model.LoginVO;
			// implements가 없음!?
public interface LoginMapper {	// memreg추상메서드(설계)
	public void memreg(LoginVO member);
	public LoginVO login(LoginVO member);
	// 한 건만 저장 가능//public void memlist(); // coding2
	public ArrayList<LoginVO> memlist(); // import까지 해줘야함
	//LoginVo 타입을 배열에다 저장
	
	// 3월 30일(목요일) 실습 풀이
	//public void memdetail(String id); // 리턴타입 모르겠으면 일단 void로 하고 나중에 바꿔줘도 됨
	public LoginVO memdetail(LoginVO login);
	
	// 회원정보 수정
	public void memberModify(LoginVO login);
	
	//회원 정보 삭제
	public void memberRemove(LoginVO login);
}
