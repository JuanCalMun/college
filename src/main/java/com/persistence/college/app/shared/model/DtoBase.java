package com.persistence.college.app.shared.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public abstract class DtoBase implements Serializable {
    private static final long serialVersionUID = 2156006690873846469L;
}
