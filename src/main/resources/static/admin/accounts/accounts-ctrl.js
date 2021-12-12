app.controller("accounts-ctrl", function($scope, $http, $rootScope) {
    $scope.items = [];
    $scope.form = {};
    $scope.initialize = function(){
        $http.get("/rest/accounts").then(resp =>{
            $scope.items = resp.data;
        }).catch(erro =>{
            if(erro.status = 403 || erro.status == 401){
                swal("Erro", "Không có quyền ", "error");
              }
        })
    };
    $scope.close = function(){
        $('#exampleModalCenter').modal('hide');
    }
    $scope.create =  function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/accounts`,item).then(resp=>{
            $scope.items.push(resp.data);
            $scope.reset();
            $scope.close();
            swal("Ok", "Tạo Thành Công", "success");
        })
        .catch(erro =>{
            swal("Erro", "Cập Nhật Thất Bại", "error");
            console.log(erro);
        })
     }
    $scope.initialize();
    $scope.edit = function(item){
        $scope.form = angular.copy(item);
    }
    $scope.imageChanged = function(files){
        var data  = new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/images',data,{
            transformRequest : angular.identity,
            headers:{'Content-Type' : undefined}
        }).then(resp =>{
            $scope.form.image = resp.data.name;
        }).catch(erro =>{
            alert("Lỗi Upload Hình Ảnh");
            console.log("Erro","erro");
        })
      }
    $scope.update =  function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/accounts/${item.username}`,item).then(resp=>{
            var index = $scope.items.findIndex(p => p.username == item.username);
            $scope.items[index] = item;
            $scope.close();
            $scope.initialize();
            swal("Ok", "Cập Nhật Thành Công", "success");
        })
        .catch(erro =>{
            swal("Erro", "Cập Nhật Thất Bại", "error");
            console.log("erro",erro);
        })
    }

    $scope.reset = function(){
        $scope.form = {
            image : ''
        }
    }
    $scope.delete =  function(item){
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
                $http.delete(`/rest/accounts/${item}`).then(resp=>{
                    var index = $scope.items.findIndex(p => p.id == item);
                    $scope.items.splice(index,1);
                    $scope.reset();
                    $scope.initialize();
                    swal("Ok", "Xóa Thành Công", "success");
                })
                 .catch(erro =>{
                    swal("Erro", "Xóa Thất Bại", "error");
                    console.log("erro",erro);
                 })
            } else {
              swal("Hủy");
            }
        });
    }

    $scope.pager={
        page:0,
        size: 5,
        get items(){
          var start =this.page * this.size;
          return $scope.items.slice(start, start + this.size);
        },
        count(){
          return Math.ceil(1.0 * $scope.items.length/this.size);
        },
        first(){
          this.page=0
        },
        prev(){
          this.page--;
          if(this.page<0){
              this.last();
          }
        }, 
          next(){
          this.page++;
          if(this.page>=count()){
              this.first();
          }
        },
        last(){
            this.page=this.count()-1;
        }
        
  }  
});
