package com.likelion.app_2022_12_19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
}
