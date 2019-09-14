const correct = require('./correct');

test('0 -> O', () => {
    expect(correct(0)).toBe('O');
});
test('L0 -> LO', () => {
    expect(correct('L0ND0N')).toBe('LONDON');
});
test('5 -> S', () => {
    expect(correct('5NGAP0RE')).toBe('SNGAPORE');
});

test('1 -> I', () => {
    expect(correct('51NGAP0RE')).toBe('SINGAPORE');
});

