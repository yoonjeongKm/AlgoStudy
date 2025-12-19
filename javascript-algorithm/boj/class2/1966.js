// 프린터 큐

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const T = Number(input[0]);
let result = [];
let lineIdx = 1;

for (let t = 0; t < T; t++) {
  // N = 문서의 개수, M = 몇 번째로 인쇄되었는지 궁금한 문서의 위치
  const [N, M] = input[lineIdx].split(" ").map(Number);
  const priorities = input[lineIdx + 1].split(" ").map(Number);

  // 큐 [{priority, index}] 객체 배열 구조로 초기화
  let queue = priorities.map((priority, index) => ({ priority, index }));

  let printOrder = 0;

  while (queue.length > 0) {
    // 큐 제일 앞에꺼 빼서 변수에 저장
    const currentDoc = queue.shift();
    // 현재 문서보다 우선순위가 높은 문서가 있는지 확인
    const hasHigherPriority = queue.some(
      (doc) => doc.priority > currentDoc.priority
    );

    if (hasHigherPriority) {
      // 우선순위 더 높은거 있으면 앞에서 뺏던거 뒤에 다시 푸쉬
      queue.push(currentDoc);
    } else {
      // 우선순위 제일 높으면 인쇄
      printOrder++;

      // 인쇄한 문서가 타깃 문서인지 확인
      if (currentDoc.index === M) {
        // 타깃 도착하면 종료, 결과에 추가
        result.push(printOrder);
        break;
      }
    }
  }

  lineIdx += 2; // 다음 케이스 이동
}

console.log(result.join("\n"));
