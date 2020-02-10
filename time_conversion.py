#!/bin/python3

import os

"""
    Takes a string representing a time in a 12-hour clock format (i.e. hh:mm:ssAM/PM) 
    and converts it to its 24-hour equivalent
    s: the string containing the time to be converted
    return: the 24-hour version of the input time
"""
def timeConversion(s):
    time = s.strip()
    h, m, s = map(int, time[:-2].split(':'))
    p = time[-2:] # check if the penultimate character is "P" for "PM"
    h = h % 12 + (p.upper() == 'PM') * 12 # if so, "true" will get cast to 1 for multiplying by 12
    return(('%02d:%02d:%02d') % (h, m, s))

if __name__ == '__main__':
    f = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    f.write(result + '\n')

    f.close()

