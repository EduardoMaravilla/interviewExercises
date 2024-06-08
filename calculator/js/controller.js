//Value of the button on calculator
function addValue(value) {
    if (document.getElementById('display').value === '0') {
        document.getElementById('display').value = value;
    } else {
        document.getElementById('display').value += value;
    }    
}

function clearDisplay() {
    document.getElementById('display').value = '';
}

function eraseDisplay() {
    let display = document.getElementById('display').value;
    display = display.substring(0, display.length - 1);
    document.getElementById('display').value = display;
}

function calculate() {
    let display = document.getElementById('display').value;
    let result = eval(display);
    document.getElementById('display').value = result;
}