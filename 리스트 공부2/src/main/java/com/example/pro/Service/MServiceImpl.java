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
	@Override
	public Map<String, Object> BoardListView(String bid) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		listVo listVo = new listVo();
		
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

	
}
