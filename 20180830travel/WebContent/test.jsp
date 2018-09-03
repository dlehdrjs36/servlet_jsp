<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGXKB1k8LOAYWW0KCV9G0NNupVvav0XAs&sensor=false"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<label for="searchTextField">Please Insert an address:</label>
<br>
<input id="searchTextField" type="text" size="50">
<p >Country Short Code: <span id="country_shortName"></span></p>
<button onclick="test()" value="test">test</button>

<script>
function test(){
	alert("실행");
var input = document.getElementById('searchTextField');
var options = {
  types: ['geocode']
};

var autocomplete = new google.maps.places.Autocomplete(input, options);

google.maps.event.addListener(autocomplete, 'place_changed', function() {
  var place = autocomplete.getPlace();
  for (var i = 0; i < place.address_components.length; i += 1) {
    var addressObj = place.address_components[i];
    for (var j = 0; j < addressObj.types.length; j += 1) {
      if (addressObj.types[j] === 'country') { /*outputs result if it is country*/
        document.getElementById('country_shortName').innerHTML = addressObj.short_name
      }
    }
  }

});
}
</script>
</body>
</html>