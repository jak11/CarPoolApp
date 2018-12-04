package com.flipkar.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flipkar.excpetions.InvalidInputException;
import com.flipkar.model.Branch;
import com.flipkar.model.VehicleCharge;

public class DatabaseStore {
    private static Map<String, Branch> branchSet = new ConcurrentHashMap<>();

    private static Map<Branch, List<VehicleCharge>> branchRate = new HashMap<>();

    public static void addBranch(String name, Branch b) throws InvalidInputException {
        if (branchSet.containsKey(name)) {
            throw new InvalidInputException("Branch already exists");
        }
        branchSet.put(name, b);
    }

    public static Branch getBranch(String name) {
        return branchSet.get(name);
    }

    public static List<Branch> getAllBranches() {
        List<Branch> branches = new ArrayList<>();
        for (Map.Entry entry : branchSet.entrySet()) {
            branches.add((Branch) entry.getValue());
        }

        return branches;
    }
}
