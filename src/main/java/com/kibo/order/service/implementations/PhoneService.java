package com.kibo.order.service.implementations;

import com.kibo.order.data.repository.v1.dao.PhoneDao;
import com.kibo.order.data.entity.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by marcus.chiu on 10/26/16.
 * @Service - indicates this class as a interfaces stereotype
 * @Transactional - starts a transaction on each method start and
 * commits it on each method exit (or rollback if method failed)
 */
@Service("phoneService")
@Transactional
public class PhoneService implements com.kibo.order.service.interfaces.IPhoneService {

    @Autowired
    private PhoneDao phoneDao;


    @Override
    public Phone findById(int id) {
        return phoneDao.findById(id);
    }

    @Override
    public void savePost(Phone phone) {
        phoneDao.savePhone(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        System.out.println("phone id: " + phone.getId());
        System.out.println("phone number: " + phone.getNumber());
        Phone entity = phoneDao.findById(phone.getId());

        if(entity != null) {
            System.out.println("entity not equals null");
            entity.setNumber(phone.getNumber());
        } else {
            System.out.println("entity is null");
        }
    }

    @Override
    public void deletePhoneById(int id) {
        phoneDao.deletePhoneById(id);
    }

    @Override
    public List<Phone> findAllPhones() {
        return phoneDao.findAllPhones();
    }
}
