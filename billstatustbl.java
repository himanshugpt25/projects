package milkman;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class billstatustbl
{
 public billstatustbl()
 {
	 Connection con;
		PreparedStatement pst;
		
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/milkman","root","2525");
				System.out.println("connected");
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("::::::::::::::::::::::");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TableView<billstatus>tbl;
			tbl=new TableView<>();
			TableColumn<billstatus, String>coln=new TableColumn<>("Name:");
			coln.setCellValueFactory(new PropertyValueFactory<>("cnamebc"));
			coln.setMinWidth(100);
			TableColumn<billstatus, Date>colsd=new TableColumn<>("Start Date:");
			colsd.setCellValueFactory(new PropertyValueFactory<>("strtdt"));
			colsd.setMinWidth(100);
			TableColumn<billstatus, Date>coled=new TableColumn<>("End Date:");
			coled.setCellValueFactory(new PropertyValueFactory<>("enddate"));
			coled.setMinWidth(100);
		   TableColumn<billstatus, Float> colamt=new TableColumn<>("Amount");
		   colamt.setCellValueFactory(new PropertyValueFactory<>("amount"));
		   colamt.setMinWidth(100);
		   tbl.getColumns().addAll(coln,colsd,coled,colamt);
		   
			
			
		}
 }

