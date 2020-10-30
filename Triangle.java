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
    double e = v1.distanceTo(v2);
    double f = v2.distanceTo(v3);
    double g = v3.distanceTo(v1);
    double semiPerimeter = (e + f + g) / 2;
    double area = Math.sqrt(semiPerimeter * (semiPerimeter - e) * (semiPerimeter - f) * (semiPerimeter - g));
    return area;
  }
  public String classify(){
    double a = Math.round(v1.distanceTo(v2) *10000.0) / 10000.0;
    double b = Math.round(v2.distanceTo(v3) *10000.0) / 10000.0;
    double c = Math.round(v3.distanceTo(v1) *10000.0) / 10000.0;
    if (a == b && b == c){
      return "equilateral";
    }
    if (a != b && b != c && c != a){
      return "scalene";
    }
    return "isosceles";
  }
  public String toString() {
    return ("v1" + v1 + " v2" + v2 + " v3" + v3);
  }
  public void setVertex(int index, Point newP){
    if (index == 0){
      v1 = newP  ;
    }
    else if (index == 1){
      v2 = newP;
    }
    else if (index == 2){
      v3 = newP;
    }
  }

}
