package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Menu;

@Service
public interface HomeService {
	
	@Autowired
	public List<Menu> javaLec () throws Exception;
}
