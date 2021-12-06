app.controller("home-ctrl", function($scope, $http, $rootScope, $routeParams) {
    $scope.countUser;
    $scope.countOrderPending;
    $scope.initialize = function(){
      $http.get("/rest/orders/getPending").then(resp =>{
            $scope.countOrderPending = resp.data;
           
       })
       $http.get("/rest/accounts/count").then(resp =>{
        $scope.countUser = resp.data;
    })
    }
    $scope.initialize();
 });
 