package org.mrstm.models;

import org.mrstm.enums.GateType;
/*unused*/
public abstract class Gate {
    private GateType gateType;

    public Gate(GateType gateType) {
        this.gateType = gateType;
    }
}
