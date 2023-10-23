from sys import stdin
from collections import deque

input = stdin.readline

n = int(input())
ary = list(map(int,input().split()))

ary.sort()
max_number = 0
if n%2==1:
    max_number = ary.pop(-1)
for i in range(0,int(n/2)):
    number = ary[i]+ary[-i-1]
    max_number = max(max_number,number)


print(max_number)