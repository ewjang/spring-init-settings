package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.HomeMapper;
import com.example.models.Menu;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	HomeMapper homeMapper;
	
	@Transactional
	public List<Menu> javaLec() throws Exception {
		int temp =93;
		return homeMapper.getBpsMenus(temp);
		//return new Menu();
	}
	
}
