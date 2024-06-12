package com.multi.spring.member.service;

import java.util.List;

import com.multi.spring.member.model.dto.MemberDTO;

public interface MemberService {

	//회원 가입
	void insertMember(MemberDTO memberDTO) throws Exception;
	
	//회원 탈퇴
	void deleteMember(String id) throws Exception;

	//회원 수정
	void updateMember(MemberDTO memberDTO) throws Exception;
	
	//회원 검색
	MemberDTO selectMember(String id) throws Exception;
	
	//회원 전체 목록
	List<MemberDTO> selectList() throws Exception;

	MemberDTO loginMember(MemberDTO m) throws Exception;
	
}
