package com.comento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder @AllArgsConstructor
public class CommCodeDTO {
    private String commCdId;
    private String commCdNm;
    private String commCdEng;
    private int cdSort;
    private String cdUseYn;
    private String conn1Cd;
    private String conn2Cd;
    private String conn3Cd;

    public CommCodeDTO(){

    }

}
