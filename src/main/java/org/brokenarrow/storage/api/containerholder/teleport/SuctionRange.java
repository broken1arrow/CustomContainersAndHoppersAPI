package org.brokenarrow.storage.api.containerholder.teleport;

public class SuctionRange {
        private final int locY;
        private final int locZ;
        private final int locX;
        private final int chunkSize;

        public SuctionRange(final int locX, final int locY, final int locZ, final int chunkSize) {
            this.locY = locY;
            this.locZ = locZ;
            this.locX = locX;
            this.chunkSize = chunkSize;
        }

        public SuctionRange(final int chunkSize) {
            this(-1, -1, -1, chunkSize);
        }

        public int getLocY() {
            return locY;
        }

        public int getLocZ() {
            return locZ;
        }

        public int getLocX() {
            return locX;
        }

        public int getChunkSize() {
            return chunkSize;
        }
    }