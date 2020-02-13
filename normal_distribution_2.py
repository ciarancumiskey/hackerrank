import math
"""
    Given a normal distribution with a mean mu, this calculates the cumulative 
    probability of x.
    @param x: The upper bound of the cumulative probability
    @param mu: The mean of this normal distribution
    @param st_dev: The standard deviation of this normal distribution
"""
def cdf(x, mu, st_dev): 
    return 0.5 * (1 + math.erf((x - mu)/(st_dev * (2 ** 0.5))))

mean_with_sd = input()
mean = float(mean_with_sd.split(" ")[0])
st_dev = float(mean_with_sd.split(" ")[1])

merit_grade = int(input())
pass_grade = int(input())

#Calculate the percentage of students who DIDN'T get a merit grade, then subtract it from 100% to #find the ones who did
print(round(100 * (1 - cdf(merit_grade, mean, st_dev)), 2))
#Do the same to calculate the amount of students who passed
fail_rate = 100 * cdf(pass_grade, mean, st_dev)
print(round(100 - fail_rate, 2))
print(round(fail_rate, 2))

