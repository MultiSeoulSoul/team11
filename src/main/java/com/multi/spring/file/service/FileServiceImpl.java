package com.multi.spring.file.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.file.model.dao.FileDAO;
import com.multi.spring.movie.model.dto.MovieDTO;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO fileDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertMovie(MovieDTO movieDTO) throws Exception {
		int result = fileDAO.insertMovie(sqlSession, movieDTO);
		
		if (result < 0) { //성공하면 1 실패하면 -1
			throw new Exception("파일 등록에 실패했습니다.");
		}
	}

}
