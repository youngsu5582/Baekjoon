n = int(input())

ary = [n+1]*(n+1)
ary[0] =0
ary[1]=0
for i in range(2,n+1):
    number = n+1
    if i %3==0:
        if number > ary[int(i/3)]:
            number = ary[int(i/3)]
    if i %2==0:
        if number > ary[int(i/2)]:
            number = ary[int(i/2)]
    if number>ary[i-1]:
        number = ary[i-1]
    ary[i] = number+1
ary[0]=0
print(ary[n])