package com.mangodevelopers;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

public class HelloWorld {
	
	public class DetectFaceDemo {
		  public void run() {
		    System.out.println("\nRunning DetectFaceDemo");

		    // Create a face detector from the cascade file in the resources
		    // directory.
		    CascadeClassifier faceDetector = new CascadeClassifier(System.getProperty("user.dir")+"/res"+"/lbpcascade_frontalface.xml");
		    Mat image = Highgui.imread(System.getProperty("user.dir")+"/res"+"/2.png");

		    // Detect faces in the image.
		    // MatOfRect is a special container class for Rect.
		    MatOfRect faceDetections = new MatOfRect();
		    faceDetector.detectMultiScale(image, faceDetections);

		    System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

		    // Draw a bounding box around each face.
		    for (Rect rect : faceDetections.toArray()) {
		        Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
		    }

		    // Save the visualized detection.
		    String filename = System.getProperty("user.dir")+"\\out"+"\\fd.png";
		    System.out.println(String.format("Writing %s", filename));
		    Highgui.imwrite(filename, image);
		  }
		}

	public static void main(String[] args) {
		
		//System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	    //Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
	    //System.out.println( "mat = " + mat.dump() );
	    
	    System.out.println("Hello, OpenCV");

	    // Load the native library.
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    new HelloWorld().new DetectFaceDemo().run();
	}

}
