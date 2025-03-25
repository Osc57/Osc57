// Variables globales
let gameBoard = ['', '', '', '', '', '', '', '', ''];
let currentPlayer = 'X';
let gameOver = false;

// Obtener las celdas del tablero
const cells = document.querySelectorAll('.cell');

// Función para actualizar el tablero
function updateBoard() {
  cells.forEach((cell, index) => {
    cell.textContent = gameBoard[index];
  });
}

// Función para comprobar si alguien ha ganado
function checkWinner() {
  // Comprobar filas
  if (
    (gameBoard[0] === currentPlayer && gameBoard[1] === currentPlayer && gameBoard[2] === currentPlayer) ||
    (gameBoard[3] === currentPlayer && gameBoard[4] === currentPlayer && gameBoard[5] === currentPlayer) ||
    (gameBoard[6] === currentPlayer && gameBoard[7] === currentPlayer && gameBoard[8] === currentPlayer)
  ) {
    return true;
  }

  // Comprobar columnas
  if (
    (gameBoard[0] === currentPlayer && gameBoard[3] === currentPlayer && gameBoard[6] === currentPlayer) ||
    (gameBoard[1] === currentPlayer && gameBoard[4] === currentPlayer && gameBoard[7] === currentPlayer) ||
    (gameBoard[2] === currentPlayer && gameBoard[5] === currentPlayer && gameBoard[8] === currentPlayer)
  ) {
    return true;
  }

  // Comprobar diagonales
  if (
    (gameBoard[0] === currentPlayer && gameBoard[4] === currentPlayer && gameBoard[8] === currentPlayer) ||
    (gameBoard[2] === currentPlayer && gameBoard[4] === currentPlayer && gameBoard[6] === currentPlayer)
  ) {
    return true;
  }

  return false;
}


function switchPlayer() {
  currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
}


function resetGame() {
  gameBoard = ['', '', '', '', '', '', '', '', ''];
  currentPlayer = 'X';
  gameOver = false;
  updateBoard();
}


cells.forEach((cell, index) => {
  cell.addEventListener('click', () => {

    if (gameOver || gameBoard[index]) {
      return;
    }

    gameBoard[index] = currentPlayer;
    updateBoard();


    if (checkWinner()) {
      alert(`¡${currentPlayer} ha ganado!`);
      gameOver = true;
      return;
    }


    if (!gameBoard.includes('')) {
      alert('¡Empate!');
      gameOver = true;
      return;
    }

    switchPlayer();
  });
});


const resetButton = document.getElementById('reset-button');
resetButton.addEventListener('click', resetGame);
