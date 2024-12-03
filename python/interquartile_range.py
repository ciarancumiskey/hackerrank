"""
    Finds the median in an array of integers
    input_nums: The input array of integers
    return: The median integer in the array
"""
def median(input_nums):
    mid = len(input_nums) // 2
    if(len(input_nums) % 2 == 0):
        return (input_nums[mid - 1] + input_nums[mid])/2
    else:
        return (input_nums[mid])

num_count = int(input())
original_nums = list(map(int, input().split()))
frequency_per_num = list(map(int, input().split()))
repeated_nums = []
for i in range(num_count):
    repeated_nums += [original_nums[i]] * frequency_per_num[i]
sorted_nums = sorted(repeated_nums)
# Use floored division to always return an integer
median_index = len(sorted_nums) // 2
if (len(sorted_nums) % 2 == 0): # Check if there's an odd/even amount of numbers in the input array
    q1 = median(sorted_nums[:median_index])
    q3 = median(sorted_nums[median_index:])
else:
    q1 = median(sorted_nums[:median_index])
    q3 = median(sorted_nums[median_index + 1:])

print(round(float(q3 - q1), 1))

