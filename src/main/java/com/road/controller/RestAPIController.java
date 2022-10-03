package com.road.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.road.response.ResponseData;
import com.road.service.RoadService;

@RestController
public class RestAPIController {

	@Autowired
	RoadService roadService;
	
	@GetMapping(path = "/api/*")
	public ResponseData road() {
		return roadService.getRoadInfo(0.05);
	}

}
