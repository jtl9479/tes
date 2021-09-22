package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.QBoardMapper;
import com.example.teamproject.Vo.QBoardVo;

@Service
public class QBoardServiceImpl implements QBoardService {
	
	@Autowired
	QBoardMapper qBoardMapper;
	@Override
	public void qBoardWrite(QBoardVo qBoardVo) {
		qBoardMapper.qBoardWrite(qBoardVo);
		
	}
	@Override
	public Map<String, Object> selectQBoardList(String m_id) {
		Map<String, Object> map = new HashMap<String,Object>();
		ArrayList<QBoardVo> list = qBoardMapper.selectQBoardList(m_id);
		map.put("list", list);
		return map;
	}
	@Override
	public QBoardVo selectQBoardView(int q_num) {
		QBoardVo qBoardVo = qBoardMapper.selectQBoardView(q_num);
		return qBoardVo;
	}
	@Override
	public void qBoardReply(QBoardVo qBoardVo) {
		qBoardMapper.qBoardReply(qBoardVo);
	}

}
