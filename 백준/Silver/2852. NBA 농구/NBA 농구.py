n = int(input())
first_score = 0
second_score = 0

first_time = 0
second_time = 0

prev_time = 0


for i in range(n):
    team,time = input().split()
    minute,second = time.split(":")
    time = int(minute)*60 + int(second)
    if i==0:
        prev_time = time
        if team=='1':
            first_score+=1
        else:
            second_score+=1
        continue
    if first_score>second_score:
        first_time += time - prev_time
    elif second_score>first_score:
        second_time += time - prev_time
    prev_time = time
    if team=='1':
        first_score+=1
    else:
        second_score+=1
 

if first_score>second_score:
    first_time += 48*60 - prev_time
elif second_score>first_score:
    second_time += 48*60 -prev_time

print(f"{first_time//60:02}:{first_time%60:02}")
print(f"{second_time//60:02}:{second_time%60:02}")



