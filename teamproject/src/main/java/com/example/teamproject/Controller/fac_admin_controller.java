package com.example.teamproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fac_admin_controller {

	//시설 관리자 예약 취소 목록
	@GetMapping("fac_cancel")
	public String fac_cancel() {
		return "/fac_admin/fac_cancel";
	}
	
	//시설 관리자 후기 댓글 모음
	@GetMapping("fac_comment")
	public String fac_comment() {
		return "/fac_admin/fac_comment";
	}
	
	//시설 관리자 시설 목록 현황
	@GetMapping("fac_list")
	public String fac_list() {
		return "/fac_admin/fac_list";
	}
	
	//시설 관리자 시설 목록 현황
	@GetMapping("fac_modify")
	public String fac_modify() {
		return "/fac_admin/fac_modify";
	}
	
	//시설 관리자 문의 현황
	@GetMapping("fac_qna")
	public String fac_qna() {
		return "/fac_admin/fac_qna";
	}
	
	//시설 관리자 시설 등록 페이지
	@GetMapping("fac_register")
	public String fac_register() {
		return "/fac_admin/fac_register";
	}
	
	//시설 관리자 예약 목록 현황
	@GetMapping("fac_reserve")
	public String fac_reserve() {
		return "/fac_admin/fac_reserve";
	}
	
	//시설 관리자 시설 뷰 페이지
	@GetMapping("fac_view")
	public String fac_view() {
		return "/fac_admin/fac_view";
	}
	
	//시설 관리자 정보 관리 페이지
	@GetMapping("fm_mypage")
	public String fm_mypage() {
		return "/fac_admin/fm_mypage";
	}
}
