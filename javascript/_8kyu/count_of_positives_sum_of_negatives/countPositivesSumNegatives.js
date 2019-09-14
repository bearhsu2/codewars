function countPositivesSumNegatives(input) {

    return input && input.length
        ? [input.filter(x => x > 0).length, input.filter(x => x < 0).reduce((x, y) => x + y, 0)]
        : [];

}

module.exports = countPositivesSumNegatives;