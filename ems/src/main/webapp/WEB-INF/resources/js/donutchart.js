var ctx = document.getElementById("studentDonutChart");
var myDonutChart = new Chart(ctx, {
	type: "doughnut",
	data: {
		labels: labelArray,
		datasets: [
			{
				data : valueArray,
				backgroundColor : [ "#1e88e5", "#26c6da", "#745af2",
					"#eceff1" ],
			},
			],
	},
	options: {
		cutoutPercentage: 80,
		gridlines: {
			lineWidth: 4,
			lineHeight: 2,
		},
		 legend: {
	            display: true,
                position: 'bottom',
	        }
	},
	plugins: [
		{
			beforeDraw: function (chart) {
				var width = chart.chart.width,
				height = chart.chart.height,
				ctx = chart.chart.ctx;

				ctx.fillStyle = "#a1a3ae";
				ctx.restore();
				ctx.font = "bold 16px 'Mulish', sans-serif";
				ctx.textBaseline = "middle";

				var text = "Pass/Failed",
				textX = Math.round((width - ctx.measureText(text).width) / 2),
				textY = height / 2;

				ctx.fillText(text, textX, textY);
				ctx.save();
			},
		},
		],
});
