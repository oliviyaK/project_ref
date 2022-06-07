package management.implementation;

import DTO.OperatorDTO;
import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import management.interfaces.AdminService;
import refrigerator.dao.EntityDaoImplAdmin;
import refrigerator.dao.EntityDaoImplOperator;
import refrigerator.entity.Operator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class AdminServiceImpl implements AdminService {
    private final EntityDaoImplOperator daoImplOperator = new EntityDaoImplOperator();
    private final EntityDaoImplAdmin daoImplAdmin;
    public AdminServiceImpl(EntityDaoImplAdmin daoImplAdmin) {
        this.daoImplAdmin=daoImplAdmin;
    }

    @Override
    public Operator createOperator(String name) {
       Operator operator = Operator.builder()
               .name(name)
               .build();
        daoImplOperator.insert(operator);
        daoImplOperator.closeDao();
        return operator;
    }

    @Override
    public void deleteOperator(int id) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        daoImplOperator.deleteById(id);
        daoImplOperator.closeDao();
    }

    @Override
    public void updateOperator(String name) {
        daoImplOperator.update(createOperator(name));
        daoImplOperator.closeDao();
    }

    @Override
    public List<Operator> operatorList() {
        List<Operator> select = daoImplOperator.select();
        daoImplOperator.closeDao();
        return select;
    }

    public Operator findOperator(int id) {
        Operator operator = daoImplOperator.selectById(id);
        daoImplOperator.closeDao();
        return operator;
    }

    @Override
    public List<OperatorDTO> operatorDTOList() {
        List<Object[]> lists = daoImplOperator.listOfOperator();
        List<OperatorDTO> operatorDTOList = new ArrayList<>();
//        for (Object[] list : lists) {
//            operatorDTOList.add(OperatorDTO.builder()
//                    .id((Integer) list[0])
//                    .name((String) list[1])
//                    .client((String) list[2])
//                    .request((String) list[3])
//                    .operation((String) list[4])
//                    .build());
//        }
        daoImplOperator.closeDao();
        return operatorDTOList;
    }
}

