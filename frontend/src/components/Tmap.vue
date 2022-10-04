<template>
<div id="map-wrapper" class="vh-50 d-flex justify-content-center my-5">
	<div id="map_div" class="align-self-center"></div>
	<button @click="search" class="btn btn-sm btn-secondary">Get Data</button>
</div>
</template>

<script>
let map; // Tmap 지도객체가 담기는 변수
const colors = { // 제한속도 별 색상
	speed10: "#DAF7A6",
	speed30: "#B1F705",
	speed50: "#FFC300",
	speed60: "#EA6A26",
	speed80: "#EAC926",
	speed90: "#FF5733",
	speed100: "#C70039",
	speed110: "#900C3F",
	speed120: "#581845"
};

export default {
    name: 'Tmap',
    mounted: function() {
		  // Options API
			// this.$loadScript("https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx6e3d85ee83db468daaa1fcc76f50932d")
			// .then(() => {
			// // Script is loaded, do something
			// 	console.log("loaded")
			// }).catch(() => {

			// })
			map = new Tmapv2.Map("map_div",  
			{
				center: new Tmapv2.LatLng(37.566481622437934,126.98502302169841), // 지도 초기 좌표
				width: "600px", 
				height: "600px",
				zoom: 15
			});
		},
		methods: {
			search() {
			// axios로 정보 획득
			const URL = "/api/road";
			this.$axios.get(URL).then((response) => {
				if (response.data.success) {
					showPolyLine(response.data.items);
				}
			});
		}
	},
}

function showPolyLine(items) {
	// let items = response.data.items;
	let middleIndex = items.length > 1 ? Math.round(items.length/2) : 1;
	// 마커 있는 곳으로 지도 중심 바꾸기
	map.setCenter(new Tmapv2.LatLng(items[middleIndex].sourceLocation.latitude, items[middleIndex].sourceLocation.longitude));

	// 제한속도에 따라 다른 색으로 경로를 표시하기 위해 제한속도 별 위치정보 배열을 저장
	let pathsWithSpeed = []; // 제한속도, 위치정보배열을 담은 객체를 저장할 배열
	let path = []; // 위치정보 배열
	let speedLimit = items[0].speed;
	for (let index = 0; index < items.length; index++) {
		let location = items[index].sourceLocation;
		// 제한속도 정보가 바뀔 때마다 (제한속도, 위치정보 배열) 담은 객체를 저장하기
		if (speedLimit != items[index].speed) {
			path.push(new Tmapv2.LatLng(location.latitude, location.longitude)); // 제한속도 별 경로가 서로 연결되게 하기 위함
			pathsWithSpeed.push({
				speed: speedLimit,
				path: path
			});
			speedLimit = items[index].speed;
			path = [];
		}
		path.push(new Tmapv2.LatLng(location.latitude, location.longitude));
	}
	// if문에서 체크하지 못한 마지막 남은 정보들 저장
	if (path.length != 0) {
		pathsWithSpeed.push({
				speed: speedLimit,
				path: path
			});
	}
	// 저장한 정보들로 폴리라인 생성
	for (let item of pathsWithSpeed) {
		new Tmapv2.Polyline({
			path: item.path,
			strokeColor: colors["speed" + item.speed],
			strokeWeight: 8,
			map: map
		});
	}
}
</script>