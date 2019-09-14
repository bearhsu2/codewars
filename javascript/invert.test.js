const invert = require('./invert');

test('1,2 => -1,-2', () => {
    expect(invert([1, 2])).toStrictEqual([-1, -2]);
});

test('1,2,3 => -1,-2,-3', () => {
    expect(invert([1, 2, 3])).toStrictEqual([-1, -2, -3]);
});

test('[]] => []', () => {
    expect(invert([])).toStrictEqual([]);
});