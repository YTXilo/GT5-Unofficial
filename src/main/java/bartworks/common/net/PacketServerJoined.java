/*
 * Copyright (c) 2018-2020 bartimaeusnek Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions: The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package bartworks.common.net;

import net.minecraft.world.IBlockAccess;

import com.google.common.io.ByteArrayDataInput;

import bartworks.MainMod;
import gregtech.api.net.GTPacket;
import io.netty.buffer.ByteBuf;

public class PacketServerJoined extends GTPacket {

    private byte config;

    public PacketServerJoined() {
        super();
    }

    public PacketServerJoined(Object obj) {
        super();
        this.config = 0;
    }

    @Override
    public byte getPacketID() {
        return 26;
    }

    @Override
    public void encode(ByteBuf aOut) {
        aOut.writeByte(this.config);
    }

    @Override
    public GTPacket decode(ByteArrayDataInput byteArrayDataInput) {
        this.config = byteArrayDataInput.readByte();
        return this;
    }

    @Override
    public void process(IBlockAccess iBlockAccess) {
        MainMod.runOnPlayerJoined(false, false);
    }
}
