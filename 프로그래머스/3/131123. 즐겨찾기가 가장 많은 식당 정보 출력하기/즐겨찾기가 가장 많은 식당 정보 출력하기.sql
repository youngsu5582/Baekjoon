-- 코드를 입력하세요
SELECT a.FOOD_TYPE,a.REST_ID,a.REST_NAME,a.FAVORITES
FROM REST_INFO a
WHERE FAVORITES IN(
SELECT MAX(b.FAVORITES)
FROM REST_INFO b
WHERE a.FOOD_TYPE = b.FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC


# REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요. 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.