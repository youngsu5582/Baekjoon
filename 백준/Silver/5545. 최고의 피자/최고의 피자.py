import sys
import heapq
input = sys.stdin.readline

n = int(input())
a,b = map(int,input().split())
c = int(input())

ary = []
for _ in range(n):
    heapq.heappush(ary,-int(input()))



weight = c
price = a
max_cal = (weight //price)

while ary:
    element = heapq.heappop(ary)
    price+=b
    weight +=-element
    max_cal = max(max_cal,(weight //price))

print(max_cal)