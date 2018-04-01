$( document ).ready(() => {

    document.addEventListener("initJS", event => {
        if(event.detail.menuId == 'reports') {

            let data = {
                'Продукт 1': [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
                'Продукт 2': [0, 5, 1, 6, 12, 46, 120, 156, 216, 329, 412, 519],
                'Продукт 3': [40, 56, 51, 62, 39, 48, 51, 45, 63, 61, 56, 54],
                'Продукт 4': [322, 241, 196, 152, 120, 93, 64, 25, 87, 171, 264, 301],
                'Продукт 5': [5, 8, 3, 4, 7, 5, 6, 2, 7, 4, 2, 1]
            };

            let chartData = data[$('.jsSelectSoldProduct').val()];


            let chart = Highcharts.chart('sold-items', {
                title: {
                    text: 'Статистика продажу'
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                },
                yAxis: {
                    title: {
                        text: 'Кількість проданих одиниць'
                    }
                },
                series: [{
                    data: chartData,
                    type: 'column'
                }]
            });

            $('.jsSelectSoldProduct').change(function() {
                chart.series[0].setData(data[$('.jsSelectSoldProduct').val()]);
            });

        }
    });





});