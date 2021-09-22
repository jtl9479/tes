package com.example.teamproject.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamproject.Service.QBoardService;
import com.example.teamproject.Vo.QBoardVo;



@Controller
public class QBoardController {
	
	@Autowired
	QBoardService qBoardService;
	@GetMapping("qBoardWrite")
	public String openQBoardWrite() {
		return "/questionBoard/qBoardWrite";
	}
	
	@PostMapping("qBoardWrite")
	public String qBoardWrite(QBoardVo qBoardVo) {
		qBoardService.qBoardWrite(qBoardVo);
		return "redirect:qBoardList";
	}
	
	@GetMapping("qBoardList")
	public String qBoardList(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String m_id = (String)session.getAttribute("session_id");
		Map<String, Object> map = qBoardService.selectQBoardList(m_id);
		model.addAttribute("map",map);
		return"/questionBoard/qBoardList";
	}
	@GetMapping("qBoardView")
	public String qBoardView(@RequestParam (value = "q_num") int q_num,Model model) {
		QBoardVo qBoardVo = qBoardService.selectQBoardView(q_num);
		model.addAttribute("qBoardVo",qBoardVo);
		return "/questionBoard/qBoardView";
	}
	@GetMapping("qBoardReply")
	public String qBoardReply(@RequestParam (value = "q_num") int q_num,Model model) {
		QBoardVo qBoardVo = qBoardService.selectQBoardView(q_num);
		model.addAttribute("qBoardVo",qBoardVo);
		return "/questionBoard/qBoardReply";
	}
	@PostMapping("qBoardReply")
	public String qBoardRe(QBoardVo qBoardVo) {
		qBoardService.qBoardReply(qBoardVo);
		return "redirect:qBoardList";
	}
}
