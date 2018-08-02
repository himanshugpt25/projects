package milkman;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import javafx.application.Application;
//import javafx.stage.Stage;

public class milk1 extends Application{
	Connection con;
	PreparedStatement pst;
	TextField txtnbc=new TextField();
	Calendar cal=Calendar.getInstance();
	DatePicker dpt1=new DatePicker();
	DatePicker dpt2=new DatePicker();
	DatePicker rhdp1=new DatePicker();
	DatePicker rhdp2=new DatePicker();
	TextField txtnt=new TextField();
	 ComboBox<String> cbrh=new ComboBox<String>();
	//	DatePicker dp=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1 , cal.get(Calendar.DATE)));
		DatePicker dp1=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1 , cal.get(Calendar.DATE)));
	public milk1()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost1:3306/milkman","himanshu","2525");
			System.out.println("connected");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("::::::::::::::::::::::");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Button btnn,btnp,btngd,btnau,btnbill,btnbc,btnbv,btnrh;
	Text lbh;
	GridPane grd;
	
	ListView<String>lst1,lst2,lst3;{
	lst1=new ListView<String>();
	lst2=new ListView<String>();
	lst3=new ListView<String>();
	lst2.getItems().add(0, "End Date :");
	lst1.getItems().add(0, "Start Date :");
	lst3.getItems().add(0, "Amount :" );}
	
	 public static void main(String abc[])
	 {
		 milk1 m=new milk1();
		 launch(abc);
	 }

	 void dashboard()
	 {
		 btnn=new Button("New Cust.");
			lbh=new Text("MILKMAN ASSISTANT");
			lbh.setFont(Font.font(40));
			// TODO Auto-generated method stub
			btnp=new Button("Daily Entry");
			btngd=new Button("Cust.det.");
			btnbill=new Button("BILL");
			btnau=new Button("About US");
			btnbc=new Button("Bill List");
			btnbv=new Button("Bill Voucher");
			btnrh=new Button("Routine History");
			btnn.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btnp.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btngd.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btnbill.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btnau.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btnbc.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btnbv.setStyle("-fx-background-color:CORNFLOWERBLUE");
			btnrh.setStyle("-fx-background-color:CORNFLOWERBLUE");
	        btnn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnn.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnn.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        
	        btnp.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnp.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnp.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnp.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        
	        btngd.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btngd.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btngd.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btngd.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        
	        btnbill.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnbill.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnbill.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnbill.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        btnau.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnau.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnau.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnau.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        btnbv.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnbv.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnbv.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnbv.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        
	        btnrh.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnrh.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnrh.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnrh.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
	        
	        btnbc.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnbc.setStyle("-fx-border-color:BLUE");
				}
	        	
	        });	
	        btnbc.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent ev) {
					// TODO Auto-generated method stub
					btnbc.setStyle("-fx-background-color:CORNFLOWERBLUE");
				}
	        	
	        });	
			//btnn.setStyle("-fx-border-color:BLUE");
		//	btnn.setStyle("-fx-text-fill:BLUE");
			btnn.setShape(new Circle(6));
			btnp.setShape(new Circle(6));
			btngd.setShape(new Circle(6));
			btnbill.setShape(new Circle(6));
			btnau.setShape(new Circle(6));
			btnbc.setShape(new Circle(6));
			btnbv.setShape(new Circle(6));
			btnrh.setShape(new Circle(6));
			btnn.setPrefSize(100, 200);
			btnp.setPrefSize(100, 200);
			btngd.setPrefSize(100, 200);
			btnbill.setPrefSize(100, 200);
			btnau.setPrefSize(100, 200);
			btnbc.setPrefSize(100, 200);
			btnbv.setPrefSize(100, 200);
			btnrh.setPrefSize(100, 200);
			VBox h=new VBox();
			grd=new GridPane();
			h.getChildren().addAll(btnn,btnp,btngd,btnbill);
			h.setSpacing(100);
			VBox h1=new VBox();
			h1.getChildren().addAll(btnbc,btnbv,btnrh,btnau);
			h1.setSpacing(100);
			HBox hb1=new HBox();
			hb1.getChildren().addAll(h,h1);
			hb1.setSpacing(50);
		ImageView img=new ImageView();
			Image img1=new Image(milk1.class.getResourceAsStream("title.png"));
			img.setImage(img1);
			img.setTranslateX(200);
			ImageView imgbc=new ImageView();
			Image imgbk=new Image(milk1.class.getResourceAsStream("milkdash-002.jpg"));
			imgbc.setImage(imgbk);
