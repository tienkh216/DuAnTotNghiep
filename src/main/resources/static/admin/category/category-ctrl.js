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
            $scope.initialize();
            swal("Ok", "Successful Update", "success");
        })
        .catch(erro =>{
            if(erro.status = 403 || erro.status == 401){
              swal("Erro", "Không có quyền sửa", "error");
              $scope.close();
            }
            else{
              swal("Erro", "Update Failed", "error");
            }
            console.log("erro",erro.status);
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
              swal("Bạn có muốn xoa không", {
                icon: "success",
              });
              $http.delete(`/rest/categories/${item}`).then(resp=>{
                    var index = $scope.items.findIndex(p => p.id == item);
                    $scope.items.splice(index,1);
                    $scope.reset();
                    $scope.initialize();
                    swal("Ok", "Successful Delete", "success");
                })
                .catch(erro =>{
                    if(erro.status = 403 || erro.status == 401){
                      swal("Erro", "Không có quyền xóa", "error");
                    }
                    else{
                      swal("Erro", "Delete Failed", "error");
                    }
                    console.log("erro",erro.status);
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
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.close();
            $scope.initialize();
            swal("Ok", "Tạo mới thành công", "success");
        })
        .catch(erro =>{
            if(erro.status = 403 || erro.status == 401){
              swal("Erro", "Không có quyền thêm sp", "error");
            }
            else{
              swal("Erro", "Tạo mới thất bại", "error");
            }
            console.log("erro",erro.status);
          })
    }
     
});
