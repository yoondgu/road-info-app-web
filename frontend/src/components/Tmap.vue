<template>
<div id="map-wrapper" class="vh-50 d-flex justify-content-center my-5">
	<div id="map_div" class="align-self-center"></div>
</div>
</template>

<script>
export default {
    name: 'Tmap',
    mounted: function() {
		  // Options API
		//   this.$loadScript("https://apis.openapi.sk.com/tmap/jsv2?version=1&appKey=l7xx6e3d85ee83db468daaa1fcc76f50932d")
		//   .then(() => {
		// 	  // Script is loaded, do something
		// 	  console.log("loaded")
		// 	})
			var map = new Tmapv2.Map("map_div",  
			{
				center: new Tmapv2.LatLng(37.566481622437934,126.98502302169841), // 지도 초기 좌표
				width: "600px", 
				height: "600px",
				zoom: 15
			});
    }
}

</script>