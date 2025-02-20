fun main() = with(System.`in`.bufferedReader()){
    val line = readLine()
    val temp = line[0]
    if(line.count{it==temp}==line.length){
        println(-1)
        return
    }

    // 어차피 무조건 깨짐
    // ABBBA -> B 에서 깨짐
    // 안깨지면, 하나만 제외
    for(i in 0 until line.length / 2){
        if(line[i] != line[line.length-i-1]){
            println(line.length)
            return
        }
    }
    println(line.length-1)
}