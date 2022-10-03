package com.road.dto;

import com.road.vo.Coord;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MatchedPoint {

	private Coord sourceLocation;
	private String idxName;
	private String linkId;
	private String speed;
	private String roadCategoryName;
	
}
