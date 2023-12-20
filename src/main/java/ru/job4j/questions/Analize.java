package ru.job4j.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> tempo = new HashMap<>();

        for (User user : previous) {
            tempo.put(user.getId(), user.getName());
        }
        for (User user : current) {
            String userName = tempo.get(user.getId());
            if (userName != null && !user.getName().equals(userName)) {
                changed++;
            }
            if (!tempo.containsKey(user.getId())) {
                added++;
            }
        }
        tempo.clear();

        for (User user : current) {
            tempo.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            if (!tempo.containsKey(user.getId())) {
                deleted++;
            }
        }

        return new Info(added, changed, deleted);
    }
}
