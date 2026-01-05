// 최소 힙

const fs = require("fs");
const input = fs.readFileSync(0, "utf8").trim().split("\n");

const N = Number(input[0]);
const nums = input.slice(1).map(Number);

const minHeap = [];

const insert = (num) => {
  minHeap.push(num);

  let idx = minHeap.length - 1;
  while (idx > 0) {
    const parent = Math.floor((idx - 1) / 2);
    if (minHeap[parent] <= minHeap[idx]) break;
    [minHeap[parent], minHeap[idx]] = [minHeap[idx], minHeap[parent]];
    idx = parent;
  }
};

const remove = () => {
  if (minHeap.length === 0) return 0;
  if (minHeap.length === 1) return minHeap.pop();

  const min = minHeap[0];
  minHeap[0] = minHeap.pop();

  let idx = 0;
  while (true) {
    let left = idx * 2 + 1;
    let right = idx * 2 + 2;
    let smallest = idx;

    if (left < minHeap.length && minHeap[left] < minHeap[smallest]) {
      smallest = left;
    }
    if (right < minHeap.length && minHeap[right] < minHeap[smallest]) {
      smallest = right;
    }

    if (smallest === idx) break;

    [minHeap[idx], minHeap[smallest]] = [minHeap[smallest], minHeap[idx]];
    idx = smallest;
  }

  return min;
};

const result = [];

for (let i = 0; i < N; i++) {
  const num = nums[i];
  if (num === 0) {
    result.push(remove());
  } else {
    insert(num);
  }
}

console.log(result.join("\n"));
