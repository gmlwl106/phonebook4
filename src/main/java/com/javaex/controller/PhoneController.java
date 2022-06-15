package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// 필드
	@Autowired
	private PhoneService phoneService;

	// 생성자

	// 메소드-gs

	// 메소드-일반

	// 전화번호 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhoneController>list()");

		// Service를 통해서 personList(주소)을 가져온다
		// PhoneService phoneService = new PhoneService() X;
		List<PersonVo> personList = phoneService.getPersonList();
		System.out.println(personList);

		// ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("personList", personList);

		return "list";

	}

	// 전화번호 등록 폼
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");

		return "writeForm";
	}

	// 전화번호 등록(@ModelAttribute 사용)
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {

		System.out.println("PhoneController>write()");

		// Service를 통해서 저장한다
		int count = phoneService.personInsert(personVo);

		// 리다이렉트
		return "redirect:/list";
	}

	// 전화번호 등록(파라미터 사용)
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam("name") String name, 
					    @RequestParam("hp") String hp,
					    @RequestParam("company") String company) {
		
		System.out.println("PhoneController>write2()");
		
		//파라미터 꺼내기
		/*
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		*/
		
		//vo로 묶기
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		// Service를 통해서 저장한다
		int count = phoneService.personInsert(personVo);
		System.out.println(count);
		
		//리다이렉트
		return "redirect:/list";
	}
	
	
	// 전화번호 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhoneController>delete()");

		// 파라미터 꺼내기
		System.out.println(no);

		// Service를 통해서 삭제한다
		int count = phoneService.personDelete(no);

		return "redirect:/list";
	}

	
	//전화번호 삭제(@PathVariable 사용)
	@RequestMapping(value="/delete2/{no}", method={RequestMethod.GET, RequestMethod.POST})
	public String delete2(@PathVariable("no") int num) {
		System.out.println("PhoneController>delete()");
		
		//주소에서 값 꺼내기
		System.out.println(num);
		
		// Service를 통해서 삭제한다
		int count = phoneService.personDelete(num);
		System.out.println(count);
		
		return "redirect:/list";
	}
	
	
	// 전화번호 수정폼
	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @RequestParam("no") int no) {
		System.out.println("PhoneController>updateForm()");

		// 주소에서 값 꺼내기
		System.out.println(no);

		// Service를 통해서 1명정보 가져오기
		PersonVo personVo = phoneService.getPerson(no);

		// ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("personVo", personVo);

		return "updateForm";
	}

	// 전화번호 수정
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(Model model, @ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update()");

		// 파라미터 꺼내기+vo로 묶기를 DS해서 메소드의 파라미터로 보내준다
		System.out.println(personVo);

		// Service를 통해서 수정하기
		int count = phoneService.personUpdate(personVo);

		return "redirect:/list";
	}

}
