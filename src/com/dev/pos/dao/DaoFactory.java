package com.dev.pos.dao;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){}//cannot create objects outside the class

    public static DaoFactory getInstance(){
        if (daoFactory==null){
            daoFactory = new DaoFactory();
        }
        return daoFactory; //singleton
    }
}
