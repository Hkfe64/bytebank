fun main() {
    println("Bytebank")

    val contaHugo = Conta("Hugo", 1234)

    val contaHkfe = Conta("Hkfe", 1235)

    contaHugo.depositar(2000.0)
    contaHkfe.depositar(546.8)

    contaHugo.transferir(contaHkfe, 300.0)

    contaHugo.sacar(80.0)

    println(contaHugo.toString())
    println(contaHkfe.toString())
}

class Conta(var titular: String, val numero: Int) {
    var saldo: Double = 0.0
        private set

    override fun toString(): String {
        return "Titular: $titular \tConta: $numero \tSaldo: ${testaCondicoes(saldo)} $saldo \t"
    }

    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double) {
        saldo -= valor
    }

    fun transferir(outraConta: Conta, valor: Double): Boolean {
        return if (saldo > valor) {
            this.sacar(valor)
            outraConta.depositar(valor)
            true
        } else false
    }
}


fun testaCondicoes(saldo: Double): String {
    return when {
        saldo > 0.0 -> "Positivo"
        saldo.equals(0.0) -> "Zerado"
        else -> "Negativo"
    }
    /*
    if(saldo > 0.0) {
        println("Saldo positivo")
    } else if (saldo.equals(0.0)) {
        println("Zerado")
    } else {
        println("Saldo negativo")
    }
     */
}

fun aula01() {
    for (i in 1..5) { // i in 5 downTo 1 step 2
        val titular = "Hugo $i"
        val numeroConta = 1000 + i
        var saldo = i + 10.0
        //
        saldo += 0.2
        //
        println("Titular: $titular")
        println("Conta: $numeroConta")
        print("Saldo: $saldo ")
        testaCondicoes(saldo)
    }
}