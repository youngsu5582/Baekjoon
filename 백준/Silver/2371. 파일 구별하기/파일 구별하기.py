from sys import stdin
input = stdin.readline

n = int(input())
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))

max_element = 0
for i in range(n):
    if len(ary[i])>max_element:
        max_element = len(ary[i])

for i in range(max_element):
    result = set()
    for j in range(n):
        result.add(tuple(ary[j][:i+1]))
    if len(result)==n:
        print(i+1)
        exit(0)