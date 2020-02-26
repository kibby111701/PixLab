/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorHorizontal(){
    Picture mark = new Picture("blue-mark.jpg");
    mark.mirrorHorizontal();
    mark.explore();
  }

  public static void testMirrorHorizontalBotToTop(){
    Picture mark = new Picture("blue-mark.jpg");
    mark.mirrorHorizontalBotToTop();
    mark.explore();
  }

  public static void testMirrorDiagonal(){
    Picture beach = new Picture("beach.jpg");
    beach.mirrorDiagonal();
    beach.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testCopy(){
    Picture barb = new Picture("barbaraS.jpg");
    Picture beach = new Picture("beach.jpg");
    beach.copy(barb, 100, 100);
    beach.explore();
  }

  public static void testCroppedCopy(){
    Picture gull = new Picture("seagull.jpg");
    Picture beach = new Picture("beach.jpg");
    beach.croppedCopy(gull, 100, 400, 100, 400, 150, 150);
    beach.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  public static void testMyCollage(){
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testEdgeDetection2(){
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2(35);
    swan.explore();
  }

  public static void testKeepOnlyBlue(){
    Picture swan = new Picture("swan.jpg");
    swan.keepOnlyBlue();
    swan.explore();
  }

  public static void testNegate(){
    Picture barbara = new Picture("barbaraS.jpg");
    barbara.negate();
    barbara.explore();
  }

  public static void testGrayscale(){
    Picture swan = new Picture("swan.jpg");
    swan.grayscale();
    swan.explore();
  }

  public static void testFixUnderwater(){
    Picture water = new Picture("water.jpg");
    water.fixUnderwater();
    water.explore();
  }

  public static void testMirrorVerticalRightToLeft(){
    Picture swan = new Picture("swan.jpg");
    swan.mirrorVerticalRightToLeft();
    swan.explore();
  }

  public static void testMirrorArms(){
    Picture snowman = new Picture("snowman.jpg");
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull(){
    Picture gull = new Picture("seagull.jpg");
    gull.mirrorGull();
    gull.explore();
  }

  public static void markTester(){
    Picture mark = new Picture("blue-mark.jpg");
    mark.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    // testZeroBlue();
    // testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    // testNegate();
    // testGrayscale();
    // testFixUnderwater();
    //testMirrorVertical();
    // testMirrorTemple();
    // testMirrorVerticalRightToLeft();
    // testMirrorHorizontal();
    // testMirrorHorizontalBotToTop();
    // testMirrorArms();
    // testMirrorGull();
    // testMirrorDiagonal();
    //testCollage();
    // testCopy();
    // testCroppedCopy();
    // testMyCollage();
    // markTester();
    // testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}