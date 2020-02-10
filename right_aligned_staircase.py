#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the staircase function below.
def staircase(n):
    for i in range(n):
        # because range() is zero-indexed, the number of spaces to print on line i is n - i - 1; the number of # symbols to print is i + 1
        print(" " * (n - 1 - i) + "#" * (i + 1))

if __name__ == '__main__':
    n = int(input())

    staircase(n)

