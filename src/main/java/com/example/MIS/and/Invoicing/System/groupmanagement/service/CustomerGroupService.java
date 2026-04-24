package com.example.MIS.and.Invoicing.System.groupmanagement.service;

import com.example.MIS.and.Invoicing.System.groupmanagement.entity.CustomerGroupEntity;
import com.example.MIS.and.Invoicing.System.groupmanagement.repository.CustomerGroupRepository;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.CustomUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerGroupService {
    private final CustomerGroupRepository customerGroupRepository;
    public CustomerGroupService(CustomerGroupRepository customerGroupRepository){
        this.customerGroupRepository=customerGroupRepository;
    }
    public CustomerGroupEntity addGroup(String groupName){
        if(customerGroupRepository.findByGroupName(groupName).isPresent()){
            throw new RuntimeException("Group Already Exists");
        }
        CustomerGroupEntity newGroup = new CustomerGroupEntity();
        newGroup.setGroupName(groupName);
        newGroup.setIsActive(true);
        return customerGroupRepository.save(newGroup);
    }
    public List<CustomerGroupEntity> getAllActiveGroups(){
        return customerGroupRepository.findByIsActiveTrue();
    }
    public CustomerGroupEntity updateGroup(Integer id, String newName){
        CustomerGroupEntity group = customerGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        Optional<CustomerGroupEntity> existing = customerGroupRepository.findByGroupName(newName);
        if (existing.isPresent() && !existing.get().getGroupId().equals(id)) {
            throw new RuntimeException("Group name already taken!");
        }
        group.setGroupName(newName);
        return customerGroupRepository.save(group);
    }
    public void deleteGroup(Integer id){
        CustomerGroupEntity group = customerGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        group.setIsActive(false);
        customerGroupRepository.save(group);
    }
}
