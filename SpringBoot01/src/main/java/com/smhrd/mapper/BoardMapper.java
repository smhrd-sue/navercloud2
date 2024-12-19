package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> list();
	
	public int write( Board board );
	
	public Board view( int idx );
	
	@Delete("""
			delete from Board 
			where idx = #{idx}
			""")
	public int delete( int idx );
	
	
	public List<Board> search( String text );
	
	
	public List<Board> chart();
	
	
	
	

}
