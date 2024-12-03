#returns the value of the Fibonacci sequence of n, the input number
def fibonacci(n):
    if(n <= 1):
        return n # Fibonacci is finished
    else:
        fib_result = fibonacci(n - 1) + fibonacci(n - 2)
        return fib_result

n = int(input())
print(fibonacci(n))
