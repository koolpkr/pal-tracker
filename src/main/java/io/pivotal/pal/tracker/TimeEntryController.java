package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public class TimeEntryController {
    private final TimeEntryRepository timeEntriesRepo;

    public TimeEntryController(TimeEntryRepository timeEntriesRepo) {
        this.timeEntriesRepo = timeEntriesRepo;
    }

    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry = timeEntriesRepo.create(timeEntryToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeEntry);
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry timeEntry = timeEntriesRepo.find(timeEntryId);
        if (timeEntry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeEntry);
    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> list = timeEntriesRepo.list();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry timeEntryToUpdate) {
        return null;
    }

    public ResponseEntity<Void> delete(long timeEntryId) {
        return null;
    }
}
