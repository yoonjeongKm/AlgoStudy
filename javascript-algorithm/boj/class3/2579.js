// 게단 오르기

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const N = Number(input[0]);
const stairs = [];

for (let i = 1; i <= N; i++) {
  stairs.push(Number(input[i]));
}

const dp = new Array(N + 1).fill(0);

dp[1] = stairs[0];
if (N >= 2) dp[2] = stairs[0] + stairs[1];

for (let i = 3; i <= N; i++) {
  // ex) (i-2까지의 최적 점수) + 도착계단
  //     (i-3까지의 최적 점수) + (이전 계단 + 도착계단)
  dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 2]) + stairs[i - 1];
}

console.log(dp[N]);
