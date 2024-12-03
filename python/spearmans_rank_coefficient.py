def rank_calculator(numbers):
    num_rank = dict((x, i + 1) for i, x in enumerate(sorted(set(numbers))))
    return [num_rank[x] for x in numbers]

n = int(input())

set_x = list(map(float, input().strip().split(" ")))
set_y = list(map(float, input().strip().split(" ")))

rx = rank_calculator(set_x)
ry = rank_calculator(set_y)

rank_diffs_squared = [(rx[i] - ry[i]) ** 2 for i in range(n)]
spearmans_rank_coeff = 1 - (6 * sum(rank_diffs_squared)) / (n * (n ** 2 - 1))
print(round(spearmans_rank_coeff, 3))
