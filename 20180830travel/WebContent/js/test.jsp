<SCRIPT type="text/JavaScript">
var contentArray = [];
var iConArray = [];
var markers = [];
var iterator = 0;
var markerArray = [];
var map;

// 중심좌표 구하기 
var bounds = new google.maps.LatLngBounds(
            new google.maps.LatLng(${latt},${lngg}),
             new google.maps.LatLng(${latt2},${lngg2})         
         );

var center = bounds.getCenter();  
alert(center);
// infowindow contents 배열
 contentArray[0] = '${from}';
 contentArray[1] = '${to}';
// marker icon 배열
 iConArray[0] = "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png";
 iConArray[1] = "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png";
// marker를 찍을 위도,경도 
markerArray[0] = new google.maps.LatLng(${latt},${lngg});
markerArray[1] = new google.maps.LatLng(${latt2},${lngg2});

 
function initialize() {
    
   var mapOptions = {
        zoom: 2,
        zoomControl : false,
        streetViewControl : false,
        //draggable : false,    
        mapTypeId: google.maps.MapTypeId.ROADMAP,
      center: center
    
    };
    
    map = new google.maps.Map(document.getElementById('map'),mapOptions);
 
    for (var i = 0; i < markerArray.length; i++) {
        addMarker();
    }
// 마커 간에 경로 긋기
    var flightPlanCoordinates = [
       new google.maps.LatLng(${latt},${lngg}),
       new google.maps.LatLng(${latt2},${lngg2})
      ];
    var flightPath = new google.maps.Polyline({
        path: flightPlanCoordinates,
        geodesic: true,
        strokeColor: "#0000FF",
        strokeOpacity: 1.0,
        strokeWeight: 2
    });

    flightPath.setMap(map);
      
}
 
 
// 마커 추가
function addMarker() {
 
    var marker = new google.maps.Marker({
        position: markerArray[iterator],
        animation:google.maps.Animation.BOUNCE,
        map: map,
        draggable: false,
        icon: iConArray[iterator]
    });
    markers.push(marker);
 
    var infowindow = new google.maps.InfoWindow({
      content: contentArray[iterator]
    });
 
    google.maps.event.addListener(marker, 'click', function() {
        infowindow.open(map,marker);
    });
    
    iterator++;
}
 

 google.maps.event.addDomListener(window, 'load', initialize); 

</SCRIPT>
