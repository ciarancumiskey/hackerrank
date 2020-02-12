def factorial(n):
    if n <= 1:
        return n
    else:
        return n * factorial(n-1)

"""
    Calculates the probability of a Poisson random variable for a given Poisson mean.
    @param mean: the mean of a Poisson distribution
"""
def poisson(mean):
    #When x is the Poisson random variable, the expectation of x**2 is mean + mean**2
    #So to find x, just find the square root of the expectation of x**2
    return (mean + mean**2)**0.5 

poisson_means_ab = input()
mean_a = float(poisson_means_ab.split(" ")[0])
mean_b = float(poisson_means_ab.split(" ")[1])

cost_a = 160 + 40*(poisson(mean_a))**2
cost_b = 128 + 40*(poisson(mean_b))**2

print(round(cost_a, 3))
print(round(cost_b, 3))
