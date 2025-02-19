class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        
        val defaultMinute = fees[0]
        val defaultPrice = fees[1]
        val unitTime = fees[2]
        val unitPrice = fees[3]
        
        val visited = mutableMapOf<Int,Int>()
        val totaled = mutableMapOf<Int,Int>()
        
        for(record in records){
            val temp = record.split(" ")
            val time = convertInt(temp[0])
            val carNumber = temp[1].toInt()
            val status = temp[2]
            
            if(status == "IN"){
                visited.put(carNumber,time)
            }else{
                val prevTime = visited.get(carNumber)!!
                val totalTime = totaled.getOrDefault(carNumber,0)
                visited.put(carNumber,1439)
                totaled.put(carNumber,totalTime + time - prevTime)
            }
        }
        for(carNumber in visited.keys){
            val prevTime = visited.get(carNumber)!!
            val totalTime = totaled.getOrDefault(carNumber,0)
            totaled.put(carNumber,totalTime + 1439 - prevTime)
        }
        
        val answer = mutableListOf<Int>()
        
        for(sortedKey in totaled.keys.sorted()){
            val totalTime = totaled.get(sortedKey)!!
            if(totalTime <= defaultMinute){
                answer.add(defaultPrice)
            }else {
                
                val count = calculateTime(totalTime-defaultMinute,unitTime)
                // println("$totalTime\t$defaultMinute\t$sortedKey\t$count")
                answer.add(defaultPrice + count*unitPrice)
            }
        
        }
        
        return answer.toIntArray()
    }
    private fun calculateTime(time:Int,unit:Int):Int{
        return if(time % unit == 0) time / unit
        else time / unit + 1        
    }
    private fun convertInt(time:String):Int{
        val temp = time.split(":").map{it.toInt()}
        return temp[0]*60 + temp[1]
    }
    
    
}
// enum class Status(val name:String){
//     IN("입차"),OUT("출차")
// }{
//     companion object{
//         fun from(value:String){
//             if(value=="입차"){
//                 return IN
//             }else{
//                 return OUT
//             }
//         }
//     }
// }

// 34분, 300분 ( 23:59 까지이므로 )
// 9600 + 5000 = 14600

//주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산
// 00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산
// 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구
// 적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구
    // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면 올림한다.
    
    
// 기본 시간 : 1439 ( 23 * 60 + 59 = 1439)
// 기본 요금 : 100,000
// 단위 시간 : 1439
// 단위 요금 : 10,000
// records 길이 : 1000
    // 시각,차량번호,내역 - 공백 구분
        // 시각 : HH:MM - 길이 5인 문자열
        // 차량번호 : 0~9로 구성된 길이 4인 문자열
        // 내역 : 2,3 인 문자열 - IN or OUT
    // 시각 기준 오름차순
    // 다음날 출차는 입력으로 주어지지 않는다.
    // 같은 시각에, 같은 차량번호 내역이 2번 이상 나타나지 않는다.
    // 23:59 입차하는 경우는 주어지지 않는다.
    