app.controller("product-ctrl", function($scope, $http, $rootScope) {
    $scope.items = [];
    $scope.form = {};
    $scope.cates = [];
    $scope.query = {}
    $scope.queryBy = '$'
    $scope.status = [];

    
    
    $scope.close = function(){
        $('#exampleModalCenter').modal('hide');
    }
    $scope.initialize = function(){
       $http.get("/rest/products").then(resp=>{
          $scope.items = resp.data;
          $scope.items.forEach(item =>{
             item.createdate = new Date(item.createdate)
          });
       });
    $http.get("/rest/categories").then(resp=>{
       $scope.cates = resp.data;
    })
    $http.get("/rest/products/status").then(resp=>{
      $scope.status = resp.data;
    })
       
    }

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
    $scope.create =  function(){
      var item = angular.copy($scope.form);
      $http.post(`/rest/products`,item).then(resp=>{
          resp.data.createDate =  new Date(resp.data.createDate);
          $scope.items.push(resp.data);
          $scope.reset();
          $scope.close();
          $scope.initialize();
          swal("Ok", "Tạo Thành Công", "success");

      })
      .catch(erro =>{
        if(erro.status = 403 || erro.status == 401){
          swal("Erro", "Không Có Quyền Thêm Sản Phẩm", "error");
        }
        else{
          swal("Erro", "Tạo Thất Bại", "error");
        }
        console.log("erro",erro.status);
      })
   }
    $scope.update =  function(){
      var item = angular.copy($scope.form);
      $http.put(`/rest/products/${item.id}`,item).then(resp=>{
          var index = $scope.items.findIndex(p => p.id == item.id);
          $scope.items[index] = item;
          $scope.close();
          $scope.initialize();
          swal("Ok", "Cập Nhật Thành Công", "success");
         
      })
      .catch(erro =>{
        if(erro.status = 403 || erro.status == 401){
          swal("Erro", "Không Có Quyền Sửa", "error");
          $scope.close();
        }
        else{
          swal("Erro", "Cập Nhật Thất Bại", "error");
        }
        console.log("erro",erro.status);
      })
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
            $http.delete(`/rest/products/${item}`).then(resp=>{
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
          createDate : new Date (),
          image : '',
          available : true
      }
    }
    $scope.pager={
          page:0,
          size: 10,
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
  
 $scope.initialize();
});
