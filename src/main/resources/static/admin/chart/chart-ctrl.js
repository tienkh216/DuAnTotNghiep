app.controller("chart-ctrl", function($scope, $http, $rootScope) {
    $scope.doanhThuThang1;
    $scope.doanhThuThang2;
    $scope.doanhThuThang3;
    $scope.doanhThuThang4;
    $scope.doanhThuThang5;
    $scope.doanhThuThang6;
    $scope.doanhThuThang7;
    $scope.doanhThuThang8;
    $scope.doanhThuThang9;
    $scope.doanhThuThang10;
    $scope.doanhThuThang11;
    $scope.doanhThuThang12;
    $scope.year;
    $scope.years = [];
    $scope.clear = function(){
        $scope.doanhThuThang1 = null;
        $scope.doanhThuThang2 = null;
        $scope.doanhThuThang3 = null;
        $scope.doanhThuThang4 = null;
        $scope.doanhThuThang5 = null;
        $scope.doanhThuThang6 = null;
        $scope.doanhThuThang7 = null;
        $scope.doanhThuThang8 = null;
        $scope.doanhThuThang9 = null;
        $scope.doanhThuThang10 = null;
        $scope.doanhThuThang11 = null;
        $scope.doanhThuThang12 = null;
    }
    $http.get("/rest/orders/getYear").then(resp=>{
        $scope.years = resp.data;
    }).catch(erro=>{
        console.log(erro);
        if(erro.status = 403 || erro.status == 401){
            swal("Erro", "Không Có Quyền", "error");
            $scope.close();
        }
    });
    $scope.xem =function(){
        var year = $scope.year;
        $scope.clear();
        $scope.layDuLieu(year);
    }
    $scope.layDuLieu = function(nam){
        $scope.clear();
        $http.get(`/rest/chart/doanhThu/${nam}`).then(resp=>{
            $scope.items = resp.data;
            for(var i = 0 ;i<$scope.items.length;i++){
                if($scope.items[i].thang == 1){
                    $scope.doanhThuThang1 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 2){
                    $scope.doanhThuThang2 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 3){
                    $scope.doanhThuThang3 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 4){
                    $scope.doanhThuThang4 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 5){
                    $scope.doanhThuThang5 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 6){
                    $scope.doanhThuThang6 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 7){
                    $scope.doanhThuThang7 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 8){
                    $scope.doanhThuThang8 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 9){
                    $scope.doanhThuThang9 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 10){
                    $scope.doanhThuThang10 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 11){
                    $scope.doanhThuThang11 = $scope.items[i].doanhThu;
                } 
                if($scope.items[i].thang == 12){
                    $scope.doanhThuThang12 = $scope.items[i].doanhThu;
                } 
            }
            var xValues = ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"];
            var yValues = [$scope.doanhThuThang1, $scope.doanhThuThang2, $scope.doanhThuThang3, $scope.doanhThuThang4,$scope.doanhThuThang5,$scope.doanhThuThang6,$scope.doanhThuThang7, $scope.doanhThuThang8, $scope.doanhThuThang9, $scope.doanhThuThang10, $scope.doanhThuThang11,$scope.doanhThuThang12];
            var barColors = ["red", "green","blue","orange","brown","red", "green","blue","orange","brown"];
        
            new Chart("peopleChart", {
            type: "bar",
            data: {
                labels: xValues,
                datasets: [{
                backgroundColor: barColors,
                data: yValues
                }]
            },
            options: {
                legend: {display: false},
                title: {
                display: true,
                text: "Biểu đồ đánh giá khách hàng theo từng vị trí"
                }
            }
            });
    }).catch(erro=>{
        console.log(erro);
        if(erro.status = 403 || erro.status == 401){
            swal("Erro", "Không Có Quyền", "error");

          }
    });
    }
        
       
  
        
   
    
});

