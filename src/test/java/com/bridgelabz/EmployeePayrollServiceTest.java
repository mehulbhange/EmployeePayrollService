package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceTest {

    @Test
    public void given3EmployeesWhenWrittenToFile_shouldMatchEmployeeEntries(){
        EmployeePayrollFileIOService fileIO = new EmployeePayrollFileIOService();
        List<EmployeePayroll> list = new ArrayList<>();
        list.add(new EmployeePayroll(10,"abc",10000));
        list.add(new EmployeePayroll(11,"def",20000));
        list.add(new EmployeePayroll(12,"xyz",25000));

        fileIO.writeDataToFile(list);
        Assertions.assertEquals(3, fileIO.countEntries());
    }

}
