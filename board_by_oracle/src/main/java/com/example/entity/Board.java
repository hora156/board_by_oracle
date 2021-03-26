package com.example.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	
	private int bno;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private Date regDate;
	
	private int viewCnt;
	
}
