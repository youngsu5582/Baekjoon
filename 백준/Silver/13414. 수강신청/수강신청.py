import sys
input = sys.stdin.readline

n,v = map(int,input().split())
ary = []
dct = {}
for i in range(v):
    element = input().strip()
    dct[element]= i
count = 0
for element in sorted(dct,key=dct.__getitem__):
    if count==n:
        break
    count+=1
    print(element)