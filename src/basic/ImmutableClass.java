package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
    private final String name;
    private final List<String> data;

    public ImmutableClass(String name, List<String> data) {
        this.name = name;
        this.data = new ArrayList<>(data);
    }

    public String getName() {
        return name;
    }

    public List<String> getData() {
        return Collections.unmodifiableList(data);
    }
}
