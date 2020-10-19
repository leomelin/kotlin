typealias Some = (Any) -> String?

object Factory {
    fun foo(
        a: String,
    ): String = "Alpha"

    fun foo(
        a: String,
        f: Some
    ): String = "Omega"
}

interface Delegate {
    fun bar()
}

data class DataClass(val delegate: Delegate): Delegate by delegate