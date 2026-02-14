package org.brokenarrow.storage.api.builders;

import java.util.function.Consumer;
import java.util.function.Function;

public interface ContainerDataHandler {

    void updateContainerData(Consumer<ContainerWrite> callback);

    void readContainerData(Consumer<ContainerRead> callback);
    <T> T readContainerData(Function<ContainerRead,T> callback);
}
