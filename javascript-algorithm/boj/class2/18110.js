// solved.ac

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const n = Number(input[0]);

// 절사평균 : 가장 높은 값 15%, 가장 낮은값 15% 제외 한뒤 구한 평균값
// 제외인원, 최종 난이도 모두 반올림

if (n === 0) {
  console.log(0);
  process.exit(0);
}

const difficultyLevels = [];

// 제외 인원수
const excludedCnt = Math.round(n * 0.15);

for (let i = 1; i <= n; i++) {
  difficultyLevels.push(Number(input[i]));
}

// 난이도 오름차순으로 정렬
const sortedDifficultyLevels = difficultyLevels.sort((a, b) => a - b);

let sum = 0;
for (
  let i = excludedCnt;
  i <= sortedDifficultyLevels.length - excludedCnt - 1;
  i++
) {
  sum += sortedDifficultyLevels[i];
}
const avg = sum / (n - excludedCnt * 2);
console.log(Math.round(avg));
