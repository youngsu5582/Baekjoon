import sys
import heapq
input = sys.stdin.readline



n = int(input())
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))

ary.sort()
queue = []

for element in ary:
    heapq.heappush(queue,element[1])
    if element[0]<len(queue):
        heapq.heappop(queue)

print(sum(queue))