open class Base {
    open lateinit var origin: String
}

class Derived : Base() {
    <!INAPPLICABLE_LATEINIT_MODIFIER!>override var origin: String
        get() = super.origin
        set(value) {}<!>
}