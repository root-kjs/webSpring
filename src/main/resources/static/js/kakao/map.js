console.log("map start");
// 카카오 지도
// https://apis.map.kakao.com/web/



// #01. 간단한 주소 출력!ㄴ
const kakaoMap1 = async() =>{
    /** 카카오 js 가져온 소스 */
    var container = document.querySelector('#map'); //지도를 담을 영역의 DOM 레퍼런스

    // 지도 생성할 때 필요한 옵션
    var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(37.4905335508, 126.7244907601), //지도의 중심좌표(카카오 본사) // 부평역 경도/위도 : 37.4905335508°N, 126.7244907601
        level: 5 //지도의 레벨(확대, 축소 정도) 0~14 // 숫자가 크면 축소범위가 커짐
    };

    // 3. 지도 생성 및 지도 객체 리턴
    var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
}// func end

// kakaoMap1();  // 예제1

// #02. 클릭한 위치에 마커 표시하기 ---> https://apis.map.kakao.com/web/sample/addMapClickEventWithMarker/
const kakaoMap2 = async() => {
    var mapContainer = document.getElementById('map'), // 1.지도를 표시할 div 
    mapOption = { 
    center: new kakao.maps.LatLng(37.4905335508, 126.7244907601), // 2. 지도의 중심좌표
    level: 5 // 지도의 확대 레벨
    };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 3. 지도를 생성합니다

    // 지도를 클릭한 위치에 표출할 마커입니다
    var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
    }); 
    // 지도에 마커를 표시합니다
    marker.setMap(map);

    // #02. 지도에 클릭 이벤트를 등록합니다

    // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
    kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        

    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 

    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);

    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';

    // var resultDiv = document.getElementById('clickLatlng'); 
    // resultDiv.innerHTML = message;
    console.log( message );

    });
}// func end

// kakaoMap2(); // 예제2


// 03. 마커에 클릭 이벤트 등록하기, https://apis.map.kakao.com/web/sample/addMarkerClickEvent/
const kakaoMap3 = async() => {

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = { 
            center: new kakao.maps.LatLng(37.4905335508, 126.7244907601), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
    
    // 마커를 표시할 위치입니다 
    var position =  new kakao.maps.LatLng(33.450701, 126.570667);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: position,
        clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
    });

    // 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
    // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
    // marker.setClickable(true);

    // 마커를 지도에 표시합니다.
    marker.setMap(map);

    // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다   ==========> 잘 안씀
    // var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    //     iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

    // // 인포윈도우를 생성합니다
    // var infowindow = new kakao.maps.InfoWindow({
    //     content : iwContent,
    //     removable : iwRemoveable
    // });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커 위에 인포윈도우를 표시합니다
        // infowindow.open(map, marker);  

        alert("해당 마커 클릭!(추후, 출력 디자인 커스텀!");
    });
}// func end

//kakaoMap3(); // 예제3



// 여러개 마커 표시하기 https://apis.map.kakao.com/web/sample/multipleMarkerImage/
const kakaoMap4 = async() => {
    // 1. 지도 옵션( 옵션 포함 지도를 표시할 div  )
    var mapContainer = document.getElementById('map'), 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };
    // 2. 지도 생성
    var map = new kakao.maps.Map(mapContainer, mapOption); 
    
    // 3. 마커를 표시할 위치와 title 객체 배열입니다 
    var positions = [
        {
            title: '카카오', 
            latlng: new kakao.maps.LatLng(33.450705, 126.570677)
        },
        {
            title: '생태연못', 
            latlng: new kakao.maps.LatLng(33.450936, 126.569477)
        },
        {
            title: '텃밭', 
            latlng: new kakao.maps.LatLng(33.450879, 126.569940)
        },
        {
            title: '근린공원',
            latlng: new kakao.maps.LatLng(33.451393, 126.570738)
        },
        {
            title: '부평역',
            latlng: new kakao.maps.LatLng(37.4905335508, 126.7244907601)
        }
    ];

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "/img/logo.jpg"; // https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png
        
    for (var i = 0; i < positions.length; i ++) {
        
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35); 
        
        // 마커 이미지를 생성합니다    
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image : markerImage // 마커 이미지 
        });
    }
}// func end

kakaoMap4(); // 예제4