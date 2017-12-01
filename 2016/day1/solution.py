def next_direction(direction, change):
    if change == 'R':
        if direction == 3:
            return 0
        else:
            return direction + 1
    else:
        if direction == 0:
            return 3
        else:
            return direction - 1


def move(x, y, direction, change, amount):
    ch = next_direction(direction, change)
    if ch == 0:
        y += int(amount)
    if ch == 1:
        x += int(amount)
    if ch == 2:
        y -= int(amount)
    if ch == 3:
        x -= int(amount)
    return x, y, ch

xx = 0
yy = 0
direction = 0  # 0 for north, 1 for east, 2 for south, 3 for west
inp = "R5, L2, L1, R1, R3, R3, L3, R3, R4, L2, R4, L4, R4, R3, L2, L1, L1, R2, R4, R4, L4, R3, L2, R1, L4, R1, R3, L5, L4, L5, R3, L3, L1, L1, R4, R2, R2, L1, L4, R191, R5, L2, R46, R3, L1, R74, L2, R2, R187, R3, R4, R1, L4, L4, L2, R4, L5, R4, R3, L2, L1, R3, R3, R3, R1, R1, L4, R4, R1, R5, R2, R1, R3, L4, L2, L2, R1, L3, R1, R3, L5, L3, R5, R3, R4, L1, R3, R2, R1, R2, L4, L1, L1, R3, L3, R4, L2, L4, L5, L5, L4, R2, R5, L4, R4, L2, R3, L4, L3, L5, R5, L4, L2, R3, R5, R5, L1, L4, R3, L1, R2, L5, L1, R4, L1, R5, R1, L4, L4, L4, R4, R3, L5, R1, L3, R4, R3, L2, L1, R1, R2, R2, R2, L1, L1, L2, L5, L3, L1".replace(" ", "")

split = inp.split(',')

for v in split:
    v1 = v[:1]
    v2 = v[1:]
    xx, yy, direction = move(xx, yy, direction, v1, v2)
print(abs(xx) + abs(yy))
