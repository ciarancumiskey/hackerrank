# Return the factorial of N
def factorial(n):
    return 1 if n <= 1 else n * factorial(n-1)

# Calculate the binomial coefficient of K successes in N trials 
def combo(n, k):
    return factorial(n) / (factorial(k) * factorial(n - k))

"""
    Given the probability p of a boy being born, calculate the 
    probability of a family of n children having k boys or more
    @param k: the number of boys
    @param n: the number of children
    @param p: the chance of a boy being born
"""
def binomial_dist(k, n, p):
    summed_probability = 0
    # Calculate the probability of k boys in a family of n children
    while(k <= n):
        summed_probability += combo(n, k) * p**k * (1 - p)**(n - k)
        # Then increment k until k = n
        k += 1
    return summed_probability

boy_girl_ratio = input()
boy_proportion = float(boy_girl_ratio.split(" ")[0])
girl_proportion = float(boy_girl_ratio.split(" ")[1])

chance_of_at_least_three_boys = binomial_dist(3, 6, (boy_proportion/(boy_proportion+girl_proportion)))
print(round(chance_of_at_least_three_boys, 3))

