fail_probability = input() #User enters the defect probability as a space-separated fraction
fprob_numerator = fail_probability.split(" ")[0]
fprob_denominator = fail_probability.split(" ")[1]
inspections = int(input()) #User enters the number of inspections to carry out
defect_probability = int(fprob_numerator)/int(fprob_denominator)
defect_prob_in_n_inspections = (1 - (1 - defect_probability)**inspections)
print(round(defect_prob_in_n_inspections, 3))
