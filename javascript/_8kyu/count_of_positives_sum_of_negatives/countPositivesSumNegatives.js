function countPositivesSumNegatives(input) {
    if (input.length === 0) {
        return [];
    }

    let count = 0;
    let sum = 0;

    for (let i = 0; i < input.length; i++) {

        const number = input[i];

        if (number > 0) {
            count++;
        } else if (number < 0){
            sum += number;
        }

    }

    return [count, sum];
}

module.exports = countPositivesSumNegatives;