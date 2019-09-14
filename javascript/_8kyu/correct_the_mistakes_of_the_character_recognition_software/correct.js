function checkAndReplace(char) {


    if (char == '0') {
        return 'O';
    }

    return char;
}

function correct(string) {
    let result = '';
    for (let i = 0; i < string.length; i++) {

        const c = checkAndReplace(string.charAt(i));
        result += c;
    }

    return result;
}

module.exports = correct;
