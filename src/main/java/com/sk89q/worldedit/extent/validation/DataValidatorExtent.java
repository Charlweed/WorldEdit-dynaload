/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.extent.validation;

import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.extent.AbstractDelegateExtent;
import com.sk89q.worldedit.extent.Extent;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Validates set data to prevent creating invalid blocks and such.
 */
public class DataValidatorExtent extends AbstractDelegateExtent {

    private final LocalWorld world;

    /**
     * Create a new instance.
     *
     * @param extent the extent
     * @param world the world
     */
    public DataValidatorExtent(Extent extent, LocalWorld world) {
        super(extent);
        checkNotNull(world);
        this.world = world;
    }

    @Override
    public boolean setBlock(Vector location, BaseBlock block) throws WorldEditException {
        final int y = location.getBlockY();
        final int type = block.getType();
        if (y < 0 || y > world.getMaxY()) {
            return false;
        }

        // No invalid blocks
        if (!world.isValidBlockType(type)) {
            return false;
        }

        if (type == 0) {
            block.setData(0);
        }

        return super.setBlock(location, block);
    }
}