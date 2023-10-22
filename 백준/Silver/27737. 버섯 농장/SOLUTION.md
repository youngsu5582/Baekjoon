### 문제 링크

https://www.acmicpc.net/problem/27737
### 문제 해석
- N * N 칸으로 이루어진 나무판에서 버섯 농사를 지음
- 버섯 포자가 연결된 칸에 버섯을 자라게 한다. ( 상화좌우 한 변 공유는 칸 들 집합 )
- x개 버섯 포자를 겹쳐 심으면 x * k 개의 연결된 칸에 버섯이 자란다.
- 주어진 포자로 , 버섯 농사 불가능하면 IMPOSSIBLE 출력
- 가능하면 , POSSIBLE 출력 후 , 다음 줄에 남은 버섯 포자 개수 출력
### 문제 해결
-  bfs 로 순회하자
- 반복문을 순회해서 , 자라야 하는 곳을 찾은 후 bfs 에 넣자
- bfs 를 순회할때마다 count ++
- 배열에 저장후 한번에 계산하자
### 슈도 코드
``` Text
board = 상태를 저장한 배열
queue =[]
result = 결과 배열

for i를 n 만큼 반복
	for j를 n 만큼 반복
		if board[i][j] 가 1이라면
			continue
		if visited[i][j] 가 true라면
			continue
		queue 에 [i,j] 추가
		visited[i][j] = true
		count = 0


		while queue 가 있을때까지
			element = queue.pop()
			for 동서남북 반복
				next = 다음 향할곳
				if next_x,next_y 가 0가 n사이에 있다면
					if board[next_x][next_y] 가 0이라면
						if visited[next_x][next_y] 가 false라면
							visited[next_x][next_y] = true
							queue 에 [next_x,next_y] 추가
		결과 배열에 count 추가

for 결과 배열에서 element 추출
	spore = ceil ( element / k )
	if m>=spore 라면
		m -= spore
	else
		print("IMPOSSIBLE")
		exit(0)

print(POSSIBLE)
print(m)
```

### 제출 코드
``` python
from sys import stdin
import math

input = stdin.readline


n,m,k = map(int,input().split())

board = []
for _ in range(n):
    board.append(list(map(int,input().split())))

visited = [[False]* n for _ in range (n)]


direction_x = [-1,0,1,0]
direction_y = [0,1,0,-1]
mushroom = []

for i in range(n):
    for j in range(n):
        if board[i][j]==1:
            continue
        if visited[i][j]==True:
            continue
        queue = []
        queue.append([i,j])
        visited[i][j]=True
        count = 0
        while queue:
            element = queue.pop(0)
            x = element[0]
            y = element[1]
            count+=1
            for index in range(4):
                next_x = x+direction_x[index]
                next_y = y + direction_y[index]
                if 0<=next_x<n and 0<=next_y<n:
                    if board[next_x][next_y]==0:
                        if visited[next_x][next_y] is False:
                            visited[next_x][next_y] = True
                            queue.append([next_x,next_y])
        mushroom.append(count)

if len(mushroom)==0:
    print("IMPOSSIBLE")
    exit(0)

for element in mushroom:
    spore = math.ceil(element/k)
    if m>=spore:
        m-=spore
    else:
        print("IMPOSSIBLE")
        exit(0)
print("POSSIBLE")
print(m)
```

### 사담
- 실버 1치곤 매우 쉬웠던 거 같은 문제
- 어려운 골드 dfs , bfs 문제랑 실버 dfs , bfs 문제는 차이가 너무 많이 나는거 같다.

##### Writed By Obisidan
