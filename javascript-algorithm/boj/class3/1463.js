// 1로 만들기

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim();

const N = Number(input);

const dp = new Array(N + 1).fill(0);

dp[1] = 0;

for (let i = 2; i <= N; i++) {
  // 1을 빼는 연산 이전 연산 휫수에 1을 더한다.
  dp[i] = dp[i - 1] + 1;

  // 2를 나누는 연산 2를 나눈후 1을 더한게 연산휫수가 더 큰지, 1을 뺀게 더 큰지 작은거를 골라서 삽입
  if (i % 2 === 0) {
    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
  }

  // 위와 마찬가지
  if (i % 3 === 0) {
    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
  }
}

console.log(dp[N]);
