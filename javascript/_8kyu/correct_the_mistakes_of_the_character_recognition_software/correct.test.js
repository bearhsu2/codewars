const correct = require('./correct');

test('0 -> O', () => {
    expect(correct('L0ND0N')).toBe('LONDON');
});
test('5 -> S', () => {
    expect(correct('5NGAP0RE')).toBe('SNGAPORE');
});

test('1 -> I', () => {
    expect(correct('51NGAP0RE')).toBe('SINGAPORE');
});

// Test.assertEquals(correct("L0ND0N"),"LONDON");
// Test.assertEquals(correct("DUBL1N"),"DUBLIN");
// Test.assertEquals(correct("51NGAP0RE"),"SINGAPORE");
// Test.assertEquals(correct("BUDAPE5T"),"BUDAPEST");
// Test.assertEquals(correct("PAR15"),"PARIS");