package com.example.pro.Vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class listVo {

	private int bid;
	private String btitle;
	private String bcontent;
	private String bname;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bdate;
	private String bupload;
	private int bhit;
	
	
	
}
