var time = 30;
var count = 3 * 1000;
dislpayTime();

var timerInterval = setInterval(getExamTimer, count);

function getExamTimer() {
  if (time == 0) {
    dislpayTime();
    clearInterval(timerInterval);
    location.replace("finish/studentDashboard");
  } 
  else {
    dislpayTime();
  }
  time--;
}

function dislpayTime() {
  document.getElementById("examTimer").innerHTML = time;
}
