import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}

	}

	public void negate(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());
			}
		}
	}

	public void grayscale(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				int total = pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen();
				int avg = total/3;				

				pixelObj.setRed(avg);
				pixelObj.setBlue(avg);
				pixelObj.setGreen(avg);
			}
		}
		
	}

	public void fixUnderwater(){
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels){
			for (Pixel pixelObj : rowArray){
				if (pixelObj.getBlue() > pixelObj.getGreen()){
					pixelObj.setGreen(255);
					pixelObj.setBlue(0);
				}
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal(){
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height/2; row++){
			for (int col = 0; col < pixels[row].length; col++){
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop(){
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height/2; row++){
			for (int col = 0; col < pixels[row].length; col++){
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal(){
		Pixel[][] pixels = this.getPixels2D();
		Pixel firstPixel = null;
		Pixel secondPixel = null;
		for (int row = 0; row < pixels.length; row++){
			for (int col = 0; col<=row; col++){
				firstPixel = pixels[row][col];
				secondPixel = pixels[col][row];
				secondPixel.setColor(firstPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count += 1;
			}
		}
		System.out.println(count);
	}

	public void mirrorArms(){
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int mirrorPoint = 190;

		for (int row = 160; row < mirrorPoint; row++){
			for (int col = 105; col <= 170; col++){
				topPixel = pixels[row][col];
				bottomPixel = pixels[mirrorPoint - row +mirrorPoint][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}

		mirrorPoint = 195;

		for (int row = 172; row < mirrorPoint; row++){
			for (int col = 240; col < 295; col++){
				topPixel = pixels[row][col];
				bottomPixel = pixels[mirrorPoint - row +mirrorPoint][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull(){
		Pixel [][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int mirrorPoint = 365;

		for (int row = 235; row <= 320; row++){
			for (int col = 238; col <= mirrorPoint; col++){
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void croppedCopy (Picture fromPic, int startFromRow, int endFromRow, int startFromCol, int endFromCol, int startToRow, int startToCol){
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();

		for (int fromRow = startFromRow, toRow = startToRow; fromRow < endFromRow && toRow < toPixels.length; fromRow++, toRow++){
			for (int fromCol = startFromCol, toCol = startToCol; fromCol < endFromCol && toCol < toPixels.length; fromCol++, toCol++){
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	} //This is a really ugly way to do it but I mean it works

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	public void myCollage(){
		Picture mark = new Picture("blue-mark.jpg");
		Picture swan = new Picture("swan.jpg");
		Picture notBlueMark = new Picture("blue-mark.jpg");
		notBlueMark.zeroBlue();
		this.croppedCopy(mark, 169, 300, 280, 390, 100, 100);
		swan.grayscale();
		this.croppedCopy(notBlueMark, 110, 390, 180, 460, 400, 200);
		this.croppedCopy(swan, 200, 320, 200, 320, 200, 320);
		this.mirrorDiagonal();
		this.write("myCollage.jpg");

	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color bottomColor = null;
		for (int row = 0; row < pixels.length-1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row+1][col];
				bottomColor = bottomPixel.getColor();
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist || leftPixel.colorDistance(bottomColor) > edgeDist){
					leftPixel.setColor(Color.BLACK);
				}else{
					leftPixel.setColor(Color.WHITE);
				}
			}
		}
	}

	public void edgeDetection2(int edgeDist){
		Pixel[][] pixels = this.getPixels2D();
		Pixel currentPixel = null;
		Pixel vertPixel = null;
		Pixel horiPixel = null;
		Color vertColor = null;
		Color horiColor = null;
		Color currentColor = null;
		for (int row = 1; row < pixels.length - 1; row ++){
			for (int col = 1; col < pixels[0].length - 1; col++){
				currentPixel = pixels[row][col];
				currentColor = currentPixel.getColor();
				for (int i = -1; i <= -1; i += 2){
					vertPixel = pixels[row + i][col];
					vertColor = vertPixel.getColor();
					int vRGBTotal = vertPixel.getRed() + vertPixel.getBlue() + vertPixel.getGreen();
					horiPixel = pixels[row][col + i];
					horiColor = horiPixel.getColor();
					int hRGBTotal = horiPixel.getRed() + horiPixel.getBlue() + horiPixel.getGreen();
					
					if (vRGBTotal < 765 && vRGBTotal > 0 && hRGBTotal < 765 && hRGBTotal > 0
						&& (vertPixel.colorDistance(currentColor) > edgeDist || horiPixel.colorDistance(currentColor) > edgeDist)) {
						vertPixel.setColor(Color.BLACK);
					}else{
						vertPixel.setColor(Color.WHITE);
					}
				}
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

} // this } is the end of class Picture, put all new methods before this
