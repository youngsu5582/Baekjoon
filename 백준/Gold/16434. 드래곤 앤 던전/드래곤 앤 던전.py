import sys
input = sys.stdin.readline

n,h = map(int,input().split())

left = 1
right = 10**21
ary = []
for _ in range(n):
    ary.append(list(map(int,input().split())))
result = right
while left<=right:
    mid = (left+right)//2
    t_atk = h
    t_hp = mid
    for x,y,z in ary:
        if t_hp<=0:
            break
        if x==1:
            if z<=t_atk:
                continue
            else:
                e = z//t_atk if not z % t_atk else z//t_atk+1
                t_hp -= (e-1)*y
        else:
            t_atk +=y
            t_hp = min(mid,t_hp+z)
    if t_hp<=0:
        left = mid+1
    else:
        result=mid
        right = mid-1
print(result)