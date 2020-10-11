package week1.classes;

import java.util.regex.Pattern;

public class Rectangle {
    private int width;
    private int height;
    private String color;

    public Rectangle(int width, int height) {
        setWidth(width);
        setHeight(height);
        this.color = "Blue";
    }

    public Rectangle(int width, int height, String color) {
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width > 0){
            this.width = width;
        }else{
            this.width = 1;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (width > 0){
            this.height = height;
        }else{
            this.height = 1;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Changed to return as String to test
//    public void draw(){
//        if(!isColor()){
//            return;
//        }
//        for(int h = 0; h < height; h++){
//            for(int w = 0; w < width; w++){
//                System.out.print(color.toUpperCase().charAt(0));
//            }
//            System.out.println();
//        }
//    }

    public String draw(){
        String msg = checkColor();
        if(!isNullOrEmpty(msg)){
            return msg;
        }
        String result = "";
        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                result += String.format(String.valueOf(color.toUpperCase().charAt(0)));
            }
            result += "\n";
        }
        result = result.replaceAll("\n$", "");
//        result = result.replace("\n$", "");   // 'replace' is for char.
        return result;
    }

    private String checkColor(){
        if(color.length() <= 2 ||  20 <= color.length() ){
            return "Color has to be more than 2 characters long and less than 20.";
        }else{
            this.color = color.toUpperCase();
            return "";
        }
    }

    private static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
