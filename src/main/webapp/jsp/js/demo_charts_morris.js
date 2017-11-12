var morrisCharts = function() {

    Morris.Line({
      element: 'morris-line-example',
      data: [
        { y: '2006', a: 100, b: 90 },
        { y: '2007', a: 75,  b: 65 },
        { y: '2008', a: 50,  b: 40 },
        { y: '2009', a: 75,  b: 65 },
        { y: '2010', a: 50,  b: 40 },
        { y: '2011', a: 75,  b: 65 },
        { y: '2012', a: 100, b: 90 }
      ],
      xkey: 'y',
      ykeys: ['a', 'b'],
      labels: ['Series A', 'Series B'],
      resize: true,
      lineColors: ['#33414E', '#95B75D']
    });
    function Graph() {
        var data = "";
        $.ajax({
            type: 'POST',
            url: 'Home.aspx/GetPiechartData',
            dataType: 'json',
            async: false,
            contentType: "application/json; charset=utf-8",
            data: {},
            success: function (result) {
                data = result.d;
            },
            error: function (xhr, status, error) {
                alert(error);
            }
        });
 
        return data;
    }

    Morris.Area({
        element: 'morris-area-example',
        data: [
            { y: '2006', a: 100, b: 90 },
            { y: '2007', a: 75,  b: 65 },
            { y: '2008', a: 50,  b: 40 },
            { y: '2009', a: 75,  b: 65 },
            { y: '2010', a: 50,  b: 40 },
            { y: '2011', a: 75,  b: 65 },
            { y: '2012', a: 100, b: 90 }
        ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        resize: true,
        lineColors: ['#1caf9a', '#FEA223']
    });


    Morris.Bar({
        element: 'morris-bar-example',
        data: [
            { y: '2006', a: 100, b: 90 },
            { y: '2007', a: 75,  b: 65 },
            { y: '2008', a: 50,  b: 40 },
            { y: '2009', a: 75,  b: 65 },
            { y: '2010', a: 50,  b: 40 },
            { y: '2011', a: 75,  b: 65 },
            { y: '2012', a: 100, b: 90 }
        ],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        barColors: ['#B64645', '#33414E']
    });


    Morris.Donut({
        element: 'morris-donut-example',
        data: [
            {label: "Download Sales", value: 12},
            {label: "In-Store Sales", value: 30},
            {label: "Mail-Order Sales", value: 20}
        ],
        colors: ['#95B75D', '#1caf9a', '#FEA223']
    });

}();