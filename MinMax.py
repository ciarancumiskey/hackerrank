#!/bin/python3

import math
import os
import random
import re
import sys

"""
    Takes an array of N integers and calculates the lowest and highest combinations of 
    N-1 elements.
    @param arr: the input array
"""
def miniMaxSum(arr):
    minSum = sum(arr) - max(arr)
    maxSum = sum(arr) - min(arr)
    print(str(minSum) + " " + str(maxSum))

if __name__ == '__main__':
    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)

