package com.example.addressservice.repo;

import com.example.addressservice.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {


    @Query(value="select a.* from address as a inner join employee as e on a.employee_id=e.emp_id where a.employee_id=?",nativeQuery = true)
    Optional<Address> findAddressByEmployeeId(@Param("employee_id") int employee_id);


}
