
num = int(input())
array = []
def find_heart():
    for row_index,line in enumerate(array):
        for col_index,element in enumerate(line):
            if element==1:
                return row_index+1,col_index
def find_arm(heart):
    left_length = 0
    right_length = 0
    x,y = heart
    while y-1-left_length >= 0 and  array[x][y-1-left_length]!=0:
        left_length+=1
    while  y+1+right_length < num and  array[x][y+1+right_length]!=0:
        right_length+=1
    return left_length,right_length

def find_waist(heart):
    x,y = heart
    waist_length = 1
    while array[x+1+waist_length][y]!=0:
        waist_length+=1
    return waist_length

def find_leg(heart,waist_length):
    x,y = heart
    x = x+waist_length
    left_length = 0
    right_length = 0
    while (x + 1 + left_length < num and array[x + 1 + left_length][y - 1] != 0):
        left_length += 1
    while (x + 1 + right_length < num and array[x + 1 + right_length][y + 1] != 0):
        right_length += 1
    return left_length,right_length


def parsing_input():
    for i in range(num):
        temp = input()
        line = []
        for element in temp:
            if element=="_":
                line.append(0)
            else:
                line.append(1)
        array.append(line)
    return

def solution(num):
    parsing_input()
    heart = find_heart()
    arms = find_arm(heart)
    waist = find_waist(heart)
    legs = find_leg(heart,waist)
    return heart,arms,waist,legs


heart,arms,waist,legs = solution(num)
print(heart[0]+1,heart[1]+1)
print(arms[0],arms[1],waist,legs[0],legs[1])
