$(document).ready(function(){
 
	if( navigator.geolocation ){
	
		navigator.geolocation.getCurrentPosition(success, fail);
		
}
	else
	 $("p").html("HTML5 Not Supported");
});
 
function success(position)
{	var googleLatLng = new google.maps.LatLng(position.coords.latitude, 
		  position.coords.longitude);
	var latitude = position.coords.latitude;
	var longitude =  position.coords.longitude;
	
	onPoint([{name:'latitude',value:latitude},{name:'longitude',value:longitude}]);
		
	//addMarker(googleLatLng,"EU ESTOU AQUI");
	
	
	
}
	function addMarker(){
		var googleLatLng = new google.maps.LatLng(latitude, 
				position.coords.longitude);
		var markerOptn={
			position 	:googleLatLng,
			title		:"",
			animation:google.maps.Animation.DROP
		};
	 	var marker = new google.maps.Marker(markerOptn);
		PF('map').addOverlay(marker);
	}
	
function fail(error)
{
	var errorType = {
0: "Unknown Error",
1: "Permission denied by the user",
2: "Position of the user not available",
3: "Request timed out"
	};
 
	var errMsg = errorType[error.code];
 
	if(error.code == 0 || error.code == 2){
		errMsg = errMsg+" - "+error.message;
	}
 
	$("p").html(errMsg);
}