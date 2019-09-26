package org.log2.properties

// See ImplJavaInterfaceWithProperties for an explanation
fun main() {
    val javaImplInKotlin = ImplJavaInterfaceWithProperties(0, 1)
    println("${javaImplInKotlin.property} ${javaImplInKotlin.nullableProperty}")

    println("${javaImplInKotlin.property} ${javaImplInKotlin.nullableProperty}")
    println("${javaImplInKotlin.getProperty()} ${javaImplInKotlin.getNullableProperty()}")
}