var queCount = 1;
var questionId = queId;	
var questionType = queType;

$(document).ready(function() {
	$('#nextButton').click(function() {
		var answerData = {};
		var selectedAnswer = new Array();
		var allOptions = new Array();
		var answerButton = $('input[name="selectedAnswer"]').attr('type');

		answerData["question"] = $('#question').html();
		$('input[name="selectedAnswer"]:checked').each(function() {
				selectedAnswer.push($(this).val());
		});
		$('#allOptions label').each(function() {
			allOptions.push($(this).text());
		});
		answerData["selectedAnswer"] = selectedAnswer;
		answerData["questionId"] = questionId;
		answerData["allOptions"] = allOptions;
		answerData["answerButton"] = answerButton;
		answerData["questionType"] = queType;

		queCount++;
		
		if(queCount == 31){
			location.replace("finish/studentDashboard");
		}
		else{
			$.ajax({
				type : 'POST',
				contentType: 'application/json',
				url : 'exam/question',
				data: JSON.stringify(answerData),
				dataType: 'json',
				success : function(data) {
					var count = 1;
					var que = "";
					$('#allOptions label').remove();
					$('#questionNumber').html(queCount);
					$('#showQuestionNo').html(queCount);

					questionId = data.id;
					questionType = data.questionType;

					$('#question').html(data.question);
					$.each(data.questionOption, function (key, value) { 
						que += '<label><input type="'+data.answerButton+'" name="selectedAnswer" value="'+count+'" /><span class="'+data.answerButton+'"></span>'+value+'</label></br>';
						count++;
					});
					$('#allOptions').html(que);
					console.log(questionId);
				}	
			});
		} 
	});
});