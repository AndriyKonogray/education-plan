package planeModel;

import java.time.LocalDate;

public interface Condition {
    boolean isDayOk(LocalDate date, Student student);
}
