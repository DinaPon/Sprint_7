package org.example.order;

public class OrderGenerator {
    public static Order getWithGrey(){
        return new Order("Naruto","Uzumaki","Konoha, 142 apt.","1", "+78003553535",  "5","2023-02-11","Saske, come back to Kanoha", new String[]{"GREY"});
    }

    public static Order getWithBlack(){
        return new Order("Naruto","Uzumaki","Konoha, 142 apt.","1", "+78003553535",  "5","2023-02-11","Saske, come back to Kanoha",new String[]{"BLACK"});
    }

    public static Order getWithoutTwoColours(){
        return new Order("Naruto","Uzumaki","Konoha, 142 apt.","1", "+78003553535",  "5","2023-02-11","Saske, come back to Kanoha",null);
    }

    public static Order getWithTwoColours(){
        return new Order("Naruto","Uzumaki","Konoha, 142 apt.","1", "+78003553535",  "5","2023-02-11","Saske, come back to Kanoha",new String[]{"GREY","BLACK"});
    }
}
