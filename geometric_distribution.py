num_and_denom = input().split(" ") # Enter the numerator and denominator
fail_probability = int(num_and_denom[0])/int(num_and_denom[1]) # Decimalise them to get the chance of failure
inspection_num = int(input()) # Enter the number of the inspection of when you want to find the first defect
chance_of_first_failure_at_nth_inspection = fail_probability
# Keep multiplying the failure rate by the non-failure rate until you get the first failure
for _ in range(1, inspection_num):
    chance_of_first_failure_at_nth_inspection *= (1 - fail_probability) 
print(round(chance_of_first_failure_at_nth_inspection, 3))
