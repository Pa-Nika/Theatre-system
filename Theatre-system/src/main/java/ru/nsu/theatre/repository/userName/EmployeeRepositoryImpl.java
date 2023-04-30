//package ru.nsu.theatre.repository.userName;
//
//import ru.nsu.theatre.entities.Employee;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//public class EmployeeRepositoryImpl implements EmployeeNameGap{
//    private final EntityManager entityManager;
//
//    public EmployeeRepositoryImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Employee> findByUsername(String username) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
//        Root<Employee> userRoot = query.from(Employee.class);
//        query.select(userRoot).where(cb.equal(userRoot.get("username"), username));
//        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);
//        return typedQuery.getResultList();
//    }
//
//}
