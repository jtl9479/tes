package com.example.teamproject.Controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamproject.Service.ReservationService;
import com.example.teamproject.Vo.Fac_admin_Vo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.ReservationVo;
import com.example.teamproject.Vo.ReviewVo;

@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("bookinglist")
	public String openBookinglist(@RequestParam(defaultValue = "1") int page,@RequestParam (defaultValue = "") String sportCategory
			, @RequestParam (defaultValue = "") String searchWord,Model model, @RequestParam(defaultValue = "") String searchCategory ) {
		Map<String, Object> map = reservationService.selectFinfo(page,sportCategory,searchWord,searchCategory);
		model.addAttribute("map",map);
		System.out.println(sportCategory);
		System.out.println(searchCategory);
		return "/reservation/bookinglist"; 
		
	}
	@GetMapping("booking")
	public String openBooking(@RequestParam(value = "finfo_no")  int finfo_no,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session_id");
		MemberVo mVo = reservationService.selectMember(id);
		Fac_admin_Vo finfo = reservationService.selectfinfoView(finfo_no);
		String fm_phone = reservationService.selectFinfo_Phone(finfo.getFm_id());
		ArrayList<ReviewVo> list = reservationService.selectAllReview(finfo_no);
		model.addAttribute("finfo",finfo);
		model.addAttribute("mVo",mVo);
		model.addAttribute("fm_phone",fm_phone);
		model.addAttribute("list",list);
		int review_no = list.size();
		model.addAttribute("review_no",review_no);
		return "/reservation/booking";
	}
	
	@GetMapping("main")
	public String openMain(Model model) {
		Map<String, Object> map = reservationService.selectMainInfo();
		model.addAttribute("map",map);
		return "/reservation/main";
	}
	
	@GetMapping("payment")
	public String openPayemnt(@RequestParam(value = "reser_no") int reser_no, Model model) {
		Map<String,Object> map = reservationService.selectResrInfo(reser_no);
		
		model.addAttribute("map",map);
		return "/reservation/payment";
	}
	@PostMapping("reserDateCheck")
	@ResponseBody
	public Map<String,Object> reserDateCheck(@RequestParam (value = "reserDate") String reserDate,@RequestParam(value = "finfo_no") int finfo_no){
		System.out.println(reserDate+","+finfo_no);
		Map<String, Object> map = reservationService.reserDateCheck(reserDate,finfo_no);
		return map;
	}

	
	@PostMapping("cancelReservaiton")
	@ResponseBody
	public int cancelResrvation(@RequestParam(value = "reser_no") int reser_no) {
		int r_no = reservationService.cancelReservation(reser_no);
		return r_no;
	}
	
	@PostMapping("searchSportList")
	@ResponseBody
	public Map<String,Object> searchSportList(@RequestParam (value = "searchArea") String searchArea){
		Map<String,Object> map = reservationService.selectSportList(searchArea);
		return map;
	}
	
	@PostMapping("searchFinfoName")
	@ResponseBody
	public Map<String,Object> searchFinfoName(@RequestParam(value = "searchArea") String searchArea ,@RequestParam(value = "sportCategory") String sportCategory){
		Map<String,Object> map = reservationService.selectFinfoName(searchArea,sportCategory);
		return map;
	}
	
	@PostMapping("writeReview")
	@ResponseBody
	public Map<String,Object> writeReview(ReviewVo reviewVo){
		Map<String,Object> map = reservationService.writeReview(reviewVo);
		return map;
	}
	
	/*
	 * @PostMapping("reservation") public String reservation(ReservationVo
	 * reservationVo, Model model) { Map<String,Object> map =
	 * reservationService.reservation(reservationVo); int reser_no =
	 * (int)map.get("reser_no"); return "redirect:payment?reser_no="+reser_no; }
	 */
	
	//결제 api
	@RequestMapping("/kakaopay.cls")
	@ResponseBody
	public String kakaopay(ReservationVo reservationVo,Model model) {
	

		System.out.println("정보");
		System.out.println(reservationVo.getReser_date());
		System.out.println(reservationVo.getFinfo_no());
		System.out.println(reservationVo.getM_no());
		System.out.println(reservationVo.getFinfo_name());
		System.out.println(reservationVo.getFinfo_price());
		System.out.println(reservationVo.getReser_time());
		String id = reservationVo.getFinfo_name();

		Map<String, Object> map = reservationService.reservation(reservationVo);
		
		int price = reservationVo.getFinfo_price();
		
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection server = (HttpURLConnection) address.openConnection();
			server.setRequestMethod("POST");
			server.setRequestProperty("Authorization", "KakaoAK 17e8293a82f7df96a1cac7ccb45eca18");
			server.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			server.setDoOutput(true);
			String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name="+id+"&quantity=1&total_amount="+price+"&vat_amount=200&tax_free_amount=0&approval_url=http://localhost:8000/success?reser_no="+reservationVo.getReser_no()+"&fail_url=https://localhost/fail&cancel_url=https://localhost/cancel";
			OutputStream output = server.getOutputStream();//준다
			DataOutputStream dataoutput = new DataOutputStream(output);
			dataoutput.writeBytes(parameter);
			dataoutput.close();
			
			
			int result = server.getResponseCode(); //통신하는 부분
			
			InputStream input;//받는 곳
			if(result == 200) {//정상적인 연결을 뜻할떄 200이다.성공
				input = server.getInputStream();//성공
				System.out.println("성공");
			}else {
				input = server.getErrorStream();//에러
			}
			InputStreamReader inputreader = new InputStreamReader(input);//받는것을 읽는것
			
			BufferedReader buffer = new BufferedReader(inputreader); //형변환 하는 것
			
			return buffer.readLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return"{\"result\":\"NO\"}";
	}
	
	@RequestMapping("success")
	public String openPayemnt(@RequestParam("pg_token") String pg_token,
			@RequestParam("reser_no") String reser_no,
			Model model) {
		System.out.println("성공값");
		System.out.println(pg_token);
		System.out.println(reser_no);
		model.addAttribute("pg_token", pg_token);
		model.addAttribute("reser_no", reser_no);
		return "/reservation/success";
	}
	
	
}
