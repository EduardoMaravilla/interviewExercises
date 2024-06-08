const CONFIG_URL = "http://localhost:8080/api";

let randomN = 0;
let attempts = 3;
async function getRandomNumberServer() {
  const resp = await fetch(CONFIG_URL + "/randomNumber");
  return await resp.json();
}
async function getRandomNumber() {
  let randomNumber = await getRandomNumberServer();
  if (randomN === 0) {
    randomN = randomNumber.randomNumber;
  }
}
getRandomNumber();

function checkTheNumber() {
  let number = parseInt(document.getElementById("guess-input").value);

  if (isNaN(number) || number > 10 || number < 0) {
    document.getElementById("tip-guess-id").innerHTML =
      "Please enter a valid number.";
      document.getElementById("guess-input").value = ''; 
    return;
  }

  if (isRandomNumber(number)) {
    document.getElementById("guessed-number-container").style.display = "flex";
    document.getElementById("number-guess").innerHTML = number;
    document.getElementById("guess-input").disabled = true;
    document.getElementById("guess-button").disabled = true;
  } else {
    attempts--;
    if (attempts === 0) {
      document.getElementById("guessed-number-container-fail").style.display =
        "flex";
      document.getElementById("number-guess-fail").innerHTML = randomN;
      document.getElementById("guess-input").disabled = true;
      document.getElementById("guess-button").disabled = true;      
    }
    document.getElementById("tip-guess-id").innerHTML = `The number is ${
      randomN > number ? "higher" : "lower"
    } (Attempts: ${attempts})`;
    document.getElementById("guess-input").value = ''; 
  }
}

function isRandomNumber(number) {
  return number === randomN;
}

function resetGame() {
  location.reload();
}

async function sleep(t){
  await new Promise(resolve => setTimeout(resolve, t));
}  
