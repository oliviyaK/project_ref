package management.interfaces;

import DTO.OperatorDTO;
import refrigerator.entity.Operator;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AdminService {

    Operator createOperator(String name);

    void deleteOperator(int id) throws InvocationTargetException,
            NoSuchMethodException, IllegalAccessException;

    void updateOperator(String name);

    List<Operator> operatorList();

    List<OperatorDTO> operatorDTOList();
}
