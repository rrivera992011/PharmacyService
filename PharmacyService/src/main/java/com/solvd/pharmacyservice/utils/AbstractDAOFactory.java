package com.solvd.pharmacyservice.utils;

import com.solvd.pharmacyservice.sql.IBaseDAO;

public abstract class AbstractDAOFactory {
    public abstract IBaseDAO getDAO(String model);
}
