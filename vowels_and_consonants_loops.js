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
 * Splits the input string into its constituent letters, then prints each vowel on a new 
 * line in the order they showed up in the input string, and then does the same for each
 * consonant.
 * @param s: the input string to be split up into individual characters
 */
function vowelsAndConsonants(s) {
    const vowels = "aeiou";
    var consonants = "";
    
    // Loop through the input string to check for vowels
    for(var i = 0; i < s.length; i++) {
       if (vowels.includes(s[i])) {
           console.log(s[i]); // Vowel detected, print it to the console
       }
       else {
           consonants += s[i] + '\n'; // Consonant detected, add it to the pile
       }
    }
    
    console.log(consonants.trim()); // Print out the consonants when the vowels are done
}


