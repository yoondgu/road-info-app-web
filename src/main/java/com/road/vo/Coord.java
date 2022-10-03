package com.road.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coord {

	private double latitude;
	private double longitude;
	private int csvIdx; // csv파일의 행순서 (0번부터 저장, csvIdx가 0이면 csv파일의 2번째 행이다.)
	
}
