package org.log2.properties;

import org.jetbrains.annotations.Nullable;

public interface JavaInterfaceWithProperties {
    int getProperty();

    void setProperty(int i);

    @Nullable Integer getNullableProperty();

    void setNullableProperty(@Nullable Integer property);
}
