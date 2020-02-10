"""
    Finds the median in an array of integers
    input_nums: The input array of integers
    return: The median integer in the array
"""
def median(input_nums):
    mid = len(input_nums) // 2
    if(len(input_nums) % 2 == 0):
        return int((input_nums[mid - 1] + input_nums[mid])/2)
    else:
        return (input_nums[mid])

num_count = int(input())
numbers = list(map(int, input().split()))
sorted_nums = sorted(numbers)
# Use floored division to always return an integer
median_index = num_count // 2
if (num_count % 2 == 0): # Check if there's an odd/even amount of numbers in the input array
    print(median(sorted_nums[:median_index]))
    q3 = median(sorted_nums[median_index:])
else:
    print(median(sorted_nums[:median_index]))
    q3 = median(sorted_nums[median_index + 1:])

print(median(sorted_nums))
print(q3)
