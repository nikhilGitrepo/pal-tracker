package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator{

    private TimeEntryRepository timeEntriesRepo;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntriesRepo) {
        this.timeEntriesRepo = timeEntriesRepo;
    }

    /**
     * Return an indication of health.
     *
     * @return the health for
     */
    @Override
    public Health health() {
        return timeEntriesRepo.list().size() < 5 ? Health.up().build() : Health.down().build();
    }
}
