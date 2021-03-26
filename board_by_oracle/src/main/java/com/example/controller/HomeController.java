package com.example.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Board;
import com.example.paging.Pagination;
import com.example.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name = "boardService")
	BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "list")
    public ModelAndView AllListView(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        int listCnt = service.tableCount();
        Pagination pagination = new Pagination(currentPage, cntPerPage, pageSize);
        pagination.setTotalRecordCount(listCnt);
 
        mav.addObject("pagination",pagination);
        mav.addObject("list",service.allBoard(pagination));
        mav.setViewName("/board/board_list");
        return mav;
    }
	
	@RequestMapping(value = "read")
	public ModelAndView read(@RequestParam(value = "bno")String bno) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detail", service.read(bno));
		mav.setViewName("/board/board_read");
		
		return mav;
	}
	
	@RequestMapping(value = "update")
	public ModelAndView update(Board board) {
		ModelAndView mav = new ModelAndView();
		
		service.update(board);
		mav.setViewName("redirect:list");
		
		return mav;
	}
	
	@RequestMapping(value = "delete")
	public ModelAndView delete(String bno) {
		ModelAndView mav = new ModelAndView();
		
		service.delete(bno);
		mav.setViewName("redirect:list");
		
		return mav;
	}
	
	/*
	 * @RequestMapping(value = "/expansianoracution") public String creatDummy() {
	 * 
	 * service.dummyCreate();
	 * 
	 * return "redirect:/board";
	 * 
	 * }
	 */
	
}
