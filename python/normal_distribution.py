import math

"""
    Given a normal distribution with a mean mu, this calculates the cumulative 
    probability of x.
    @param x: The upper bound of the cumulative probability
    @param mu: The mean of this normal distribution
    @param st_dev: The standard deviation of this normal distribution
"""
def cumulative_distribution(x, mu, st_dev): 
    return 0.5 * (1 + math.erf((x - mu)/(st_dev * (2 ** 0.5))))

mean_with_sd = input()
mean = float(mean_with_sd.split(" ")[0])
st_dev = float(mean_with_sd.split(" ")[1])

upper_limit = float(input())

boundary = input()
lower_bound = float(boundary.split(" ")[0])
upper_bound = float(boundary.split(" ")[1])

print(round(cumulative_distribution(upper_limit, mean, st_dev), 3))
#To find the probability of a bounded region, calculate the cumulative distributions of the lower and upper bounds and then get the difference
print(round((cumulative_distribution(upper_bound, mean, st_dev) - cumulative_distribution(lower_bound, mean, st_dev)), 3))
