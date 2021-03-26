package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Board;
import com.example.mapper.BoardMapper;
import com.example.paging.Pagination;

@Service("boardService")
public class BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	public List<Board> allBoard() {
		
		return mapper.allBoard();
		
	}
	
	public List<Board> allBoard(Pagination pagination) {
		return mapper.allBoard(pagination);
	}
	
	public int tableCount() {
		
		return mapper.tableCount();
		
	}
	
	public void create() {
		
			new Board();
			Board board = Board.builder()
			.title("test")
			.content("test")
			.writer("test")
			.build();
			
			mapper.create(board);
	}
	
	public Board read(String bno) {
		return mapper.read(bno);
	}
	
	public void update(Board board) {
		mapper.update(board);
	}
	
	public void delete(String bno) {
		mapper.delete(bno);
	}
	
}
