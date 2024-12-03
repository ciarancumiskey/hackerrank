"""
Calculates the likelihood that an elevator with a specified weight limit X can safely carry a load
of N boxes with an average weight MU following a normal distribution with standard deviation SD.
"""
import math

def cdf(x, mu, st_dev):
    return 0.5*(1 + math.erf((x - mu)/(st_dev * (2**0.5))))

weight_limit = int(input())
num_boxes = int(input())
mean_box_weight = int(input()) # sample average of the data set
sd_box_weight = int(input())

total_weight = mean_box_weight*num_boxes
sd_sum = num_boxes**0.5 * sd_box_weight

print(round(cdf(weight_limit, total_weight, sd_sum), 4))

