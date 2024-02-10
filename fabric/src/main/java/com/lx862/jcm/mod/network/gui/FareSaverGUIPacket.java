package com.lx862.jcm.mod.network.gui;

import com.lx862.jcm.mod.render.gui.screen.FareSaverScreen;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.MinecraftClient;
import org.mtr.mapping.holder.PacketBuffer;
import org.mtr.mapping.holder.Screen;
import org.mtr.mapping.registry.PacketHandler;
import org.mtr.mapping.tool.PacketBufferReceiver;
import org.mtr.mapping.tool.PacketBufferSender;

public class FareSaverGUIPacket extends PacketHandler {
    private final BlockPos blockPos;
    private final int discount;

    public FareSaverGUIPacket(PacketBufferReceiver packetBufferReceiver) {
        this.blockPos = BlockPos.fromLong(packetBufferReceiver.readLong());
        this.discount = packetBufferReceiver.readInt();
    }

    public FareSaverGUIPacket(BlockPos blockPos, int discount) {
        this.blockPos = blockPos;
        this.discount = discount;
    }

    @Override
    public void write(PacketBufferSender packetBufferSender) {
        packetBufferSender.writeLong(blockPos.asLong());
        packetBufferSender.writeInt(discount);
    }

    @Override
    public void runClient() {
        MinecraftClient.getInstance().openScreen(new Screen(new FareSaverScreen(blockPos, discount)));
    }
}
