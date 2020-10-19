open class Base {
    open lateinit var origin: String
}

class Derived : Base() {
    override var origin: String
        get() = super.origin
        set(value) {}
}