num_count = int(input())
numbers = list(map(int, input().split()))
mean = sum(numbers)/len(numbers)
squared_dist_from_mean_list = []
# Loop through the input array to calculate the squared distances from the mean
for i in range(len(numbers)):
    if(numbers[i] <= mean):
        distance = mean - numbers[i]
    else:
        distance = numbers[i] - mean
    squared_dist_from_mean_list.append(distance**2)
# Find the mean of the squared distances, then get the square root of that
print(round((sum(squared_dist_from_mean_list)/num_count)**0.5, 1))

