function getConcatenation(nums: number[]): number[] {
    let length: number = nums.length;
    let concatenated: number[] = [];

    for (let i = 0; i < length; i++) {
        concatenated[i] = nums[i];
        concatenated[nums.length + i] = nums[i];
    }

    return concatenated;

    // Alternative Solutions

    // return nums.concat(nums);
    // return [...nums, ...nums];
}

let testArray: number[] = [1, 2, 3];
let result = getConcatenation(testArray);
console.log("#1929 - Concatenation of Array - Easy");
console.log(result);