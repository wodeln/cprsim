package com.bolean.entity;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author 
 */
@Table(name="cpr_args_version")
public class ArgsApi implements Serializable {

    private double argsVersion;

    @Transient
    private ArgsType argsType;

    public double getArgsVersion() {
        return argsVersion;
    }

    public void setArgsVersion(double argsVersion) {
        this.argsVersion = argsVersion;
    }

    public ArgsType getArgsType() {
        return argsType;
    }

    public void setArgsType(ArgsType argsType) {
        this.argsType = argsType;
    }
}