dict = {}
N = int(input())

data = list(map(int, input().split()))
for temp in data:
    if temp not in dict:
        dict[temp] = 1
    else:
        dict[temp] += 1
M = int(input())

data = list(map(int, input().split()))

for i in range(M):
    if(dict.get(data[i])):
        print(dict.get(data[i]), end=' ')
    else:
        print(0, end=' ')
