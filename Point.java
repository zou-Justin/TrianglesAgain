public class Point{
  private double x,y;

  public Point(double X, double Y){
    x=X;
    y=Y;
  }
  public double distanceTo(Point other){
    double dis = Math.sqrt(Math.pow(other.x - x,2)+Math.pow(other.y - y,2));
    return dis;
   }
   public boolean equals( Point other) {
     return (other.x == x && other.y == y);
   }
  public Point(Point p){
    x = p.x;
    y = p.y;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }
  public String toString(){
    return ("(" + x + ", " + y + ")");
  }

}
