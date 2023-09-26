a,b = map(int,input().split())

def search(a,b,count):
    if a>b:
        return -1
    if a==b:
        return count
    count1 = search(a*2,b,count+1)
    count2 = search(a*10+1,b,count+1)
    if count1 == -1 and count2 ==-1:
        return -1
    if count1 ==-1 and count2 !=-1:
        return count2
    elif count2==-1 and count1 !=-1:
        return count1
    else:
        return min(count1,count2)


result =search(a,b,0)
print (-1 if result==-1 else result+1)