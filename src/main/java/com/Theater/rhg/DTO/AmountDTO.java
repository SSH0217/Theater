package com.Theater.rhg.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
@Setter
@Getter
public class AmountDTO {
    private Long id;
    private boolean dosed;
    @Min(5000)
    private int amount;

}
