// 제로

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const N = Number(input[0]);
const stack = [];

for (let i = 1; i <= N; i++) {
  const num = Number(input[i]);
  if (num === 0) {
    stack.pop();
  } else {
    stack.push(num);
  }
}

const sum = stack.reduce((acc, curr) => acc + curr, 0);
console.log(sum);
