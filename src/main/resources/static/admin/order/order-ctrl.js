app.controller("order-ctrl", function($scope, $http, $rootScope) {
   $scope.items = [];
   $scope.form = {};
   $scope.status = [];

   $scope.close = function(){
    $('#exampleModalCenter').modal('hide');
   }
   $scope.initialize = function(){
    $http.get("/rest/orders").then(resp=>{
       $scope.items = resp.data;
       $scope.items.forEach(item =>{
          item.createDate = new Date(item.createDate)
       });
    });
    $http.get("/rest/orders/status").then(resp=>{
        $scope.status = resp.data;
    })
   }

   $scope.edit = function(item){
    $scope.form = angular.copy(item);
   }

   $scope.update =  function(){
    var item = angular.copy($scope.form);
    $http.put(`/rest/orders/${item.id}`,item).then(resp=>{
        var index = $scope.items.findIndex(p => p.id == item.id);
        $scope.items[index] = item;
        $scope.close();
        $scope.initialize();
        swal("Ok", "Successful Update", "success");
        
    })
    .catch(erro =>{
        swal("Erro", "Update Failed", "error");
        console.log("erro",erro);
    })
   }
   $scope.delete =  function(item){
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
          $http.delete(`/rest/orders/${item.id}`).then(resp=>{
                var index = $scope.items.findIndex(p => p.id == item.id);
                $scope.items.splice(index,1);
                $scope.close();
                $scope.initialize();
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
   $scope.initialize();
    
});
