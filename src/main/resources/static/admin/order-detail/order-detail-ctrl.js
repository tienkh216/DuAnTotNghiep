app.controller("order-detail-ctrl", function($scope, $http, $rootScope, $routeParams) {
    const id =$routeParams.id;
    $scope.form ={};
    $scope.items =[];
    $scope.username;
    $scope.address;
    $scope.total=0;
    $scope.initialize = function(){
        $http.get(`/rest/orderdetail/${id}`).then(resp=>{
            console.log(resp.data);
            $scope.items = resp.data;
            $scope.username = resp.data[0].order.account.username;
            $scope.address = resp.data[0].order.address;
            for(var i =0; i<$scope.items.length;i++){
                $scope.total+= (resp.data[i].product.price) * (resp.data[i].quantity);
            }
            console.log($scope.total);
        })
    }
   

    $scope.initialize();
 });
 