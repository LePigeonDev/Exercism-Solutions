import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class AppointmentScheduler {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return (appointmentDate.isBefore(LocalDateTime.now())) ? true : false;
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime start = LocalTime.of(12, 00, 00);
        LocalTime end = LocalTime.of(18, 00, 00);
        LocalTime time = appointmentDate.toLocalTime();
        return ((time.isAfter(start) || time.equals(start)) && time.isBefore(end));
    }

    public String getDescription(LocalDateTime appointmentDate) {
    DateTimeFormatter printer = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a.", Locale.ENGLISH );
    return "You have an appointment on " + printer.format(appointmentDate);
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }
}
