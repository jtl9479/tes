package com.example.teamproject.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QBoardVo {

	private int q_num;
	private String q_title;
	private String q_content;
	private String m_nickname;
	private int q_group;
	private int q_step;
	private int q_indent;
	private String q_category;
	private String m_id;
}
