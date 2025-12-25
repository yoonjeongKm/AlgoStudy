// 동전 0

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, K] = input[0].split(" ").map(Number);

const coinList = [];

for (let i = 1; i <= N; i++) coinList.push(Number(input[i]));

let target = K;
let coinCnt = 0;
for (let i = coinList.length - 1; i >= 0; i--) {
  if (target === 0) {
    break;
  }

  if (coinList[i] > K) {
    continue;
  }

  coinCnt += Math.floor(target / coinList[i]);
  target -= Math.floor(target / coinList[i]) * coinList[i];
}

console.log(coinCnt);
