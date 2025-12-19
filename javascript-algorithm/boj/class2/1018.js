// 체스판 다시 칠하기

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const board = input.slice(1).map((line) => line.split(""));

let minRepaint = Infinity;

// 8 * 8 체스판 크기로 이동하면서 완전탐색하기
// 그리고 8 * 8 체스판에서 다시 칠해야하는 칸의 개수 세기
for (let row = 0; row <= N - 8; row++) {
  for (let col = 0; col <= M - 8; col++) {
    let startWhite = 0; // 시작이 W인 경우
    let startBlack = 0; // 시작이 B인 경우

    for (let i = 0; i < 8; i++) {
      for (let j = 0; j < 8; j++) {
        // 현재 내가 보고있는 체스판
        const currentCell = board[row + i][col + j];

        // (i + j)가 짝수인 경우
        if ((i + j) % 2 === 0) {
          // 만약 짝수일때 W가 아니면 white 카운트 증가
          if (currentCell !== "W") startWhite++;
          // 만약 짝수일때 B가 아니면 black 카운트 증가
          if (currentCell !== "B") startBlack++;
        } else {
          // 아래도 같은 로직
          if (currentCell !== "B") startWhite++;
          if (currentCell !== "W") startBlack++;
        }
      }
    }

    // 짝수, 홀수 일때 시작 색을 기준으로 다시 칠해야하는 칸의 개수 중 최소값 구하기
    const currentMinRepaint = Math.min(startWhite, startBlack);
    minRepaint = Math.min(minRepaint, currentMinRepaint);
  }
}

console.log(minRepaint);
