package com.example.teamproject.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.Fac_admin_Mapper;
import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.ReservationVo;



@Service
public class Fac_admin_ServiceImpl implements Fac_admin_Service {

	@Autowired
	Fac_admin_Mapper fac_admin_Mapper;
	@Override//insertList
	public int insertFile(Fac_admin_Vo fac_admin_Vo) {
		int result = fac_admin_Mapper.insertFile(fac_admin_Vo);
		System.out.println(fac_admin_Vo.getFm_id());
		return result;
	}

	@Override//allList
	public Map<String, Object> selectAllList(String fm_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Fac_admin_Vo> list	= fac_admin_Mapper.selectAllList(fm_id);
		map.put("list", list);
		return map;
	}

	@Override//selectOneList
	public Fac_admin_Vo selectOneList(int finfo_no) {
		Fac_admin_Vo fac_admin_Vo = fac_admin_Mapper.selectOneList(finfo_no);
		return fac_admin_Vo;
	}

	@Override//modify
	public int updateListModify(Fac_admin_Vo fac_admin_Vo) {
		int result = fac_admin_Mapper.updateOneList(fac_admin_Vo);
		return result;
	}

	@Override//delete
	public void deleteOneList(int finfo_no) {
		fac_admin_Mapper.deleteOneList(finfo_no);
		
	}

	@Override
	public Map<String, Object> selectReserveList(int page, String fm_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ReservationVo> list = fac_admin_Mapper.selectReserveList(fm_id);
		
		map.put("list", list);
		
		return map;
	}

	@Override
	public FmanagerVo fmanagerMypage(String fm_id) {
		FmanagerVo fVo = fac_admin_Mapper.fmanagerMypage(fm_id);
		return fVo;
	}

	@Override
	public int fm_Modify(FmanagerVo fVo) {
		System.out.println("수정");

		int result = fac_admin_Mapper.fm_Modify(fVo);
		
		return result;
	}

	

}
