console.log("datamap start");


// https://www.data.go.kr/data/15051492/fileData.do
const kakaoDataMap1 = async() => {

    const serviceKey ="JbK3US3dccf5%2Bz%2BQig8jxLUU4s%2BMMlps5%2BxExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8%2FVKEBLRLv5e0Q%3D%3D";
    const URL ="https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=10&serviceKey=";


    const response = await fetch( URL+serviceKey, { method: "GET" });
    const data = await response.json();

    console.log(data);


    // 3. 사이드바에 출력하기
    const sidebar = document.querySelector("#sidebar")
    let html ="";
    

    data.data.forEach(  (value) => {
        html += `
        <div class ="store">
            <div> ${value.약국명} </div>
            <div> ${value.전화번호} </div>
            <div> ${value['소재지도로명주소']} </div>
        </div>
        `
    } );
    sidebar.innerHTML = html;
}// func end
kakaoDataMap1(); // 

//마커 클러스터러에 클릭이벤트 추가하기 https://apis.map.kakao.com/web/sample/addClustererClickEvent/
const kakaoDataMap2 = async() => {
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.4905335508, 126.7244907601), // 지도의 중심좌표
        level : 5 // 지도의 확대 레벨
    });

    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 5, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    /**  ###########  아작스(제이쿼리)를 fetch로 변경  ############################################ */

    // fetch를 이용한 공공데이터 자료 활용
    const serviceKey ="JbK3US3dccf5%2Bz%2BQig8jxLUU4s%2BMMlps5%2BxExVQHLtypXrG3I3uzGd8V4RiKfI7Ex9jeINDO8%2FVKEBLRLv5e0Q%3D%3D";
    const URL ="https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=10&serviceKey=";
    const response = await fetch( URL+serviceKey, { method: "GET" });
    const data = await response.json();
    //console.log(data);
    console.log( data.data );
    // map qksqhrans
    let markers = data.data.map(( value ) => {  
        // 마커 생성 후
        let marker = new kakao.maps.Marker({
         position : new kakao.maps.LatLng(value.위도, value.경도)
        });

        let html ="";

        kakao.maps.event.addListener( marker, 'click' , () => {
            //alert('마커 클릭!');
            const sidebar = document.querySelector("#sidebar");
            html += `
            <button onclick="kakaoDataMap1();" type="button">전체 보기</button>
             <div class ="store">
                    <div> ${value.약국명} </div>
                    <div> ${value.전화번호} </div>
                    <div> ${value['소재지도로명주소']} </div>
        </div>
            `
            sidebar.innerHTML = html;
        } );

        return marker;

        // 1차 수정 : 마커 생성 후 리턴 반환 map 반복문을 사용하는 이유, 자동으로 배열에 생성된 객체가 푸시 됨. 
        //  return new kakao.maps.Marker({
        //     position : new kakao.maps.LatLng(value.위도, value.경도)
        //     });
         });

    //$.get("/download/web/data/chicken.json", function(data) {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다. // 마커 생성후 리턴
        // var markers = $(data.positions).map(function(i, position) { //$ 제이쿼리 --> map 반복문을 이용하여 마커를 하나씩 생성하여 return
        //     return new kakao.maps.Marker({
        //         position : new kakao.maps.LatLng(position.lat, position.lng)// 위도/경도
        //     });
        // });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);  // addMarkers ---> 여러개 마커를 클러스터로 표현!
   // });

    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });

}// func end

kakaoDataMap2(); 