function twoSum(nums: number[], target: number): number[] {
    let complementsMap: Map<number, number> = new Map<number, number>();

    for (let i = 0; i < nums.length; i++) {
        let complement: number = target - nums[i];

        if (complementsMap.has(complement)) {
            return [complementsMap.get(complement) ?? 0, i];
        }
        else {
            complementsMap.set(nums[i], i);
        }
    }

    return [0, 0];
}

console.log("#1 - Two Sum - Easy");

const nums: number[] = [2, 7, 11, 15];
let result: number[] = twoSum(nums, 9);
console.log(result);