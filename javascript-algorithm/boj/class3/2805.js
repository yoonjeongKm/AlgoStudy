// 나무 자르기

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);

let left = 0;
let right = Math.max(...trees);
let answer = 0;

while (left <= right) {
  const mid = Math.floor((left + right) / 2);
  let total = 0;

  for (const tree of trees) {
    if (tree > mid) {
      total += tree - mid;
    }
  }

  if (total >= M) {
    answer = mid;
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(answer);
