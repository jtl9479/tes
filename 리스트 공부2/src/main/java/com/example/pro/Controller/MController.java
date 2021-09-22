package com.example.pro.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pro.Service.MService;
import com.example.pro.Vo.listVo;

@Controller
public class MController {

	@Autowired
	MService mService;
	
	
	//화면
	@RequestMapping("list")
	public String BoardList(Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = mService.BoardList();
		
		model.addAttribute("map", map);
		
		return "list";
	}

	//뷰
	@RequestMapping("view")
	public String BoardListView(@RequestParam String bid, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = mService.BoardListView(bid);
		
		model.addAttribute("map", map);
		
		return "view";
	}

	//쓰기 페이지
	@GetMapping("write")
	public String BoardListWrite(Model model) {
		
		return "write";
	}
	
	//글쓰기 등록
	@PostMapping("write")
	public String BoardListWrite(listVo listVo, Model model) {
		
		mService.BoardListWrite(listVo);
		
		return "redirect:list";
	}
	
	//수정페이지 이동
	@GetMapping("modify")
	public String BoardListmModify(@RequestParam String bid, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = mService.BoardListModify(bid);
		
		model.addAttribute("map", map);
		
		return "modify";
	}
	
	//수정페이지 등록
	@PostMapping("modify")
	public String BoardListmModifyCheck(listVo listVo, Model model) {
		
		mService.BoardListmModifyCheck(listVo);
		
		return "redirect:list";
	}
	
	//삭제 페이지
	@GetMapping("delete")
	public String BoardListdelete(listVo listVo,Model model) {
		
		int result = 0;
		result = mService.BoardListdelete(listVo);
		System.out.println(result);
		model.addAttribute("result", result);
		
		return "delete";
	}
	
	//답변 페이지 이동
	@GetMapping("reply")
	public String BoardListReply(listVo listVo,Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = mService.BoardListReply(listVo);
		
		model.addAttribute("map", map);
		
		return "reply";
	}
	
	//답변 완료
	@PostMapping("reply")
	public String BoardListReply_Check(listVo listVo,Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = mService.BoardListReply_Check(listVo);
		
		model.addAttribute("map", map);
		
		return "reply";
	}
	
	
	
}
