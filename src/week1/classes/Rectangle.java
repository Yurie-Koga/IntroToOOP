package week1.classes;

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

    public void draw(){
        if(!isColor()){
            return;
        }
        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                System.out.print(color.toUpperCase().charAt(0));
            }
            System.out.println();
        }
    }

    private boolean isColor(){
        if(color.length() <= 2 ||  20 <= color.length() ){
            System.out.println("Color has to be more than 2 characters long and less than 20.");
            return false;
        }else{
            this.color = color.toUpperCase();
            return true;
        }
    }
}
