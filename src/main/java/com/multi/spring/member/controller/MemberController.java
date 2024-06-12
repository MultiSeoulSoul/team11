package com.multi.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.multi.spring.member.model.dto.MemberDTO;
import com.multi.spring.member.service.MemberService;

/* error-page
 * exception-type
 * ExceptionHandler
 * ControllerAdvice + ExceptionHandler
 * */

@SessionAttributes("loginUser") // Model에 Attribute 추가할때 자동으로 설정된 키값을 세션에 자동등록 시키는 기능 //Model에 담긴 key 값: loginUser
@Controller
@RequestMapping("/member") // "/" 안하면 자동으로 생성되지만 썼음
public class MemberController {

	//생성자 주입
	private final MemberService memberService;
	
	
	
	//@Autowired 생략가능
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
//	@ExceptionHandler(value = BadSqlGrammarException.class) //쿼리를 붙이고 테스트 //특정 에러(BadSqlGrammarException)만 잡기
//	public ModelAndView controllerExceptionHandler(Exception e) {
//		
//		e.printStackTrace();
//		return new ModelAndView("common/errorPageServer").addObject("msg",e.getMessage());
//	}
	
	
//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView controllerExceptionHandler(Exception e) {
//		
//		e.printStackTrace();
//		return new ModelAndView("common/errorPage").addObject("msg",e.getMessage());
//	}
	
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/member")
	public void memberMain() {
	
	}
	
	@RequestMapping("/insert_form")
	public void insertForm() {
		
	}
	
	@RequestMapping("/delete_form")
	public void deleteForm() {
		
	}
	
	@RequestMapping("/update_form")
	public void updateForm() {
		
	}
	
	@RequestMapping("/one_form")
	public void oneForm() {
		
	}
	
	@RequestMapping("/enrollForm")
	public String enrollForm() {
		return "member/enroll_form";
	}
	

	//회원 가입
	@PostMapping("/insert")
	public String insertMember(MemberDTO memberDTO, HttpSession session) throws Exception{
		System.out.println("insert --> " + memberDTO);
		
		memberService.insertMember(memberDTO);
		
		session.setAttribute("msg", "회원 가입 성공");
		return "redirect:/member/member";
	}
	
	//회원 탈퇴
	@GetMapping("/delete")
	public String deleteMember(String id) throws Exception{
		
		memberService.deleteMember(id);
		
		return "redirect:/member/member";
	}
	
	//회원 수정
	@PostMapping("/update")
	public String updateMember(MemberDTO memberDTO, HttpSession session) throws Exception{
		System.out.println("update --> " + memberDTO);
		
		memberService.updateMember(memberDTO);
		
		session.setAttribute("msg", "회원 정보 수정 성공");
		return "redirect:/member/member";
	}
	
	//회원 검색
	@GetMapping("/one")
	public void selectList(String id, Model model) throws Exception{
		MemberDTO memberDTO = memberService.selectMember(id);
		
		model.addAttribute("dto", memberDTO); //"dto" <-- one.jsp
	}
	
	//회원 전체 목록
	@GetMapping("/list")
	public void selectList(Model model) throws Exception{ //void
		List<MemberDTO> list = memberService.selectList();
		
		model.addAttribute("list", list);
	}
		
//	//로그인 //비밀번호 암호화 안 된 계정 가능
//	@PostMapping("/login")
//	public String loginMember(MemberDTO m, HttpSession session) {
//		System.out.println("login --> " + m);
//		
//		try {
//			MemberDTO memberDTO = memberService.loginMember(m);
//			
//			session.setAttribute("loginUser", memberDTO); //<--menubar.jsp "loginUser"
//			return "redirect:/"; //Home
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "common/errorPage";
//		}
//	}
//	
//	//로그아웃
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		
//		session.invalidate();
//		return "redirect:/";
//	}
	
	
	//로그인
	@PostMapping("/login")
	public String loginMember(MemberDTO m, Model model) {
		System.out.println("login --> " + m);
		
		try {
			MemberDTO memberDTO = memberService.loginMember(m);
			model.addAttribute("loginUser", memberDTO);
			return "redirect:/"; //Home
			
		} catch (Exception e) {
			e.printStackTrace();
			return "common/errorPage";
		}
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(SessionStatus status) { //@SessionAttributes--SessionStatus
		
		status.setComplete();  //현재 SessionAttributes 에 의해 저장된 오브젝트를 제거		
		return "redirect:/";
	}
	
}
