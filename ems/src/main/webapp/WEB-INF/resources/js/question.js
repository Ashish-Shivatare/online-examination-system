var type = "text";
var name = "option";
var queOption = "questionOption";
var correctAns = "correctAnswer";
var id;
var answerButton;
var ca = document.getElementsByName("correctAnswer");
var ab = document.getElementsByName("answerButton");

for (var i = 0; i < ca.length; i++) {
	id = parseInt(ca[i].value) + 1;
}

for (var j = 0; j < ab.length; j++) {
	if(ab[j].checked){
		answerButton = ab[j].value;
	}
}

function getAnswerButton(values){
	this.answerButton = values;
	for (var k = 0; k < ca.length; k++) {
		ca[k].type = values;
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
	correctOption.id = correctAns + id;
	correctOption.className = "form-check-input";
	correctOption.value = id;
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

document.getElementById("deleteOption").onclick = function() {
	var dd = document.getElementsByName("questionOption");
	if(dd.length > 2){
		var option = document.getElementById("option"+dd.length);
		option.remove();
		id--;
	}
};

