package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Member;

@Mapper // 해당파일이 Mapper임을 명시
public interface MemberMapper {
	
	// 1. 연결
	// 기존 방식 --> 기능 실행시마다 Connection 생성 --> DB 부하가 커짐
	// >> DataBase Connection Pool (DataSource)
	//    미리 만들어두고, 빌려만 주자.
	
	// 2. 기능구현(MyBatis Framework)
	// java <--(mapping)--> xml
	// (실행코드)            (sql)
	// insert/delete/update >> int 리턴
	// sql문의 id == 메소드 이름
	public int join( Member member );
	
	
	public Member login( Member member );
	
	
	public int update( Member member );
	
	
	public Member check( String email );
	
	
	
	
	

}
