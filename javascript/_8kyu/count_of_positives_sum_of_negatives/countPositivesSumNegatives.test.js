const countPositivesSumNegatives = require('./countPositivesSumNegatives');

test('[] -> []', () => {
    expect(countPositivesSumNegatives([])).toStrictEqual([]);
});

test('[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15] -> [10, -65]', () => {
    expect(countPositivesSumNegatives(
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15]))
        .toStrictEqual([10, -65]);
});

