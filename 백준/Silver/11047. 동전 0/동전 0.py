from sys import stdin

input = stdin.readline

n,k = map(int,input().split())

ary = []
for _ in range(n):
    ary.append(int(input()))

coin = 0

for i in range(n-1,-1,-1):
    coin += k//ary[i]
    k %= ary[i]


print(coin)