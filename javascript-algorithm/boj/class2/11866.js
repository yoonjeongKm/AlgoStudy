// 요세푸스 문제 0

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split(" ");

const N = Number(input[0]);
const K = Number(input[1]);

// N명의 사람 들어있는 큐
const queue = [];
const result = [];

// 큐 초기화
for (let i = 1; i <= N; i++) {
  queue.push(i);
}

let idx = 0;

while (true) {
  // 큐 비면 종료
  if (queue.length === 0) {
    break;
  }

  // K번째 사람 제거
  idx = (idx + K - 1) % queue.length;
  result.push(queue.splice(idx, 1)[0]);
}

console.log(`<${result.join(", ")}>`);
