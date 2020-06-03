// CURIOUS_ABOUT <init>, invoke, g, f, a, b, c, d, _____get_firstName$_______Sharable____, _____get_lastName$_______Sharable____, _set_____firstName$_______Sharable____, _set_____lastName$_______Sharable____, toString, hashCode
// WITH_RUNTIME

import kotlinx.stm.*

@SharedMutable
class User(fname: String, lname: String) {
    var firstName: String = fname
    var lastName: String = lname
//    val stm: STM = STMSearcher.findStm()
//    val firstName$SHARABLE: UniversalDelegate<String> = stm.wrap(fname)
//    val lastName$SHARABLE: UniversalDelegate<String> = stm.wrap(lname)

//    fun _set_firstName$SHARABLE(ctx: STMContext, newValue: String) { stm.setVar(ctx, firstName$SHARABLE, newValue) }
//    fun _get_firstName$SHARABLE(ctx: STMContext): String = stm.getVar(ctx, firstName$SHARABLE)

//    fun _set_lastName$SHARABLE(ctx: STMContext, newValue: String) { stm.setVar(ctx, lastName$SHARABLE, newValue) }
//    fun _get_lastName$SHARABLE(ctx: STMContext): String = stm.getVar(ctx, lastName$SHARABLE)

    fun f(): String /* = runAtomically*/ {
        val x = firstName.hashCode()
        val y = firstName.hashCode()
        return "$x:$y"
    }

    override fun toString(): String /* = runAtomically*/ {
        return "atomic(2) user is: $firstName $lastName"
    }
}


@AtomicFunction
fun User.d(block: (User) -> String) = block(this)

@AtomicFunction
fun ((User) -> User).c(u: User, block: (User) -> String) = this(u).d(block)

@AtomicFunction
fun b(u: User, transform: (User) -> User, block: (User) -> String) = transform.c(u, block)

@AtomicFunction
fun a(u: User) {
    println(b(u, { it }) { "atomic user is: ${u.firstName} ${u.lastName}" })
}

fun g() {
    val u = User("Vadim", "Briliantov")

    runAtomically {
        val tmp = u.firstName
        u.firstName = u.lastName
        u.lastName = tmp

        a(u)
    }

    println(u.firstName)
}

@SharedMutable
object SM {
    var x: Int = 21
}

fun g2() {
    SM.x = 42
}