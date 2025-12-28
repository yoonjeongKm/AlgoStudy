// 패션왕 신해빈

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

let idx = 0;
const T = Number(input[idx++]);

for (let t = 0; t < T; t++) {
  const n = Number(input[idx++]);
  const map = new Map();

  for (let i = 0; i < n; i++) {
    // 구조분해 할당으로 name, type 변수에 값 삽입
    const [name, type] = input[idx++].split(" ");
    // 만약 기존 들어있는 타입이라면 get해서 그값을 가져오고 + 1  새로운 type 라면 0 + 1
    map.set(type, (map.get(type) || 0) + 1);
  }

  let result = 1;
  for (const cnt of map.values()) {
    result *= cnt + 1;
  }

  // 아무것도 안입을 경우 빼주기
  console.log(result - 1);
}
