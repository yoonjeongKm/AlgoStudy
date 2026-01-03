// 2 x n 타일링

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim();

const N = Number(input);

const dp = new Array(N + 1).fill(0);

dp[1] = 1;
dp[2] = 2;

for (let i = 3; i <= N; i++) {
  dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
}

console.log(dp[N]);
