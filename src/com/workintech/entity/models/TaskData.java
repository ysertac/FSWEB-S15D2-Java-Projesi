package com.workintech.entity.models;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String owner) {
        if (owner.equalsIgnoreCase("ann")) {
            return this.annsTasks;
        }
        if (owner.equalsIgnoreCase("bob")) {
            return this.bobsTasks;
        }
        if (owner.equalsIgnoreCase("carol")) {
            return this.carolsTasks;
        }
        if (owner.equalsIgnoreCase("all")) {
            return getUnion(bobsTasks, annsTasks, carolsTasks);
        }
        return new HashSet<>();
    }

    private Set<Task> getUnion(Set<Task>... sets) {
        HashSet<Task> total = new LinkedHashSet<>();
        for (Set<Task> taskSet : sets) {
            total.addAll(taskSet);
        }
        return total;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersections = new HashSet<>(first);
        intersections.retainAll(second);
        return intersections;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task> second) {
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public void setAnnsTasks(Set<Task> annsTasks) {
        this.annsTasks = annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public void setBobsTasks(Set<Task> bobsTasks) {
        this.bobsTasks = bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void setCarolsTasks(Set<Task> carolsTasks) {
        this.carolsTasks = carolsTasks;
    }
}
