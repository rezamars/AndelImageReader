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
        
        
	
	public void runTestClass(Stage primaryStage1) {
	
                this.primaryStage = primaryStage1;
            
		//Mat img = Highgui.imread("C:\\Users\\Reza\\Desktop\\testtips.jpg");//input image
		 //Mat img = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\testtips-13.jpg", Imgcodecs.IMREAD_COLOR);
		
		 //Mat img = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\europatips-7.jpg", Imgcodecs.IMREAD_COLOR);
                 
                 //filePath = "C:\\Users\\Reza\\Desktop\\testtips-filer\\stryktips-10.jpg";
                 filePath = "C:\\Users\\Reza\\Desktop\\testing-image-changeDPI\\stryktips-1.jpg";
                 
		 Mat img = Imgcodecs.imread(filePath, Imgcodecs.IMREAD_COLOR);
		 
		    if(img.empty())
				try {
					throw new Exception("no image");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
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
		
                
		Mat tpl8 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13(1).jpg", Imgcodecs.IMREAD_COLOR);//template image
		Mat tpl9 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13(2).jpg", Imgcodecs.IMREAD_COLOR);//template image
		Mat tpl10 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13(3).jpg", Imgcodecs.IMREAD_COLOR);//template image
		Mat tpl11 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13(4).jpg", Imgcodecs.IMREAD_COLOR);//template image
		Mat tpl12 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1-13(5).jpg", Imgcodecs.IMREAD_COLOR);//template image
		
		
		//drawRecOverMatches(tpl8, img);
		cutRecOverMatch(tpl8, img);
		cutRecOverMatch(tpl9, img);
		cutRecOverMatch(tpl10, img);
		cutRecOverMatch(tpl11, img);
		cutRecOverMatch(tpl12, img);
		
	    Image tmpImg = HighGui.toBufferedImage(img);
            
            
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
	    slice();
            saveAndPrintPictureDPI();
            //changeTipsImageDPI();
            
            if((imageWidthDpi != 0.0) && (imageWidthDpi != 144) || ((imageHeightDpi != 0.0) && (imageHeightDpi != 144))){
                //changeImageDPI();
            }
            
            checkPatternsOfSlices();
            
	}
	
	public void drawRecOverMatches(Mat tpl, Mat img){
		
		    
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
		    while(true) 
		    {
		        Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
		        Point maxp = maxr.maxLoc;
		        maxval = maxr.maxVal;
		        Point maxop = new Point(maxp.x + tpl.width(), maxp.y + tpl.height());
		        dst = img.clone();
		        if(maxval >= threshold)
		        {
		            System.out.println("Template Matches with input image");

		            Imgproc.rectangle(img, maxp, new Point(maxp.x + tpl.cols(),
		                    maxp.y + tpl.rows()), new Scalar(0, 0, 0),2);
		            Imgproc.rectangle(result, maxp, new Point(maxp.x + tpl.cols(),
		                    maxp.y + tpl.rows()), new Scalar(0, 255, 0),-1);
		           
		            
		        }else{
		            break;
		        }
		    }
		    
		    //Imgcodecs.imwrite("C:\\Users\\Reza\\Desktop\\output.jpg", dst);//save image
		    
		
	}
	
	public void cutRecOverMatch(Mat tpl, Mat img){
		
	    
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
	            
	            //Rect rect = new Rect((int) (maxp.x + tpl.cols()), 
	            	//	(int) (maxp.y + tpl.rows()), 0, 0); // 8 and 14 are the smallerst x and y
	            //Imgproc.rectangle(result,rect,new Scalar(0, 255, 0),-1);
	            
	            
	          //Reading the source image in to a Mat object
	            //Mat src = Imgcodecs.imread("D:\images\blank.jpg");
	            //Drawing a Rectangle
	            Point point1 = maxp;
	            Point point2 = new Point((maxp.x+450) + tpl.cols(),
	                    (maxp.y+0) + tpl.rows());// change maxp.+1.99999999999991484587 to lower or higher slice-height
	            Scalar color = new Scalar(0, 0, 0);
	            int thickness = -1;
	            //Imgproc.rectangle (result, point1, point2, color, thickness);
	            
	            /*
	            Rectangle2D rect2D ;
	            rect2D.add(1, 2);(point1,point2);
	            Rectangle rect= new Rectangle();
	            rect.setFrameFromDiagonal(new (Point point1, point2);
	            */
	            
	            //MatOfPoint currentContour = point2;
	            //Rect rectangle = Imgproc.boundingRect(result);
	            //Imgproc.rectangle(result, rectangle.tl(), rectangle.br(), new Scalar(255,0,0),1);
	            
	            //Imgproc.rectangle(result, maxp, new Point(maxp.x + tpl.cols(),
	              //      maxp.y + tpl.rows()), new Scalar(0, 255, 0),-1);
	           
	            
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
	            
	            BufferedImage image = null;
	            
	            try {
	            	image = cropImage(bufImage,point1,point2);
	            	Mat newMatImage = BufferedImage2Mat(image);
                        theRectangleCutImage = (BufferedImage) HighGui.toBufferedImage(newMatImage);
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
        
        
        //Stage primaryStage = new Stage();
        
        //StackPane root = new StackPane();
        BorderPane borderPane = new BorderPane();
        
        VBox vboxLeft = new VBox(10);
        vboxLeft.setPadding(new Insets(10, 10, 10, 15));   
        vboxLeft.setSpacing(10);
        
        //vboxLeft.setPrefSize(100, 100);
        //vboxLeft.setFillWidth(true);
        vboxLeft.setAlignment(Pos.TOP_CENTER);
        //vboxLeft.prefWidthProperty().bind(primaryStage.widthProperty().multiply(0.10));
        //Controller.primaryStage.getChildren().add(left);
        vboxLeft.getChildren().add(imgDisplay);
        
        VBox vboxRight = new VBox();
        vboxRight.setPadding(new Insets(10, 10, 10, 15));   
        vboxRight.setSpacing(10);
        //vboxRight.getChildren().add(imgDisplay);
        //vboxRight.setPrefSize(100, 100);
        vboxRight.setAlignment(Pos.TOP_CENTER);
        
        
        for(int x=0 ; x < 13 ; x++){
        	imgSliceDis[x] = new Label();
        	//frame.add(imgSliceDis[x]);
        	vboxRight.getChildren().add(imgSliceDis[x]);
        }
        
        
        borderPane.setLeft(vboxLeft);
        borderPane.setRight(vboxRight);
        
        Scene scene = new Scene(borderPane, 1000, 500);
        
        primaryStage.setTitle("Source image; Control; Result image");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
	
	public void slice(){
		

        // initalizing rows and columns
        int rows = 13;
        int columns = 1;

        // initializing array to hold subimages
        //BufferedImage imgs[] = new BufferedImage[13];

        
        System.out.println("ORG----theRectangleCutImage.getHeight(): " + theRectangleCutImage.getHeight());
        if(theRectangleCutImage.getHeight() < 660){
            
            //theRectangleCutImage = addHeightToImage(theRectangleCutImage,theRectangleCutImage.getWidth());
            /*
            try {
                theRectangleCutImage = resize(theRectangleCutImage,theRectangleCutImage.getWidth(), 660);
            } catch (IOException ex) {
                Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            Image newResizedImage = theRectangleCutImage.getScaledInstance(theRectangleCutImage.getWidth(), 660, Image.SCALE_SMOOTH);
            theRectangleCutImage = imageToBufferedImage(newResizedImage);
        }
        
        System.out.println("NEW----theRectangleCutImage.getHeight(): " + theRectangleCutImage.getHeight());
        
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
            fXimage = SwingFXUtils.toFXImage((BufferedImage) imgs[x], null);
        
            ImageView imageView = new ImageView();
            imageView.setFitHeight(25);
            imageView.setFitWidth(300);
            imageView.setImage(fXimage);
            imgSliceDis[x].setGraphic(imageView);
            
        }
        
	    
        
        
        System.out.println("Sub-images have been created.");
    }
		
	public BufferedImage cropImage(BufferedImage image, Point point1, Point point2)
            throws Exception {

        /* 
         * Create the return image
         */
        //BufferedImage retval = createImage(clip.width, clip.height);
        BufferedImage retval = createImage(((int)point2.x) -((int)point1.x), ((int)point2.y)-((int)point1.y));
        Graphics2D g2 = retval.createGraphics();

        
        /* 
         * Render the clip region
         */
        /*g2.drawImage(
                image.getSubimage(clip.x, clip.y, clip.width, clip.height),
                0, 0, null);*/
        
        //g2.setColor(java.awt.Color.black);
        
        g2.drawImage(
                image.getSubimage((int)point1.x, (int)point1.y, 
                		((int)point2.x) -((int)point1.x), ((int)point2.y)-((int)point1.y)),
                0, 0, null);
        
        //g2.setColor(java.awt.Color.black);
        
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
	    return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
	}
    
        public void checkPatternsOfSlices() {
            
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
            
            
            Mat mat1 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2-1.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat2 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2-2.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat3 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2-3.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat4 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2-4.jpg", Imgcodecs.IMREAD_COLOR);//template image
            Mat mat5 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2-5.jpg", Imgcodecs.IMREAD_COLOR);//template image
            //Mat mat6 = Imgcodecs.imread("C:\\Users\\Reza\\Desktop\\testtips-filer\\1x2-6.jpg", Imgcodecs.IMREAD_COLOR);//template image
            
            
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
        
        public void drawRecOverSignsMatch(Mat tpl, Mat img, int matIndex){
		
	    
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
	    //Imgproc.matchTemplate(img, tpl2,result,Imgproc.TM_CCOEFF_NORMED);//Template Matching
	    
	    Imgproc.threshold(result, result, 0.1, 1, Imgproc.THRESH_TOZERO);  
	    double threshold = 0.95;
	    double maxval;
	    Mat dst;
	    int q = 1;
	    
	    //while(true) 
	    //while(q == 1) 	
	    //{
	        Core.MinMaxLocResult maxr = Core.minMaxLoc(result);
	        Point maxp = maxr.maxLoc;
	        maxval = maxr.maxVal;
	        Point maxop = new Point(maxp.x + tpl.width(), maxp.y + tpl.height());
	        dst = img.clone();
	        
	        if(maxval >= threshold)
	        {
	            System.out.println("in drawRecOverSignsMatch...");

	            Imgproc.rectangle(img, maxp, new Point((maxp.x) + tpl.cols(),
	                    (maxp.y+0) + tpl.rows()), new Scalar(0, 0, 0),2);
	            
	            
	            //Drawing a Rectangle
	            Point point1 = maxp;
	            Point point2 = new Point((maxp.x) + tpl.cols(),
	                    (maxp.y+0) + tpl.rows());// change maxp.+1.99999999999991484587 to lower or higher slice-height
	            Scalar color = new Scalar(0, 0, 0);
	            int thickness = -1;
	            
                    //Imgcodecs.imwrite("C:\\Users\\Reza\\Desktop\\output.jpg", img);//save image
                    
                try {
 
                    imgs[matIndex] = Mat2BufferedImage(img);
                } catch (IOException ex) {
                    Logger.getLogger(TestClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                fillMatchesInSlices();
            //}
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
        
        public BufferedImage scaleImage(int orgWidth) {
            
            //int width = 484;
            int height = 50;    
            
            //String testfilePath = "C:\\Users\\Reza\\Desktop\\testing-image-changeDPI\\stryktips-1-changed.jpg";
            
            BufferedImage bi = null;
            try {
                //ImageIcon ii = new ImageIcon(testfilePath);//path to image
                bi = new BufferedImage(orgWidth, height, BufferedImage.TYPE_INT_RGB);
                //Graphics2D g2d = (Graphics2D) bi.createGraphics();
                //g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
                //g2d.drawImage(theRectangleCutImage, 0, 0, orgWidth, height, null);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return bi;
        }
        
        public BufferedImage addHeightToImage(BufferedImage src, int orgWidth)
        {
            int newHeight = 660 ;
            
            
            BufferedImage img = 
                    new BufferedImage(orgWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            
            int x, y;
            int ww = src.getWidth();
            int hh = src.getHeight();
            int[] ys = new int[newHeight];
            for (y = 0; y < newHeight; y++)
                ys[y] = y * hh / newHeight;
            for (x = 0; x < orgWidth; x++) {
                int newX = x * ww / orgWidth;
                for (y = 0; y < orgWidth; y++) {
                    int col = src.getRGB(newX, ys[newHeight]);
                    img.setRGB(x, y, col);
                }
            }
            
            return img;
        }
        
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
}
