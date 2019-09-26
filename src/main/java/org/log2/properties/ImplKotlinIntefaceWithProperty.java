package org.log2.properties;

import org.jetbrains.annotations.Nullable;
import org.log2.properties.KotlinInterfaceWithProperty;

public class ImplKotlinIntefaceWithProperty implements KotlinInterfaceWithProperty {
    private int property;
    private Integer nullableProperty;

    @Override
    public int getProperty() {
        return property;
    }

    @Override
    public void setProperty(int i) {
        property = i;
    }

    @Nullable
    @Override
    public Integer getNullableProperty() {
        return nullableProperty;
    }

    @Override
    public void setNullableProperty(@Nullable Integer integer) {
        nullableProperty = integer;
    }
}
