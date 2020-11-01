package com.persistence.college.app.person.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageablePersonDto extends PersonDto {

    private static final long serialVersionUID = 7046208563487287526L;

    private int page = 0;
    private int size = 20;
}
