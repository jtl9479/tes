package com.example.teamproject.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

@Mapper
public interface LoginMapper {

	//회원로그인 체크
	MemberVo member_login_check(String M_ID, String M_PW);

	//시설관리자 로그인 체크
	FmanagerVo Fmanager_login_check(String FM_ID, String FM_PW);

	//회원 회원가입 기능
	int member_register_check(MemberVo memberVo);

	//시설 관리자 회원가입 기능
	int fac_register_check(FmanagerVo fmanagerVo);

	//회원 아이디 찾기 기능
	MemberVo member_ld_find_check(String M_NICKNAME, String M_eMAIL);

	//시설 아이디 찾기 기능
	FmanagerVo fac_ld_find_check(String fM_NAME, String fM_PHONE);

	//회원 비밀번호 찾기 기능
	MemberVo member_pw_find_check(String M_NAME, String M_eMAIL);

	//시설 비밀번호 찾기 기능
	FmanagerVo fac_pw_find_check(String fM_ID, String fM_PHONE);

	//관리자 로그인
	AdminVo admin_login(String a_ID, String a_PW);

}
