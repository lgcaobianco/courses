package finaloopchallenge.burger.additional;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class AdditionalsAvailable{
    private List<Additional> additionalList = new ArrayList<>();

    public List<Additional> getAdditionalList() {
        return additionalList;
    }

    public void addAdditionalAsAvailable(Additional additional){
        additionalList.add(additional);
    }

    public Additional getAdditionalByName(String name){
        for(Additional ad: additionalList){
            if(ad.getName().equals(name)){
                return ad;
            }
        }
        return null;
    }

    public void showAdditionalsAvailable(){
        System.out.println("Additionals available are:");
        for(Additional additional: additionalList){
            System.out.println(additional);
        }
    }




}