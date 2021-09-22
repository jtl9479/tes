package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.ReservationMapper;
import com.example.teamproject.Vo.EventBoardVo;
import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.NoticeBoardVo;
import com.example.teamproject.Vo.PaymentVo;
import com.example.teamproject.Vo.RefundVo;
import com.example.teamproject.Vo.ReservationVo;
import com.example.teamproject.Vo.ReviewVo;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationMapper reservationMapper;

	@Override
	public Map<String, Object> selectFinfo(int page, String sportCategory, String searchWord,String searchCategory) {
		Map<String, Object> map = new HashMap<String, Object>();
		int limit = 6;
		int numLimit = 10;
		int listCount = reservationMapper.selectFinfoCount(sportCategory,searchWord,searchCategory);
		int startPage = (((int) ((double) page / numLimit + 0.99)) - 1) * numLimit + 1;
		int endPage = startPage + numLimit - 1;
		int maxPage = ((int)((double) listCount / limit + 0.99));
		if (endPage > maxPage)
			endPage = maxPage;
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println("count" + listCount);
		System.out.println("startPage" + startPage);
		System.out.println("endPage" + endPage);
		System.out.println("maxPage" + maxPage);
		System.out.println("startRow" + startRow);
		System.out.println("endRow" + endRow);
		ArrayList<Fac_admin_Vo> list = reservationMapper.selectFinfoList(searchCategory, sportCategory,searchWord, startRow, endRow);
		map.put("page", page);
		map.put("searchCategory", searchCategory);
		map.put("sportCategory", sportCategory);
		map.put("searchWord", searchWord);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("maxPage", maxPage);
		map.put("list", list);
		return map;
	}

	@Override
	public Fac_admin_Vo selectfinfoView(int finfo_no) {
		Fac_admin_Vo finfo = reservationMapper.selectfinfoView(finfo_no);
		return finfo;
	}

	@Override
	public MemberVo selectMember(String id) {
		MemberVo mVo = reservationMapper.selectMember(id);
		return mVo;
	}

	@Override
	public Map<String, Object> reserDateCheck(String date, int finfo_no) {
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<String> reserList = reservationMapper.reserDateCheck(date, finfo_no);
		String[] reserTime = {"10:00~13:00","14:00~17:00","18:00~21:00"};
		System.out.println("DB조회"+reserList.size());
		int[] correctNum = {100,100,100};
		int k = 0;
		if(reserList.size()!=0) {
		for(int i=0; i<reserTime.length; i++) {
			System.out.println("기존시간"+reserTime[i]);
			for(int j=0; j<reserList.size(); j++) {
				System.out.println("비교시간"+reserList.get(j));
				if(reserTime[i].equals(reserList.get(j)) ) {
					System.out.println("i값"+i);
					System.out.println("비교"+reserTime[i].equals(reserList.get(j)));
					System.out.println("k"+k);
					correctNum[i] = i;
					System.out.println("k값"+correctNum[k]);
					k++;
					reserTime[i] += " (예약불가)";
					}
				}
			}
		}
		for(int h=0; h<correctNum.length; h++) {
			System.out.println("배열값 " + correctNum[h]);
		}
		map.put("reserTime", reserTime);
		map.put("correctNum", correctNum);
		map.put("correctSize", reserList.size());
		return map;
	}

	@Override
	public Map<String, Object>  reservation(ReservationVo reservationVo) {
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("service");
		System.out.println("정보");
		System.out.println(reservationVo.getReser_date());
		System.out.println(reservationVo.getFinfo_no());
		System.out.println(reservationVo.getM_no());
		System.out.println(reservationVo.getFinfo_name());
		System.out.println(reservationVo.getFinfo_price());
		System.out.println(reservationVo.getReser_time());
		
		reservationMapper.reservation(reservationVo);
		int fee = reservationMapper.getReservationFee(reservationVo.getFinfo_no());
		reservationMapper.chargeFee(fee,reservationVo.getM_no());
		int reser_no = reservationVo.getReser_no();
		reservationMapper.insertPay(reservationVo.getM_no(),reser_no,fee);
		String fm_id = reservationMapper.getFmId(reservationVo.getFinfo_no());
		System.out.println(fm_id);
		reservationMapper.getFee(fee,fm_id);
		System.out.println(fee);
		return map;
	}

	@Override
	public Map<String,Object> selectResrInfo(int reser_no) {
		Map<String,Object> map = new HashMap<String,Object>();
		ReservationVo rVo = reservationMapper.selectResult(reser_no);
		MemberVo mVo = reservationMapper.selectMemberInfo(rVo.getM_no());
		PaymentVo pVo = reservationMapper.selectPaymentInfo(reser_no);
		String img_name = reservationMapper.selectImgName(rVo.getFinfo_no());
		map.put("rVo", rVo);
		map.put("mVo", mVo);
		map.put("pVo", pVo);
		if(pVo.getPay_status().equals("1")) {
			RefundVo refundVo = reservationMapper.selectRefundInfo(reser_no);
			map.put("refundVo", refundVo);
		}
		map.put("img_name", img_name);
		return map;
		
	}

	@Override
	public int cancelReservation(int reser_no) {
		reservationMapper.cancelResrvation(reser_no);
		int refundFee = reservationMapper.selectRefundFee(reser_no);
		String fm_id = reservationMapper.selectRefundFmId(reser_no);
		reservationMapper.chargeRefundFee(refundFee,fm_id);
		int m_no = reservationMapper.selectRefundM_no(reser_no);
		reservationMapper.getRefundFee(m_no,refundFee);
		reservationMapper.insertRefund(reser_no,refundFee,m_no);
		reservationMapper.cancelPayment(reser_no);
		return reser_no;
	}

	@Override
	public Map<String, Object> selectMainInfo() {
		Map<String, Object> map = new HashMap<String,Object>();
		ArrayList<EventBoardVo> eventList =  reservationMapper.selectEventInfo();
		ArrayList<NoticeBoardVo> noticeList = reservationMapper.selectNoticeInfo();
		map.put("eventList", eventList);
		map.put("noticeList", noticeList);
		return map;
	}

	@Override
	public Map<String, Object> selectSportList(String searchArea) {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<String> sportList = reservationMapper.selectSportList(searchArea);
		int sportNo = sportList.size();
		map.put("sportList", sportList);
		map.put("sportNo", sportNo);
		return map;
	}

	@Override
	public Map<String, Object> selectFinfoName(String searchArea, String sportCategory) {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<Fac_admin_Vo> finfoList = reservationMapper.selectFinfoName(searchArea,sportCategory);
		int finfoNo = finfoList.size();
		map.put("finfoList", finfoList);
		map.put("finfoNo", finfoNo);
		return map;
	}

	@Override
	public String selectFinfo_Phone(String fm_id) {
		String fm_phone = reservationMapper.selectFinfo_Phone(fm_id);
		return fm_phone;
	}


	@Override
	public Map<String, Object> writeReview(ReviewVo reviewVo) {
		Map<String,Object> map = new HashMap<String,Object>();
		reservationMapper.writeReview(reviewVo);
		ReviewVo reVo = reservationMapper.selectOneReview(reviewVo.getR_no());
		int reviewCount = reservationMapper.selectReviewCount(reviewVo.getFinfo_no());
		String name = reVo.getM_nickname();
		String content = reVo.getR_content();
		String date = reVo.getR_date();
		int star_on = reVo.getR_rate();
		int star_off = (5-reVo.getR_rate());
		map.put("name", name);
		map.put("content", content);
		map.put("date", date);
		map.put("star_on", star_on);
		map.put("star_off", star_off);
		map.put("reviewCount", reviewCount);
		return map;
	}

	@Override
	public ArrayList<ReviewVo> selectAllReview(int finfo_no) {
		ArrayList<ReviewVo> list = reservationMapper.selectAllReview(finfo_no);
		return list;
	}

	

}
