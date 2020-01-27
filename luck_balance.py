#!/bin/python3

import math
import os
import random
import re
import sys

""" loss_limit is the number of important contests Lena's allowed to lose

    contests is a 2D array/matrix, where the first element in each sub-array is the contest's "luck cost", and the second element is its importance - 0 for unimportant, 1 for important"""
def luckBalance(loss_limit, contests):
    important_contest_scores = []

    luck_balance = 0
    
    for i in range(len(contests)):
        if(contests[i][1] == 0):
            luck_balance += contests[i][0] # this contest is unimportant so its luck cost can be added to the luck_balance anyway
        else:
            important_contest_scores.append(contests[i][0])
    
    important_contest_scores.sort(reverse = True) # sort the luck costs from most to least costly
    
    # check to prevent out-of-bounds errors
    if(loss_limit <= len(important_contest_scores)):
        for j in range(loss_limit): 
            luck_balance += important_contest_scores[j] # add the most costly contests to luck_balance, as Lena can afford to lose those

        for k in range(loss_limit, len(important_contest_scores)):
            luck_balance -= important_contest_scores[k] # subtract the least costly contests to luck_balance, as Lena's not allowed to lose those
    
        return luck_balance
    else:
        for i in important_contest_scores:
            luck_balance += i
        return luck_balance

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    contest_count = int(nk[0])

    loss_limit = int(nk[1])

    contests = []

    for _ in range(contest_count):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(loss_limit, contests)

    fptr.write(str(result) + '\n')

    fptr.close()

