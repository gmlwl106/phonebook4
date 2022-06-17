package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;


@Service
public class PhoneService {

	//필드
	@Autowired
	private PhoneDao phoneDao;
	
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	//전화번호 리스트
	public List<PersonVo> getPersonList(){
		System.out.println("PhoneService->getPersonList()");
		
		List<PersonVo> personList = phoneDao.getPersonList();
		
		return personList;
	}
	
	//전화번호 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhoneService->personInsert()");
		
		int count = phoneDao.personInsert(personVo);
		
		return count;
	}
	
	//전화번호 등록(map을 사용하는 가상의 상황)
	public int personInsert3() {
		System.out.println("PhoneDao->personInsert3()");
		
		//map을 만들어서 사용한다 *1회성
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", "박깜이");
		pMap.put("hp", "010-2222-3333");
		pMap.put("company", "02-2222-3333");
		
		int count = phoneDao.personInsert3(pMap);
		
		return count;
	}
	
	
	//전화번호 삭제
	public int personDelete(int no) {
		System.out.println("PhoneService->personDelete()");
		
		int count = phoneDao.personDelete(no);
		
		return count;
	}
	
	//전화번호 수정폼(정보가져오기)
	public PersonVo getPerson(int no) {
		System.out.println("PhoneService->getPerson()");
		
		PersonVo personVo = phoneDao.getPerson(no);
		
		return personVo;
	}
	
	//전화번호 수정폼(map 방식)
	public Map<String, Object> getPerson2(int no) {
		System.out.println("PhoneService->getPerson2()");
		
		Map<String, Object> pMap = phoneDao.getPerson2(no);
		
		return pMap;
	}
	
	//전화번호 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhoneService->personUpdate()");
	
		int count = phoneDao.personUpdate(personVo);
		
		return count;
	}
}
