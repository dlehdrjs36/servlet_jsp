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