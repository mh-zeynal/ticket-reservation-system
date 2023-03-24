package com.example.ticket.entityListeners;

import com.example.ticket.entities.Customer;
import com.example.ticket.entities.Permission;
import com.example.ticket.entities.UserWithPermissions;
import com.example.ticket.entities.UserWithPermissionsCompositeKey;
import com.example.ticket.repositories.CustomerRepository;
import com.example.ticket.repositories.PermissionRepository;
import com.example.ticket.repositories.UserWithPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.PostUpdate;

@Component
public class CustomerListener {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserWithPermissionRepository userWithPermissionRepository;

    private PermissionRepository permissionRepository;

    @PostUpdate
    @TransactionalEventListener
    public void onCustomerUpdate(Customer customer) {
        Customer oldCustomer = customerRepository.getByCustomerId(customer.getCustomerId());
        boolean isVIPChanged = oldCustomer.isVIP() != customer.isVIP();
        if (!isVIPChanged || !customer.isVIP())
            return;
        UserWithPermissionsCompositeKey pkey = new UserWithPermissionsCompositeKey();
        Permission permission = permissionRepository.getByTitle("upgrade to vip");
        pkey.setPermission(permission);
        pkey.setUser(customer.getUser());
        userWithPermissionRepository.deleteById(pkey);
        permission = permissionRepository.getByTitle("see offers");
        UserWithPermissions userWithPermissions = new UserWithPermissions();
        userWithPermissions.setUser(customer.getUser());
        userWithPermissions.setPermission(permission);
        userWithPermissionRepository.save(userWithPermissions);
    }
}
