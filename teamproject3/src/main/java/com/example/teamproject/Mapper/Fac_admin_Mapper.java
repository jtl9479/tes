package com.example.teamproject.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.ReservationVo;



@Mapper
public interface Fac_admin_Mapper {

	//insertList
	int insertFile(Fac_admin_Vo fac_admin_Vo);

	//AllList
	List<Fac_admin_Vo> selectAllList(String fm_id);

	//selectOneList
	Fac_admin_Vo selectOneList(int finfo_no);

	//modify
	int updateOneList(Fac_admin_Vo fac_admin_Vo);

	//delete
	void deleteOneList(int finfo_no);

	//select Reserve List
	List<ReservationVo> selectReserveList(String fm_id);

	FmanagerVo fmanagerMypage(String fm_id);

	int fm_Modify(FmanagerVo fVo);

}
