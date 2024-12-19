package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardMapper mapper;
	
	
	@RequestMapping("/search")
	public List<Board> search(String text) {
		// 1. 데이터 수집
		// 2. 기능 실행
		List<Board> list = mapper.search( "%" + text + "%" );
		
		// 3. 데이터 응답
		return list;
	}
	
	
	@RequestMapping("/chart")
	public List<Board> chart() {
		// 1. 데이터 수집
		// 2. 기능 실행
		List<Board> list = mapper.chart();
		
		// 3. 데이터 응답
		return list;
	}
	
	
	
	
	
	
	
	
	

}
