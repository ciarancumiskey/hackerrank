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

function confirmEnding(str, target) {
  /*Make a substring out of str starting target.length characters from the end,
    then compare against target */
  if(str.substr(str.length - target.length) === target){
    return true;
  } else {
    return false;
  }
}

confirmEnding("Bastian", "n");

function repeatStringNumTimes(str, num) {
  if(num <= 0) {
    return ""; 
  }
  let repeatStr = '';
  while(num > 0){
    repeatStr += str;
    num--;
  }
  return repeatStr;
}

repeatStringNumTimes("abc", 3);

function truncateString(str, num) {
  // Clear out that junk in your trunk
  if(str.length <= num){
    return str; //No need to truncate anything or add ellipses
  }
  str = str.substr(0, num);
  str += "...";
  return str;
}

truncateString("A-tisket a-tasket A green and yellow basket", 8);

function findElement(arr, func) {
  let num = 0;
  //Loop through arr
  for(var i = 0; i < arr.length; i++){
    num = arr[i]; //Overwrite num's value with the i-th element in arr
    if(func(num)){
      return num; //Num fulfils func, so return it
    }
  }
  return undefined;
}

findElement([1, 2, 3, 4], num => num % 2 === 0);

function titleCase(str) {
  //Turn str to lower case, then split it into separate words
  var wordsArr = str.toLowerCase().split(" "); 
  var result = wordsArr.map(function(val){
      //capitalise the first letter in each word
      return val.replace(val.charAt(0), val.charAt(0).toUpperCase());
  });
  return result.join(" "); //Rejoin the title-cased words
}


titleCase("I'm a little tea pot");