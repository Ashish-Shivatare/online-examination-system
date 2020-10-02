var type = "text";
var name = "option";
var queOption = "questionOption";
var correctAns = "correctAnswer";
var id = 3;
var answerButton = "radio";
var ca = document.getElementsByName("correctAnswer");
var i;

function getAnswerButton(value){
	this.answerButton = value;
	for (i = 0; i < ca.length; i++) {
		ca[i].type = value;
	}
}

function add(type, id, name) {
	var addOption = document.createElement("input");
	var correctOption = document.createElement("input");
	var label = document.createElement("label");

	addOption.type = type;
	addOption.name = queOption;
	addOption.id = name + id;
	addOption.placeholder = name + " " + id;
	addOption.className = "form-control";		
	correctOption.type = answerButton;
	correctOption.name = correctAns;
	correctOption.id = addOption.id;
	correctOption.className = "form-check-input";
	correctOption.value = id;
	correctOption.setAttribute("onclick","getCorrectAnswer()");
	label.id = id;
	label.innerHTML = id;
	label.className = "form-check-label";

	var options = document.getElementById("options");
	var correctAnswer = document.getElementById("correctAns");

	options.appendChild(addOption);
	correctAnswer.appendChild(correctOption);
	correctAnswer.appendChild(label);
}

document.getElementById("addOption").onclick = function() {
	add(type, id, name);
	id = id + 1;
};