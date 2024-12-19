package com.smhrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;

import com.smhrd.entity.Board;
import com.smhrd.entity.Member;
import com.smhrd.mapper.MemberMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller // Spring에게 POJO임을 알려주기위한 어노테이션(필수)
public class MemberController {
	
	// xml, interface --> SqlSessionFactory --> DAO
	// MyBatis가 interface를 구현해서 서버 메모리에 등록시켜놓음
	@Autowired // 메모리에서 넣을 수 있는거 가져와서 넣어라
	private MemberMapper mapper;
	
	
	// Spring 
	// FrontController 기반
	// Servlet이 늘어날수록 서버 메모리 부하 증가 --> Servlet을 단 하나만 쓰자
	// 일반 Class에 "어떤 요청이 들어왔을 때, 무슨 일을 할지를 정의"
	// FrontController에서는 정의된 내용을 실행
	
	// Spring에서는 Servlet을 기본으로 제공, 클래스만 만들면 된다.
	// POJO(Plain Old Java Object)라고도 부른다.
	
	// "어떤 요청이 들어왔을 때, 무슨 일을 할지를 정의" --> 메소드
	@RequestMapping("/goMain") // goMain 요청이 들어오면 goMain()을 실행해라
	public String goMain() {
		// 1. 데이터 수집
		// 2. 기능 실행
		// 3. View 이동
		// forward 이동시, 이동하고싶은 "jsp파일의 이름"만 리턴하면된다.
		return "main";
	}
	
	
	@RequestMapping("/join")
	public String join( Member member ) {
		// 필요한 객체 생겼다! 
		// --> 매개변수에 변수를 선언해두면, Spring이 알아서 객체를 집어넣어줌
		
		// 1. 데이터 수집
		// 2. 기능 실행
		// >> DB에 회원정보 저장하기
		int cnt = mapper.join(member);
		
		if(cnt > 0) {
			System.out.println("회원가입 성공");
		}
		
		// 3. View 이동
		// redirect
		return "redirect:/goMain"; 
	}
	
	
	@RequestMapping("/login")
	public String login( Member member, HttpSession session ) {
		// 1. 데이터  수집
		// 2. 기능 실행
		Member result = mapper.login(member);
		
		if(result == null) {
			System.out.println("login f");
		}else {
			System.out.println("login t");
			session.setAttribute("user", result);
		}
		
		// 3. View 이동
		return "redirect:/goMain";
	}
	
	
	@RequestMapping("/goUpdate")
	public String goUpdate() {
		// 1. 데이터 수집
		// 2. 기능 실행
		// 3. View 이동
		return "update";
	}
	
	
	@RequestMapping("/update")
	public String update( Member member, HttpSession session ) {
		// 1. 데이터 수집
		Member user = (Member) session.getAttribute("user");
		String email = user.getEmail();
		
		member.setEmail(email);
		
		// 2. 기능 실행
		int cnt = mapper.update(member);
		
		if( cnt > 0 ) {
			System.out.println("update t");
			session.setAttribute("user", member);
		}else {
			System.out.println("update f");
		}
		
		// 3. View 이동
		return "redirect:/goMain";
	}
	
	
	@RequestMapping("/socket")
	public void socket() {}
	
	
	
	
	
	
	
	
	
	
	

}
