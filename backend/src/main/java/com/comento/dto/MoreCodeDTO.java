package com.comento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MoreCodeDTO {
    private String commCdID;
    private String cdId;
    private String cdNm;
    private String cdEng;
    private int cdSort;
    private String cdUseYn;
    private String conn1Cd;
    private String conn2Cd;
    private String conn3Cd;
}
