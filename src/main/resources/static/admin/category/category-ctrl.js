app.controller("category-ctrl", function($scope, $http, $rootScope) {
    $scope.items = [];
    $scope.form = {};
    $scope.initialize = function(){
        $http.get("/rest/categories").then(resp =>{
            $scope.items = resp.data;
        });
    };
    $scope.close = function(){
        $('#exampleModalCenter').modal('hide');
    }
    $scope.initialize();
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
    }
    $scope.update =  function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/categories/${item.id}`,item).then(resp=>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            $scope.close();
            swal("Ok", "Successful Update", "success");
        })
        .catch(erro =>{
            swal("Erro", "Update Failed", "error");
            console.log("erro",erro);
        })
     }
     
     $scope.delete = function(item){
        swal({
            title: "Are you sure?",
            text: "Once deleted, you will not be able to recover this imaginary file!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
          })
          .then((willDelete) => {
            if (willDelete) {
              swal("Do you want to delete your account?", {
                icon: "success",
              });
              $http.delete(`/rest/categories/${item}`,item).then(resp=>{
                var index = $scope.items.findIndex(p => p.id == item);
                $scope.items.splice(index,1);
                swal("Ok", "Successful Delete", "success");
                })
                .catch(erro =>{
                    swal("Erro", "Delete Failed", "error");
                    console.log("erro",erro);
                })
                } else {
                swal("cancel");
                }
        });
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
            $scope.close();
            swal("Ok", "Successful Create", "success");
        })
        .catch(erro =>{
            swal("Ok", "Successful Create", "success");
            console.log(erro);
        })
     }
     
});
