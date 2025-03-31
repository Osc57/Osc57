const tablero = document.getElementById("tablero");
const status = document.getElementById("status");
let celdas = [];
let jugador = "X";
let boardState = ["", "", "", "", "", "", "", "", ""];

function crearTablero() {
  tablero.innerHTML = "";
  boardState = ["", "", "", "", "", "", "", "", ""];
  jugador = "X";
  status.textContent = "Turno de: " + jugador;
  for (let i = 0; i < 9; i++) {
    let celda = document.createElement("div");
    celda.classList.add("btn", "btn-outline-dark", "d-flex", "align-items-center", "justify-content-center");
    celda.style.width = "100px";
    celda.style.height = "100px";
    celda.style.fontSize = "2rem";
    celda.dataset.index = i;
    celda.addEventListener("click", comprobarMovimiento);
    tablero.appendChild(celda);
    celdas[i] = celda;
  }
}

function comprobarMovimiento(movimiento) {
  let indice = movimiento.target.dataset.index;
  if (boardState[indice] === "") {
    boardState[indice] = jugador;
    movimiento.target.textContent = jugador;
    if (combrobarGanador()) {
      status.textContent = "Ganador: " + jugador;
      desactivarTablero();
      return;
    }
    jugador = jugador === "X" ? "O" : "X";
    status.textContent = "Turno de: " + jugador;
  }
}

function combrobarGanador() {
  const combosGanadores = [
    [0, 1, 2], [3, 4, 5], [6, 7, 8],
    [0, 3, 6], [1, 4, 7], [2, 5, 8],
    [0, 4, 8], [2, 4, 6]
  ];
  return combosGanadores.some(combo => {
    const [a, b, c] = combo;
    return boardState[a] && boardState[a] === boardState[b] && boardState[a] === boardState[c];
  });
}

function desactivarTablero() {
  celdas.forEach(celda => celda.removeEventListener("click", handleMove));
}

function reiniciarJuego() {
  crearTablero();
}

crearTablero();
