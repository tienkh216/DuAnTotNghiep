app.controller("product-ctrl", function($scope, $http, $rootScope) {
	  $scope.items = [];
	  $scope.form = {};
      $scope.cates = [];
      $scope.query = {}
      $scope.queryBy = '$'
      
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
            alert("Loi upload hinh anh");
            console.log("Erro","erro");
        })
      }
      $scope.create =  function(){
        var item = angular.copy($scope.form);
        $http.post(`/rest/products`,item).then(resp=>{
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
      $scope.update =  function(){
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`,item).then(resp=>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert('Cập nhật thành công')
        })
        .catch(erro =>{
            alert("Cập nhật thất bại");
            console.log("erro",erro);
        })
      }
      $scope.delete =  function(item){
        $http.delete(`/rest/products/${item.id}`).then(resp=>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert('Xóa thành công')
        })
        .catch(erro =>{
            alert("Xóa thất bại");
            console.log("erro",erro);
        })
   	 }
   	 $scope.reset = function(){
        $scope.form = {
            createDate : new Date (),
            image : '',
            available : true
        };
    }  
   $scope.initialize();
  
});
