package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.QBoardVo;

@Mapper
public interface QBoardMapper {

	void qBoardWrite(QBoardVo qBoardVo);

	ArrayList<QBoardVo> selectQBoardList(String m_id);

	QBoardVo selectQBoardView(int q_num);

	void qBoardReply(QBoardVo qBoardVo);

}
