package com.bolean.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author 
 */
@Table(name="cpr_args_type")
public class ArgsType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long argsTypeId;

    /**
     * 参数分类名称
     */
    @NotEmpty
    private String argsTypeName;

    private String argsTypeKey;

    @Transient
    private List<Args> args;

    public List<Args> getArgs() {
        return args;
    }

    public void setArgs(List<Args> args) {
        this.args = args;
    }

    public Long getArgsTypeId() {
        return argsTypeId;
    }

    public void setArgsTypeId(Long argsTypeId) {
        this.argsTypeId = argsTypeId;
    }

    public String getArgsTypeName() {
        return argsTypeName;
    }

    public void setArgsTypeName(String argsTypeName) {
        this.argsTypeName = argsTypeName;
    }

    public String getArgsTypeKey() {
        return argsTypeKey;
    }

    public void setArgsTypeKey(String argsTypeKey) {
        this.argsTypeKey = argsTypeKey;
    }
}