-- 코드를 입력하세요
SELECT product_code,p.price*sum(sales_amount) as SALES
from PRODUCT p
JOIN OFFLINE_SALE o
ON p.product_id = o.product_id
group by(p.product_code)
ORDER BY SALES DESC,product_code ASC

# PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 
# 결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.

# 상품코드는 8자리, 앞 2자리는 카테고리 코드