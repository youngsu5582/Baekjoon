import sys
input = sys.stdin.readline

t = int(input())

for _ in range (t):
    ary = list(map(str,input().split()))
    dct = {}
    while True:
        animal = input().strip()
        if(animal == "what does the fox say?"):
            break
        ani = animal.strip().split(" goes ")
        if ani[1] not in dct:
            dct[ani[1]] = True
    result = []
    for element in ary:
        if element not in dct:
            result.append(element)
    for element in result:
        print(element,end=" ")
    