'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function regexVar() {
    /*
     * The ^ checks for matches within the circular () brackets.
     * The square [] brackets are the characters for the input string to be checked against.
     * The full stop and plus .+ allow for 0 or more occurances of any other characters following the initial RegEx check.
     * \1 repeats the last stored RegEx check (in this case, for a/e/i/o/u)
     * $ is for checking that no other characters come after that repeat
     */
    let re = /^([aeiou]).+\1$/;
    
    return re;
}


function main() {
    const re = regexVar();
    const s = readLine();
    
    console.log(re.test(s));
}
