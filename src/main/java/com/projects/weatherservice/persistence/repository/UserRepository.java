package com.projects.weatherservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.weatherservice.business.entity.UserDetails;

/**
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On On 19-Oct-2021
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
