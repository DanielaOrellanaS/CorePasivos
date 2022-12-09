package com.banquito.corepasivos.utils;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TTO<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;
}
