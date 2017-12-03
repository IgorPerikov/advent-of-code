import math

a = 347991
power = int(math.ceil(math.sqrt(a)))
if power % 2 == 0:
    power = power + 1
print(power)
part1 = math.floor(power / 2)
prev_power = power - 2
print(prev_power)

pattern = [None] * (power - 1)
init_value = math.floor(power / 2) - 1
flag = True
for i in range(power - 1):
    pattern[i] = init_value
    if flag:
        init_value -= 1
        if init_value <= 0:
            flag = False
    else:
        init_value += 1

print(pattern)
normalized_value = a - (prev_power ** 2 + 1)
index = normalized_value % (power - 1)
part2 = pattern[index]
print(part1 + part2)
