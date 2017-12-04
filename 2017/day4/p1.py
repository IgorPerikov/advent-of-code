import collections

with open('input') as f:
    content = f.readlines()
content = [x.strip('\n') for x in content]
valid_count = 0
for pwd in content:
    pwd_words = pwd.split(' ')
    counter = collections.Counter()
    for pwd_word in pwd_words:
        counter[pwd_word] += 1
    word, count = counter.most_common(1)[0]
    if count == 1:
        valid_count += 1
print(valid_count)
