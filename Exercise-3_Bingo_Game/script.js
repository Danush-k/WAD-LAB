// Game State Variables
let board1 = [];
let board2 = [];
let marked1 = [];
let marked2 = [];
let currentPlayer = 1;
let gameActive = false;
let calledNumbers = [];

// Helper function to generate shuffled 5x5 card numbers (1 to 25)
function generateCardNumbers() {
  const numbers = Array.from({ length: 25 }, (_, i) => i + 1);
  for (let i = numbers.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [numbers[i], numbers[j]] = [numbers[j], numbers[i]];
  }

  const card = [];
  for (let r = 0; r < 5; r++) {
    card.push(numbers.slice(r * 5, (r + 1) * 5));
  }
  return card;
}

// Render a player's board into the DOM
function renderBoard(boardId, card, marked) {
  const boardEl = document.getElementById(boardId);
  boardEl.innerHTML = "";

  for (let r = 0; r < 5; r++) {
    for (let c = 0; c < 5; c++) {
      const cell = document.createElement("div");
      cell.classList.add("cell");
      const num = card[r][c];

      if (marked[r][c]) {
        cell.classList.add("marked");
        cell.textContent = "X";
      } else {
        cell.textContent = num;
        cell.onclick = () => {
          if (gameActive) {
            document.getElementById("numberInput").value = num;
            markNumber();
          }
        };
      }
      boardEl.appendChild(cell);
    }
  }
}

// Start / Initialize the Bingo Game
function startGame() {
  board1 = generateCardNumbers();
  board2 = generateCardNumbers();
  marked1 = Array.from({ length: 5 }, () => Array(5).fill(false));
  marked2 = Array.from({ length: 5 }, () => Array(5).fill(false));

  calledNumbers = [];
  currentPlayer = 1;
  gameActive = true;

  document.getElementById("startBtn").disabled = true;
  document.getElementById("markBtn").disabled = false;
  document.getElementById("numberInput").disabled = false;
  document.getElementById("numberInput").value = "";
  document.getElementById("numberInput").focus();

  updateStatus("Player 1's Turn");
  renderBoard("board1", board1, marked1);
  renderBoard("board2", board2, marked2);
}

// Reset the Game to initial state
function resetGame() {
  gameActive = false;
  calledNumbers = [];
  document.getElementById("board1").innerHTML = "";
  document.getElementById("board2").innerHTML = "";
  document.getElementById("startBtn").disabled = false;
  document.getElementById("markBtn").disabled = true;
  document.getElementById("numberInput").disabled = true;
  document.getElementById("numberInput").value = "";
  updateStatus("Click \"Start\" to play!");
}

// Mark the entered number on both players' cards
function markNumber() {
  if (!gameActive) return;

  const inputEl = document.getElementById("numberInput");
  const num = parseInt(inputEl.value, 10);

  // Validate number
  if (isNaN(num) || num < 1 || num > 25) {
    alert("Please enter a valid number between 1 and 25.");
    inputEl.focus();
    return;
  }

  if (calledNumbers.includes(num)) {
    alert(`Number ${num} is already marked! Choose another number.`);
    inputEl.value = "";
    inputEl.focus();
    return;
  }

  // Record number as called
  calledNumbers.push(num);

  // Mark number on both cards if found
  markCard(num, board1, marked1);
  markCard(num, board2, marked2);

  // Re-render boards
  renderBoard("board1", board1, marked1);
  renderBoard("board2", board2, marked2);

  // Check for winning conditions
  const p1Wins = checkBingo(marked1);
  const p2Wins = checkBingo(marked2);

  if (p1Wins && p2Wins) {
    updateStatus("It's a Tie! Both players achieved Bingo!");
    endGame();
  } else if (p1Wins) {
    updateStatus("Bingo! Player 1 Wins the Game!");
    endGame();
  } else if (p2Wins) {
    updateStatus("Bingo! Player 2 Wins the Game!");
    endGame();
  } else {
    // Switch turn between players
    currentPlayer = currentPlayer === 1 ? 2 : 1;
    updateStatus(`Player ${currentPlayer}'s Turn`);
    inputEl.value = "";
    inputEl.focus();
  }
}

// Mark matching number in a card matrix
function markCard(num, card, marked) {
  for (let r = 0; r < 5; r++) {
    for (let c = 0; c < 5; c++) {
      if (card[r][c] === num) {
        marked[r][c] = true;
      }
    }
  }
}

// Check if any row, column, or diagonal is completely marked
function checkBingo(marked) {
  // Check rows
  for (let r = 0; r < 5; r++) {
    if (marked[r].every(v => v)) return true;
  }

  // Check columns
  for (let c = 0; c < 5; c++) {
    if (marked.every(row => row[c])) return true;
  }

  // Check diagonals
  if ([0, 1, 2, 3, 4].every(i => marked[i][i])) return true;
  if ([0, 1, 2, 3, 4].every(i => marked[i][4 - i])) return true;

  return false;
}

// End the game
function endGame() {
  gameActive = false;
  document.getElementById("markBtn").disabled = true;
  document.getElementById("numberInput").disabled = true;
}

// Update turn / result status message
function updateStatus(msg) {
  document.getElementById("turnStatus").textContent = msg;
}

// Listen for Enter key on the input box
document.getElementById("numberInput").addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    markNumber();
  }
});
