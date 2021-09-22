package com.example.pro.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pro.Mapper.Mmapper;
import com.example.pro.Vo.listVo;

@Service
public class MServiceImpl implements MService{

	@Autowired
	Mmapper mmapper;

	
	//게시판 화면
	@Override
	public Map<String, Object> BoardList() {

		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<listVo> list = new ArrayList<listVo>();
		
		list = mmapper.BoardList();
		
		map.put("list", list);
		
		return map;
	}

	//게시판 뷰
	//조회수 증가
	@Override
	public Map<String, Object> BoardListView(String bid) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		mmapper.BoardListhit(bid);
		listVo listVo = new listVo();
		System.out.println(listVo.getBname());
		int result = 0;
		System.out.println(result);
		System.out.println("조회수");
		System.out.println(listVo.getBhit());
		
		listVo = mmapper.BoardListView(bid);


		map.put("listVo", listVo);
		
		return map;
	}

	//화면 글쓰기 저장
	@Override
	public void BoardListWrite(listVo listVo) {

		
		 mmapper.BoardListWrite(listVo);
		
		return;
	}

	//수정 페이지 이동
	@Override
	public Map<String, Object> BoardListModify(String bid) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		listVo listVo = new listVo();
		
		listVo = mmapper.BoardListModify(bid);


		map.put("listVo", listVo);
		
		
		return map;
	}

	//수정페이지 등록
	@Override
	public void BoardListmModifyCheck(listVo listVo) {
		
		mmapper.BoardListmModifyCheck(listVo);
			
		return;
	}

	//게시물 삭제
	@Override
	public int BoardListdelete(listVo listVo) {

		int result = 0;
		
		result = mmapper.BoardListdelete(listVo);
		
		return result;
	}

	//답글 페이지 이동
	@Override
	public Map<String, Object> BoardListReply(listVo listVo) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		
		listVo = mmapper.BoardListReply(listVo);

		map.put("listVo", listVo);
		
		return map;
	}

	@Override
	public Map<String, Object> BoardListReply_Check(listVo listVo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
