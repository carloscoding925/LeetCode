"use strict";
function solution(nums, target) {
    var _a;
    let indices = [0, 0];
    const complementMap = new Map();
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (complementMap.has(complement)) {
            indices[0] = (_a = complementMap.get(complement)) !== null && _a !== void 0 ? _a : 0;
            indices[1] = i;
            return indices;
        }
        else {
            complementMap.set(nums[i], i);
        }
    }
    return indices;
}
console.log("#1 - Two Sum - Easy");
const nums = [3, 2, 4];
const target = 6;
let result = solution(nums, target);
console.log("Result: [" + result[0] + "], [" + result[1] + "]");
