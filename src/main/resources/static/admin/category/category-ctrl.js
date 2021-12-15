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
            swal("Ok", "Cập Nhật Thành Công", "success");
        })
        .catch(erro =>{
            if(erro.status = 403 || erro.status == 401){
              swal("Erro", "Không có quyền sửa", "error");
              $scope.close();
            }
            else{
              swal("Erro", "Cập Nhật Thất Bại", "error");
            }
            console.log("erro",erro.status);
          })
    }
     
    $scope.delete = function(item){
        swal({
            title: "Bạn Có Chắc",
            text: "Bạn Có Muốn Xóa Không ?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
          })
          .then((willDelete) => {
            if (willDelete) {
              swal("Bạn Có Muốn Xóa Không ?", {
                icon: "success",
              });
              $http.delete(`/rest/categories/${item}`).then(resp=>{
                    var index = $scope.items.findIndex(p => p.id == item);
                    $scope.items.splice(index,1);
                    $scope.reset();
                    $scope.initialize();
                    swal("Ok", "Xóa Thành Công", "success");
                  })
                .catch(erro =>{
                    if(erro.status = 403 || erro.status == 401){
                      swal("Erro", "Không có quyền xóa", "error");
                    }
                    else{
                      swal("Erro", "Xóa Thất Bại", "error");
                    }
                    console.log("erro",erro.status);
                })
            } else {
              swal("Hủy");
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
