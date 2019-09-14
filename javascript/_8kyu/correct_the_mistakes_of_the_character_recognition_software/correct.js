function checkAndReplace(char) {


    if (char === '0') return 'O';

    if (char === '5') return 'S';

    if (char === '1') return 'I';


    return char;
}

function correct(string) {
    let result = '';
    for (let i = 0; i < string.length; i++) {
        result += checkAndReplace(string.charAt(i));
    }

    return result;
}

module.exports = correct;
