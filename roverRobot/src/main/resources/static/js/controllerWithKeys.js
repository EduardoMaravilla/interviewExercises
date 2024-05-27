document.addEventListener('DOMContentLoaded', (event) => {
  const rover = document.getElementById("rover-robot");
  let posX = 50;
  let posY = 50;
  const moveStep = 20;

  document.addEventListener("keydown", (event) => {
    switch (event.key) {
      case "ArrowUp":
        posY -= moveStep;
        break;
      case "ArrowDown":
        posY += moveStep;
        break;
      case "ArrowLeft":
        posX -= moveStep;
        break;
      case "ArrowRight":
        posX += moveStep;
        break;      
    }
    posX = Math.max(0, Math.min(window.innerWidth - rover.width, posX));
    posY = Math.max(0, Math.min(window.innerHeight - rover.height, posY));
    rover.style.left = posX + "px";
    rover.style.top = posY + "px";
  });
});
