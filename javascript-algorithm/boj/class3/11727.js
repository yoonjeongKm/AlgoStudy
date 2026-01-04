// 2xn 타일링 2

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim();

const N = Number(input);

const dp = new Array(N + 1).fill(0);

// dp[1] = 1
// dp[2] = 3
// dp[3] = 5
// dp[4] = 11
// dp[5] = 21
// dp[n] = dp[n-1] + 2 * dp[n-2]

dp[1] = 1;
dp[2] = 3;

for (let i = 3; i <= N; i++) {
  dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
}

console.log(dp[N]);
