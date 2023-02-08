package com.solvd.pharmacyservice.utils;

import com.solvd.pharmacyservice.utils.enums.DBConnectionType;

public class DBFactoryGenerator {

    public static AbstractDAOFactory getFactory(DBConnectionType connectionType){
        switch (connectionType) {
            case JDBC:
                return new JBDCDAOFactory();
            case MYBATIS:
                return new MyBatisDAOFactory();
            default:
                throw new UnsupportedFactoryException("Not supported connection type");
        }

    }
}
