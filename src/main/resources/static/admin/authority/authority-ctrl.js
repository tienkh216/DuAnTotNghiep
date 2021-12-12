app.controller("authority-ctrl", function($scope, $http, $rootScope) {
  $scope.roles=[];
  $scope.admins=[];
  $scope.authorities=[];

  $scope.authority_of=function(acc,role){
      if($scope.authorities){
          return $scope.authorities.find(ur => ur.account.username  == acc.username && ur.role.id == role.id);
      }
  }

  $scope.authority_changed=function(acc,role){
      var authority=$scope.authority_of(acc, role);
      if(authority){
          $scope.revoke_authority(authority)
      }else{
          authority={account:acc,role:role};
          $scope.grant_authority(authority)
      }
  }
  $scope.grant_authority=function(authority){
      $http.post(`/rest/authorities`,authority).then(resp=>{
          $scope.authorities.push(resp.data);
          swal("Ok", " Thành Công", "success");
         
      }).catch(error=>{
        swal("Erro", "Thất Bại", "error");
          console.log("error",error);
      })
  }
  $scope.revoke_authority=function(authority){
      $http.delete(`/rest/authorities/${authority.id}`).then(resp=>{
          var index=$scope.authorities.findIndex(a=>a.id==authority.id);
          $scope.authorities.splice(index, 1);
          swal("Ok", " Thành Công", "success");
         
      }).catch(error=>{
        swal("Erro", "Thất Bại", "error");
          console.log("error",error);
      })
  }
  $scope.initialize=function(){
      $http.get("/rest/roles").then(resp=>{
          $scope.roles=resp.data;
       
      })
      $http.get("/rest/accounts?admin=true").then(resp=>{
          $scope.admins=resp.data;
      })
      $http.get("/rest/authorities?admin=true").then(resp=>{
          $scope.authorities=resp.data;
      }).catch(erro =>{
          console.log(erro.status);
        if(erro.status = 403 || erro.status == 401){
            swal("Erro", "Không có quyền ", "error");
        }
    })

  }
  $scope.initialize();
      
  $scope.pager={
    page:0,
    size: 5,
    get admins(){
      var start =this.page * this.size;
      return $scope.admins.slice(start, start + this.size);
    },
    count(){
      return Math.ceil(1.0 * $scope.admins.length/this.size);
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
  