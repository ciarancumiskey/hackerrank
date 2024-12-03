#Calculates the factorial of the input number n
def factorial(n):
    if n <= 1:
        return n
    else:
        return n * factorial(n-1)

e = 2.71828
p_mean = float(input()) # the mean of the Poisson distribution
k = float(input()) 
#Use the Poisson distribution formula ((lambda**k)*(e**(-lambda)))/k!
poisson_dist_of_k = ((p_mean**k)*(e**-p_mean))/factorial(k)
print(round(poisson_dist_of_k, 3))
