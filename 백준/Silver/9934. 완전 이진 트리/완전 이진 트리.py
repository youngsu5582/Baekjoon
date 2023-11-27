import sys

input = sys.stdin.readline

n = int(input())
ary = list(map(int,input().split()))

result = []
for _ in range(n):
    result.append([])
def dfs(left,right,count):
    if left>right:
        return
    if count==n:
        return
    mid = (left+right)//2
    result[count].append(ary[mid])
    dfs(left,mid-1,count+1)
    dfs(mid+1,right,count+1)
dfs(0,len(ary),0)
for array in result:
    for element in array:
        print(element,end=" ")
    print()