app.controller("order-detail-ctrl", function($scope, $http, $rootScope, $routeParams) {
    const id =$routeParams.id;
    $scope.form ={};
    $scope.items =[];
    $scope.username;
    $scope.address;
    $scope.paymethod;
    $scope.total=0;
    $scope.createDate;
    $scope.phone;
    $scope.initialize = function(){
        $http.get(`/rest/orderdetail/${id}`).then(resp=>{
            $scope.items = resp.data;
            $scope.username = resp.data[0].order.account.username;
            $scope.address = resp.data[0].order.address;
            $scope.paymethod = resp.data[0].order.paymentMethod.description;
            $scope.createDate = resp.data[0].order.createDate;
            $scope.phone = resp.data[0].order.phone;
            for(var i =0; i<$scope.items.length;i++){
                $scope.total+= (resp.data[i].product.price) * (resp.data[i].quantity);
            }
            
        })
    }
   

    $scope.initialize();
 });
 