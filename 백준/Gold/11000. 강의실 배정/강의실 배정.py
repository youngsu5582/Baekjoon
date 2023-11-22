from sys import stdin
import heapq

input = stdin.readline

n = int(input())


ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))
hq = []

max_count=[0]


ary.sort()
ary.append([10**9+1,0])
min_ary = [ary[0][1]]
# 0 이 가장 작음
# 1 이 가장 큼
for index in range(1,n+1):
    element = ary[index][1]
    if ary[index][0]<min_ary[0]:
        heapq.heappush(min_ary,element)
    else:
#        min_ary[0]<=ary[index][0]
        heapq.heappushpop(min_ary,element)
    if ary[index][0]>=min_ary[-1]:
        if max_count[-1]<len(min_ary):
            max_count[-1]=len(min_ary)
        min_ary = [ary[index][1]]

print(max_count[-1])
