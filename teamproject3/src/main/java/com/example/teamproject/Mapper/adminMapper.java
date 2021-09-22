package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.MemberVo;

@Mapper
public interface adminMapper {

	//관리자 회원관리 페이지 이동
	ArrayList<MemberVo> admin_member_list();

}
