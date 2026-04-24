package com.example.MIS.and.Invoicing.System.groupmanagement.controller;

import com.example.MIS.and.Invoicing.System.groupmanagement.entity.CustomerGroupEntity;
import com.example.MIS.and.Invoicing.System.groupmanagement.service.CustomerGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer-groups")
public class CustomerGroupController {

    private final CustomerGroupService customerGroupService;

    public CustomerGroupController(CustomerGroupService customerGroupService) {
        this.customerGroupService = customerGroupService;
    }

    @PostMapping
    public ResponseEntity<?> addGroup(@RequestBody Map<String, String> request) {
        try {
            String groupName = request.get("groupName");
            CustomerGroupEntity created = customerGroupService.addGroup(groupName);
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllGroups() {
        List<CustomerGroupEntity> groups = customerGroupService.getAllActiveGroups();
        return ResponseEntity.ok(groups);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        try {
            String newName = request.get("groupName");
            CustomerGroupEntity updated = customerGroupService.updateGroup(id, newName);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer id) {
        try {
            customerGroupService.deleteGroup(id);
            return ResponseEntity.ok("Group deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}