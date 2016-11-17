$(document).ready(function(){
 
	if( navigator.geolocation ){
	
		navigator.geolocation.getCurrentPosition(success, fail);
		
}
	else
		 $("p").html("Localização do usuario não encontrada");
});
 
function success(position)
{	var googleLatLng = new google.maps.LatLng(position.coords.latitude, 
		  position.coords.longitude);
	var latitude = position.coords.latitude;
	var longitude =  position.coords.longitude;
	
	onPoint([{name:'latitude',value:latitude},{name:'longitude',value:longitude}]);
		
	
	
	
	
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