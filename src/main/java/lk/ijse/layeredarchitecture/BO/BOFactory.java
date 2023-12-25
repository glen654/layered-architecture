package lk.ijse.layeredarchitecture.BO;

import lk.ijse.layeredarchitecture.BO.custom.impl.CustomerBoImpl;
import lk.ijse.layeredarchitecture.BO.custom.impl.ItemBoImpl;
import lk.ijse.layeredarchitecture.BO.custom.impl.PlaceOrderBoImpl;

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
