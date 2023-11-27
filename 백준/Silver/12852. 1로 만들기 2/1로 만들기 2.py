import sys

input = sys.stdin.readline

n = int(input())

max_length = 100000
max_ary = [0]*(100000)

def dfs(n,ary):
    global max_ary
    global max_length
    if len(ary)>=max_length:
        return
    if n==1:
        ary.append(1)
        if max_length>len(ary):
            max_length = len(ary)
            max_ary = ary.copy()
        ary.pop()
        return
    ary.append(n)
    if n%3==0:
        dfs(n//3,ary)
    if n%2==0:
        dfs(n//2,ary)
    dfs(n-1,ary)
    ary.pop()
ary = []
dfs(n,ary)
print(len(max_ary)-1)
for element in max_ary:
    print(element,end=" ")