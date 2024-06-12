package com.multi.spring.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.member.model.dto.MemberDTO;

@Repository
public class MemberDAO {

	//회원 가입
	public int insertMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		return sqlSession.insert("memberMapper.insertMember", memberDTO);
	}
	
	//회원 탈퇴
	public int deleteMember(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.delete("memberMapper.deleteMember", id);
	}

	//회원 수정
	public int updateMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		return sqlSession.update("memberMapper.updateMember", memberDTO);
	}
	
	//회원 검색
	public MemberDTO selectMember(SqlSessionTemplate sqlSession, String id) {
		return sqlSession.selectOne("memberMapper.selectMember", id);
	}
	
	//회원 전체 목록
	public List<MemberDTO> selectList(SqlSessionTemplate sqlSession) {
		return (List)sqlSession.selectList("memberMapper.selectList");
	}

	//로그인
	public MemberDTO loginMember(SqlSessionTemplate sqlSession, MemberDTO m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

}
