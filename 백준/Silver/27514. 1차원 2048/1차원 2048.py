from sys import stdin
from collections import deque
import math
n = int(input())
temp = list(map(int,input().split()))
ary = [0] * 64

for element in temp:
    if element==0:
        continue
    ary[int(math.log(element,2))]+=1
    
for index in range(0,63):
    element = int(ary[index]/2)
    ary[index+1]+=element

index = 63
while index !=-1 and ary[index]==0:
    index-=1
if index==-1:
    print(0)
else:
    print(2**index)