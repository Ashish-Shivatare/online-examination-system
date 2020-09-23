var barChartData = {
		labels: labelArray,
		datasets: [
			{
				borderColor: "rgba(116,90,242, 0.8)",
				borderWidth: 1.5,
				backgroundColor: "rgba(30,136,229, 0.4)",
				data: passValueArray,
			},
			{
				borderColor: "rgba(38,198,218, 0.8)",
				borderWidth: 1.5,
				backgroundColor: "rgba(38,198,218, 0.4)",
				data: failedValueArray,
			},
			{
				borderColor: "rgba(116,90,242, 0.8)",
				borderWidth: 1.5,
				backgroundColor: "rgba(116,90,242, 0.4)",
				data: totalValueArray,
			},
			],
};

var ctx = document.getElementById("studentBarChart");
var canvas = new Chart(ctx, {
	type: "bar",
	data: barChartData,
	options: {
		responsive: true,
		legend: {
			display: false,
		},
		maintainAspectRatio: false,
		layout: {
			padding: {
				top: 30,
				bottom: 0,
				left: 0,
				right: 40,
			},
		},
		title: {
			display: false,
		},
		tooltips: {
			mode: "index",
			intersect: false,
		},
		responsive: true,
		scales: {
			x: {
				stacked: true,
			},
			y: {
				stacked: true,
			},
			xAxes: [
				{
					ticks: {
						fontColor: 'black',
						fontSize: 40,
						padding: 10,
						
					},
					gridLines: {
						drawBorder: false,
						color: "rgb(221, 221, 221)",
						zeroLineColor: "rgb(221, 221, 221)",
						 borderDash: [2],
						 zeroLineBorderDash: [2],
						tickMarkLength: 0,
					},
				},
				],
				yAxes: [
					{
						ticks: {
							fontColor: "#a1a3ae",
							padding: 10,
							beginAtZero: true,
							stepSize: 200,
							callback: function (value, index, values) {
								if (parseInt(value) >= 1000) {
			                           return value + 'k' ;
			                           } else {
			                        return value;
			                         }
							},
						},
						gridLines: {
							drawBorder: false,
							color: "rgb(221, 221, 221)",
							zeroLineColor: "rgb(221, 221, 221)",
							 borderDash: [2],
							 zeroLineBorderDash: [2],
							tickMarkLength: 0,
						},
					},
					],
		},
	},
});
