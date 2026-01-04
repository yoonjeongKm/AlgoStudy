// 잃어버린 괄호

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const str = input[0];
const minusSplitArr = str.split("-");

let result = 0;

// 첫값만 result에 더해주고 나머지는 다 빼주면 최솟값이된다
for (let i = 0; i < minusSplitArr.length; i++) {
  let sum = 0;
  const sumSplitArr = minusSplitArr[i].split("+");
  for (let j = 0; j < sumSplitArr.length; j++) {
    sum += Number(sumSplitArr[j]);
  }
  if (i === 0) {
    result += sum;
  } else {
    result -= sum;
  }
}

console.log(result);
