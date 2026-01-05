// 랜선 자르기

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const [K, N] = input[0].split(" ").map(Number);
const lanLines = input.slice(1).map(Number);

// 문제에서 주어진 가장 작은 랜선의 길이값 1
let smallestLanLine = 1;

// 가장 큰 랜선의 길이
let lagestLanLine = Math.max(...lanLines);

// 결과
let result = 0;

while (smallestLanLine <= lagestLanLine) {
  // 중앙값
  const mid = Math.floor((smallestLanLine + lagestLanLine) / 2);
  let count = 0;

  // 랜선 배열 반복하면서 중간값으로 나눈다 count 누적합으로 개수를 구한다
  for (let i = 0; i < K; i++) {
    count += Math.floor(lanLines[i] / mid);
  }

  // 직접 카운트한 랜선의 개수가 N보다 크거나 같으면 결과값에 그 중간값을 넣어준다
  // 만약 반복문 조건에 부합하면 그 result 값이 console에 출력
  // 만약 조건에 아직 부합하지 않아 계속 반복이 된다면 가작 작은 랜선길이를 중간값 + 1 해서 다시 반복해준다
  // 만약 조건에 부합하지 않으면 가장 큰 랜선길이를 중간값 -1 해서 다시 반복해준다
  if (count >= N) {
    result = mid;
    smallestLanLine = mid + 1;
  } else {
    lagestLanLine = mid - 1;
  }
}
console.log(result);
