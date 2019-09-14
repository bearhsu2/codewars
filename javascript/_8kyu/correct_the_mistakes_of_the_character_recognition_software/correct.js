function correct(input) {
    let result = '';

    const string = input.toString();
    for (let i = 0; i < string.length; i++) {
        result += checkAndReplace(string.charAt(i));
    }

    return result;
}

function checkAndReplace(char) {

    if (char === '0') return 'O';

    if (char === '5') return 'S';

    if (char === '1') return 'I';

    return char;
}

module.exports = correct;
