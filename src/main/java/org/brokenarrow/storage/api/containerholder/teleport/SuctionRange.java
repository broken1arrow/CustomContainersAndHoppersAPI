package org.brokenarrow.storage.api.containerholder.teleport;

/**
 * Represents the suction range used for item pickup.
 * <p>
 * The range can be defined in one of two ways:
 * </p>
 * <ul>
 * <li><strong>Block radius</strong>: A radius in X, Y, and Z directions from a central point</li>
 * <li><strong>Chunk radius</strong>: A radius in chunks, not tied to a specific position</li>
 * </ul>
 * <p>
 * If the range is chunk-based, the block radius values will be set to {@code -1}.
 * If the range is block-based, the chunk radius will be set to {@code -1}.
 * </p>
 */
public class SuctionRange {
    private final int radiusY;
    private final int radiusZ;
    private final int radiusX;
    private final int chunkRadius;

    /**
     * Creates a suction range tied to a specific block location.
     *
     * @param radiusX the radius along the X-axis
     * @param radiusY the radius along the Y-axis
     * @param radiusZ the radius along the Z-axis
     */
    public SuctionRange(final int radiusX, final int radiusY, final int radiusZ) {
        this(radiusX, radiusY, radiusZ, -1);
    }

    /**
     * Creates a chunk-based suction range.
     * <p>
     * Defines how many chunks outward from the source should be included
     * in the suction area.
     * </p>
     *
     * @param chunkRadius the radius in chunks
     */
    public SuctionRange(final int chunkRadius) {
        this(-1, -1, -1, chunkRadius);
    }

    /**
     * Internal constructor used to initialize both range types.
     *
     * @param radiusX     the radius along the X-axis
     * @param radiusY     the radius along the Y-axis
     * @param radiusZ     the radius along the Z-axis
     * @param chunkRadius the range in chunks used for item suction
     */
    private SuctionRange(final int radiusX, final int radiusY, final int radiusZ, final int chunkRadius) {
        this.radiusY = radiusY;
        this.radiusZ = radiusZ;
        this.radiusX = radiusX;
        this.chunkRadius = chunkRadius;
    }

    /**
     * Returns the Y-axis radius from the center.
     *
     * @return the Y-axis radius, or {@code -1} if not set
     */
    public int getRadiusY() {
        return radiusY;
    }

    /**
     * Returns the Z-axis radius from the center.
     *
     * @return the Z-axis radius, or {@code -1} if not set
     */
    public int getRadiusZ() {
        return radiusZ;
    }

    /**
     * Returns the X-axis radius from the center.
     *
     * @return the X-axis radius, or {@code -1} if not set
     */
    public int getRadiusX() {
        return radiusX;
    }

    /**
     * Returns the chunk radius from the center.
     *
     * @return the chunk radius, or {@code -1} if not chunk-based
     */
    public int getChunkRadius() {
        return chunkRadius;
    }
}