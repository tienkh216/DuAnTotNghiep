const app=angular.module("app",[]);

app.controller("ctrl",function($scope,$http){




    $scope.tinhTongtien = function()
    {
        var tongTien = 0;
        for(var i =0;i<$scope.cart.items.length;i++)
        {
        
            tongTien += $scope.cart.items[i].price * $scope.cart.items[i].qty;

          
        }
        return tongTien;
    }




    //QUẢN LÝ GIỎ HÀNG
    $scope.cart={
        items:[],
        //Thêm sản phẩm vào giỏ hàng
        add(id){
            var item = this.items.find(item => item.id ==id);
            if(item){
                     // item.replace(/[^0-9]/g, '');
                     //    ngModelCtrl.$setViewValue(item);
                     //    ngModelCtrl.$render();
                item.qty++;
                this.saveToLocalStorage();
            }else{
                $http.get(`/client/products/${id}`).then(resp =>{
                    resp.data.qty =1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        //Xóa sản phẩm khỏi giỏ hàng
        remove(id){
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },
        //Xóa sạch các mặt hàng trong giỏ
        clear(){
            this.items=[];
            this.saveToLocalStorage();
        },


        //Tính thành tiền của một sản phẩm
        amt_of(item){},


        //Tính tổng số lượng các mặt hàng trong giỏ
        get count(){
            return this.items
            .map(item => item.qty)
            .reduce((total,qty) => total += qty,0);
        },

        //Tổng thành tiền các mặt hàng trong giỏ
        get amout(){
            return this.items
            .map(item => item.qty * item.price)
            .reduce((total,qty) => total += qty,0);
        },

        //Lưu giỏ hàng vào local storage
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },

        //Đọc giỏ hàng từ local storage
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) :[];
        }

    }

    $scope.cart.loadFromLocalStorage();

	$(document).on('focus','.select',function(){
        console.log($(this).data('check'));

    });




    // $(".select").on('click', function() {
    //     //  ret = DetailsView.GetProject($(this).attr("#data-id"), OnComplete, OnTimeOut, OnError);
    //     alert($(this).attr("data-selected"));
    // });







    function initGetData()
    {

        var countries = [];

        var specific_address = jQuery("#user_address").val();
        countries.push(specific_address);


        $.each($(".ls_ward option:selected"), function(){
            countries.push($(this).text());
        });

        $.each($(".ls_district option:selected"), function(){
            countries.push($(this).text());
        });
        $.each($(".ls_province option:selected"), function(){
            countries.push($(this).text());
        });

        $scope.address = countries.join("  ").toString();

        var notes = jQuery("textarea#note").val();

        $scope.note = notes;


        var pay ;
        $.each($('input[name="content"]:checked'), function(){
            pay = $(this).val();
        });




        $scope.payM = parseInt(pay);




        $scope.listOrder = {


            createDate: new Date(),
            address: $scope.address,
            notes: $scope.note = jQuery("textarea#note").val(),
            orderStatus: {id: 1},
            phone: $("#phone").val().toString(),
            name: $("#name").val().toString(),
            paymentMethod: {id:$scope.payM},
            account: {
                username: $("#username").text(),
            },


            get orderDetails() {
                return $scope.cart.items.map(item => {
                    return {
                        product: {id: item.id},
                        price: item.price,
                        quantity: item.qty
                    }
                });
            }
        }
        console.log("lấy data thành công");



    }

    // $(document).ready(function() {
    //     $(".place-order").click(function(){
    //
    //
    //
    //     });
    // });
    //



    $scope.order ={
        createDate: new Date(),


         purchase(){
             initGetData();
            var order = angular.copy($scope.listOrder);
       debugger
            //Thực hiện đặt hàng
            $http.post("/test/checkout",order).then(resp =>{
                alert("Đặt hàng thành công!");
                $scope.cart.clear();
                location.href="/client/order/orderDetail/" + resp.data.id;
            }).catch(error =>{
                alert("Đặt hàng lỗi")
                console.log(error)
            })
         }
     }
});
