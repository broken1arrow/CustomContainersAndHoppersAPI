package org.brokenarrow.storage.api.stats;

import org.brokenarrow.storage.api.craftselltask.TaskProvider;

import javax.annotation.Nonnull;

public interface Stats {

    void updateFrom(@Nonnull final TaskProvider data, final int amount);

    int getTotalAmount();

    Stats copy();
}
