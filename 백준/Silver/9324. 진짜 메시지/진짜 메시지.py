import sys
input = sys.stdin.readline

n = int(input())
result = []
for _ in range(n):
    string = input().strip()
    dct={}
    size = len(string)
    index = 0
    string+="a"
    while index!=size:
        element = string[index]
        if element in dct:
            dct[element]+=1
        else:
            dct[element]=1
        if dct[element]%3==0:
            if string[index+1]!=element:
                break
            else:
                index+=1
        index+=1
            
    if index==size:
        result.append("OK")
    else:
        result.append("FAKE")


for element in result:
    print(element)