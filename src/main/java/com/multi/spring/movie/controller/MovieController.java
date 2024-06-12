package com.multi.spring.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.multi.spring.movie.model.dto.MovieDTO;

@Controller
@RequestMapping("/movie")
public class MovieController {

	
//	private final MovieService movieService;
//	//--------------------------------------------------------- // @Autowired 생략 가능
//	 public MovieController(MovieService movieService) {
//		 this.movieService = movieService; 
//	 }
	
	
	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}
	
	
	@GetMapping("/genre")
	public void MovieMain() {
		
	}
	
	
	@PostMapping("/genre")
	public void MovieGenre(MovieDTO movieDTO, Model model) {
		
		System.out.println("입력한 장르는: " + movieDTO);
		
		// db 처리
		
		// model.addAttribute("movieDTO", movieDTO);
		
	}
	
	
	@RequestMapping("/movie2")
	public void movie2() {
	
	}
	
	
	@PostMapping("/movie.do")
	public String MovieSelect(String title, int price, Model model , RedirectAttributes redirectAttributes) { // RedirectAttribute는 redirect용
		
		System.out.println("입력한 영화는: " + title);
		System.out.println("입력한 영화 가격은: " + price);
		
		//관람료가 10000원이상이면 pay.jsp로 감.
		//관람료가 10000원 이상이 아니면 webapp/movie2.jsp로 감.
		String page = "redirect:movie2";
		
		
		// forward일 때
		/*
		if(price >= 10000) {
			
			page = "movie/pay";

		}
		*/
		
		// forward일 때
		// model.addAttribute("title", title);
		// model.addAttribute("price", price);

		
		// redirect일 때
		if(price >= 10000) {
			
			page = "redirect:pay"; // redirectAttributes 말고 "redirect:pay?키="밸류 로 보낼 수도 있다.

		}
		
		// redirect일 때 : model에 담을 수 없다. 메소드에 다시 파라미터로 보낸다.
		redirectAttributes.addAttribute("title", title);
		redirectAttributes.addAttribute("price", price);
		
		return page;
		
	}
	
	// redirect 하여 들어온 파라미터를 다시 받아 준다. 받아준 파라미터를 다시 model에 보내 forward하면 pay.jsp에서 model로 가져올 수 있다.
	@RequestMapping("pay")
	public void pay( @RequestParam("title") String title, @RequestParam("price") int price, Model model) {
	 System.out.println("pay-------");
	 
	 	// 따라서 아래처럼 model에 다시 담지 않으면 ${param. }으로 가져온 값만 뜬다.
	 	// model.addAttribute("title", title);
	 	// model.addAttribute("price", price );
	   
	 	// pay.jsp로 자동 포워딩 (경로가 같음)
 	}
	
	
	@RequestMapping("pay2.do")
	public String pay2( @RequestParam("total") int total, Model model) {
		
		int result = (int)(total * 0.9);
		
		System.out.println("최종 결제 금액: " + result);
		
		model.addAttribute("result", result);
		
		return "movie/pay2";
		
	}
	
	
	@RequestMapping("/genre2")
	public String MovieGenre2( @RequestParam("movie") String genre) {
		
		System.out.println("입력한 장르는: " + genre);
		
		String page = "";
		
		if(genre.equals("drama") || genre.equals("드라마")) {
			
			page = "movie/drama";
			
		}
		else if(genre.equals("comic") || genre.equals("코믹") || genre.equals("예능")) {
			
			page = "movie/comic";
			
		}
		else if(genre.equals("action") || genre.equals("액션")) {
			
			page = "movie/action";
			
		}
		else {
			
			page = "redirect:genre";
	
		}
		
		return page;
		
	}
	
	
	
}
