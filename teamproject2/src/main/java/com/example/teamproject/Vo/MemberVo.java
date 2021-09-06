package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVo {

	private int M_No;
	private String M_ID;
	private String M_PW;
	private String M_NAME;
	private String M_NICKNAME;
	private String M_BIRTH;
	private String M_GENDER;
	private String M_eMAIL;
	private String M_POST;
	private String M_ADD1;
	private String M_ADD2;
	private String M_PHONE;
	private String M_GRADE;
	private String M_POINT;
}
