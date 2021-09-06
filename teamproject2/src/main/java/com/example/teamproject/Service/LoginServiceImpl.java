package com.example.teamproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.LoginMapper;
import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;

	//회원 로그인 체크
	@Override
	public MemberVo member_login_check(String M_ID, String M_PW) {

		MemberVo memberVo = loginMapper.member_login_check(M_ID,M_PW);
		
		return memberVo;
	}
	
	
	//시설 관리자 로그인 체크
	@Override
	public FmanagerVo Fmanager_login_check(String FM_ID, String FM_PW) {
	

		
		FmanagerVo fmanagerVo = loginMapper.Fmanager_login_check(FM_ID,FM_PW);
		
		return fmanagerVo;
	}


	//회원 회원가입 기능
	@Override
	public int member_register_check(MemberVo memberVo) {

		int result = loginMapper.member_register_check(memberVo);
		
		return result;
	}

	//시설관리자 회원가입 기능
	@Override
	public int fac_register_check(FmanagerVo fmanagerVo) {
		
		int result = loginMapper.fac_register_check(fmanagerVo);
		
		return result;
	}


	//회원 아이디 찾기
	@Override
	public MemberVo member_ld_find_check(String M_NICKNAME, String M_eMAIL) {

		MemberVo memberVo = loginMapper.member_ld_find_check(M_NICKNAME,M_eMAIL);
		
		return memberVo;
	}

	//시설 아이디 찾기
	@Override
	public FmanagerVo fac_ld_find_check(String fM_NAME, String fM_PHONE) {

		FmanagerVo fmanagerVo = loginMapper.fac_ld_find_check(fM_NAME,fM_PHONE);
		
		return fmanagerVo;
	}

	//회원 비밀번호 찾기
	@Override
	public MemberVo member_pw_find_check(String M_NAME, String M_eMAIL) {

		MemberVo memberVo = loginMapper.member_pw_find_check(M_NAME,M_eMAIL);
		
		return memberVo;
	}

	//시설 비밀번호 찾기
	@Override
	public FmanagerVo fac_pw_find_check(String fM_ID, String fM_PHONE) {


		FmanagerVo fmanagerVo= loginMapper.fac_pw_find_check(fM_ID,fM_PHONE);
		
		return fmanagerVo;
	}

	//관리자 로그인
	@Override
	public AdminVo admin_login(String a_ID, String a_PW) {

		System.out.println("서브시");
		System.out.println(a_ID);
		
		AdminVo adminVo = loginMapper.admin_login(a_ID,a_PW);
		
		return adminVo;
	}
	

	
	
	
	
	
}
