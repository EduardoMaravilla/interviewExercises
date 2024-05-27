function clickCommandsL() {
  appendCommand("L");
}

function clickCommandsM() {
  appendCommand("M");
}

function clickCommandsR() {
  appendCommand("R");
}

function appendCommand(command) {
  const textarea = document.getElementById("commans-area");
  textarea.value += command;
}

function clearAllCommands() {
  const textarea = document.getElementById("commans-area");
  textarea.value = "";
}

function undoLastCommand() {
  const textarea = document.getElementById("commans-area");
  textarea.value = textarea.value.slice(0, -1);
}


