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

/**
 * Given a score from 0 to 30, return a grade from F to A, where each grade represents a
 * band of scores from 0-5, 6-10, 11-15, 16-20, 21-25, 26-30.
 * @param score: The score to be graded
 * @return: the grade that score corresponds to
 */
function getGrade(score) {
    let grade;
    if(score <= 5){
        return "F";
    } else if (5 < score && score <= 10){
        grade = "E";
    } else if (10 < score && score <= 15){
        grade = "D";
    } else if (15 < score && score <= 20){
        grade = "C";
    } else if (20 < score && score <= 25){
        grade = "B";
    } else {
        grade = "A";
    }
    
    return grade;
}


function main() {
    const score = +(readLine());
    
    console.log(getGrade(score));
}
