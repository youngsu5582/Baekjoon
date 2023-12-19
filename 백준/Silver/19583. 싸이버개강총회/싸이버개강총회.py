import sys
input = sys.stdin.readline

def convert(timeInfo : str):
    time = timeInfo.split(":")
    return int(time[0])*60 + int(time[1])


roll = {}

start, mid, end = map(str,input().split())
start = convert(start)
mid = convert(mid)
end = convert(end)


dct = {}
while True:
    info = input()
    if len(info)<5:
        break
    # 시작전 출첵
    timeInfo,name = info.split()
    time = convert(timeInfo)
    if (time<=start):
        dct[name] =1
    if(mid<=time<=end):
        if name in dct:
            dct[name] =2

count = 0
for value in dct.values():
    if(value==2):
        count+=1

print(count)