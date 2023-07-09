/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andelimagetosystem;

//import com.sun.media.sound.InvalidDataException;
//import com.sun.image.codec.jpeg.ImageFormatException;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGEncodeParam;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import static javax.print.attribute.ResolutionSyntax.DPI;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.jimageanalyst.ImageInfo;
import org.jimageanalyst.JImageAnalyst;
import org.jimageanalyst.JImageAnalystFactory;
import org.opencv.core.CvType;
import org.w3c.dom.Node;


/**
 *
 * @author Reza
 */
public class TestClass {
    
        //public Mat img;
        public String filePath = "";
        public Label imgDisplay = new Label();
	public Label imgSliceDis[] = new Label[13];
	BufferedImage imgs[] = new BufferedImage[13];
        public BufferedImage theRectangleCutImage;
        private Stage primaryStage;
        
        private double imageWidthDpi = 0.0;
        private double imageHeightDpi = 0.0;
        
        private String[] andelArray = new String[13];
        
        private Mat[] imgMat = new Mat[13];
        //private BufferedImage theImageToCrop = null;
        
	
	public void runTestClass(Stage primaryStage1) {
	
                this.primaryStage = primaryStage1;
            
		//Mat img = Highgui.imread("C:\\Users\\Reza\\Desktop\\testtips.jpg");//input image
		 //Mat img = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\testtips-13.jpg", Imgcodecs.IMREAD_COLOR);
		
		 //Mat img = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\europatips-7.jpg", Imgcodecs.IMREAD_COLOR);
                 
                 //filePath = "C:\\Users\\Reza\\Desktop\\testtips-filer\\europatips\\europatips-10.jpg";
                 filePath = "C:\\Users\\Reza\\Desktop\\testtips-filer\\stryktips\\stryktips-13.jpg";
                 //filePath = "C:\\Users\\Reza\\Desktop\\testing-image-changeDPI\\stryktips-1-changed.jpg";
                 
		 //Mat imgOrg = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_ANYCOLOR);
                 Mat img = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_GRAYSCALE);
		 
                 //Mat img = makeCouponImageGrayScale(imgOrg);
                 
                 adjustSystemImageWidthTo660(img);
                 
                 
		    if(img.empty())
				try {
					throw new Exception("no image");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
                                
		//testGrayScaleCouponImage(img);
                //testMatchGrayscale();
                
                //printCouponImageGrayScale(img);
                    
		/*    
		Mat tpl = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1sign-1.jpg", Imgcodecs.IMREAD_COLOR);//template image
		    
		Mat tpl2 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1sign-2.jpg", Imgcodecs.IMREAD_COLOR);//template image  
		
		Mat tpl3 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1sign-3.jpg", Imgcodecs.IMREAD_COLOR);//template image 
		
		Mat tpl4 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1sign-4.jpg", Imgcodecs.IMREAD_COLOR);//template image   
		
		Mat tpl5 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1sign-5.jpg", Imgcodecs.IMREAD_COLOR);//template image 
		
		Mat tpl6 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1sign-6.jpg", Imgcodecs.IMREAD_COLOR);//template image  
		
		Mat tpl7 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1xsign.jpg", Imgcodecs.IMREAD_COLOR);//template image    
		
		
		
		drawRecOverMatches(tpl, img);
		drawRecOverMatches(tpl2, img);
		drawRecOverMatches(tpl3, img);
		drawRecOverMatches(tpl4, img);
		drawRecOverMatches(tpl5, img);
		drawRecOverMatches(tpl6, img);
		drawRecOverMatches(tpl7, img);
		*/
		
                
		Mat tpl8 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13\\1-13(1).jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
		Mat tpl9 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13\\1-13(2).jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
		Mat tpl10 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13\\1-13(3).jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
		Mat tpl11 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13\\1-13(4).jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
		Mat tpl12 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13\\1-13(5).jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
		
		
		//drawRecOverMatches(tpl8, img);
		cutRecOver1To13Match(tpl8, img);
		cutRecOver1To13Match(tpl9, img);
		cutRecOver1To13Match(tpl10, img);
		cutRecOver1To13Match(tpl11, img);
		cutRecOver1To13Match(tpl12, img);
		
	    Image tmpImg = HighGui.toBufferedImage(img);
            
            for(int i = 0 ; i < andelArray.length ; i++){
                andelArray[i] = "empty";
            }
            
            
            //theRectangleCutImage = (BufferedImage) HighGui.toBufferedImage(img);
            
	    //BufferedImage bi = new BufferedImage(100, 100, 0);
	    //bi.getScaledInstance(200, 200, 1);
	    //bi.set
	    
	    //ImageIcon icon = new ImageIcon(tmpImg);
            //imgDisplay.set.setIcon(icon);
        
            javafx.scene.image.Image fXimage;
            fXimage = SwingFXUtils.toFXImage((BufferedImage) tmpImg, null);
        
            System.out.println("The image height is: " + fXimage.getHeight());
            System.out.println("The image width is: " + fXimage.getWidth());
            
            ImageView imageView = new ImageView();
            imageView.setFitHeight(500);
            imageView.setFitWidth(500);
            imageView.setImage(fXimage);
            /*
            imageView.setViewport(
                new Rectangle2D(500, 320, 420, 300)
            );*/
            
            /*
            imgDisplay.setFont(Font.font("Athelas", FontPosture.ITALIC, 20));
            imgDisplay.setStyle("-fx-background-color: cornsilk");
            imgDisplay.setPadding(new Insets(0, 0, 5, 0));
            imgDisplay.setGraphic(
                    imageView
            );*/
            //imgDisplay.setContentDisplay(ContentDisplay.TOP);

            imgDisplay.setGraphic(imageView);
            //imgDisplay.setPrefSize(20, 20);
            //imgDisplay.setMaxSize(30, 30);
            
	    
	    createStage();
	    sliceTheMatchesWithPatterns();
            saveAndPrintPictureDPI();
            //changeTipsImageDPI();
            
            if((imageWidthDpi != 0.0) && (imageWidthDpi != 144) || ((imageHeightDpi != 0.0) && (imageHeightDpi != 144))){
                //changeImageDPI();
            }
            
                        
            checkPattern_1X2_OfSlices();
            checkPattern_1X_OfSlices();
            
            //testNewRonaldoTemplateMatching();
            
            fillMatchesInSlices();
            
            printAndelArrayOnTerminal();
            
	}
	
