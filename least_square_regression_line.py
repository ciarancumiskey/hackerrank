n = 5
grades = [map(int, input().split(" ")) for _ in range(n)]
sum_x, sum_y, sum_x_sq, sum_xy = map(sum, zip(*[(x, y, x**2, x*y) for x, y in grades]))
b = (n * sum_xy - sum_x * sum_y) / (n * sum_x_sq - sum_x**2)
a = (sum_y / n) - b * (sum_x / n)
print(round((a + b * 80), 3)) # find the expected Y grade if the X grade is 80%
