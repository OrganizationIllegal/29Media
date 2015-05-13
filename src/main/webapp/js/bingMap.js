 var map = null;
	  var searchManager = null;
	  var LA=new Microsoft.Maps.Location(39.916927,116.404269);//天安门      
      var LA2=new Microsoft.Maps.Location(47.6215, -122.349329);//西雅图
      var LA3=new Microsoft.Maps.Location(40.003202,116.32838);//清华大学
      var LA4=new Microsoft.Maps.Location(39.877491,116.486297);//北工大
      var LA5=new Microsoft.Maps.Location(39.909843,116.433015);//北京站
      /*加载地图*/
      function getMap()
      {
         map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false,showDashboard: false, disableZooming: true });
		 map.setView({ zoom: 11, center: LA });
		 addDefaultPushpin();
		 //addPushpin2();
		 addPushpin3();
		 addPushpin4();
		 addPushpin5();
		 
      }
      function getPopMap(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
 		 map.setView({ zoom: 11, center: LA });
 		 addDefaultPushpin();
 		 //addPushpin2();
 		 addPushpin3();
 		 addPushpin4();
 		 addPushpin5();
      }
      function getIndexMap(){
    	  map = new Microsoft.Maps.Map(document.getElementById('indexMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false,showDashboard: false, disableZooming: true });
 		 map.setView({ zoom: 11, center: LA });
 		 addDefaultPushpin();
 		 //addPushpin2();
 		 addPushpin3();
 		 addPushpin4();
 		 addPushpin5();
 		 map2 = new Microsoft.Maps.Map(document.getElementById('eyeMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn', center: LA, mapTypeId: Microsoft.Maps.MapTypeId.birdseye, zoom: 15,showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false,showDashboard: false, disableZooming: true });
      }
     /* 增加pushpin*/
      function addDefaultPushpin()
      {
        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
		pushpinOver= Microsoft.Maps.Events.addHandler(pushpin, 'mouseover', addDefaultInfobox);  
		pushpinClick= Microsoft.Maps.Events.addHandler(pushpin, 'click', popModal); 
        map.entities.push(pushpin);
      }
      function addPushpin2()
      {
        var pushpin2= new Microsoft.Maps.Pushpin(LA2, null); 
		pushpinOver= Microsoft.Maps.Events.addHandler(pushpin2, 'mouseover', addInfobox2);
		pushpinClick= Microsoft.Maps.Events.addHandler(pushpin2, 'click', popModal);
        map.entities.push(pushpin2);
      }
      function addPushpin3()
      {
        var pushpin3= new Microsoft.Maps.Pushpin(LA3, null); 
		pushpinOver= Microsoft.Maps.Events.addHandler(pushpin3, 'mouseover', addInfobox3);
		pushpinClick= Microsoft.Maps.Events.addHandler(pushpin3, 'click', popModal);
        map.entities.push(pushpin3);
      }
      function addPushpin4()
      {
        var pushpin4= new Microsoft.Maps.Pushpin(LA4, null); 
		pushpinOver= Microsoft.Maps.Events.addHandler(pushpin4, 'mouseover', addInfobox4);
		pushpinClick= Microsoft.Maps.Events.addHandler(pushpin4, 'click', popModal);
        map.entities.push(pushpin4);
      }
      function addPushpin5()
      {
        var pushpin5= new Microsoft.Maps.Pushpin(LA5, null); 
		pushpinOver= Microsoft.Maps.Events.addHandler(pushpin5, 'mouseover', addInfobox5);
		pushpinClick= Microsoft.Maps.Events.addHandler(pushpin5, 'click', popModal);
        map.entities.push(pushpin5);
      }
     /* 增加infobox*/
	  function addDefaultInfobox()
      { 
        var infoboxOptions = {width :200, height :100,title:'北京工业大学', description:'中等价位',offset:new Microsoft.Maps.Point(0,20)}; 
        var defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions );    
        map.entities.push(defaultInfobox);
      }
	  function addInfobox2()
      {       
        var infoboxOptions2 = {width :200, height :100,title:'西雅图', description:'偏远地带',offset:new Microsoft.Maps.Point(0,20)}; 
        var Infobox2 = new Microsoft.Maps.Infobox(LA2, infoboxOptions2 );    
        map.entities.push(Infobox2);
      }
	  function addInfobox3()
      {       
        var infoboxOptions3 = {width :200, height :100,title:'清华大学', description:'天价',offset:new Microsoft.Maps.Point(0,20)}; 
        var Infobox3 = new Microsoft.Maps.Infobox(LA3, infoboxOptions3 );    
        map.entities.push(Infobox3);
      }
	  function addInfobox4()
      {       
        var infoboxOptions4 = {width :200, height :100,title:'天安门', description:'天价',offset:new Microsoft.Maps.Point(0,20)}; 
        var Infobox4 = new Microsoft.Maps.Infobox(LA4, infoboxOptions4 );    
        map.entities.push(Infobox4);
      }
	  function addInfobox5()
      {       
        var infoboxOptions5 = {width :200, height :100,title:'北京站', description:'天价',offset:new Microsoft.Maps.Point(0,20)}; 
        var Infobox5 = new Microsoft.Maps.Infobox(LA5, infoboxOptions5 );    
        map.entities.push(Infobox5);
      }
	  /*弹出模态框*/
	  function popModal(){
		  getPopMap();
		  $('#myModal').modal('show');
	  }
	 /* 搜索*/
	    function createSearchManager() 
  {
      map.addComponent('searchManager', new Microsoft.Maps.Search.SearchManager(map)); 
      searchManager = map.getComponent('searchManager'); 
  }
  function LoadSearchModule()
  {
    Microsoft.Maps.loadModule('Microsoft.Maps.Search', { callback: geocodeRequest })
  }
  function geocodeRequest() 
  { 
    createSearchManager(); 
    //var where = 'Denver, CO';
	var where =document.getElementById("txtQuery").value;
    var userData = { name: 'Maps Test User', id: 'XYZ' }; 
    var request = 
    { 
        where: where, 
        count: 5, 
        bounds: map.getBounds(), 
        callback: onGeocodeSuccess, 
        errorCallback: onGeocodeFailed, 
        userData: userData 
    }; 
    searchManager.geocode(request); 
  } 
  function onGeocodeSuccess(result, userData) 
  { 
    if (result) { 
        map.entities.clear(); 
        var topResult = result.results && result.results[0]; 
        if (topResult) { 
            var pushpin = new Microsoft.Maps.Pushpin(topResult.location, null); 
            map.setView({ center: topResult.location, zoom: 12 });
            map.entities.push(pushpin); 
        } 
    } 
  } 
  function onGeocodeFailed(result, userData) { 
    alert('Geocode failed'); 
  } 