        public void adjustSystemImageWidthTo660(Mat img){
            
            MatOfByte matOfByte = new MatOfByte();
	            Imgcodecs.imencode(".jpg", img, matOfByte);
	            //Storing the encoded Mat in a byte array
	            byte[] byteArray = matOfByte.toArray();
	            //Preparing the Buffered Image
	            InputStream in = new ByteArrayInputStream(byteArray);
	            BufferedImage buffImage = null;
	            try {
					buffImage = ImageIO.read(in);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
            System.out.println("In-adjust----buffImage.getHeight(): " + buffImage.getHeight());
            //System.out.println("----buffImage.getWidth(): " + buffImage.getWidth());
                                   
        }
        	
	public void cutRecOver1To13Match(Mat tpl, Mat img){
		
	    
	    if(tpl.empty())
			try {
				throw new Exception("no template");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    Mat result = new Mat();
	    Imgproc.matchTemplate(img, tpl,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    //Imgproc.matchTemplate(img, tpl2,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    
	    Imgproc.threshold(result, result, 0.1, 1, Imgproc.THRESH_TOZERO);  
	    double threshold = 0.95;
	    double maxval;
	    Mat dst;
	    int q = 1;
	    
	    //while(true) 
	    while(q == 1) 	
	    {
	        Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
	        Point maxp = maxr.maxLoc;
	        maxval = maxr.maxVal;
	        Point maxop = new Point(maxp.x + tpl.width(), maxp.y + tpl.height());
	        dst = img.clone();
	        
	        if(maxval >= threshold)
	        {
	            System.out.println("Template Matches with input image");

	            Imgproc.rectangle(img, maxp, new Point((maxp.x+450) + tpl.cols(),
	                    (maxp.y+0) + tpl.rows()), new Scalar(0, 0, 0),2);
	            
	            
	            Point point1 = maxp;
	            Point point2 = new Point((maxp.x+450) + tpl.cols(),
	                    (maxp.y+0) + tpl.rows());// change maxp.+1.99999999999991484587 to lower or higher slice-height
	            Scalar color = new Scalar(0, 0, 0);
	            int thickness = -1;
	            	           
	            
	          //Encoding the image
	            MatOfByte matOfByte = new MatOfByte();
	            Imgcodecs.imencode(".jpg", dst, matOfByte);
	            //Storing the encoded Mat in a byte array
	            byte[] byteArray = matOfByte.toArray();
	            //Preparing the Buffered Image
	            InputStream in = new ByteArrayInputStream(byteArray);
	            BufferedImage bufImage = null;
	            try {
					bufImage = ImageIO.read(in);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            //BufferedImage image = null;
	            
	            try {
	            	bufImage = cropImage(bufImage,point1,point2);
	            	Mat newMatImage = BufferedImage2Mat(bufImage);
                        theRectangleCutImage = (BufferedImage) HighGui.toBufferedImage(newMatImage);
                        
                        System.out.println("ORG----theRectangleCutImage.getHeight(): " + theRectangleCutImage.getHeight());
                        System.out.println("ORG----theRectangleCutImage.getWidth(): " + theRectangleCutImage.getWidth());
                        
                        
                        if(theRectangleCutImage.getHeight() < 660){
                            int heightDifference = 660 - theRectangleCutImage.getHeight();
                            //System.out.println("aaaaaaaaaaa- heightDifference= " + heightDifference );
                            double imageAddingHeightProcentage = (Double.valueOf(heightDifference)/theRectangleCutImage.getHeight());
                            //System.out.println("aaaaaaaaaaa- imageAddingHeightProcentage= " + imageAddingHeightProcentage );
                            double theWidthProcentageMultiplier = (1 + imageAddingHeightProcentage);
                            //System.out.println("aaaaaaaaaa- theWidthProcentageMultiplier= " + theWidthProcentageMultiplier );
                            double theRectangleCutImageNewWidthDouble = (theWidthProcentageMultiplier * theRectangleCutImage.getWidth()) ;
                            int theRectangleCutImageNewWidthInt = (int)theRectangleCutImageNewWidthDouble;
                            //System.out.println("aaaaaaaaaaa- theRectangleCutImageNewWidthInt= " + theRectangleCutImageNewWidthInt );                   
                            Image newResizedImage = theRectangleCutImage.getScaledInstance( theRectangleCutImageNewWidthInt ,660, Image.SCALE_SMOOTH);
                            theRectangleCutImage = imageToBufferedImage(newResizedImage);
                        }
                        
                        System.out.println("NEW----theRectangleCutImage.getHeight(): " + theRectangleCutImage.getHeight());
                        System.out.println("NEW----theRectangleCutImage.getWidth(): " + theRectangleCutImage.getWidth());
                        
	            	//Imgcodecs.imwrite("C:\\Users\\Reza\\Desktop\\output.jpg", newMatImage);//save image
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            q = 2;
	            
	        }else{
	            break;
	        }
	    }
	     
	    //Imgcodecs.imwrite("C:\\Users\\Reza\\Desktop\\output.jpg", dst);//save image
	    
}
	
	
	private void createStage() {
        String title = "Source image; Control; Result image";
        
        
                BorderPane borderPane = new BorderPane();
        
        VBox vboxLeft = new VBox(10);
        vboxLeft.setPadding(new Insets(10, 10, 10, 15));   
        vboxLeft.setSpacing(10);
        
        vboxLeft.setAlignment(Pos.TOP_CENTER);
        
        vboxLeft.getChildren().add(imgDisplay);
        
        VBox vboxRight = new VBox();
        vboxRight.setPadding(new Insets(10, 10, 10, 15));   
        vboxRight.setSpacing(10);
        
        vboxRight.setAlignment(Pos.TOP_CENTER);
        
        
        for(int x=0 ; x < 13 ; x++){
        	imgSliceDis[x] = new Label();
        	vboxRight.getChildren().add(imgSliceDis[x]);
        }
        
        
        borderPane.setLeft(vboxLeft);
        borderPane.setRight(vboxRight);
        
        Scene scene = new Scene(borderPane, 1000, 500);
        
        primaryStage.setTitle("Source image; Control; Result image");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
	
	public void sliceTheMatchesWithPatterns(){
		

        // initalizing rows and columns
        int rows = 13;
        int columns = 1;
      
        // Equally dividing original image into subimages
        int subimage_Width = (theRectangleCutImage.getWidth() / columns);
        double subimage_Height = theRectangleCutImage.getHeight() / rows;
        //double subimage_Height = 50;
        
        System.out.println("The subimage_Width is: " + subimage_Width);
        System.out.println("The subimage_Height is: " + subimage_Height);
        
        if(subimage_Height < 50){
            //subimage_Height = 50.0;
            
        }
        
        int current_img = 0;
        
        // iterating over rows and columns for each sub-image
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                // Creating sub image
                imgs[current_img] = new BufferedImage(subimage_Width, (int)subimage_Height, theRectangleCutImage.getType());
                Graphics2D img_creator = imgs[current_img].createGraphics();

                if(subimage_Height < 50){
                    //subimage_Height = subimage_Height + (0.50);
                }
                
                if((i == 6) && (subimage_Height == 50)){
                    subimage_Height = subimage_Height + (0.25);
                }
                else if((i == 6) && (subimage_Height >= 51)){
                    //subimage_Height = subimage_Height - (0.05);
                }
                else if((i == 6) && (subimage_Height < 50)){
                    //subimage_Height = subimage_Height + (0.50);
                }
                
                // coordinates of source image
                int src_first_x = subimage_Width * j;
                double src_first_y = subimage_Height * i;

                // coordinates of sub-image
                int dst_corner_x = subimage_Width * j + subimage_Width;
                double dst_corner_y = subimage_Height * i + subimage_Height;
                
                
                
                img_creator.drawImage(theRectangleCutImage, 0, 0, subimage_Width, (int)subimage_Height, src_first_x, (int)src_first_y, dst_corner_x, (int)dst_corner_y, null);
                current_img++;
            }
        }
         
        
        /*
        //writing sub-images into image files
        for (int i = 0; i < 13; i++)
        {
            File outputFile = new File("img" + i + ".jpg");
            try {
				ImageIO.write(imgs[i], "jpg", outputFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        */
        
        //Mat img0Mat = Imgcodecs.imread(imgs[0], Imgcodecs.IMREAD_COLOR);
        
        //Image slice1Img = HighGui.toBufferedImage(img0Mat);
        
        for(int x = 0 ; x < 13 ; x++){
        	//ImageIcon sliceIcon = new ImageIcon(imgs[x]);
    	    //imgSliceDis[x].setIcon(sliceIcon);
            
            javafx.scene.image.Image fXimage;
            fXimage = SwingFXUtils.toFXImage(imgs[x], null);
        
            ImageView imageView = new ImageView();
            imageView.setFitHeight(25);
            imageView.setFitWidth(300);
            imageView.setImage(fXimage);
            imgSliceDis[x].setGraphic(imageView);
            
        }
        
        System.out.println("Sub-images have been created.");
            
        //printSelectedSliceOnDesktop(imgs[4]);
    }
		
	public BufferedImage cropImage(BufferedImage image, Point point1, Point point2)
            throws Exception {

        /* 
         * Create the return image
         */
        BufferedImage retval = createImage(((int)point2.x) -((int)point1.x), ((int)point2.y)-((int)point1.y));
        Graphics2D g2 = retval.createGraphics();

        
        g2.drawImage(
                image.getSubimage((int)point1.x, (int)point1.y, 
                		((int)point2.x) -((int)point1.x), ((int)point2.y)-((int)point1.y)),
                0, 0, null);
                
        g2.dispose();
        retval.flush();

        return retval;

    }
	
	public BufferedImage createImage(int width, int height) {
            return new BufferedImage(width, height,
                    //BufferedImage.TYPE_4BYTE_ABGR);
                            BufferedImage.TYPE_INT_RGB);
        }
        
	
	public Mat BufferedImage2Mat(BufferedImage image) throws IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ImageIO.write(image, "jpg", byteArrayOutputStream);
	    byteArrayOutputStream.flush();
	    //return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
            return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_GRAYSCALE);
	}
        
        public void checkPattern_1X2_OfSlices() {
            
            String patternText = "1X2";
                       
            for(int imgMatIndex = 0 ; imgMatIndex < 13 ; imgMatIndex++){
                try {
                    imgMat[imgMatIndex] = BufferedImage2Mat(imgs[imgMatIndex]);
                } catch (IOException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            Mat mat1 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-1.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat2 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-2.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat3 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-3.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat4 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-4.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat5 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-5.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat6 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-6.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat7 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-7.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat8 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-8.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            
            Mat mat9 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-9.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat10 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-10.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat11 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-11.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat12 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-12.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat13 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-13.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat14 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-14.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            
            Mat mat15 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-15.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat16 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-16.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat17 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-17.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat18 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-18.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat19 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-19.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            
            Mat mat20 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-20.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat21 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-21.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            
            for(int imgMatIndex = 0 ; imgMatIndex < 13 ; imgMatIndex++){
                if(imgMat[imgMatIndex] != null){
                    
                    drawRecOverSignsMatch(mat1, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat2, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat3, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat4, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat5, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat6, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat7, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat8, imgMat[imgMatIndex], imgMatIndex, patternText);
                    
                    drawRecOverSignsMatch(mat9, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat10, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat11, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat12, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat13, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat14, imgMat[imgMatIndex], imgMatIndex, patternText);
                    
                    drawRecOverSignsMatch(mat15, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat16, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat17, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat18, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat19, imgMat[imgMatIndex], imgMatIndex, patternText);
                    
                    drawRecOverSignsMatch(mat20, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat21, imgMat[imgMatIndex], imgMatIndex, patternText);
                    
                    }
            
            }
        }
        
        public void drawRecOverSignsMatch(Mat tpl, Mat img, int matIndex, String patternText){
		
            
	    if(tpl.empty())
			try {
				throw new Exception("no template");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                                //exit();
			}
	    
                        
	    Mat result = new Mat();
	    Imgproc.matchTemplate(img, tpl,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    
	    Imgproc.threshold(result, result, 0.1, 1, Imgproc.THRESH_TOZERO);  
            
            //double threshold = templateSpecifikThreshold;          
            double threshold = 0.98;           
	    
	    double maxval;
            
	        Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
	        Point maxp = maxr.maxLoc;
	        maxval = maxr.maxVal;
                
	        if(maxval >= threshold)
	        {
	            System.out.println("in drawRecOverSignsMatch...");

                    //System.out.println("The index of slice is: " + matIndex);
                    
                    andelArray[matIndex] = patternText;
                    
	            Imgproc.rectangle(img, maxp, new Point((maxp.x) + tpl.cols(),
	                    (maxp.y+0) + tpl.rows()), new Scalar(0, 0, 0),2);
	            
	                                
                try {
 
                    imgs[matIndex] = Mat2BufferedImage(img);
                } catch (IOException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                            
        }
        
        public void checkPattern_1X_OfSlices() {
            
            String patternText = "1X";         
            
            Mat mat1 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-1.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat2 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-2.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat3 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-3.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat4 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-4.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat5 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-5.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            
            Mat mat6 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-6.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat7 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-7.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat8 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-8.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat9 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-9.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat10 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-10.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat11 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-11.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat12 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-12.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            Mat mat13 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x\\1x-13.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
            
            
            for(int imgMatIndex = 0 ; imgMatIndex < 13 ; imgMatIndex++){
                if(imgMat[imgMatIndex] != null){
                    
                    drawRecOverSignsMatch(mat1, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat2, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat3, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat4, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat5, imgMat[imgMatIndex], imgMatIndex, patternText);
                    
                    drawRecOverSignsMatch(mat6, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat7, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat8, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat9, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat10, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat11, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat12, imgMat[imgMatIndex], imgMatIndex, patternText);
                    drawRecOverSignsMatch(mat13, imgMat[imgMatIndex], imgMatIndex, patternText);
                    
                }
            
            }
        }
        
        public void fillMatchesInSlices(){
            
            for(int x = 0 ; x < 13 ; x++){
        	//ImageIcon sliceIcon = new ImageIcon(imgs[x]);
    	    //imgSliceDis[x].setIcon(sliceIcon);
            
            javafx.scene.image.Image fXimage;
            fXimage = SwingFXUtils.toFXImage((BufferedImage) imgs[x], null);
        
            ImageView imageView = new ImageView();
            imageView.setFitHeight(25);
            imageView.setFitWidth(300);
            imageView.setImage(fXimage);
            imgSliceDis[x].setGraphic(imageView);
            
            }
            
        }
        
        public static BufferedImage Mat2BufferedImage(Mat mat) throws IOException{
            //Encoding the image
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", mat, matOfByte);
            //Storing the encoded Mat in a byte array
            byte[] byteArray = matOfByte.toArray();
            //Preparing the Buffered Image
            InputStream in = new ByteArrayInputStream(byteArray);
            BufferedImage bufImage = ImageIO.read(in);
            return bufImage;
        }
        
        //public int horizontal = 0 ;
        //public int vertical = 0; 
        
        
        public void saveAndPrintPictureDPI(){
            
            
            File file = new File(filePath);
            
            byte fileContent[] = new byte[(int) file.length()];
            FileInputStream fin;
            try {
            // Read image in byte array
            fin = new FileInputStream(file);
            fin.read(fileContent);
            // Get Image information
            InputStream inp = new ByteArrayInputStream(fileContent);
            JImageAnalyst analyst = JImageAnalystFactory.getDefaultInstance();
            ImageInfo imageInfo = null;
                try {
                    imageInfo = analyst.analyze(inp);
                } catch (org.jimageanalyst.InvalidDataException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            imageWidthDpi = imageInfo.getPhysicalWidthDpi();
            imageHeightDpi = imageInfo.getPhysicalHeightDpi();
            
            System.out.println("Horizontal Resolution : "
            + imageWidthDpi + " dpi");
            // Vertical resolution
            System.out.println("Vertical Resolution : "
            + imageHeightDpi + " dpi");

            } catch (FileNotFoundException e) {
            System.out.println("File not found");
            } catch (IOException ex) {   
                Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        /*
        public static final String DENSITY_UNITS_NO_UNITS = "00";
        public static final String DENSITY_UNITS_PIXELS_PER_INCH = "01";
        public static final String DENSITY_UNITS_PIXELS_PER_CM = "02";

        //public BufferedImage gridImage;

        
        public void changeImageDPI() {
            //outputFile.delete();
            
            String inputFilePath = "C:\\Users\\Reza\\Desktop\\testing-image-changeDPI\\stryktips-1.jpg";
            
            Mat img = Imgcodecs.imread(inputFilePath, Imgcodecs.IMREAD_COLOR);
            Image image = null;
            try {
                image = Mat2BufferedImage(img);
            } catch (IOException ex) {
                Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            File outputFile = new File("C:\\Users\\Reza\\Desktop\\testing-image-changeDPI\\stryktips-1-changed.jpg");

            final String formatName = "jpeg";

            for (Iterator<ImageWriter> iw = ImageIO.getImageWritersByFormatName(formatName); iw.hasNext();) {
                ImageWriter writer = iw.next();
                ImageWriteParam writeParam = writer.getDefaultWriteParam();
                ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
                IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, writeParam);
                if (metadata.isReadOnly() || !metadata.isStandardMetadataFormatSupported()) {
                    continue;
                }

                try {
                    setDPI(metadata);
                } catch (IIOInvalidTreeException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }

                ImageOutputStream stream = null;
                try {
                    stream = ImageIO.createImageOutputStream(outputFile);
                } catch (IOException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    writer.setOutput(stream);
                    writer.write(metadata, new IIOImage((RenderedImage) image, null, metadata), writeParam);
                } catch (IOException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        stream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }

        
        public static void setDPI(IIOMetadata metadata) throws IIOInvalidTreeException {
            String metadataFormat = "javax_imageio_jpeg_image_1.0";
            IIOMetadataNode root = new IIOMetadataNode(metadataFormat);
            IIOMetadataNode jpegVariety = new IIOMetadataNode("JPEGvariety");
            IIOMetadataNode markerSequence = new IIOMetadataNode("markerSequence");

            IIOMetadataNode app0JFIF = new IIOMetadataNode("app0JFIF");
            app0JFIF.setAttribute("majorVersion", "1");
            app0JFIF.setAttribute("minorVersion", "2");
            app0JFIF.setAttribute("thumbWidth", "0");
            app0JFIF.setAttribute("thumbHeight", "0");
            app0JFIF.setAttribute("resUnits", DENSITY_UNITS_PIXELS_PER_INCH);
            app0JFIF.setAttribute("Xdensity", String.valueOf(144));
            app0JFIF.setAttribute("Ydensity", String.valueOf(144));

            root.appendChild(jpegVariety);
            root.appendChild(markerSequence);
            jpegVariety.appendChild(app0JFIF);

            metadata.mergeTree(metadataFormat, root);
        }
        */
        
             
        public BufferedImage resize(BufferedImage inputBufferedImage,
            int scaledWidth, int scaledHeight)
            throws IOException {
            // reads input image
            //File inputFile = new File(inputImagePath);
            //BufferedImage inputImage = ImageIO.read(inputFile);

            // creates output image
            BufferedImage bImage = new BufferedImage(scaledWidth,
                    scaledHeight, inputBufferedImage.getType());

            // scales the input image to the output image
            Graphics2D g2d = bImage.createGraphics();
            g2d.drawImage(bImage, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();

            // extracts extension of output file
            //String formatName = outputImagePath.substring(outputImagePath
              //      .lastIndexOf(".") + 1);

            // writes to output file
            //ImageIO.write(outputImage, formatName, new File(outputImagePath));
            return bImage;
        }
        
        
    public static BufferedImage imageToBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }    
    
    /*
    public void testNewRonaldoTemplateMatching(){
        
        // Reading the main image   
        String filepathRonaldo = "C:\\Users\\Reza\\Desktop\\imagereader-examples-pics\\aaa.png";  
        Mat imgSrc = Imgcodecs.imread(filepathRonaldo, Imgcodecs.IMREAD_COLOR);
        
        Mat dst = new Mat();
        //Converting the image to grey scale
        Imgproc.cvtColor(imgSrc, dst, Imgproc.COLOR_RGB2GRAY);
        //Instantiating the Imagecodecs class
        Imgcodecs imageCodecs = new Imgcodecs();
        //Writing the image
        imageCodecs.imwrite("C:\\Users\\Reza\\Desktop\\imagereader-examples-pics\\colortogreyscale.jpg", dst);
                
        Mat newImgSrc = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\imagereader-examples-pics\\colortogreyscale.jpg");
        Mat matchFaceTemplateMat = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\imagereader-examples-pics\\bbb.jpg", Imgcodecs.IMREAD_COLOR);//template image
        
        Mat result = new Mat();
	    Imgproc.matchTemplate(newImgSrc, matchFaceTemplateMat,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    //Imgproc.matchTemplate(img, tpl2,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    
	    Imgproc.threshold(result, result, 0.1, 1, Imgproc.THRESH_TOZERO);  
	    double threshold = 0.99;
	    double maxval;
	    
	        Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
	        Point maxp = maxr.maxLoc;
	        maxval = maxr.maxVal;
	        Point maxop = new Point(maxp.x + matchFaceTemplateMat.width(), maxp.y + matchFaceTemplateMat.height());
                
	        if(maxval >= threshold)
	        {

	            Imgproc.rectangle(dst, maxp, new Point((maxp.x) + matchFaceTemplateMat.cols(),
	                    (maxp.y+0) + matchFaceTemplateMat.rows()), new Scalar(255, 255, 0),1);
	            
	                              
                }
                
                Imgcodecs imageWriteCodecs = new Imgcodecs();    
                imageWriteCodecs.imwrite("C:\\Users\\Reza\\Desktop\\imagereader-examples-pics\\test.jpg", dst);
                    
                System.out.println("At the end of testRonaldoNewTemplateMatching()");  
    }
    */
    
    public Mat tipsDST = new Mat();
    
    /*
    public void testGrayScaleCouponImage(Mat imgSrc){
        
        tipsDST = new Mat();
        //Converting the image to grey scale
        Imgproc.cvtColor(imgSrc, tipsDST, Imgproc.COLOR_RGB2GRAY);
        //Instantiating the Imagecodecs class
        Imgcodecs imageCodecs = new Imgcodecs();
        //Writing the image
        imageCodecs.imwrite("C:\\Users\\Reza\\Desktop\\testing-grayscale\\colortograyscale-2.jpg", tipsDST);
        
    }
    */
    
    /*
    public void testMatchGrayscale(){
        
        Mat tpl1 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testing-grayscale\\1x2-1.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
        Mat tpl2 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testing-grayscale\\1x2-2.jpg", Imgcodecs.IMREAD_GRAYSCALE);//template image
        
        Mat result = new Mat();
	Imgproc.matchTemplate(tipsDST, tpl1,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    
	Imgproc.threshold(result, result, 0.1, 1, Imgproc.THRESH_TOZERO);  
	double threshold = 0.96;
	double maxval;
        
	Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
	Point maxp = maxr.maxLoc;
	maxval = maxr.maxVal;
                
	if(maxval >= threshold)
	{
	    System.out.println("in testGrayscaleDrawRecOverSignsMatch...");

	    Imgproc.rectangle(tipsDST, maxp, new Point((maxp.x) + tpl1.cols(),
	                    (maxp.y+0) + tpl1.rows()), new Scalar(0, 0, 0),2);
	    	               
            //Imgcodecs.imwrite("C:\\Users\\Reza\\Desktop\\testing-grayscale\\output.jpg", tipsDST);//save image
        }
        
        Mat result2 = new Mat();
	Imgproc.matchTemplate(tipsDST, tpl2,result2,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    
	Imgproc.threshold(result2, result2, 0.1, 1, Imgproc.THRESH_TOZERO);  
	double threshold2 = 0.96;
	double maxval2;
        
	Core.MinMaxLocResult maxr2 = Core.minMaxLoc(result2);
	Point maxp2 = maxr2.maxLoc;
	maxval2 = maxr2.maxVal;
                
	if(maxval2 >= threshold2)
	{
	    System.out.println("in testGrayscaleDrawRecOverSignsMatch...");

	    Imgproc.rectangle(tipsDST, maxp2, new Point((maxp2.x) + tpl2.cols(),
	                    (maxp2.y+0) + tpl2.rows()), new Scalar(0, 0, 0),2);
	    	               
            Imgcodecs.imwrite("C:\\Users\\Reza\\Desktop\\testing-grayscale\\output.jpg", tipsDST);//save image
        }
        
    }
    */
    
    /*
    public Mat makeCouponImageGrayScale(Mat imgSrc){
        
        tipsDST = new Mat();
        //Converting the image to grey scale
        Imgproc.cvtColor(imgSrc, tipsDST, Imgproc.COLOR_RGB2GRAY);
        //Instantiating the Imagecodecs class
        Imgcodecs imageCodecs = new Imgcodecs();
        //Writing the image
        //imageCodecs.imwrite("C:\\Users\\Reza\\Desktop\\testing-grayscale\\colortograyscale.jpg", tipsDST);
        imageCodecs.imwrite("C:\\Users\\Reza\\Desktop\\colortograyscale-2.jpg", tipsDST);
        return tipsDST;
    }
    */
    
    /*
    public void checkGrayscalePatternsOfSlices() {
            
            //Mat img = Imgcodecs.imread(imgs[0], Imgcodecs.IMREAD_COLOR);
            //Mat image = HighGui.toBufferedImage("faces/s1/1.pgm", 0);
            Mat[] imgMat = new Mat[13];
            
            for(int imgMatIndex = 0 ; imgMatIndex < 13 ; imgMatIndex++){
                try {
                    imgMat[imgMatIndex] = BufferedImage2Mat(imgs[imgMatIndex]);
                } catch (IOException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            Mat mat1 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-1.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat2 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-2.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat3 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-3.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat4 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-4.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat5 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-5.jpg", Imgcodecs.IMREAD_COLOR);//template image
            //Mat mat6 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2\\1x2-6.jpg", Imgcodecs.IMREAD_COLOR);//template image
            
            
            for(int imgMatIndex = 0 ; imgMatIndex < 13 ; imgMatIndex++){
                if(imgMat[imgMatIndex] != null){
                    drawRecOverSignsMatch(mat1, imgMat[imgMatIndex], imgMatIndex);
                    drawRecOverSignsMatch(mat2, imgMat[imgMatIndex], imgMatIndex);
                    drawRecOverSignsMatch(mat3, imgMat[imgMatIndex], imgMatIndex);
                    drawRecOverSignsMatch(mat4, imgMat[imgMatIndex], imgMatIndex);
                    drawRecOverSignsMatch(mat5, imgMat[imgMatIndex], imgMatIndex);
                    //drawRecOverSignsMatch(mat6, imgMat[imgMatIndex], imgMatIndex);
                }
            
            
            }
        }
    */
    
    public void printCouponImageGrayScale(Mat imgSrc){
        
        Imgcodecs imageCodecs = new Imgcodecs();
        //Writing the image
        imageCodecs.imwrite("C:\\Users\\Reza\\Desktop\\colortograyscale-2.jpg", imgSrc);
        
    }
    
    public void printSelectedSliceOnDesktop(BufferedImage  selectedBuffImage){
        
        Mat imgSrc = null;
        
        //making a .jpg-picture of desired buffimagepattern on desktop
        try {
             imgSrc = BufferedImage2Mat(selectedBuffImage);
        } catch (IOException ex) {
             Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Imgcodecs imageCodecs = new Imgcodecs();
        //Writing the image
        imageCodecs.imwrite("C:\\Users\\Reza\\Desktop\\patternslice.jpg", imgSrc);
    }
    
    public void printAndelArrayOnTerminal(){
        for(int i = 0 ; i <andelArray.length ; i++){
            System.out.println("At match " + (i+1) + ", the pattern is= " + andelArray[i]);
        }
    }
}
