package strategy;

import domain.Employee;

public interface FilterBase {

    boolean operation(Employee  employee);
}
