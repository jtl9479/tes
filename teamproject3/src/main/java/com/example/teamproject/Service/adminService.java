package com.example.teamproject.Service;

import java.util.ArrayList;

import com.example.teamproject.Vo.MemberVo;

public interface adminService {

	//관리자 회원관리 페이지 이동
	ArrayList<MemberVo> admin_member_list();

}
