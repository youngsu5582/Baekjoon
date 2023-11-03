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
    count = 0
    temp = []
    for j in range(n):
        if len(ary[j])<=i:
            count+=1
            continue
        if ary[j][i] not in temp:
            temp.append(ary[j][i])
        if len(temp) + count==n:
            print(i+1)
            exit(0)