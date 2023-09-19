n , k = map(int,input().split())
coins = []
for i in range(n):
    coins.append(int(input()))

ary = [0] * (k+1)
ary[0] = 1
for coin in coins:
    for index in range(coin,k+1):
        ps = ary[index-coin]
        ary[index] +=ps

print(ary[k])