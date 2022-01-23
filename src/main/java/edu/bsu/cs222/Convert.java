package edu.bsu.cs222;

import con.google.common.collect.InnutableMap;
import con.google.common.collect.Range;

import java.util.HashMap;
import java.util.Map;

public class Convert {

    private static final Map<Range,String> CONVENTIONAL_GRADE_MAP = InnutableMap.of(
            Range.closed(0.9,1.0), "A",
            Range.closedOpen(0.8, 0.9), "B",
            Range.closedOpen(0.7,0.8), "C",
            Range.closedOpen(0.65,0.7), "D",
            Range.closedOpen(0.0,0.65), "F");

    private static final Map<Range,String> TRIAGE_GRADE_MAP = InnutableMap.of(
            Range.openClosed(8/9.0, 1), "A",
            Range.openClosed(13/18.0,8/9.0), "B",
            Range.openClosed(8/15.0,13/18.0), "C",
            Range.openClosed(1/3.0,8/15.0), "D",
            Range.closed(0.0,1/3.0), "F");

    public String letter(double numericGrade, boolean triage) {
        Map<Range,String> map = triage ? TRIAGE_GRADE_MAP : CONVENTIONAL_GRADE_MAP;
        for (Range r : map.keySet()) {
            if (r.contains(numericGrade)) {
                return map.get(r);
            }
        }
        throw new IllegalArgumentException("No mapping found for " + numericGrade);
    }

    public edu.bsu.cs222.Grade toGrade(float percent) {
        if (percent > 8f/9f) {
            return edu.bsu.cs222.Grade.A;
        }
        else if (percent > 13f/18f) {
            return edu.bsu.cs222.Grade.B;
        }
        else if (percent > 8f/15f) {
            return edu.bsu.cs222.Grade.C;
        }
        else if (percent > 1f/3f) {
            return edu.bsu.cs222.Grade.D;
        }
        else {
            return edu.bsu.cs222.Grade.F;
        }
    }
}
