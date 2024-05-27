package org.eduardomaravill.roverRobot.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eduardomaravill.roverRobot.models.Direction;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RobertDto {
    @Max(18)
    @Min(0)
    private Integer x;
    @Max(8)
    @Min(0)
    private Integer y;
    private Direction direction;
}
