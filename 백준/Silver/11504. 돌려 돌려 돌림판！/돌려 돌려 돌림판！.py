from sys import stdin

input = stdin.readline
result = []
t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    x = int(''.join(list(map(str,input().split()))))
    y= int(''.join(list(map(str,input().split()))))
    ary = list(map(int,input().split()))
    total_count = 0
    for i in range(n):
        number = 0
        for j in range(i,i+m,1):
                number *=10
                number+=ary[j%n]
        if x<=number<=y:
            total_count+=1
    result.append(total_count)


for element in result:
     print(element)