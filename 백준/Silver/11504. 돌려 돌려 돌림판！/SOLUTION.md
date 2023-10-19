### 문제 링크

https://www.acmicpc.net/problem/11504

### 문제 해석
- N 등분된 원형판 존재 , 임의 M 자리 수 X 와 Y ( X<=Y ) 주어짐
- M 칸 연속으로 읽은 값 Z 가 X<= Z <=Y 를 만족할 시 ,게임을 승리
- 게임을 승리할 수 있는 가지수 계산

### 문제 해결
-  T 와 N , M 의 값이 매우 작으므로 브루트 포스!
- 원형 큐를 생각하자 ! ( index % N )
- x , y 를 int 로 바꾼후 , z 를 계산하여 비교
### 슈도 코드
``` Text
x = 문자열로 받은 값 정수 변환
y = 문자열로 받은 값 정수 변환

result = 0

ary = 원형판 값이 들어가 있는 배열
for i 를 n까지 반복
	z = 0
	for j 를 i 부터 i+m 까지 반복
		z *= 10
		number += ary[j%n] ( 원형 큐 )

	if x<=z<=y:
		result +=1

result 출력
```

### 제출 코드
``` python
from sys import stdin

input = stdin.readline
result = []
t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    x = int(''.join(list(map(str,input().split()))))
    y= int(''.join(list(map(str,input().split()))))
    ary = list(map(int,input().split()))
    total_count = 0
    for i in range(n):
        number = 0
        for j in range(i,i+m,1):
                number *=10
                number+=ary[j%n]
        if x<=number<=y:
            total_count+=1
    result.append(total_count)


for element in result:
     print(element)
```

### 사담
- 브루트 포스가 아니라면 조금 어려울 지도
- 범위가 작으면 어떻게든 풀 생각을 하자!

##### Writed By Obisidan
