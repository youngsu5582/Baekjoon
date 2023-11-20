from sys import stdin
import heapq

input = stdin.readline

n = int(input())
ary = []
for _ in range(n):
    heapq.heappush(ary,int(input()))
result = 0
while len(ary)!=1:
    first = heapq.heappop(ary)
    second = heapq.heappop(ary)
    temp = first+second
    result+=temp
    heapq.heappush(ary,temp)

print(result)