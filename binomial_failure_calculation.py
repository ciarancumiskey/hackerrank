def factorial(n):
    return 1 if n <= 1 else n * factorial(n-1)

def binom_coefficient_calc(n, k):
    return factorial(n) / (factorial(k) * factorial(n - k))

def binomial_dist(k, n, p):
    return binom_coefficient_calc(n, k) * p**k * (1 - p)**(n - k)
        
fail_rate_and_batch_size = input()
failure_rate = int(fail_rate_and_batch_size.split(" ")[0])
batch_size = int(fail_rate_and_batch_size.split(" ")[1])

# Calculate the chance of 2 or less failures per batch
print(round(sum(binomial_dist(i, batch_size, failure_rate/100) for i in range(3)),3))
# Calculate the chance of at least 2 failures per batch
print(round(sum(binomial_dist(i, batch_size, failure_rate/100) for i in range(2, batch_size + 1)),3))

