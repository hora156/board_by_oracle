package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Board;
import com.example.paging.Pagination;

@Mapper
public interface BoardMapper {
	
	// select * from tbl_board
	public List<Board> allBoard();
	
	// Paging
	public List<Board> allBoard(Pagination pagination);
	
	// count
	public int tableCount();
	
	public void create(Board board);
	
	public Board read(String bno);
	
	public void update(Board board);
	
	public void delete(String bno);
	
}
