package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.EventBoardMapper;
import com.example.teamproject.Vo.EventBoardImgVo;
import com.example.teamproject.Vo.EventBoardVo;



@Service
public class EventBoardServiceImpl implements EventBoardService {
	@Autowired
	EventBoardMapper eventBoardMapper;
	
//	게시판 가져오기
	@Override
	public Map<String, Object> selectEventBoardList(String searchCategory, String sportsCategory, String searchWord,
			int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		int limit = 10;
		int numLimit = 10;
		int listCount = eventBoardMapper.selectEventBoardCount(searchCategory, sportsCategory, searchWord);
		int startPage = (((int) ((double) page / numLimit + 0.99)) - 1) * numLimit + 1;
		int endPage = startPage + numLimit - 1;
		int maxPage = ((int)((double) listCount / limit + 0.99));
		if (endPage > maxPage)
			endPage = maxPage;
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println("count" + listCount);
		System.out.println("startPage" + startPage);
		System.out.println("endPage" + endPage);
		System.out.println("maxPage" + maxPage);
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
		ArrayList<EventBoardVo> list = eventBoardMapper.selectEventBoardList(searchCategory, sportsCategory,
				searchWord, startRow, endRow);
		map.put("page", page);
		map.put("searchCategory", searchCategory);
		map.put("sportsCategory", sportsCategory);
		map.put("searchWord", searchWord);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("list", list);
		return map;
	}
	
//	게시글 쓰기
	@Override
	public void eventBoardInsert(EventBoardVo eventBoardVo, ArrayList<EventBoardImgVo> imgList) {
		eventBoardMapper.eventBoardInsert(eventBoardVo);
		int eb_num = eventBoardVo.getEb_num();
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				eventBoardMapper.eventBoardImgInsert(eb_num, fileName);
			}

		}
	}
//	게시글 가져오기
	@Override
	public Map<String, Object> selectEventView(int eb_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 게시글 조회수 1씩증가
		eventBoardMapper.updateEventBoardHit(eb_num);
		// 게시글 및 이미지 가져오기
		EventBoardVo eventBoardVo = eventBoardMapper.selectEventBoardView(eb_num);
		ArrayList<EventBoardImgVo> imgList = eventBoardMapper.selectEventBoardImg(eb_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}
		// 게시글 이전글 글번호 뽑아오기
		EventBoardVo nextView = eventBoardMapper.selectNextView(eb_num);
		// 게시글 다음글 글번호 뽑아오기
		EventBoardVo preView = eventBoardMapper.selectPreView(eb_num);
		map.put("eventBoardVo", eventBoardVo);
		map.put("nextView", nextView);
		map.put("preView", preView);
		return map;
	}
//	게시글삭제
	@Override
	public void eventBoardDelete(int eb_num) {
		eventBoardMapper.eventBoardDelete(eb_num);
		eventBoardMapper.eventBoardDeleteImg(eb_num);
	}
//	게시글 수정페이지 불러오기
	@Override
	public Map<String, Object> selectEventBoardModifyView(int eb_num) {
		Map<String, Object> map = new HashMap<String, Object>();
		EventBoardVo eventBoardrVo = eventBoardMapper.selectEventBoardView(eb_num);
		ArrayList<EventBoardImgVo> imgList = eventBoardMapper.selectEventBoardImg(eb_num);

		if (imgList.size() != 0) {
			map.put("imgList", imgList);
		}

		map.put("eventBoardrVo", eventBoardrVo);
		return map;
	}
//	수정하기
	@Override
	public void eventBoardModify(EventBoardVo eventBoardVo, ArrayList<EventBoardImgVo> imgList) {
		eventBoardMapper.eventBoardModify(eventBoardVo);
		int eb_num = eventBoardVo.getEb_num();
		ArrayList<EventBoardImgVo> imgOriginalList = eventBoardMapper.selectEventBoardImg(eb_num);
		if (imgList.size() != 0) {
			for (int i = 0; i < imgList.size(); i++) {
				String fileName = imgList.get(i).getImg_name();
				if(fileName != null) {
					int img_no = imgOriginalList.get(i).getImg_no();
					eventBoardMapper.eventBoardImgModify(fileName,img_no);
				}
			}

		}
		for(int i= 0; i< imgOriginalList.size(); i++) {
			System.out.println(imgOriginalList.get(i).getImg_name());
		}
	}
}
