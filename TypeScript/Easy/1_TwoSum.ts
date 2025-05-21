function solution(nums: number[], target: number): number[] {
    let indices: number[] = [0, 0];
    const complementMap: Map<number, number> = new Map<number, number>();

    for (let i: number = 0; i < nums.length; i++) {
        let complement: number = target - nums[i];
        if (complementMap.has(complement)) {
            indices[0] = complementMap.get(complement) ?? 0;
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

const nums: number[] = [3, 2, 4];
const target: number = 6;

let result: number[] = solution(nums, target);
console.log("Result: [" + result[0] + "], [" + result[1] + "]");