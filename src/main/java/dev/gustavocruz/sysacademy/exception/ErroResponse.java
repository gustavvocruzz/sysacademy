package dev.gustavocruz.sysacademy.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResponse(LocalDateTime timeStamp,
                           Integer status,
                           String erro,
                           List<String> messages) {
}
