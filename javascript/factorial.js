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
/*
 * Calculates the factorial of the input number.
 * @param n: The number to be factorialised
 * @return The factorial of n
 */
function factorial(n){
    if(n <= 1){
        return n
    }
    else {
        return n * factorial(n - 1)
    }
}

function main() {
    const n = +(readLine());
    
    console.log(factorial(n));
}
