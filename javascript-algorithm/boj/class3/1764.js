// 듣보잡

const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);

const unheard = [];
const unseen = [];

for (let i = 1; i <= N; i++) unheard.push(input[i]);
for (let i = N + 1; i <= N + M; i++) unseen.push(input[i]);

const unheardSet = new Set(unheard);

const result = unseen.filter((name) => unheardSet.has(name));
result.sort();

console.log(result.length);
console.log(result.join("\n"));
