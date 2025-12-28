// 파도반 수열

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const T = Number(input[0]);

// P[1] ~ P[5]까지 초기값
const P = [0, 1, 1, 1, 2, 2];

const calc = (num) => {
  while (P.length <= num) {
    P.push(P[P.length - 1] + P[P.length - 5]);
  }
};

for (let i = 1; i <= T; i++) {
  const n = Number(input[i]);
  calc(n);
  console.log(P[n]);
}
