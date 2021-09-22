package com.example.pro.Service;

import java.util.Map;

import com.example.pro.Vo.listVo;

public interface MService {

	//리스트 화면 
	Map<String, Object> BoardList();

	//리스트 뷰
	Map<String, Object> BoardListView(String bid);

	//리스트 글쓰기 저장
	void BoardListWrite(listVo listVo);

	//리스트 수정 페이지 이동
	Map<String, Object> BoardListModify(String bid);

	//리스트 수정 페이지 등록
	void BoardListmModifyCheck(listVo listVo);

	//리스트 게시물 삭제
	int BoardListdelete(listVo listVo);

	//답글 페이지 이동
	Map<String, Object> BoardListReply(listVo listVo);

	//답글 등록
	Map<String, Object> BoardListReply_Check(listVo listVo);


}