BackgroundImage c=new BackgroundImage(imgbk, null, null, null, null);
Background g=new Background(c);

			// GridPane.setConstraints(lbh, 0, 0, 5, 2, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		      //  grd.getChildren().add(lbh);
		        GridPane.setConstraints(hb1, 0, 3, 4, 4, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		        grd.getChildren().add(hb1);
		       // GridPane.setConstraints(h1, 2, 3, 1, 4, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		        //grd.getChildren().add(h1);
		        GridPane.setConstraints(img, 0, 0, 5, 2, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		        grd.getChildren().add(img);
		        GridPane.setConstraints(imgbc, 7, 3, 5, 20, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		        grd.getChildren().add(imgbc);
		        hb1.setTranslateY(100);
		        hb1.setTranslateX(50);
		        imgbc.setTranslateY(50);
		        imgbc.setFitHeight(700);
		        imgbc.setFitWidth(700);
		        imgbc.setTranslateX(-80);
		       			/*Pane root=new Pane();
			StackPane hold=new StackPane();
			Canvas c=new Canvas(400,300);
			hold.getChildren().add(c);
			root.getChildren().add(hold);
			hold.setStyle("-fx-background-color:blue");*/
			btnn.setOnAction(e->fillnew());
			btnp.setOnAction(e->dopost());
			btnbill.setOnAction(e->dobill());
			btnbc.setOnAction(e->billcollector());
			btnbv.setOnAction(e->billvoucher());
			btngd.setOnAction(e->getdetails());
			btnrh.setOnAction(e->rhistory());
			btnau.setOnAction(e->aboutus());
			grd.setBackground(g);
			grd.setStyle("-fx-background-color: AQUAMARINE");
			Stage st=new Stage();
			Scene s=new Scene(grd,1200,700,Color.BLACK);
			s.setFill(Color.CORNFLOWERBLUE);
		
			st.setScene(s);
			st.setTitle("Milkman_ass.1.2");
		
	        st.show();		
			
		 
	 }
	 void aboutus()
	 {
		 TextArea txtam;
		 txtam=new TextArea("Milkman Assistant version 1.2 is designed to ease the \ndaily updates,new customer enrolls and bill generations\n"
		 		+ "and keeping the whole record saved in database.\n This software is specifically designed for milkmen to\n avoid any clerical errors or "
		 		+ "mistakes.\n This software is provided with technical assistance and\nhow to use,moreover is always under\n improvement.\n\n"
		 		+ "Developed By:- HIMANSHU GUPTA\n Under the guidance of:\n Rajesh K.Bansal Sir");
		 //txtat=new TextArea();
		 //VBox vab=new VBox();
		 //vab.getChildren().addAll(txtam,txtat);
		 //vab.setSpacing(20);
		 txtam.setStyle("-fx-background-color:AQUAMARINE");
		 txtam.setFont(Font.font(getUserAgentStylesheet(), 20));
		 txtam.setEditable(false);
		 Stage sta=new Stage();
		 Scene sa=new Scene(txtam, 500,500);
		 sta.setScene(sa);
		 sta.setTitle("About_Us...");
		 sta.show();
	 }
	@Override
	public void start(Stage st) throws Exception {
		Text log=new Text("LOGIN PANEL ->");
		log.setFont(Font.font(30));
		Text uname,uid;
		ImageView img=new ImageView();
		Image img1=new Image(milk1.class.getResourceAsStream("loginp.png.png"));
		img.setImage(img1);
		ImageView imgb=new ImageView();
		Image imgb1=new Image(milk1.class.getResourceAsStream("btnlog.png.png"));
		imgb.setImage(imgb1);
		ImageView imgbf=new ImageView();
		Image imgbf1=new Image(milk1.class.getResourceAsStream("btnfp.png"));
		imgbf.setImage(imgbf1);
		
		img.setFitWidth(400);
		img.setFitHeight(80);
		img.setTranslateY(80);
		img.setTranslateX(30);
		uname=new Text("User Name:");
		uid=new Text("Password:");
		TextField txtun=new TextField();
		PasswordField txtp=new PasswordField();
		Button btnl,btnf;
		
		btnl=new Button();
		btnl.setGraphic(imgb);
		imgb.setFitHeight(25);
		imgb.setFitWidth(50);
		btnl.setPrefSize(50, 5);
		btnf=new Button();
		btnf.setGraphic(imgbf);
		imgbf.setFitHeight(30);
		btnf.setPrefHeight(5);
		GridPane grdl=new GridPane();
		GridPane.setConstraints(img, 0, 0, 4, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(img);
		GridPane.setConstraints(uname, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(uname);
		GridPane.setConstraints(txtun, 2, 1, 1, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(txtun);
		GridPane.setConstraints(uid, 1,2 , 1, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(uid);
		GridPane.setConstraints(txtp, 2, 2, 1, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(txtp);
		GridPane.setConstraints(btnl, 2, 3, 1, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(btnl);
		GridPane.setConstraints(btnf, 3, 3, 1, 1, HPos.CENTER, VPos.CENTER);
		grdl.getChildren().add(btnf);
		btnl.setTranslateY(230);
		btnf.setTranslateY(230);
		txtp.setTranslateY(180);
		uid.setTranslateY(180);
		txtp.setTranslateX(150);
		uid.setTranslateX(100);
		uname.setTranslateX(100);
		txtun.setTranslateX(150);
		uname.setTranslateY(150);
		txtun.setTranslateY(150);
		log.setTranslateY(100);
		log.setTranslateX(70);
		String uno="himanshu";
		String upo="9463610225";
		btnl.setOnAction(e->{
			String un=txtun.getText();
			String up=txtp.getText();
		
		if(uno.equals(un) && upo.equals(up))
			{
				dashboard();
				st.close();
			}
			else
			{
			System.out.println("Invalid");
		}
		});
		btnf.setOnAction(e->{
			
			SST_SMS s1=new SST_SMS();
			s1.bceSunSoftSend(upo,"your pswd is-"+upo);
			System.out.println("sms sent");
		});
		grdl.setStyle("-fx-background-color:AQUAMARINE");
		Scene s=new Scene(grdl,500,500);
		st.setScene(s);
		st.setTitle("LoginPanel..");
		st.show();
	}
	void fillnew()
	{
		 Button btns=new Button("SAVE");
		 Button btnb=new Button("Back");
		Text lbln,lbla,lblm,lblcm,lblbm;
		lbln=new Text("Name");
		lbla=new Text("Address");
		lblm=new Text("Mob.no.");
		lblcm=new Text("Cow milk qty.:");
		lblbm=new Text("Buffalo milk qty.:");
		TextField txtn,txta,txtm,txtcm,txtbm;
		ImageView imgcst=new ImageView();
		Image imgcst1=new Image(milk1.class.getResourceAsStream("newcustomer.png"));
		imgcst.setImage(imgcst1);
		txtn=new TextField();
		txta=new TextField();
		txtm=new TextField();
		txtcm=new TextField();
		txtbm=new TextField();
		GridPane grd2=new GridPane();
		txtn.setPrefSize(400, 10);
		btns.setTranslateX(400);
		btns.setTranslateY(300);
		btnb.setTranslateX(400);
		btnb.setTranslateY(300);
		VBox vb1=new VBox();
		vb1.getChildren().addAll(txtn,txta,txtm,txtcm,txtbm);
		vb1.setSpacing(20);
		VBox vb2=new VBox();
		vb2.getChildren().addAll(lbln,lbla,lblm,lblcm,lblbm);
		vb2.setSpacing(30);
		 GridPane.setConstraints(vb2, 0, 1, 1, 5, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd2.getChildren().add(vb2);
	        GridPane.setConstraints(vb1, 1, 1, 1, 5, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd2.getChildren().add(vb1);
	        GridPane.setConstraints(imgcst, 0, 1, 5, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd2.getChildren().add(imgcst);
	        imgcst.setTranslateX(250);
	        imgcst.setTranslateY(50);
	        imgcst.setFitWidth(700);
	        vb1.setTranslateX(300);
	        vb1.setTranslateY(250);
	        vb2.setTranslateX(300);
	        vb2.setTranslateY(250);
	        btns.setPrefSize(100, 10);
	        btnb.setPrefSize(100, 10);
	        grd2.setStyle("-fx-background-color:AQUAMARINE");
	        //GridPane.setConstraints(lblm, 0, 2, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(lblm);
	     //   GridPane.setConstraints(txtm, 1, 2, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	       // grd2.getChildren().add(txtm);
	        //GridPane.setConstraints(lbla, 0, 3, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(lbla);
	        //GridPane.setConstraints(txta, 1, 3, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(txta);
	        GridPane.setConstraints(btns, 0, 7, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd2.getChildren().add(btns);
	        //GridPane.setConstraints(lblcm, 0, 4, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(lblcm);
	        //GridPane.setConstraints(txtcm, 1, 4, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(txtcm);
	        //GridPane.setConstraints(lblbm, 0, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(lblbm);
	        //GridPane.setConstraints(txtbm, 1, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd2.getChildren().add(txtbm);
	        GridPane.setConstraints(btnb, 1, 7, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd2.getChildren().add(btnb);
	        
		btns.setOnAction(e->{
		try
		{
			pst=(PreparedStatement) con.prepareStatement("insert into custdetails(custname,mobno,address,cmilkq,bmilkq,dateen) values(?,?,?,?,?,curdate())");
			pst.setString(1, txtn.getText());
			pst.setString(2, txtm.getText());
			pst.setString(3, txta.getText());
			pst.setString(4, txtcm.getText());
			pst.setString(5, txtbm.getText());
			pst.executeUpdate();
			Stage df=new Stage();
			Text txtdf=new Text("RECORD SAVED");
			txtdf.setFont(Font.font(20));
			
			df.initModality(Modality.WINDOW_MODAL);
			VBox vbf=new VBox(txtdf);
			
			vbf.setAlignment(Pos.CENTER);
			df.setScene(new Scene(vbf,300,300));
			df.show();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			Stage df=new Stage();
			Text txtdf=new Text("NAME EXISTS ALREADY");
			txtdf.setFont(Font.font(20));
			
			df.initModality(Modality.WINDOW_MODAL);
			VBox vbf=new VBox(txtdf);
			
			vbf.setAlignment(Pos.CENTER);
			df.setScene(new Scene(vbf,300,300));
			df.show();
		}
		
		/*double j=0;
		for(double i=0;i<1000000000;i++)
		{
			j++;
		}*/
	
		
	});
	      Stage st2=new Stage();
	      Scene s2=new Scene(grd2,1200,700);
	      st2.setScene(s2);
	      st2.setTitle("Add new Customer");
	      btnb.setOnAction(e->{
	    	  st2.close();
	      });
	      st2.show();
	      
	
	
		// TODO Auto-generated method stub
		
	}
	void dopost()
	{
		 GridPane grd4=new GridPane();
		 Button btnpf,btnmis,btnpos;
		 btnpf=new Button("Post Full");
		 btnmis=new Button("Missed");
		 btnpos=new Button("Post");
		 Text lblcm,lblbm,lblq1,lblq2;
		 lblcm=new Text("Cow Milk");
		 lblbm=new Text("Buffalo Milk");
		 lblq1=new Text("Quantity");
		 lblq2=new Text("Quantity");
		 TextField txtq1,txtq2;
		 txtq1=new TextField();
		 txtq2=new TextField();
		 HBox hb=new HBox();
		 hb.getChildren().addAll(lblcm,txtq1,lblbm,txtq2);
		 hb.setSpacing(5);
		ListView<String>names=new ListView<String>();
		ArrayList<String>ary=new ArrayList<String>();
		try
		{
			pst=(PreparedStatement) con.prepareStatement("select custname from custdetails ");
			
			ResultSet rs =pst.executeQuery();
			
			while(rs.next())
			{
				
				 String nm=rs.getString("custname");
				ary.add(nm);
			}
		
			//else
			//{
				//System.out.println("invalid");
			//}
			names.getItems().addAll(ary);
			names.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		    
			
			btnpf.setOnAction(e->{
				ObservableList<String>sel;
			    sel=names.getSelectionModel().getSelectedItems();
			   ary.removeAll(sel);
			    try
			    {
			    	for(String s:ary)
			    	{
			    		
			    PreparedStatement pst2,pst3;		
			   pst3=(PreparedStatement) con.prepareStatement("insert into dailyentry values(curdate(),?,?,?)");
			   pst3.setString(1, s);
			   pst2=(PreparedStatement) con.prepareStatement("select * from custdetails where custname=?");
			   pst2.setString(1,s);
			   ResultSet rs1= pst2.executeQuery();
			   if(rs1.next())
			   {
				   float c=rs1.getFloat("cmilkq");
				   float b=rs1.getFloat("bmilkq");
				   pst3.setFloat(2, c);
				   pst3.setFloat(3, b);
			   }
			   pst3.executeUpdate();
			   
			    }
			    	names.getItems().removeAll(ary);
			    System.out.println("Entry saved");
			    }
			    catch(SQLException e3)
			    {
			    	e3.printStackTrace();
			    }
			   
			});
			btnmis.setOnAction(e->{
				ObservableList<String>obsl;
				obsl=names.getSelectionModel().getSelectedItems();
				names.getItems().removeAll(obsl);
			});
			btnpos.setOnAction(e->{
				try
				{
					ObservableList<String>obsli;
					obsli=names.getSelectionModel().getSelectedItems();
					pst=(PreparedStatement) con.prepareStatement("insert into dailyentry values(curdate(),?,?,?)");
					pst.setString(1, names.getSelectionModel().getSelectedItem());
					pst.setFloat(2, Float.parseFloat(txtq1.getText()));
					pst.setFloat(3, Float.parseFloat(txtq2.getText()));
					pst.executeUpdate();
					names.getItems().removeAll(obsli);
					txtq1.clear();
					txtq2.clear();
				}
				catch(SQLException eh)
				{
					eh.printStackTrace();
				}
			});
			
		ImageView imgd=new ImageView();
		Image imgd1=new Image(milk1.class.getResourceAsStream("dailyentry.png"));
		imgd.setImage(imgd1);
		grd4.setGridLinesVisible(false);
		  GridPane.setConstraints(names, 0, 0, 7, 12, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd4.getChildren().add(names);
	        GridPane.setConstraints(btnpf, 8, 3, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd4.getChildren().add(btnpf);
	        GridPane.setConstraints(btnmis, 9, 3, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd4.getChildren().add(btnmis);
	        GridPane.setConstraints(hb, 8, 9, 3, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd4.getChildren().add(hb);
	        //GridPane.setConstraints(lblq1, 7, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd4.getChildren().add(lblq1);
	        //GridPane.setConstraints(txtq1, 8, 6, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd4.getChildren().add(txtq1);
	        //GridPane.setConstraints(lblbm, 9, 6, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd4.getChildren().add(lblbm);
	     //   GridPane.setConstraints(lblq2, 9, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	       // grd4.getChildren().add(lblq2);
	        //GridPane.setConstraints(txtq2, 10, 6, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grd4.getChildren().add(txtq2);
	        GridPane.setConstraints(btnpos, 9, 10, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd4.getChildren().add(btnpos);
	        GridPane.setConstraints(imgd, 0, 0, 7, 2, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grd4.getChildren().add(imgd);
	        imgd.setFitWidth(600);
	        imgd.setFitHeight(100);
	        imgd.setTranslateX(200);
	        imgd.setTranslateY(50);
	        grd4.setStyle("-fx-background-color:AQUAMARINE");
	        btnpos.setTranslateY(200);
	        btnpos.setTranslateX(100);
	        hb.setTranslateX(20);
	        hb.setTranslateY(200);
	        btnpf.setTranslateX(100);
	        btnpf.setTranslateY(200);
	        btnmis.setTranslateX(100);
	        btnmis.setTranslateY(200);
	        names.setTranslateX(20);
	        names.setTranslateY(200);
	        names.setPrefWidth(700);
		Stage st3=new Stage();
		Scene s3=new Scene(grd4,1200,700);
		st3.setScene(s3);
		st3.setTitle("Post Daily Entry");
		st3.show();
		
	}


	void dobill()
	{
		
		// float cq=0,bq=0;
		 DatePicker dp2=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1 , cal.get(Calendar.DATE)));
		Text lblsd,lbled,lbln,lblm,lblcm,lblbm,lblct,lblbt,lblgt,lblq1,lblq2,lblh;
		lblsd=new Text("Start date");
		lbled=new Text("End Date");
		lbln=new Text("Name");
		lblm=new Text("Mob.no.:");
		lblcm=new Text("C.Milk.Q");
		lblbm=new Text("B.Milk.Q");
		lblq1=new Text("Price:");
		lblq2=new Text("Price:");
		lblct=new Text("C.M.Total:");
		lblbt=new Text("B.M.Total:");
		lblgt=new Text("Total:");
		lblh=new Text("BILL ->");
		lblh.setFont(Font.font(20));
		Button btngb,btnsm,btnt,btnok,btns;
		btns=new Button("Save");
		btngb=new Button("Get Bill");
		btnsm=new Button("SMS");
		btnt=new Button("Total");
		btnok=new Button("OK");
		ComboBox<String>cb=new ComboBox<String>();
		cb.setEditable(true);
		cb.setPromptText("Name");
		
		ArrayList<String>aryn=new ArrayList<String>();
		try
		{
			pst=(PreparedStatement) con.prepareStatement("select custname from custdetails");
			ResultSet rsn=pst.executeQuery();
			while(rsn.next()){
				String n=rsn.getString("custname");
				aryn.add(n);
			}
			cb.getItems().addAll(aryn);
		}
		catch(SQLException es)
		{
			es.printStackTrace();
		}
		TextField txtn,txtm,txtcq,txtbq,txtcp,txtbp,txtct,txtbt,txtgt;
		txtn=new TextField();
		txtm=new TextField();
		txtcq=new TextField();
		txtbq=new TextField();
		txtcp=new TextField();
		txtbp=new TextField();
		txtct=new TextField();
		txtbt=new TextField();
		txtgt=new TextField();
		TextField txtsd=new TextField();
		HBox hb1=new HBox();
		HBox hb2=new HBox();
		HBox hb3=new HBox();
		hb1.getChildren().addAll(lblcm,txtcq,lblbm,txtbq);
		hb1.setSpacing(5);
		hb2.getChildren().addAll(lblq1,txtcp,lblq2,txtbp);
		hb2.setSpacing(5);
		hb3.getChildren().addAll(lblct,txtct,lblbt,txtbt);
		hb3.setSpacing(5);
		GridPane grds=new GridPane();
		txtn.requestFocus();
				 GridPane.setConstraints(lblh, 0, 0, 3, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
        grds.getChildren().add(lblh);
        GridPane.setConstraints(cb, 1, 2, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
        grds.getChildren().add(cb);
		 GridPane.setConstraints(txtsd, 2, 4, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	       grds.getChildren().add(txtsd);
	       GridPane.setConstraints(dp2, 1, 4, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	       grds.getChildren().add(dp2);
			 GridPane.setConstraints(dp1, 1, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		        grds.getChildren().add(dp1);
		        GridPane.setConstraints(btnok, 2, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
		        grds.getChildren().add(btnok);
	        
        
		 GridPane.setConstraints(lbln, 0, 2, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(lbln);
	     
	        GridPane.setConstraints(lblm, 0, 3, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(lblm);
	        GridPane.setConstraints(txtm, 1, 3, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(txtm);
	        GridPane.setConstraints(lblsd, 0, 4, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(lblsd);
	        GridPane.setConstraints(lbled, 0, 5, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(lbled);
	        GridPane.setConstraints(btngb, 1, 6, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(btngb);
	        GridPane.setConstraints(hb1, 0, 7, 4, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(hb1);
	        GridPane.setConstraints(hb2, 0, 8, 4, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(hb2);
	        GridPane.setConstraints(hb3, 0, 10, 4, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(hb3);
	        //GridPane.setConstraints(btngb, 1, 9, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        //grds.getChildren().add(btngb);
	        GridPane.setConstraints(lblgt, 0, 11, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(lblgt);
	        GridPane.setConstraints(btnsm, 2, 11, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(btnsm);
	        GridPane.setConstraints(btns, 3, 11, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(btns);
	        GridPane.setConstraints(txtgt, 1, 11, 1, 1, HPos.CENTER,VPos.CENTER,null,null,new Insets(10,15,10,15));
	        grds.getChildren().add(txtgt);
	        LocalDate local=dp1.getValue();
	        LocalDate local2=dp2.getValue();
	        
	        btnok.setOnAction(e->{
	        	PreparedStatement pstm;
	        	try
  	     		{
	        		pstm=(PreparedStatement) con.prepareStatement("select * from custdetails where custname=?");
	        		pstm.setString(1, cb.getSelectionModel().getSelectedItem());
	                ResultSet rsm=pstm.executeQuery();
	                if(rsm.next())
	                {
	                	String m=rsm.getString("mobno");
	                	txtm.setText(m);
	                    Date d=rsm.getDate("dateen");
	                    String dt=d.toString();
	                    txtsd.setText(dt);
	                }
	    			pst=(PreparedStatement) con.prepareStatement("update custdetails set datele=? where custname=?");
	    			Date d=Date.valueOf( local);
	    			pst.setDate(1, d);
	    			pst.setString(2, cb.getSelectionModel().getSelectedItem());
	    			pst.executeUpdate();
	    		}
	        	catch(SQLException e1)
	        	{
	        		System.out.println("hehe"); 
	        		e1.printStackTrace();
	        	}
	        
	        	
	        	
	        });
	        
	        btngb.setOnAction(e->{
	        	boolean a,b;
	        	a=txtbp.getText().isEmpty();
	        	b=txtcp.getText().isEmpty();
	        	if(a==false&&b==false)
	        	{
	        	PreparedStatement pstq;
	        	try
	        	{
	        	  /* SimpleDateFormat dtf=new SimpleDateFormat("MM/dd/yyyy");
	        	   Date dt2=(Date) DateFormat.parseDate(txtsd.getText());*/
	        		pstq=(PreparedStatement) con.prepareStatement("select * from dailyentry where custn=?");
	        		pstq.setString(1,cb.getSelectionModel().getSelectedItem() );
	        	 //  pstq.setDate(2, Date.valueOf(local2));
	        	  // pstq.setDate(3, Date.valueOf(local));
	        	   float cqt=0,bqt=0;
	              		ResultSet rsq=pstq.executeQuery();
	              		System.out.println("???????");
	      while(rsq.next()) 		
	      {
	    	  System.out.println("/////////");
	    	   cqt=cqt+rsq.getFloat("cmq");
	    	   bqt=bqt+rsq.getFloat("bmq");
	        		txtcq.setText(String.valueOf(cqt));
	        		txtbq.setText(String.valueOf(bqt));
	        		float cp=Float.parseFloat(txtcp.getText());
		        	float bp=Float.parseFloat(txtbp.getText());
		        	float ct,bt,gt;
	     ct=cp*cqt;
	     bt=bp*bqt;
	     gt=ct+bt;
	      		txtct.setText(String.valueOf(ct));
	      		txtbt.setText(String.valueOf(bt));
	      		txtgt.setText(String.valueOf(gt));
		        	       	
	     	        
	      }        	
	        	}
	       
	        	catch(SQLException eq)
	        	{
	        		eq.printStackTrace();
	        	}
	        	
	        	
	        	}
	        	else
	        	{
	        	txtbp.setPromptText("Enter the price");
	        	txtcp.setPromptText("Enter the price");
	        	}
	        });
	        btns.setOnAction(e->{
	        try
	        {
	        	PreparedStatement pstbc,pstbc1;
	        	
	        	pstbc=(PreparedStatement) con.prepareStatement("select * from custdetails where custname=?");
	        	pstbc.setString(1, cb.getSelectionModel().getSelectedItem());
	        	ResultSet rstbc=pstbc.executeQuery();
	        	pst=(PreparedStatement) con.prepareStatement("Insert into billstatus (cnamebc,strtdt,amount,enddate) values(?,?,?,?)");
	        	if(rstbc.next())
	        	{
	        		Date dbce=Date.valueOf(local);
	        		String nbc=rstbc.getString("custname");
	        	pst.setString(1,nbc);
	        	Date dbc=Date.valueOf(local2);
	        	pst.setDate(2, dbc);
	        	pst.setFloat(3, Float.parseFloat(txtgt.getText()));
	        	pst.setDate(4, dbce);
	        	pst.executeUpdate();
	                }
	        	btns.setStyle("-fx-background-color:WHITE");
	        	System.out.println("Record saved");
	        }
	        catch(SQLException ebc)
	        {
	        	ebc.printStackTrace();
	        }
	        });
	        btnsm.setOnAction(e->{
	        	String ss1=txtcq.getText();
	        	String ss2=txtbq.getText();
	        	String ss3=txtct.getText();
	        	String ss4=txtbt.getText();
	        	String ss5=txtgt.getText();
	        	SST_SMS s2=new SST_SMS();
	        	s2.bceSunSoftSend("9463610225", "Dear customer your milk bill is:\n cow qty="+ss1+"\n buffalo qty:"+ss2+"Cow total=: Rs."
	        			+ ss3+"\nBuffalo total: Rs "+ss4+"\nTotal: Rs "+ss5);
	        	System.out.println("sms sent");
				
			});
		
	        
	       

	   	        Stage st4=new Stage();
	        Scene s4=new Scene(grds,1200,700);
	        st4.setScene(s4);
	        st4.setTitle("Get_Bill");
	        st4.show();
	
	}
	/*void dodsave(LocalDate local)
	{
		try
		{
			pst=(PreparedStatement) con.prepareStatement("insert into custdetails(datele) values(?) where custname='?'");
			Date d=Date.valueOf( local);
			pst.setDate(1, d);
			pst.setString(2, txtn);
		}
	}*/
	
	void billcollector()
	{
		ComboBox<String>cbn=new ComboBox<String>();
		ArrayList<String>arln=new ArrayList<String>();
		
		
		Button btnpaid=new Button("PAID");
		Button btndet=new Button("Get Details");
		Text lblnbc=new Text("Total Amount:");
		
		GridPane grdbc=new GridPane();
		
		HBox hbc=new HBox();
		HBox hbc1=new HBox();
		hbc1.getChildren().addAll(lblnbc,txtnbc,btnpaid);
		hbc1.setSpacing(10);
		hbc.getChildren().addAll(lst1,lst2,lst3);
		hbc.setSpacing(10);
		txtnbc.setText(String.valueOf(0));
		ImageView imgbill=new ImageView();
		Image imgbl=new Image(milk1.class.getResourceAsStream("billcollector.png"));
		imgbill.setImage(imgbl);
		 GridPane.setConstraints(btndet, 5, 0, 1, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
		    grdbc.getChildren().add(btndet);
		 GridPane.setConstraints(hbc1, 0, 14, 12, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
		    grdbc.getChildren().add(hbc1);
		 GridPane.setConstraints(hbc, 0, 2, 12, 10, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
		    grdbc.getChildren().add(hbc);
	    GridPane.setConstraints(cbn, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
	    grdbc.getChildren().add(cbn);
	    GridPane.setConstraints(imgbill, 0, 0, 8, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
	    grdbc.getChildren().add(imgbill);

	    cbn.translateXProperty();
	    hbc.setTranslateX(200);
	    hbc1.setTranslateX(200);
	    btndet.setTranslateX(200);
	    cbn.setTranslateX(200);
	    hbc.setTranslateY(100);
	    hbc1.setTranslateY(100);
	    btndet.setTranslateY(100);
	    cbn.setTranslateY(100);
	    imgbill.setTranslateX(200);
	    grdbc.setStyle("-fx-background-color:AQUAMARINE");
		try {
			pst=(PreparedStatement) con.prepareStatement("select custname from custdetails");
		
				ResultSet rsnbc=pst.executeQuery();
		while(rsnbc.next())
		{
		String bcn=rsnbc.getString("custname");
		arln.add(bcn);
		}
		cbn.getItems().addAll(arln);
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btndet.setOnAction(e->{
			lst1.getItems().clear();
			lst3.getItems().clear();
			lst2.getItems().clear();
			lst2.getItems().add(0, "End Date :");
			lst1.getItems().add(0, "Start Date :");
			lst3.getItems().add(0, "Amount :" );
			
			ArrayList<String>alst1,alst2,alst3;
			alst1=new ArrayList<String>();
			alst2=new ArrayList<String>();
			alst3=new ArrayList<String>
			();
			try{
			PreparedStatement pstnbc;
			pstnbc=(PreparedStatement) con.prepareStatement("select * from billstatus where cnamebc=?");
			pstnbc.setString(1, cbn.getSelectionModel().getSelectedItem());
			ResultSet rstbc=pstnbc.executeQuery();
			while(rstbc.next())
			{
				Date de=rstbc.getDate("enddate");
				Date d=rstbc.getDate("strtdt");
				Float a=rstbc.getFloat("amount");
				alst1.add(d.toString());
				alst2.add(de.toString());
				alst3.add(String.valueOf(a));
			}
			lst1.getItems().addAll(1, alst1);
			lst2.getItems().addAll(1, alst2);
			lst3.getItems().addAll(1, alst3);
			}
			catch(SQLException en)
			{
				en.printStackTrace();
			}
		});
	btnpaid.setOnAction(e->{
		try
		{
			pst=(PreparedStatement) con.prepareStatement("update billstatus set status = ? where enddate=? and cnamebc=?");
			pst.setInt(1, 1);
			pst.setString(3, cbn.getSelectionModel().getSelectedItem());
			pst.setDate(2,Date.valueOf(lst2.getSelectionModel().getSelectedItem()));
			pst.executeUpdate();
						
		}
		catch(SQLException ef)
		{
			System.out.println("???????????????????");
			
		}
	});
		
	
		Stage stbc=new Stage();
		Scene sbc=new Scene(grdbc,1200,700);
		stbc.setScene(sbc);
		stbc.setTitle("Bill_Collector");
		stbc.show();
		dodblclick();
	}
	
	void dodblclick()
	{
lst1.setOnMouseClicked(new EventHandler<MouseEvent>() {

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub

		float sum;
		if(event.getClickCount()==2)
		{
			int i=lst1.getSelectionModel().getSelectedIndex();
			lst2.getSelectionModel().select(i);
			lst3.getSelectionModel().select(i);
			String a=lst3.getSelectionModel().getSelectedItem();
			float s=Float.parseFloat(a);
			sum=Float.parseFloat(txtnbc.getText())+s;
			txtnbc.setText(String.valueOf(sum));
			txtnbc.setEditable(false);
		}
	}
});
	}
	void billvoucher()
	{
		//------------------------------------------------------------------------------------------------
		TableView<billstatus>tbl;
		tbl=new TableView<>();
		TableColumn<billstatus, String>coln=new TableColumn<>("Name:");
		coln.setCellValueFactory(new PropertyValueFactory<>("cnamebc"));
		coln.setMinWidth(200);
		TableColumn<billstatus, Date>colsd=new TableColumn<>("Start Date:");
		colsd.setCellValueFactory(new PropertyValueFactory<>("strtdt"));
		colsd.setMinWidth(200);
		TableColumn<billstatus, Date>coled=new TableColumn<>("End Date:");
		coled.setCellValueFactory(new PropertyValueFactory<>("enddate"));
		coled.setMinWidth(200);
	   TableColumn<billstatus, Float> colamt=new TableColumn<>("Amount");
	   colamt.setCellValueFactory(new PropertyValueFactory<>("amount"));
	   colamt.setMinWidth(200);
	   tbl.getColumns().addAll(coln,colsd,coled,colamt);
	   
		//---------------------------------------------------------------------------------------
		
				
		
		Button btnf=new Button("Fetch");
		Text lblbvh=new Text("Bill Voucher ->");
		lblbvh.setFont(Font.font(STYLESHEET_CASPIAN, 30));
		Text lbl1,lbl2,lbl3;
		lbl1=new Text("Start DATE:");
		lbl2=new Text("FROM:");
		lbl3=new Text("TO:");
		TextField txt1,txt2;
		txt1=new TextField();
		txt2=new TextField();
		HBox hbv=new HBox();
		hbv.getChildren().addAll(lbl1,lbl2,dpt1,lbl3,dpt2);
		hbv.setSpacing(10);
		HBox hbv2=new HBox();
		
		RadioButton rbf,rbb;
		rbf=new RadioButton("full paid");
		rbb=new RadioButton("Bal");
		hbv2.getChildren().addAll(rbf,rbb,btnf);
		hbv2.setSpacing(15);
		ToggleGroup grp=new ToggleGroup();
		rbf.setToggleGroup(grp);
		rbb.setToggleGroup(grp);
		GridPane grdbv=new GridPane();
		ImageView imgv=new ImageView();
		Image imgv1=new Image(milk1.class.getResourceAsStream("VOUCHERS.png"));
		imgv.setImage(imgv1);
		
		
GridPane.setConstraints(imgv, 0, 0, 4, 1, HPos.RIGHT, VPos.CENTER,null,null,new Insets(10,15,10,15));
grdbv.getChildren().add(imgv);
GridPane.setConstraints(hbv, 0, 1, 5, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10,15,10,15));
grdbv.getChildren().add(hbv);
GridPane.setConstraints(hbv2, 2, 2, 4, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10,15,10,15));
grdbv.getChildren().add(hbv2);
GridPane.setConstraints(tbl, 0, 10, 16, 10, HPos.CENTER, VPos.CENTER,null,null,new Insets(10,15,10,15));
grdbv.getChildren().add(tbl);
//lblbvh.setTranslateX(100);
grdbv.setStyle("-fx-background-color:AQUAMARINE");
imgv.setTranslateX(400);
imgv.setFitHeight(100);
imgv.setTranslateY(30);
imgv.setFitWidth(400);
hbv.setTranslateX(100);
hbv.setTranslateY(50);
hbv2.setTranslateX(100);
hbv2.setTranslateY(50);
tbl.setTranslateX(100);
tbl.setTranslateY(50);
tbl.setPrefWidth(800);

btnf.setOnAction(e->{
	if(rbf.isSelected())
	{
		tbl.setItems(getrows());
		System.out.println("?????");
	}
	else
		{
			tbl.setItems(getsrows());
		}
});
Stage stbv=new Stage();
Scene sbv=new Scene(grdbv,1200,700);
stbv.setScene(sbv);
stbv.setTitle("Bill_Voucher.");
stbv.show();
	}
	ObservableList<billstatus> getrows()
	{
		ObservableList<billstatus>lsttbl=FXCollections.observableArrayList();
		LocalDate ltb1=dpt1.getValue();
		LocalDate ltb2=dpt2.getValue();
		Date dtt1=Date.valueOf(ltb1);
		Date dtt2=Date.valueOf(ltb2);
		try{
		pst=(PreparedStatement) con.prepareStatement("select * from billstatus where status=? and strtdt>=? and strtdt<=?");
		pst.setInt(1, 1);
		pst.setDate(2, dtt1);
		pst.setDate(3, dtt2);
		ResultSet rstt=pst.executeQuery();
		while(rstt.next())
		{
			billstatus rf=new billstatus(rstt.getString("cnamebc"),rstt.getDate("strtdt"),rstt.getDate("enddate"),rstt.getFloat("amount"));
			lsttbl.add(rf);
		}
		}
		catch(SQLException et)
		{
			et.printStackTrace();
		}
		return lsttbl;
		
	}
	ObservableList<billstatus> getsrows()
	{
		ObservableList<billstatus>lsttblb=FXCollections.observableArrayList();
		LocalDate ltb1=dpt1.getValue();
		LocalDate ltb2=dpt2.getValue();
		Date dtt1=Date.valueOf(ltb1);
		Date dtt2=Date.valueOf(ltb2);
		try{
		pst=(PreparedStatement) con.prepareStatement("select * from billstatus where status=? and strtdt>=? and strtdt<=?");
		pst.setInt(1, 0);
		pst.setDate(2, dtt1);
		pst.setDate(3, dtt2);
		ResultSet rstt=pst.executeQuery();
		while(rstt.next())
		{
			billstatus rf=new billstatus(rstt.getString("cnamebc"),rstt.getDate("strtdt"),rstt.getDate("enddate"),rstt.getFloat("amount"));
			lsttblb.add(rf);
		}
		}
		catch(SQLException et)
		{
			et.printStackTrace();
		}
		return lsttblb;
		
	}
	void getdetails()
	{
		TableView<custdetails>tbcd=new TableView<>();
		TableColumn<custdetails, String>tblcn=new TableColumn<>("NAME:");
		tblcn.setCellValueFactory(new PropertyValueFactory<>("custname"));
		tblcn.setMinWidth(150);
		TableColumn<custdetails, String>tblmn=new TableColumn<>("Mob.No.");
		tblmn.setCellValueFactory(new PropertyValueFactory<>("mobno"));
		tblmn.setMinWidth(150);
		TableColumn<custdetails, String> tblca=new TableColumn<>("Address:");
		tblca.setCellValueFactory(new PropertyValueFactory<>("address"));
		tblca.setMinWidth(150);
		TableColumn<custdetails, Date>tblcsd=new TableColumn<>("Start Date:");
		tblcsd.setCellValueFactory(new PropertyValueFactory<>("dateen"));
		tblcsd.setMinWidth(150);
		TableColumn<custdetails, Date>tblced=new TableColumn<>("Date Left:");
		tblced.setCellValueFactory(new PropertyValueFactory<>("datele"));
		tblced.setMinWidth(150);
		TableColumn<custdetails, Float>tblcm=new TableColumn<>("Cow Milk Q.");
		tblcm.setCellValueFactory(new PropertyValueFactory<>("cmilkq"));
		tblcm.setMinWidth(150);
		TableColumn<custdetails, Float> tblbm=new TableColumn<>("Buffalo Milk Q.");
		tblbm.setCellValueFactory(new PropertyValueFactory<>("bmilkq"));
		tblbm.setMinWidth(150);
		tbcd.getColumns().addAll(tblcn,tblmn,tblca,tblcsd,tblced,tblcm,tblbm);
		//-----------------------------------------------------------------------------------------------------------
		tbcd.setPrefWidth(1050);
		tbcd.setTranslateX(60);
		tbcd.setTranslateY(100);
		Text lblh,lblg;
		lblh=new Text("Customer Details -> ");
		lblh.setFont(Font.font(30));
		lblg=new Text("Name:");
		RadioButton rbcm,rbbm,rbb;
		rbcm=new RadioButton("Cow Milk");
		rbbm=new RadioButton("Buffalo Milk");
		rbb=new RadioButton("Both");
		Button btns=new Button("Search");
		GridPane grdt=new GridPane();
		ToggleGroup t=new ToggleGroup();
		rbcm.setToggleGroup(t);
		rbbm.setToggleGroup(t);
		rbb.setToggleGroup(t);
		HBox ht1=new HBox();
		HBox ht2=new HBox();
		ht1.getChildren().addAll(lblg,txtnt,btns);
		ht2.getChildren().addAll(rbcm,rbbm,rbb);
		ht1.setSpacing(20);
		ht2.setSpacing(20);
		ht1.setTranslateX(60);
		ht1.setTranslateY(50);
		ht2.setTranslateX(60);
		ht2.setTranslateY(50);
		tbcd.setTranslateY(60);
		btns.setOnAction(e->{
			if(rbcm.isSelected())
			{
				tbcd.setItems(getcdtbl1());
			}
			else
				if(rbbm.isSelected())
				{
					tbcd.setItems(getcdtbl2());
				}
				else
				{
					tbcd.setItems(getcdtbl3());
				}
		});
		lblh.setTranslateX(100);
		ht1.setTranslateX(60);
		ht2.setTranslateX(60);
		ImageView imgcs=new ImageView();
		Image imgcs1=new Image(milk1.class.getResourceAsStream("CUSTDETAILS.png"));
		imgcs.setImage(imgcs1);
		grdt.setGridLinesVisible(false);
		GridPane.setConstraints(imgcs, 0, 0, 5, 1, HPos.LEFT, VPos.CENTER, null, null,new Insets(10,15,10,15));
		grdt.getChildren().add(imgcs);
		GridPane.setConstraints(ht1, 1, 2, 5, 1, HPos.CENTER, VPos.CENTER, null, null,new Insets(10,15,10,15));
		grdt.getChildren().add(ht1);
		GridPane.setConstraints(ht2, 1, 4, 5, 1, HPos.CENTER, VPos.CENTER, null, null,new Insets(10,15,10,15));
		grdt.getChildren().add(ht2);
		GridPane.setConstraints(tbcd, 0, 5, 5, 1, HPos.CENTER, VPos.CENTER, null, null,new Insets(10,15,10,15));
		grdt.getChildren().add(tbcd);
		imgcs.setTranslateX(200);
		imgcs.setTranslateY(20);
		grdt.setStyle("-fx-background-color:AQUAMARINE");
		Stage stcd=new Stage();
		Scene scd=new Scene(grdt,1200,700);
		stcd.setScene(scd);
		stcd.setTitle("Cust_Details..");
		stcd.show();		
		
		
	}
	ObservableList<custdetails> getcdtbl1()
	{
		ObservableList<custdetails>lstcd1=FXCollections.observableArrayList();
		try{
			pst=(PreparedStatement) con.prepareStatement("select * from custdetails where bmilkq=? and custname=?");
			pst.setFloat(1, 0);
			pst.setString(2, txtnt.getText());
			ResultSet tbcd1=pst.executeQuery();
			while(tbcd1.next())
			{
				custdetails ob1=new custdetails(tbcd1.getString("custname"),tbcd1.getString("mobno"),tbcd1.getString("address"),tbcd1.getFloat("cmilkq"),tbcd1.getFloat("bmilkq"),tbcd1.getDate("dateen"),tbcd1.getDate("datele"));
				lstcd1.add(ob1);
			}
		}
		catch(SQLException etcd)
		{
			etcd.printStackTrace();
		}
		return lstcd1;
	}
	ObservableList<custdetails> getcdtbl2()
	{
		ObservableList<custdetails>lstcd2=FXCollections.observableArrayList();
		try{
			pst=(PreparedStatement) con.prepareStatement("select * from custdetails where cmilkq=? and custname=?");
			pst.setFloat(1, 0);
			pst.setString(2, txtnt.getText());
			ResultSet rst=pst.executeQuery();
			while(rst.next())
			{
				custdetails ob2=new custdetails(rst.getString("custname"),rst.getString("mobno"),rst.getString("address"),rst.getFloat("cmilkq"),rst.getFloat("bmilkq"),rst.getDate("dateen"),rst.getDate("datele"));
				lstcd2.add(ob2);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lstcd2;
	}
	ObservableList<custdetails> getcdtbl3()
	{
		ObservableList<custdetails>lstcd3=FXCollections.observableArrayList();
		try{
			pst=(PreparedStatement) con.prepareStatement("select * from custdetails where custname=?");
			pst.setString(1, txtnt.getText());
			ResultSet rs2=pst.executeQuery();
			while(rs2.next())
			{
				custdetails ob3=new custdetails(rs2.getString("custname"),rs2.getString("mobno"),rs2.getString("address"),rs2.getFloat("cmilkq"),rs2.getFloat("bmilkq"),rs2.getDate("dateen"),rs2.getDate("datele"));
				lstcd3.add(ob3);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lstcd3;
	}
	void rhistory()
	{
		TableView<dailyentry> tblrh=new TableView<>();
		TableColumn<dailyentry, Date>tblhd=new TableColumn<>("Date:");
		tblhd.setCellValueFactory(new PropertyValueFactory<>("tdate"));
		tblhd.setMinWidth(200);
		TableColumn<dailyentry, String>tblhn=new TableColumn<>("Name:");
		tblhn.setCellValueFactory(new PropertyValueFactory<>("custn"));
		tblhn.setMinWidth(200);
		TableColumn<dailyentry, Float>tblhc=new TableColumn<>("Cow Milk Q.");
		tblhc.setCellValueFactory(new PropertyValueFactory<>("cmq"));
		tblhc.setMinWidth(200);
		TableColumn<dailyentry, Float>tblhb=new TableColumn<>("Buffalo Milk Q.");
		tblhb.setCellValueFactory(new PropertyValueFactory<>("bmq"));
		tblhb.setMinWidth(200);
		tblrh.getColumns().addAll(tblhn,tblhd,tblhc,tblhb);
		tblrh.setTranslateX(150);
		tblrh.setTranslateY(50);
		tblrh.setPrefWidth(800);
		
		Text lblrh=new Text("Routine History ->");
        lblrh.setFont(Font.font(30));
        Text rhn,rhd,rhfr,rhto;
        rhn=new Text("Name :");
        rhd=new Text("DATE:");
        rhfr=new Text("FROM");
        rhto=new Text("To");
        HBox rhhb=new HBox();
        rhhb.getChildren().addAll(rhd,rhfr,rhdp1,rhto,rhdp2);
        rhhb.setSpacing(20);
        rhhb.setTranslateX(300);
        rhhb.setTranslateY(80);
        Button btnrh=new Button("FETCH");
        ImageView imgrh=new ImageView();
        Image img=new Image(milk1.class.getResourceAsStream("history.png"));
        imgrh.setImage(img);
       
       
        ArrayList<String>aryrh=new ArrayList<String>();
        try
        {
        	pst=(PreparedStatement) con.prepareStatement("select custname from custdetails");
        	ResultSet rstrh=pst.executeQuery();
        	while(rstrh.next())
        	{
        		aryrh.add(rstrh.getString("custname"));
        	}
        	cbrh.getItems().addAll(aryrh);
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
        GridPane grdrh=new GridPane();
        GridPane.setConstraints(imgrh, 0, 0, 5, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
        grdrh.getChildren().add(imgrh);
        lblrh.setTranslateX(30);
        GridPane.setConstraints(rhn, 1, 1, 1, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
        grdrh.getChildren().add(rhn);
        GridPane.setConstraints(rhhb, 0, 2, 5, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
        grdrh.getChildren().add(rhhb);
        GridPane.setConstraints(btnrh, 2, 3, 1, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
        grdrh.getChildren().add(btnrh);
        btnrh.setTranslateX(50);
        GridPane.setConstraints(tblrh, 1, 4, 8, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
        grdrh.getChildren().add(tblrh);
        GridPane.setConstraints(cbrh, 2, 1, 1, 1, HPos.CENTER, VPos.CENTER,null,null,new Insets(10, 15, 10, 15));
        grdrh.getChildren().add(cbrh);
        btnrh.setTranslateX(600);
        btnrh.setTranslateY(-20);
        cbrh.setTranslateX(420);
        cbrh.setTranslateY(70);
        rhn.setTranslateX(400);
        rhn.setTranslateY(70);
        imgrh.setTranslateX(300);
        imgrh.setTranslateY(20);
        grdrh.setStyle("-fx-background-color:AQUAMARINE");
        tblrh.setStyle("-fx-border-color:BLUE");
        
        btnrh.setOnAction(e->{
        	tblrh.setItems(rhrows());
        });
        Stage strh=new Stage();
        
        Scene srh=new Scene(grdrh,1200,700);
        strh.setScene(srh);
        strh.setTitle("History...");
        strh.show();
        
	}
	ObservableList<dailyentry> rhrows()
	{
		LocalDate lrh1=rhdp1.getValue();
		LocalDate lrh2=rhdp2.getValue();
		Date rhd1=Date.valueOf(lrh1);
		Date rhd2=Date.valueOf(lrh2);
		ObservableList<dailyentry> lstrh=FXCollections.observableArrayList();
		try
		{
			pst=(PreparedStatement) con.prepareStatement("select * from dailyentry where custn=? and tdate>=? and tdate<=?");
			pst.setDate(2, rhd1);
			pst.setDate(3, rhd2);
			pst.setString(1, cbrh.getSelectionModel().getSelectedItem());
			ResultSet rh=pst.executeQuery();
			while(rh.next())
			{
				dailyentry rhr=new dailyentry(rh.getDate("tdate"), rh.getString("custn"), rh.getFloat("cmq"),rh.getFloat("bmq"));
				lstrh.add(rhr);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lstrh;
	}
}
		
	
	



	