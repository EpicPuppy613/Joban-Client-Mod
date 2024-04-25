package com.lx862.jcm.mod.data.pids.preset.components;

import com.lx862.jcm.mod.data.KVPair;
import com.lx862.jcm.mod.data.pids.preset.PIDSContext;
import com.lx862.jcm.mod.data.pids.preset.components.base.TextureComponent;
import org.mtr.core.operation.ArrivalResponse;
import org.mtr.core.operation.ArrivalsResponse;
import org.mtr.mapping.holder.Direction;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.holder.World;
import org.mtr.mapping.mapper.GraphicsHolder;
import org.mtr.mapping.mapper.GuiDrawing;

public class PlatformCircleComponent extends TextureComponent {
    private final int arrivalIndex;
    public PlatformCircleComponent(double x, double y, double width, double height, KVPair additionalParam) {
        super(x, y, width, height, additionalParam);
        this.arrivalIndex = additionalParam.get("arrivalIndex", 0);
    }

    @Override
    public void render(GraphicsHolder graphicsHolder, GuiDrawing guiDrawing, Direction facing, PIDSContext context) {
        ArrivalsResponse arrivals = context.arrivals;
        if(arrivalIndex >= arrivals.getArrivals().size()) return;

        ArrivalResponse arrival = arrivals.getArrivals().get(arrivalIndex);
        drawTexture(graphicsHolder, guiDrawing, facing, texture, 0, 0, width, height, arrival.getRouteColor() + ARGB_BLACK);
    }
}
