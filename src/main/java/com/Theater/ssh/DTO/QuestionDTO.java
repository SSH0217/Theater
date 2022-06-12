package com.Theater.ssh.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class QuestionDTO {
    @NotNull
    private String question;
}
