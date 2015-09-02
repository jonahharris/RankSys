/* 
 * Copyright (C) 2015 RankSys http://ranksys.github.io
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.ranksys.compression.codecs.dsi;

import it.unimi.dsi.io.InputBitStream;
import it.unimi.dsi.io.OutputBitStream;
import java.io.IOException;

/**
 *
 * @author Saúl Vargas (Saul.Vargas@glasgow.ac.uk)
 */
public class FixedLengthBitStreamCODEC extends BitStreamCODEC {

    private final int b;

    public FixedLengthBitStreamCODEC(int b) {
        this.b = b;
    }

    @Override
    public void write(OutputBitStream obs, int[] in, int offset, int len) throws IOException {
        for (int i = offset; i < offset + len; i++) {
            obs.writeInt(in[i], b);
        }
    }

    @Override
    public void read(InputBitStream ibs, int[] out, int offset, int len) throws IOException {
        for (int i = offset; i < offset + len; i++) {
            out[i] = ibs.readInt(b);
        }
    }

}
