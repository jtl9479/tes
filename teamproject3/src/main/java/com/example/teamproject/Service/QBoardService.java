package com.example.teamproject.Service;

import java.util.Map;

import com.example.teamproject.Vo.QBoardVo;

public interface QBoardService {

	void qBoardWrite(QBoardVo qBoardVo);

	Map<String, Object> selectQBoardList(String m_id);

	QBoardVo selectQBoardView(int q_num);

	void qBoardReply(QBoardVo qBoardVo);

}
