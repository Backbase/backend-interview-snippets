package business;

import java.util.Objects;

public class Account {
    private Long id;
    private String name;
    private Double availableBalance;
    private boolean closed;

    // Getters/Setters

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(id);
        h += (h << 5) + Objects.hashCode(name);
        h += (h << 5) + Objects.hashCode(availableBalance);
        h += (h << 5) + Objects.hashCode(closed);
        return h;
    }
}
