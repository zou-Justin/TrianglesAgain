public class Tester{
  public static void main(String[] args) {

      boolean failure = false;
      failure = constructorTester() || failure;
      failure = getPerimeterTester() || failure;
      failure = getAreaTester() || failure;
      failure = classifyTester() || failure;
      failure = toStringTester() || failure;
      failure = setVertexTester() || failure;

      if (failure) {
        System.out.println("\nThere's a bug in your class");
      } else {
        System.out.println("\nNice job, partner");
      }
    }

    public static boolean constructorTester() {
      System.out.println("\nconstructor TEST");
      boolean failure = false;

      Triangle t1 = new Triangle(1, 1, 1, 1, 1, 1);
      Point p1 = new Point(1, 1);
      Point p2 = new Point(1, 1);
      Point p3 = new Point(1, 1);
      Triangle t2 = new Triangle(p1, p2, p3);
      failure = !t2.toString().equals(t1.toString());


      if (failure) {
        System.out.println("A CONSTRUCTOR DOESN'T WORK");
      } else {
        System.out.println("THE CONSTRUCTORS WORK");
      }

      return failure;
    }

    public static boolean getPerimeterTester() {
      System.out.println("\ngetPerimeter() TEST");
      boolean failure = false;
      Triangle[] triangles = {
        new Triangle(0,0,0,0,0,0),                                                //degenerate equilateral case
        new Triangle(643.43,23.4,643.43,23.4,643.43,23.4),                        //degenerate equilateral case off origin
        new Triangle(0,0,1,0,0,0),                                                //degenerate isosceles
        new Triangle(0,0,1,0,3,0),                                                //degenerate scalene
        new Triangle(0,1000,0,0,1000,0),                                          //isosceles right triangle
        new Triangle(-10,0,0,0,-5,2),                                             //isosceles
        new Triangle(0,0,2,0,1,Math.sqrt(3)),                                     //equilateral
        new Triangle(0,3,4,0,0,0),                                                //3,4,5 triangle (scalene)
        new Triangle(0,0,30000,0,200,40)                                          //scalene
      };
      double[] perimeters = {
        0,
        0,
        2,
        6,
        2000 + 1000*Math.sqrt(2),
        10 + 2 * Math.sqrt(29),
        6,
        12,
        30000 + Math.sqrt(41600) + Math.sqrt(888041600),
      };

      for (int index = 0; index < triangles.length; index++) {
        if (triangles[index].getPerimeter() == perimeters[index]) {
          //System.out.println("PERIMETER TEST PASSED AT RUN: " + index);           //if you want live printouts uncomment this.
        } else {
          failure = true;
          System.out.println("WE HAVE FAILED");
          System.out.println("EXPECTED: " + perimeters[index]);
          System.out.println("ACTUAL: "  + triangles[index].getPerimeter());
        }
      }

      if (failure) {
        System.out.println("getPerimeter() DOESN'T WORK");
      } else {
        System.out.println("getPerimeter() WORKS");
      }

      return failure;
    }

    public static boolean getAreaTester() {
      System.out.println("\ngetArea() TEST");
      boolean failure = false;

      Triangle[] triangles = {
        new Triangle(0,0,0,0,0,0),                                                //degenerate equilateral
        new Triangle(463532.23,6432.32,463532.23,6432.32,463532.23,6432.32),      //degenerate FP equilateral
        new Triangle(1.2,0,0,0,1.2,0),                                            //degenerate isosceles
        new Triangle(0,3,0,1,0,0),                                                //degenerate scalene
        new Triangle(3,0,0,0,0,4),                                                //3 4 5 scalene
        new Triangle(-1,0,1,0,0,1),                                               //isosceles
        new Triangle(0,0,2,0,1, Math.sqrt(3)),                                    //equilateral
        new Triangle(0,0,30,0,200,40),                                            //scalene
      };
      double[] areas = {
        0,
        0,
        0,
        0,
        6,
        1,
        Math.sqrt(3),
        600,
      };

      double acceptableError = 1E-10;
      for (int index = 0; index < triangles.length; index++) {
        double errorBars = triangles[index].getArea() - areas[index];
        errorBars = Math.abs(errorBars);
        if (errorBars < acceptableError) {                                        //The check is set up this way to counteract FP value errors from the difference in area finding methods.
          //System.out.println("AREA TEST PASSED AT RUN: " + index);              //if you want live printouts uncomment this.
        } else {
          failure = true;
          System.out.println("WE HAVE FAILED");
          System.out.println("EXPECTED: " + areas[index]);
          System.out.println("ACTUAL: "  + triangles[index].getArea());
        }
      }

      if (failure) {
        System.out.println("getArea() DOESN'T WORK");
      } else {
        System.out.println("getArea() WORKS");
      }

      return failure;
    }

    public static boolean classifyTester() {
      System.out.println("\nclassify() TEST");
      boolean failure = false;
      Triangle[] triangles = {
        new Triangle(0,0,0,0,0,0),                                                //degenerate equilateral
        new Triangle(12.21321,12321.232,12.21321,12321.232,12.21321,12321.232),   //degenerate FP equilateral
        new Triangle(0,0,0,0,0,1),                                                //degenerate isosceles (up down)
        new Triangle(1,0,0,0,0,0),                                                //degenerate isosceles (left right)
        new Triangle(0,0,1,0,3,0),                                                //degenerate scalene
        new Triangle(0,1,1,0,0,0),                                                //isosceles right triangle
        new Triangle(1.023,12,123,1.194,234325,21321),                            //scalene
        new Triangle(0,1,0,0,1,0.5),                                              //isosceles
        new Triangle(0.1,0.1,-1.9,0.1,-0.9,-1.632051),                            //equilateral
        new Triangle(-10,0,0,0,-5,2),                                             //isosceles
        new Triangle(-1000,0,0,1,1000,0),                                         //isosceles
      };

      String[] classifications = {                                                //Corresponding results for above triangles.
       "equilateral",
       "equilateral",
       "isosceles",
       "isosceles",
       "scalene",
       "isosceles",
       "scalene",
       "isosceles",
       "equilateral",
       "isosceles",
       "isosceles",
     };

     for (int index = 0; index < triangles.length; index++) {
       if (triangles[index].classify().equals(classifications[index])) {          //The check is set up this way to counteract FP value errors from the difference in area finding methods.
         //System.out.println("CLASSIFY TEST PASSED AT RUN: " + index);           /if you want live printouts uncomment this.
       } else {
         failure = true;
         System.out.println("WE HAVE FAILED");
         System.out.println("EXPECTED: " + classifications[index]);
         System.out.println("ACTUAL: "  + triangles[index].classify());
       }
     }

     if (failure) {
       System.out.println("classify() DOESN'T WORK");
     } else {
       System.out.println("classify() WORKS");
     }

      return failure;
    }

    public static boolean toStringTester() {
      System.out.println("\ntoString() TEST");
      boolean failure = false;
      Triangle[] triangles = {
        new Triangle(0,0,0,0,0,0),                                                //degenerate equilateral
        new Triangle(12.21321,12321.232,12.21321,12321.232,12.21321,12321.232),   //degenerate FP equilateral
        new Triangle(0,0,0,0,0,1),                                                //degenerate isosceles (up down)
        new Triangle(1,0,0,0,0,0),                                                //degenerate isosceles (left right)
        new Triangle(0,0,1,0,3,0),                                                //degenerate scalene
        new Triangle(0,1,1,0,0,0),                                                //isosceles right triangle
        new Triangle(1.023,12,123,1.194,234325,21321),                            //scalene
        new Triangle(0,1,0,0,1,0.5),                                              //isosceles
        new Triangle(0.1,0.1,-1.9,0.1,-0.9,-1.632051),                            //equilateral
        new Triangle(-10,0,0,0,-5,2),                                             //isosceles
        new Triangle(-1000,0,0,1,1000,0),                                         //isosceles
      };
      String[] expectedString = {
        "v1(0.0, 0.0) v2(0.0, 0.0) v3(0.0, 0.0)",
        "v1(12.21321, 12321.232) v2(12.21321, 12321.232) v3(12.21321, 12321.232)",
        "v1(0.0, 0.0) v2(0.0, 0.0) v3(0.0, 1.0)",
        "v1(1.0, 0.0) v2(0.0, 0.0) v3(0.0, 0.0)",
        "v1(0.0, 0.0) v2(1.0, 0.0) v3(3.0, 0.0)",
        "v1(0.0, 1.0) v2(1.0, 0.0) v3(0.0, 0.0)",
        "v1(1.023, 12.0) v2(123.0, 1.194) v3(234325.0, 21321.0)",
        "v1(0.0, 1.0) v2(0.0, 0.0) v3(1.0, 0.5)",
        "v1(0.1, 0.1) v2(-1.9, 0.1) v3(-0.9, -1.632051)",
        "v1(-10.0, 0.0) v2(0.0, 0.0) v3(-5.0, 2.0)",
        "v1(-1000.0, 0.0) v2(0.0, 1.0) v3(1000.0, 0.0)",
      };

      for (int index = 0; index < triangles.length; index++) {
        if (triangles[index].toString().equals(expectedString[index])) {          //The check is set up this way to counteract FP value errors from the difference in area finding methods.
          //System.out.println("toString() TEST PASSED AT RUN: " + index);          //if you want live printouts uncomment this.
        } else {
          failure = true;
          System.out.println("WE HAVE FAILED");
          System.out.println("EXPECTED: " + expectedString[index]);
          System.out.println("ACTUAL: "  + triangles[index].toString());
        }
      }

      if (failure) {
        System.out.println("toString() DOESN'T WORK");
      } else {
        System.out.println("toString() WORKS");
      }

       return failure;
     }

     public static boolean setVertexTester() {
       System.out.println("\nsetVertex() TEST");
       boolean failure = false;
       Point point = new Point(1,1);
       Point swap = new Point(0,0);
       Triangle[] triangles = {
         new Triangle(point, point, point),
         new Triangle(point, point, point),
         new Triangle(point, point, point)
       };
       String[] expectedStringPostSwap = {
         "v1(0.0, 0.0) v2(1.0, 1.0) v3(1.0, 1.0)",
         "v1(1.0, 1.0) v2(0.0, 0.0) v3(1.0, 1.0)",
         "v1(1.0, 1.0) v2(1.0, 1.0) v3(0.0, 1.0)",
       };

       for (int index = 0; index < triangles.length; index++) {
         String original = "v1(1.0, 1.0) v2(1.0, 1.0) v3(1.0, 1.0)";
         if (!original.equals(triangles[index].toString())) {
           failure = true;
           System.out.println("This setup is wrong. You shouldn't be here");
         } else {
           triangles[index].setVertex(index, swap);
           if (expectedStringPostSwap[index].equals(expectedStringPostSwap[index])) {
             //System.out.println("toString() TEST PASSED AT RUN: " + index);          //if you want live printouts uncomment this.
            } else {
             failure = true;
             System.out.println("WE HAVE FAILED");
             System.out.println("EXPECTED: " + expectedStringPostSwap[index]);
             System.out.println("ACTUAL: "  + triangles[index].toString());
            }
         }
       }

       if (failure) {
         System.out.println("setVertex() DOESN'T WORK");
       } else {
         System.out.println("setVertex() WORKS");
       }

       return failure;
     }

  }
