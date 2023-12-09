import sys
input = sys.stdin.readline

n,w,l = map(int,input().split())


t = 1
ary = list(map(int,input().split()))

stack = [ary.pop(0)]
time = [t+w]
while ary:

    element = ary[0]
    t+=1
    if time[0]<=t:
         stack.pop(0)
         time.pop(0)
    if sum(stack)+element<=l:
        stack.append(ary.pop(0))
        time.append(t+w)

t = max(t,time[-1])
print(t)
    
# if stack:
#         size = len(stack)-1
#         t += (w-size)
#         size-=1
#         stack=[]
# print(t)
