// 괄호

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const N = Number(input[0]);
const result = [];

const openBracket = "(";
const closeBracket = ")";

for (let i = 1; i <= N; i++) {
  const bracketStr = input[i];

  const stack = [];
  let isBalanced = true;

  for (let char of bracketStr) {
    if (char === openBracket) {
      stack.push(char);
    } else if (char === closeBracket) {
      if (stack.length === 0) {
        isBalanced = false;
        break;
      }
      stack.pop();
    }
  }

  if (isBalanced && stack.length === 0) {
    result.push("YES");
  } else {
    result.push("NO");
  }
}

console.log(result.join("\n"));
