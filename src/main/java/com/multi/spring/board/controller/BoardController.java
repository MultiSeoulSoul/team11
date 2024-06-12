
package com.multi.spring.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.spring.board.model.dto.BoardDTO;
import com.multi.spring.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	//생성자 주입
	private final BoardService boardService;
	//@Autowired 생략가능
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}

	@RequestMapping("/bbs")
	public void bbsMain() {

	}

	@RequestMapping("/bbs_insert_form")
	public void memberInsert() {

	}

	@RequestMapping("/bbs_delete_form")
	public void membeDelete() {

	}

	@RequestMapping("/bbs_update_form")
	public void memberUpdate() {

	}

	@RequestMapping("/bbs_one_form")
	public void memberOne() {

	}

	@RequestMapping("/bbs_list")
	public void memberList() {

	}
	

	//글 쓰기
	@PostMapping("/insert")
	public String insertBoard(BoardDTO boardDTO, HttpSession session) throws Exception {
		System.out.println("insert --> " + boardDTO);
		
		boardService.insertBoard(boardDTO);
		
		session.setAttribute("msg", "게시글 작성 성공");
		return "redirect:/board/bbs";
	}

	//글 삭제
	@GetMapping("/delete")
	public String deleteBoard(int no, HttpSession session) throws Exception {

		boardService.deleteBoard(no);

		session.setAttribute("msg", "게시글 삭제 성공");
		return "redirect:/board/bbs";
	}

	//글 수정
	@PostMapping("/update")
	public String updateBoard(BoardDTO boardDTO, HttpSession session) throws Exception {
		System.out.println("update --> " + boardDTO);
		
		boardService.updateBoard(boardDTO);
		
		session.setAttribute("msg", "게시글 수정 성공");
		return "redirect:/board/bbs";
	}

	//글 검색(상세페이지)
	@GetMapping("/bbs_one")
	public void selectBoard(int no, Model model) throws Exception {
		BoardDTO boardDTO = boardService.selectBoard(no);

		model.addAttribute("bag", boardDTO); //"bag" <-- bbs_one_form.jsp
	}

	//글 전체목록
	@GetMapping("/bbs_list")
	public void selectBoardList(Model model) throws Exception {
		ArrayList<BoardDTO> list = boardService.selectBoardList();

		model.addAttribute("list", list);
	}

}
