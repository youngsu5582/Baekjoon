import sys
input = sys.stdin.readline
import heapq

n = int(input())
ary=[]
for _ in range(n):
    heapq.heappush(ary,int(input()))



count = 1
result =0
while ary:
    element = heapq.heappop(ary)
    result += abs(count-element)
    count +=1   

print(result)