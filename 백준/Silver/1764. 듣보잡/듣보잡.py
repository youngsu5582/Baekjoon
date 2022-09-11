dict = {}

data = list(map(int, input().split()))
num = 0
list = []
for i in range(data[0]):
    str = input()
    dict[str] = 1
for i in range(data[1]):
    str = input()
    if str not in dict:
        continue
    else:
        list.append(str)

print(len(list))
for temp in (sorted(list)):
    print(temp)
