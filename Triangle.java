public class Triangle{
  private Point v1, v2, v3;

public Triangle(double x1, double y1,double x2, double y2,double x3, double y3){
  v1 = new Point(x1,y1);
  v2 = new Point(x2,y2);
  v3 = new Point(x3,y3);
}
  public Triangle(Point a, Point b, Point c){
    v1 = a;
    v2 = b;
    v3 = c;
  }
  public double getPerimeter(){
    return v1.distanceTo(v2) + v2.distanceTo(v3) + v3.distanceTo(v1);
  }
  public double getArea(){
    double a = v1.distanceTo(v2);
    double b = v2.distanceTo(v3);
    double c = v3.distanceTo(v1);
    double semiPerimeter = (a + b + c) / 2;
    double area = Math.sqrt(semiPerimeter * semiPerimeter - a * semiPerimeter - b * semiPerimeter-c);
    return area;
  }
  public String classify(){
    if (v1.distanceTo(v2) == v2.distanceTo(v3) && v2.distanceTo(v3) == v3.distanceTo(v1)){
      return "equilateral";
    }
    else if (v1.distanceTo(v2) != v2.distanceTo(v3) && v2.distanceTo(v3) != v3.distanceTo(v1)){
      return "scalene";
    }
    return "isosceles";
  }
  public String toString() {
    return ("v1" + v1 + "v2" + v2 + "v3" + v3);
  }

}
