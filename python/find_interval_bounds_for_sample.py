sample_size = int(input())
pop_mean = float(input())
sd_pop = float(input())
mid_interval = float(input())
z_score = float(input())

sd_sample = sd_pop/sample_size**0.5
print(round(pop_mean - sd_sample * z_score, 2)) #Lower bound of interval
print(round(pop_mean + sd_sample * z_score, 2)) #Upper bound of interval
