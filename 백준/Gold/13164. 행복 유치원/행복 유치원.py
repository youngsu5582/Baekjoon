import sys
input = sys.stdin.readline

n,k = map(int,input().split())

ary = list(map(int,input().split()))
greedy = []

for i in range(1,n):
    greedy.append( ary[i]-ary[i-1])


greedy.sort(reverse=True)
print(sum(greedy[k-1:]))