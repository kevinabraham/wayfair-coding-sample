var MapHelper = {};

(function($) {

    var directionsDisplay,
    directionsService = new google.maps.DirectionsService(),
    mymap, mapElement;

    function initialize() {
      directionsDisplay = new google.maps.DirectionsRenderer();
      var boston = new google.maps.LatLng(42.3581, -71.0636);
      var mapOptions = {
        zoom:7,
        center: boston,
        panControl: false,
        zoomControl: false
      }
      mymap = new google.maps.Map(mapElement, mapOptions);
      directionsDisplay.setMap(mymap);
    }

    MapHelper.init = function(mapElem) {
       mapElement = mapElem;
       initialize();
        //google.maps.event.addDomListener(window, 'load', initialize);
    };

    MapHelper.showDirections = function (sourceLat, sourceLong, destLat, destLong){

          var start =  new google.maps.LatLng(sourceLat, sourceLong);
          var end =  new google.maps.LatLng(destLat, destLong);
          var request = {
              origin:start,
              destination:end,
              travelMode: google.maps.TravelMode.TRANSIT,
              transitOptions: {
                    departureTime: new Date(new Date().getTime())
                },
                unitSystem: google.maps.UnitSystem.IMPERIAL
          };

          directionsService.route(request, function(response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                console.log(response);
                directionsDisplay.setDirections(response);
            }
          });
    };
})(jQuery);
