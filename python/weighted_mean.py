array_size = int(input())
array_x = list(map(int, input().split()))
array_w = list(map(int, input().split()))
weighted_array = []
# Loop through the two entered arrays, multiplying corresponding elements with each other
for i in range(array_size):
    weighted_array.append(array_x[i] * array_w[i])
# Sum up the resulting weighted array and the array of weights, then round to 1 decimal place
print(round(sum(weighted_array)/sum(array_w), 1))

