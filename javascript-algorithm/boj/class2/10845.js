// 큐

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const N = Number(input[0]);
const queue = [];
let frontIdx = 0;
let output = [];

// frontIdx를 이용해서 큐가 비어있는지 아닌지를 판별
// frontIdx가 queue.length와 같다면 큐는 비어있는 상태
for (let i = 1; i <= N; i++) {
  const [command, value] = input[i].split(" ");

  switch (command) {
    case "push":
      queue.push(value);
      break;

    case "pop":
      if (frontIdx === queue.length) {
        output.push("-1");
      } else {
        output.push(queue[frontIdx]);
        frontIdx++;
      }
      break;

    case "size":
      output.push(queue.length - frontIdx);
      break;

    case "empty":
      output.push(frontIdx === queue.length ? "1" : "0");
      break;

    case "front":
      output.push(frontIdx === queue.length ? "-1" : queue[frontIdx]);
      break;

    case "back":
      output.push(frontIdx === queue.length ? "-1" : queue[queue.length - 1]);
      break;
  }
}

console.log(output.join("\n"));
