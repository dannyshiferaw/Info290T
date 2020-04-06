package edu.berkeley.aep;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class CombineGroupsTest {
    @Test
    public void shouldCombineIntoTwoGroups() {
        List<CombineGroups.Group> groups = new LinkedList<>();
        groups.add(new CombineGroups.Group("A", 2));
        groups.add(new CombineGroups.Group("B", 3));
        groups.add(new CombineGroups.Group("C", 2));
        groups.add(new CombineGroups.Group("D", 1));

        CombineGroups combineGroups = new CombineGroups();
        int expectedNumOfGroups = 2;
        int actualNumOfGroups = combineGroups.getAllowedNumOfGroups(groups);
        Assert.assertEquals(expectedNumOfGroups, actualNumOfGroups);
    }
}
