count = int(input())
nums = list(map(int,input().split()))
nums.sort()
max = nums[-1]
sum = max
for i in range(count-1):
    sum += nums[i]/2

print(sum)