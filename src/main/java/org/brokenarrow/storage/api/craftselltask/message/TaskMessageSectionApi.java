package org.brokenarrow.storage.api.craftselltask.message;

import org.brokenarrow.storage.api.craftselltask.TaskDataApi;
import org.brokenarrow.storage.api.craftselltask.TaskProvider;
import org.brokenarrow.storage.api.craftselltask.util.TypeOfTask;
import org.brokenarrow.storage.api.stats.Stats;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public interface TaskMessageSectionApi {
    /**
     * Retrieve the containers' location.
     *
     * @return the location of the container.
     */
    @Nonnull
    Location getLocation();

    /**
     * Defines and executes the body message logic for the multi-line message.
     * <p>
     * The provided consumer is invoked once for each completed task and can be used
     * to send per-task information to the player (for example, one entry per craft
     * or sale), depending on how
     * {@link TaskProvider#sendBodyMessage(Player, MessageSenderApi)} is configured.
     *
     * @param body a consumer that handles individual task data
     * @throws NullPointerException if {@code body} is {@code null}
     */
    void onBody(Consumer<TaskDataApi> body);

    /**
     * Sends the header for a multi-line message to the player.
     * <p>
     * The header is sent once per {@link TypeOfTask} and is typically used to
     * provide context for the following body messages, such as a title or timestamp.
     * <p>
     * The given consumer is invoked only if {@code stats} is present and valid
     * (i.e. non-null and with a total amount greater than or equal to zero).
     * Implementations of {@link Stats} are responsible for providing a meaningful
     * value via {@link Stats#getTotalAmount()}.
     * <p>
     * If the stats are missing or invalid, this method performs no action.
     *
     * @param headerConsumer a consumer that receives the current {@link Stats};
     *                       must not be {@code null}
     * @throws NullPointerException if {@code headerConsumer} is {@code null}
     */
    void onHeader(@Nonnull final Consumer<Stats> headerConsumer);

    /**
     * Sends the footer for a multi-line message to the player.
     * <p>
     * The footer is sent once per {@link TypeOfTask} and is typically used to
     * summarize the results of the executed tasks, such as totals or earnings.
     * <p>
     * The given consumer is invoked only if {@code stats} is present and valid
     * (i.e. non-null and with a total amount greater than or equal to zero).
     * Implementations of {@link Stats} are responsible for providing a meaningful
     * value via {@link Stats#getTotalAmount()}.
     * <p>
     * If the stats are missing or invalid, this method performs no action.
     *
     * @param footerConsumer a consumer that receives the current {@link Stats};
     *                       must not be {@code null}
     * @throws NullPointerException if {@code footerConsumer} is {@code null}
     */
    void onFooter(@Nonnull final Consumer<Stats> footerConsumer);

    /**
     * The type of task this tore data for.
     *
     * @return the task typ for example sell or crafting.
     */
    TypeOfTask getTaskType();
}
