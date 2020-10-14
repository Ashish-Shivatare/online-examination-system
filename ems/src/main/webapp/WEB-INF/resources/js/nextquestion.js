var queCount = 1;
var questionId = queId;

$(document).ready(function() {
	$('#nextButton').click(function() {
		var answerData = {};
		var selectedAnswer = new Array();
		answerData["question"] = $('#question').html();
		$('input[name="selectedAnswer"]:checked').each(function() {
			selectedAnswer.push($(this).val());
		});
		answerData["selectedAnswer"] = selectedAnswer;
		answerData["questionId"] = questionId;
		console.log(questionId);

		queCount++;
		if(queCount == 31){
			location.replace("finish/studentDashboard");
		}

		$.ajax({
			type : 'POST',
			contentType: 'application/json',
			url : 'exam/question',
			data: JSON.stringify(answerData),
			dataType: 'json',
			success : function(data) {
				var count = 1;
				var que = "";
				$('#allOptions label').empty();
				$('#questionNumber').html(queCount);
				questionId = data.id;
				$('#question').html(data.question);
				$.each(data.questionOption, function (key, value) { 
					que += '<label><input type="'+data.answerButton+'" name="selectedAnswer" value="'+count+'" /><span class="'+data.answerButton+'"></span>'+value+'</label></br>';
					count++;
				});
				$('#allOptions').html(que);
			}	
		});  

	});
});