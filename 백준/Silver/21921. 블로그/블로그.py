n,m = map(int,input().split())
ary = list(map(int,input().split()))

array = [0] *(n+1)
max_number = 0
max_stack = []
su = 0
if m==1:
    for i in range(n):
        if ary[i]>=max_number:
            max_number = ary[i]
            max_stack.append(max_number)
else :
    for i in range(m):
       su+=ary[i]
    max_number = su
    max_stack.append(max_number)
    for j in range(m,n):
        su-= ary[j-m]
        su+=ary[j]
        if su>=max_number:
            max_number = su
            max_stack.append(max_number)
if(max_number==0):
    print("SAD")
else:
    print(max_number)
    print(len(max_stack)-max_stack.index(max_number))


