num_and_denom = input().split(" ") # Enter the numerator and denominator
fail_prob = int(num_and_denom[0])/int(num_and_denom[1]) # Decimalise them to get the chance of failure
n = int(input()) # Enter the number of the inspection of when you want to find the first defect
chance_of_first_failure_at_nth_inspection = fail_prob
# Use the geometric distribution formula g(n, p) = (1-p)**(n-1)*p
chance_of_first_failure_at_nth_inspection = (1 - fail_prob) ** (n - 1) * fail_prob
print(round(chance_of_first_failure_at_nth_inspection, 3))

