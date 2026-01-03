// 구간 합 구하기 4

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const nums = input[1].split(" ").map(Number);

const arr = new Array(N + 1).fill(0);

for (let i = 1; i <= N; i++) {
  arr[i] = arr[i - 1] + nums[i - 1];
}

const results = [];

for (let i = 2; i <= M + 1; i++) {
  const [a, b] = input[i].split(" ").map(Number);
  results.push(arr[b] - arr[a - 1]);
}

console.log(results.join("\n"));
