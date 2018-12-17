package Testate.Testat21.Box.src;

public class Box {

    private double width;
    private double height;
    private double depth;

    public Box (double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public double getDepth(){
        return depth;
    }

    public double getVolumeSize(){
        return width*height*depth;
    }

    public double getAreaSize(){
        return (2*width*height)+(2*width*depth)+(2*height*depth);
    }

    public double getEdgesLength(){
        return 4*width+4*height+4*depth;
    }

    public boolean isCube(){
        return ((width == height) && (height == depth) && (depth == width));
    }

    public int compareTo ( Box f){
        if (this.getVolumeSize() > f.getVolumeSize())
            return 1;
        else if (this.getVolumeSize() == f.getVolumeSize())
            return 0;
        else return -1;
    }

    public int compareEdges ( Box f){
        if (this.getEdgesLength() > f.getEdgesLength())
            return 1;
        else if (this.getEdgesLength() == f.getEdgesLength())
            return 0;
        else return -1;
    }

    public int compareArea ( Box f){
        if (this.getAreaSize() > f.getAreaSize())
            return 1;
        else if (this.getAreaSize() == f.getAreaSize())
            return 0;
        else return -1;
    }

    public double getMin(){
        if (this.isCube())
            return width;
        else if (width <= height && width <= depth)
            return width;
        else if (height <= width && height <= depth)
            return height;
        else return depth;
    }

    public double getMed(){
        if (this.isCube())
            return width;
        else if ((width <= height && width >= depth) || (width >= height && width <= depth))
            return width;
        else if ((height <= width && height >= depth) || (height >= width && height <= depth))
            return height;
        else return depth;
    }

    public double getMax(){
        if (this.isCube())
            return width;
        else if (width > height && width > depth)
            return depth;
        else if (height > width && height > depth)
            return height;
        else return depth;
    }

    public boolean encloses (Box f){
        boolean result = false;
        if (this.isCube() && f.isCube() && (this.getHeight() > f.getHeight()))
            result = true;
        else if (this.getMin() > f.getMin() && this.getMed() > f.getMed() && this.getMax() > f.getMax())
            result = true;
        return result;
    }
}
