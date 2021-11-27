app = angular.module("admin-app",["ngRoute"]);
app.config(function($routeProvider){
    $routeProvider
    .when("/product",{
        templateUrl:"/admin/product/index.html",
        controller:"product-ctrl"
    })
    .when("/category",{
        templateUrl:"/admin/category/index.html",
        controller:"category-ctrl"
    })
    .when("/order",{
        templateUrl:"/admin/order/index.html",
        controller:"order-ctrl"
    })
    .when("/customer",{
        templateUrl:"/admin/accounts/index.html",
        controller:"accounts-ctrl"
    })
    .when("/chart",{
        templateUrl:"/admin/chart/index.html",
        controller:"chart-ctrl"
    })
    .otherwise({
        template  : "<h1> FPT POLYTECHNIC </h1>"
    })
})