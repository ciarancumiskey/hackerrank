function reverseString(str) {
  /**
   * Split the string with the empty string ''
   * Reverse the resulting array
   * Join the array elements back together with the empty string ''
   */
  return str = str.split('').reverse().join('');
}

reverseString("hello");

function factorialize(num) {
  if(num < 0){
    return "Please enter 0 or a positive integer"
  } else if (num === 1){
    return 1;
  } else {
    let factorial = 1;
    for(let i = 1; i <= num; i++){
      factorial *= i;
    }  
    return factorial;
  }
}

factorialize(5);

function findLongestWordLength(str) {
  let wordsArray = str.split(' '); //Use the whitespace to split the separate words
  let longestWordLength = 0;
  for(let i = 0; i < wordsArray.length; i++){
    if(wordsArray[i].length > longestWordLength){
      longestWordLength = wordsArray[i].length;
    }
  }
  return longestWordLength;
}

findLongestWordLength("The quick brown fox jumped over the lazy dog");

function largestOfFour(arr) {
  // You can do this!
  var largestArray = [];
  for(let i = 0; i < arr.length; i++){
    largestArray[i] = arr[i][0]; //start off with the 1st number in each sub-array
    for(let j = 1; j < arr[i].length; j++){
      if(arr[i][j] > largestArray[i]){
        largestArray[i] = arr[i][j];
      }
    }
  }
  return largestArray;
}

largestOfFour([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39], [1000, 1001, 857, 1]]);