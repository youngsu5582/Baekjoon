from sys import stdin

input = stdin.readline

n = int(input())
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))

ary.sort()
ary.append([float("inf"),float("inf")])
sum = 0
first = ary[0]
for index in range(1,len(ary)):
    if ary[index][0]<first[1]:
        if first[1]<ary[index][1]:
            first[1] = ary[index][1]
    else:
        sum += first[1]-first[0]
        first = ary[index]
print(sum)