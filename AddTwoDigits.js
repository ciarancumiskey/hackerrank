/**
 * Given a two digit number, find the sum of its digits.
 * @param n: The input number.
 * @return: The sum of n's digits.
 */
function addTwoDigits(n) {
    /* Math.floor will round the result down to the last whole number, which in this case 
    will be the first digit of n. Then get the remainder and add that to get the sum of 
    n's two digits. */ 
    return Math.floor(n / 10) + n % 10;
}
