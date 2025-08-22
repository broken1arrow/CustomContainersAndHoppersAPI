package org.brokenarrow.storage.api.stats;

import org.brokenarrow.storage.api.craftselltask.TaskDataApi;

import javax.annotation.Nonnull;

public interface Stats {

    void updateFrom(@Nonnull final TaskDataApi data);

    int getTotalAmount();

}
