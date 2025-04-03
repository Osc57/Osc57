const tablero = document.getElementById("tablero");
const status = document.getElementById("status");
let celdas = [];
let jugador = "X";
let estadoTablero = ["", "", "", "", "", "", "", "", ""];

function crearTablero() {
  tablero.innerHTML = "";
  estadoTablero = ["", "", "", "", "", "", "", "", ""];
  jugador = "X";
  status.textContent = "Turno de: " + jugador;
  for (let i = 0; i < 9; i++) {
    let celda = document.createElement("div");
    celda.style.width = "100px";
    celda.style.height = "100px";
    celda.style.fontSize = "5rem";
    celda.style.border = "2px solid black";
    celda.style.display = "flex";
    celda.style.alignItems = "center";
    celda.style.justifyContent = "center";
    celda.style.cursor = "pointer";
    celda.dataset.index = i;
    celda.addEventListener("click", comprobarMovimiento);
    tablero.appendChild(celda);
    celdas[i] = celda;
  }
}

function comprobarMovimiento(movimiento) {
  let indice = movimiento.target.dataset.index;
  if (estadoTablero[indice] === "") {
    estadoTablero[indice] = jugador;
    movimiento.target.textContent = jugador;

    if (jugador === "O") {
      movimiento.target.style.color = "red";
    } else {
      movimiento.target.style.color = "black";
    }

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
    return estadoTablero[a] && estadoTablero[a] === estadoTablero[b] && estadoTablero[a] === estadoTablero[c];
  });
}

function desactivarTablero() {
  celdas.forEach(celda => celda.removeEventListener("click", handleMove));
}

function reiniciarJuego() {
  crearTablero();
}

crearTablero();
