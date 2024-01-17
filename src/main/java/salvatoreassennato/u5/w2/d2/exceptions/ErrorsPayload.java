package salvatoreassennato.u5.w2.d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class ErrorsPayload {
    private String message;
    private LocalDateTime timeDate;
}
