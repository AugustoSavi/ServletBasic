package com.example.core.Utils;

import java.util.Objects;

public class Utils{
    private String NULL = "null";
    private Long ZERO = 0L;

    public Long getId(String value){
        return Objects.isNull(value) || NULL.equals(value) || value.isEmpty() ? 0L : Long.parseLong(value);
    }

    public Long getZERO() {
        return ZERO;
    }

    public Boolean isZero(Long value) {
        return ZERO.equals(value);
    }
}
