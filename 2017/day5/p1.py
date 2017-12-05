#!/usr/bin/python3
with open('input') as f:
    content = f.readlines()
content = [int(x.strip('\n')) for x in content]
count = 0
i = 0
while True:
    try:
        step = content[i]
        content[i] += 1
        i += step
        count += 1
    except:
        break
print(count)
