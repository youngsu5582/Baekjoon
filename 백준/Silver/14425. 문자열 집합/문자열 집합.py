data = list(map(int, input().split()))
N = data[0]
M = data[1]
string_set = set()

num = 0
for i in range(N):
    string_set.add(input())
for i in range(M):
    str = input()
    if str in string_set:
        num += 1

print(num)
