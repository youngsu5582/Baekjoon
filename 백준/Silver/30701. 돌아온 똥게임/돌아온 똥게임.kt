import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, d) = readLine().split(" ").map { it.toInt() }
    val monster = mutableListOf<Long>()
    val equip = mutableListOf<Long>()


    repeat(n) {
        val st = StringTokenizer(readLine())
        val command = st.nextToken().toInt()
        val info = st.nextToken().toLong()
        if (command == 1) {
            monster.add(info)
        } else {
            equip.add(info)
        }
    }

    monster.sort()
    equip.sort()

    var count = 0
    var human = d.toLong()
    while (monster.isNotEmpty() || equip.isNotEmpty()) {
        // 몬스터 방 조회
        if (monster.isNotEmpty()) {
            val mon = monster.removeFirst()
            if (isWin(mon, human)) {
                human += mon
                count++
                continue
            }
            // 못이기시 장비 조회 - 이길때까지 계속 조회 해야 한다.
            while (equip.isNotEmpty()) {
                val e = equip.removeFirst()
                human *= e
                count++
                if (isWin(mon, human)) {
                    human += mon
                    count++
                    break
                }
            }
            if(isWin(mon,human).not()) {
                break
            }
            continue
        }
        if (equip.isNotEmpty()) {
            human *= equip.removeFirst()
            count++
        }
    }
    println(count)
}


private fun isWin(monster: Long, human: Long): Boolean {
    return monster < human
}