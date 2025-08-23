package org.brokenarrow.storage.api.craftselltask.message;

import org.brokenarrow.storage.api.craftselltask.TaskDataApi;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;

import java.util.function.Consumer;

public interface TaskMessageSectionApi {

    TaskMessageSectionApi body(Consumer<TaskDataApi> body);

    TypeOfTask getTaskType();
}
