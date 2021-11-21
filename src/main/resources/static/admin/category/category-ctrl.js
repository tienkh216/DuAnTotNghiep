app.controller("category-ctrl", function($scope, $http, $rootScope) {
    $scope.items = [];
    $scope.form = {};
    $scope.initialize = function(){
        $http.get("/rest/categories").then(resp =>{
            $scope.items = resp.data;
        });
    };
    $scope.initialize();
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
    }
    $scope.update =  function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/categories/${item.id}`,item).then(resp=>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert('Cập nhật thành công')
        })
        .catch(erro =>{
            alert("Cập nhật thất bại");
            console.log("erro",erro);
        })
     }
     
     $scope.delete = function(item){
     var r = confirm("Do you want delete category");
     if(r=true){
        $http.delete(`/rest/categories/${item}`,item).then(resp=>{
            var index = $scope.items.findIndex(p => p.id == item);
            $scope.items.splice(index,1);
            alert('Xóa thành công')
        })
        .catch(erro =>{
            alert("Xóa thất bại");
            console.log("erro",erro);
        })

    }
     }
     $scope.reset = function(){
         $scope.form = {
             id : '',
             name: ''
         }
     }
     $scope.create = function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/categories`,item).then(resp=>{
            resp.data.createDate =  new Date(resp.data.createDate);
            $scope.items.push(resp.data);
            $scope.reset();
            alert('Thêm mới thành công')
        })
        .catch(erro =>{
            alert("Thêm mới thất bại");
            console.log(erro);
        })
     }
     
});
