package com.kibo.order.data.repository.dao_implementation;

import com.kibo.order.data.repository.dao.AbstractDao;
import com.kibo.order.data.repository.dao.PhoneDao;
import com.kibo.order.data.entity.entity.Phone;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marcus.chiu on 10/26/16.
 */
@Repository("PhoneDao")
public class PhoneDaoImpl extends AbstractDao<Integer, Phone> implements PhoneDao{

    @Override
    public Phone findById(int id) {
        return getByKey(id);
    }

    @Override
    public void savePhone(Phone phone) {
        persist(phone);
    }

    @Override
    public void deletePhoneById(int id) {
        Query query = getSession().createSQLQuery("delete from Employee where phone_id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Phone> findAllPhones() {
        Criteria criteria = createEntityCriteria();
        return (List<Phone>) criteria.list();
    }

    @Override
    public Phone findPhoneByNumber(String number) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("number", number));
        return (Phone) criteria.uniqueResult();
    }
}
