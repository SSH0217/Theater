package com.Theater.rhg.DTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
public class PercentDTO {
    private Long id;
    private boolean dosed;
    @Range(min = 0,max = 100)
    private int percent;
}
