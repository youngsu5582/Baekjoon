### 문제 링크
https://www.acmicpc.net/problem/13903

### 문제 해석
- 준규는 회사 가는 길을 규칙에 맞추어서 걷는다.
	- 세로 블록만 밟는다
	- 특정 규칙으로만 이동
	- 첫 번쨰 row 에서 출발해 마지막 row 에 도착시 출근 성공
- 최소한의 걸음으로 출근 하기


### 문제 해결
-  bfs 로 해결하자! ( queue 에 x y count 추가 )
- 가장 먼저 도착하는게 , 제일 짧은 경우이므로 확인후 break
- visited 배열을 통해 왔다 갔다 방지 ( 0 1 -> 1 1 -> 0 1)
### 슈도 코드
``` Text
rule = 규칙들 저장 ( [0,1] , [1,2] ) - 등등 
queue = []
for i 를 c까지 반복
	만약 board[0][i] 가 1이라면 ( 세로 블록 )
		queue 에 [0,i,0]
while queue
	x , y , count = queue.popleft()
	if x== r-1: ( 마지막 row 에 도달)
		print(count)
	for rule 에 있는 element 반복
		next_x = x + element[0]
		next_y = y + element[1]
		if 0<= next_x r && 0<= next_y <c and visited[next_x][next_y] == false 라면
			visited[next_x][next_y] = true
			if board[next_x][next_y] 가 1이라면 ( 세로 블록 )
				queue.append([next_x,next_y,count+1])

```

### 제출 코드
``` python
import sys
from collections import deque
input = sys.stdin.readline


r,c = map(int,input().split())

visited = [[False] * c for _ in range(r)]

board = []
for _ in range(r):
    board.append(list(map(int,input().split())))

n = int(input())
rule = []
for _ in range(n):
    rule.append(list(map(int,input().split())))

max_stack = [float('inf')]

queue = deque()


for i in range(c):
    if board[0][i] ==1:
        queue.append([0,i,0])


while queue:
    x,y,count= queue.popleft()
    if x==r-1:
        if max_stack[-1]>count:
            max_stack.append(count)
            break

    for element in rule:
        next_x = element[0]+x
        next_y = element[1]+y
        if 0<=next_x < r and 0<=next_y<c and visited[next_x][next_y]is False:
            visited[next_x][next_y]=True
            if board[next_x][next_y]==1:
                queue.append([next_x,next_y,count+1])

if len(max_stack)==1:
    print(-1)
else:
    print(max_stack[-1])
```

### 사담
- 사실 dfs 든 , bfs 든 어떻게든 풀 수는 있으나 시간 초과 나 메모리 초과가 발생한다.
- 중복 방지를 하는게 포인트 ( 하지 않으면 무한 반복 )

##### Writed By Obisidan
