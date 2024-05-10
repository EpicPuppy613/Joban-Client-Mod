package com.lx862.jcm.mod.data.pids.preset;

import org.mtr.core.operation.ArrivalResponse;
import org.mtr.core.operation.ArrivalsResponse;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.mtr.mapping.holder.World;

public class PIDSContext {
    public final World world;
    public final ObjectArrayList<ArrivalResponse> arrivals;
    public final double deltaTime;

    public PIDSContext(World world, ObjectArrayList<ArrivalResponse> arrivals, double deltaTime) {
        this.world = world;
        this.arrivals = arrivals;
        this.deltaTime = deltaTime;
    }
}
