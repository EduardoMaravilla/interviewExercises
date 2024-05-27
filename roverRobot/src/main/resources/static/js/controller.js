const URL_SERVER = "http://localhost:8080/api";

async function getObstacles() {
  const response = await fetch(URL_SERVER + "/obstacles");
  return await response.json();
}

async function createMap() {
  const obstacles = await getObstacles();
  obstacles.forEach((obstacle) => {
    createObstacle(obstacle.x, obstacle.y);
  });
}
async function updateRoverRobot() {
  let robot = {
    x: posX,
    y: posY,
    direction: position,
  };
  let config = {
    method: "PUT",
    body: JSON.stringify(robot),
    headers: {
      "Content-Type": "application/json",
    }
  };
  await fetch(URL_SERVER + "/rover", config);
  getRoverPosition();
}
async function getRoverPosition() {
  const response = await fetch(URL_SERVER + "/rover");
  let rover = await response.json();
  posX = rover.x;
  posY = rover.y;
  position = rover.direction;
  moveRover(posX, posY);
  rotate(position);
}

const Direction = {
  NORTH: "NORTH",
  EAST: "EAST",
  SOUTH: "SOUTH",
  WEST: "WEST",
};

const rotationMap = {
  [Direction.NORTH]: "rotate(270deg)",
  [Direction.EAST]: "rotate(0deg)",
  [Direction.SOUTH]: "rotate(90deg)",
  [Direction.WEST]: "scaleX(-1)",
};

let posX = 0;
let posY = 0;
let position = Direction.EAST;

function moveRover(x, y) {
  x = Math.max(0, Math.min(18, x));
  y = Math.max(0, Math.min(18, y));
  const rover = document.getElementById("rover-robot");
  rover.style.top = y * 100 + 1 + "px";
  rover.style.left = x * 100 + 1 + "px";
}

function createObstacle(x, y) {
  const obstacle = document.createElement("img");
  obstacle.src = "images/obstacle.png";
  obstacle.className = "obstacle-robot";
  const container = document.getElementById("container");
  container.appendChild(obstacle);
  obstacle.style.top = y * 100 + 1 + "px";
  obstacle.style.left = x * 100 + 1 + "px";
}

function move(direction) {
  switch (direction) {
    case Direction.NORTH:
      posY--;
      break;
    case Direction.EAST:
      posX++;
      break;
    case Direction.SOUTH:
      posY++;
      break;
    case Direction.WEST:
      posX--;
      break;
  }
  if (posX < 0) {
    posX = 0;
  }
  if (posY < 0) {
    posY = 0;
  }
  if (posX > 18) {
    posX = 18;
  }
  if (posY > 8) {
    posY = 8;
  }
}

function moveForward() {
  move(position);
  updateRoverRobot();
  playMoveSound();
}

function moveBack() {
  switch (position) {
    case Direction.NORTH:
      move(Direction.SOUTH);
      break;
    case Direction.EAST:
      move(Direction.WEST);
      break;
    case Direction.SOUTH:
      move(Direction.NORTH);
      break;
    case Direction.WEST:
      move(Direction.EAST);
      break;
  }
  updateRoverRobot();
  playMoveSound();
}

function rotate(direction) {
  const rover = document.getElementById("rover-robot");
  rover.style.transform = rotationMap[direction];
  position = direction;
}

function rotateLeft() {
  switch (position) {
    case Direction.NORTH:
      position = Direction.WEST;
      break;
    case Direction.EAST:
      position = Direction.NORTH;
      break;
    case Direction.SOUTH:
      position = Direction.EAST;
      break;
    case Direction.WEST:
      position = Direction.SOUTH;
      break;
  }
  updateRoverRobot();
  playMoveSound();
}

function rotateRight() {
  switch (position) {
    case Direction.NORTH:
      position = Direction.EAST;
      break;
    case Direction.EAST:
      position = Direction.SOUTH;
      break;
    case Direction.SOUTH:
      position = Direction.WEST;
      break;
    case Direction.WEST:
      position = Direction.NORTH;
      break;
  }
  updateRoverRobot();
  playMoveSound();
}
function playMoveSound() {
  const audioElement = new Audio("sounds/robot-moving.wav");
  audioElement.currentTime = 0;
  audioElement.volume = 0.1;
  audioElement.play();
  setTimeout(() => {
    audioElement.volume = 0.1;
    audioElement.pause();
    audioElement.currentTime = 0;
  }, 500);
}
createMap();
getRoverPosition();

async function executeCommands() {
  let commands = document
    .getElementById("commans-area")
    .value.trim()
    .toUpperCase();
   let newCommands = await getNewCommands(commands);
   commands = newCommands.commands;
   document.getElementById("commans-area").value = commands;
  for (let i = 0; i < commands.length; i++) {
    const command = commands[i];
    switch (command) {
      case "M":
       moveForward();
        break;
      case "L":
        rotateLeft();
        break;
      case "R":
        rotateRight();
        break;
      default:
        break;
    }
    await sleep(700);
  }
}

async function sleep(t){
  await new Promise(resolve => setTimeout(resolve, t));
}  

async function getNewCommands(commandsMove) {
  let commands = {
    "commands": commandsMove
  }
  let config = {
    method: "POST",
    body: JSON.stringify(commands),
    headers: {
      "Content-Type": "application/json",
    }
  };
  const response = await fetch(URL_SERVER + "/rover/commands", config);
  return await response.json();
}