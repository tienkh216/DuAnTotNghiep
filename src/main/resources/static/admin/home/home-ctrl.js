app.controller("home-ctrl", function($scope, $http, $rootScope, $routeParams) {
    $scope.countUser;
    $scope.countOrderPending;
    $scope.countOrderSuccess;
    $scope.initialize = function(){
      $http.get("/rest/orders/getPending").then(resp =>{
            $scope.countOrderPending = resp.data;
           
       })
       $http.get("/rest/accounts/count").then(resp =>{
        $scope.countUser = resp.data;
      })
      $http.get("/rest/orders/getSuccess").then(resp =>{
        $scope.countOrderSuccess = resp.data;
      })
      $scope.items = [];
      $http.get("/rest/chart").then(resp=>{
          $scope.items = resp.data;
          $scope.name1=  resp.data[0].name;
          $scope.name2 = resp.data[1].name;
          $scope.name3 = resp.data[2].name;
          $scope.name4 = resp.data[3].name;
          $scope.name5 = resp.data[4].name;
          $scope.value1 = resp.data[0].soluong;
          $scope.value2 = resp.data[1].soluong;
          $scope.value3 = resp.data[2].soluong;
          $scope.value4 = resp.data[3].soluong;
          $scope.value5 =resp.data[4].soluong;
         
  
          var xValues = [ $scope.name1, $scope.name2, $scope.name3, $scope.name4, $scope.name5];
          var yValues = [ $scope.value1,  $scope.value2,  $scope.value3,  $scope.value4,  $scope.value5];
          var barColors = [
          "#b91d47",
          "#00aba9",
          "#2b5797",
          "#e8c3b9",
          "#1e7145"
          ];
          new Chart("myChart", {
              type: "pie",
              data: {
                  labels: xValues,
                  datasets: [{
                  backgroundColor: barColors,
                  data: yValues
                  }]
              },
              options: {
                  title: {
                  display: true,
                  text: "Biểu đồ tổng giá trị sản phẩm hoàn thành theo tháng"
                  }
              }
          });
      });

    }
    $scope.initialize();
 });
 