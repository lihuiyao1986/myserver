package com.server.user.dao.hibernate.impl;

import com.server.user.dao.base.BaseDao;
import com.server.user.dao.hibernate.IAddressDao;
import com.server.user.dao.model.AddressInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jk on 16/11/7.
 */
@Transactional
@Repository
public class AddressDaoImpl implements IAddressDao{

    @Autowired
    private BaseDao baseDao;

    @Override
    public void saveAddress(AddressInfo addressInfo) {
        baseDao.save(addressInfo);
    }
}
