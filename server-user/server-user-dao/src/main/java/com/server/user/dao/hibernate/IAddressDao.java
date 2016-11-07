package com.server.user.dao.hibernate;

import com.server.user.dao.model.AddressInfo;

/**
 * Created by jk on 16/11/7.
 */
public interface IAddressDao {

    public void saveAddress(AddressInfo addressInfo);
}
