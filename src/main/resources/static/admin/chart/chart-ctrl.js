app.controller("chart-ctrl", function($scope, $http, $rootScope) {
    $scope.chartProduct =function(){
        var xValues = ["S.A.N Mass Effect Revolution", "Super Huge Gain - MASS Evogen", "Labrada Muscle Mass", "RSP TrueGain - Tăng cân hạn chế mỡ", "ISOJECT Premium EVOGEN - Whey Isolate"];
        var yValues = [55, 49, 44, 24, 15];
        var barColors = [
        "#b91d47",
        "#00aba9",
        "#2b5797",
        "#e8c3b9",
        "#1e7145"
        ];
        new Chart("myChart", {
        type: "pie",
        data: {
            labels: xValues,
            datasets: [{
            backgroundColor: barColors,
            data: yValues
            }]
        },
        options: {
            title: {
            display: true,
            text: "Biểu đồ tổng giá trị sản phẩm hoàn thành theo tháng"
            }
        }
        });
    }
    $scope.charOrder = function(){
        var xValues = ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"];
        var yValues = [46, 49, 44, 24, 15,12,46, 49, 44, 24, 15,12,16];
        var barColors = ["red", "green","blue","orange","brown","red", "green","blue","orange","brown"];
    
        new Chart("peopleChart", {
        type: "bar",
        data: {
            labels: xValues,
            datasets: [{
            backgroundColor: barColors,
            data: yValues
            }]
        },
        options: {
            legend: {display: false},
            title: {
            display: true,
            text: "Biểu đồ đánh giá khách hàng theo từng vị trí"
            }
        }
        });
    }
    $scope.chartProduct();
    $scope.charOrder();


   
});

