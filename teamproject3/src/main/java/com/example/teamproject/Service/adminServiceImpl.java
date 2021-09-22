package com.example.teamproject.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.adminMapper;
import com.example.teamproject.Vo.MemberVo;

@Service
public class adminServiceImpl implements adminService {

	@Autowired
	adminMapper adminMapper;
	//관리자 회원관리 페이지 이동
	@Override
	public ArrayList<MemberVo> admin_member_list() {

		ArrayList<MemberVo> list = adminMapper.admin_member_list();
		
		
		return list;
	}
}
