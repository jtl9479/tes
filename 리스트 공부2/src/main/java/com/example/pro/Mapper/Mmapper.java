package com.example.pro.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.pro.Vo.listVo;

@Mapper
public interface Mmapper {

	//게시판 
	ArrayList<listVo> BoardList();

	//게시판 뷰
	listVo BoardListView(String bid);
	//조회수
	void BoardListhit(String bid);
	//게시판 글쓰기 저장
	void BoardListWrite(listVo listVo);

	//리스트 수정페이지이동
	listVo BoardListModify(String bid);
	
	//리스트 수정페이지등록
	void BoardListmModifyCheck(listVo listVo);

	//리스트 삭제
	int BoardListdelete(listVo listVo);

	//답변 페이지 이동
	listVo BoardListReply(listVo listVo);




}
