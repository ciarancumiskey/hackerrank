data_size = int(input())
set_x = list(map(float,input().strip().split(" ")))
mean_x = sum(set_x)/data_size
#Use the standard deviation formula of sd(X)=(sum((xi - mu_x)**2)/N)**0.5
sd_x = (sum([(i - mean_x)**2 for i in set_x])/data_size)**0.5
set_y = list(map(float,input().strip().split(" ")))
mean_y = sum(set_y)/data_size
sd_y = (sum([(i - mean_y)**2 for i in set_y])/data_size)**0.5
#Use the covariance formula of cov(X, Y)=(sum((xi - mu_X)*(yi - mu_Y)))
covariance = sum([(set_x[i] - mean_x)*(set_y[i] - mean_y) for i in range(data_size)])
pearson_coeff = covariance/(data_size * sd_x * sd_y)
print(round(pearson_coeff, 3))
