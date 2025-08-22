package org.brokenarrow.storage.api.Crafting.util;

import org.brokenarrow.storage.api.craftselltask.TaskProvider;

import java.util.function.Consumer;

public interface TaskSectionApi {

    TaskSectionApi body(Consumer<TaskProvider> body);
}
