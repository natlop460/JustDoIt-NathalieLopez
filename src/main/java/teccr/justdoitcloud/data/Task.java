package teccr.justdoitcloud.data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
public class Task {

    private static Long counter = 0L;

    private Long id;

    @Size(min=3, message = "Descripcion debe tener al menos 3 caracteres")
    private String description;

    private LocalDateTime created;
    private LocalDate deadline;

    @NotNull
    private Status status;

    public Task(String description, LocalDateTime created, LocalDate deadline, Status status) {
        this.id = ++counter;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.status = status;
    }

    public enum Status {
        PENDING,
        INPROGRESS,
        DONE
    }
}
