package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Menu;
import com.example.service.HomeService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {

	@Autowired
	HomeService homeService;

	@Operation(summary="메뉴 테이블 조회", description="한화토탈 BPS 시스템에 등록된 메뉴 조회")
	@GetMapping("/getMenu") 
	public ResponseEntity<List<Menu>> javalec() throws Exception {
		return ResponseEntity.ok().body(homeService.javaLec()); 
	}
	
	@Operation(summary="default api", description="blank")
	@GetMapping("/")
	public String Welcome () {
		return "welcome";
	}
	
	@Operation(summary="Hello 호출 api", description="blank")
	@GetMapping("/hello")
	public String Hello () {
		return "hello";
	}
	
	@Operation(summary="PathVariable 테스트 api", description="blank")
	@GetMapping("/hello/{userId}")
	public String GetUrlPath (@PathVariable String userId) {
		return userId;
	}
}
