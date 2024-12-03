#!/bin/python3

import math
import os
import random
import re
import sys

# Check if Harold can make a ransom note out of the complete words in the magazine.
# @param magazine: The magazine that Harold is trying to make a ransom note from.
# @param note: The ransom note Harold wants to make.
# @return whether Harold can make a ransom note or not
def checkMagazine(magazine, note):
    magDict = {}
    for magWord in magazine:
        magDict.setdefault(magWord, 0)
        magDict[magWord] += 1
        
    for noteWord in note:
        if noteWord in magDict:
            magDict[noteWord] -= 1
        else:
            return False
    return all([x >= 0 for x in magDict.values()])
    
if __name__ == '__main__':
    mnLengths = input().split()

    magLength = int(mnLengths[0])
    noteLength = int(mnLengths[1])

    magazine = input().rstrip().split()
    note = input().rstrip().split()

    print("Yes") if checkMagazine(magazine, note) else print("No")
