package org.log2.properties

/**
 * if we remove the private var from the properties, then the getters and setters will automatically
 * become recursive and we will get a StackOverflow error.
 *
 * The moral of the story is that if we want to implement a java interface with getter and setters,
 * then we are required to implement those getter and setters manually.
 *
 * However, we can still use these getters and setters as normal properties in kotlin code.
 * We just need to write a little more boilerplate, which is disappointing, but workable.
 *
 * The other way around works as expected. A java implementation of a kotlin interface that has a property
 * will just have to implement getters and setters for that property.
 */
class ImplJavaInterfaceWithProperties(private var property: Int, private var nullableProperty: Int?) :
    JavaInterfaceWithProperties {
    override fun getProperty(): Int {
        return property;
    }

    override fun setProperty(i: Int) {
        property = i
    }

    override fun getNullableProperty(): Int? {
        return nullableProperty
    }

    override fun setNullableProperty(i: Int?) {
        nullableProperty = i
    }
}