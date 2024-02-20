package com.example.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.models.Menu;

@Mapper //Mybatis 라이브러리 설정후 추가
@Repository("com.example.mapper.HomeMapper")
public interface HomeMapper {

	public List<Menu> getBpsMenus(int menuNo) throws Exception;
	
}
