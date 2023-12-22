package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.BO.impl.CustomerBoImpl;
import com.example.layeredarchitecture.BO.impl.ItemBoImpl;
import com.example.layeredarchitecture.BO.impl.PlaceOrderBoImpl;
import com.example.layeredarchitecture.DAO.SuperDAO;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBOFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,PLACE_ORDER
    }

    public SuperBo getBo(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();
            default:
                return null;
        }
    }

}
