package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMain extends Application {
	Stage s1;
	Department department;
	ComboBox<String> comp = new ComboBox<>();
	AVL av = new AVL();

	@Override

	public void start(Stage stage) throws FileNotFoundException {
		s1 = stage;

		stage.setTitle("Departments");
		GridPane root = new GridPane();
		BorderPane Root = new BorderPane();
		Root.setTop(root);

		root.setPadding(new Insets(15, 15, 15, 15));
		root.setVgap(10);
		root.setHgap(10);

		Button b1 = new Button("Department   ");
		b1.setStyle("-fx-background-radius:20.0 10.0;");
		b1.setStyle("-fx-background-color: linear-gradient(#2bcbba , #fed330)");
		b1.setMaxSize(300, 1500);

		Button b2 = new Button("  Student    ");
		b2.setStyle("-fx-background-radius:20.0 10.0;");
		b2.setStyle("-fx-background-color: linear-gradient(#2bcbba , #fed330)");
		b2.setMaxSize(300, 1500);

		Button b3 = new Button("  Exit       ");
		b3.setStyle("-fx-background-radius:20.0 10.0;");
		b3.setStyle("-fx-background-color: linear-gradient(#2bcbba , #fed330)");
		b3.setMaxSize(300, 1500);

		b1.setOnAction(e -> {
			Department(new Stage());
			s1.close();
		});
		b2.setOnAction(e -> {
			student(new Stage());
			s1.close();
		});
		b3.setOnAction(e -> {
			s1.close();
		});

		VBox v1 = new VBox(30);
		v1.setAlignment(Pos.CENTER);
		v1.getChildren().addAll(b1, b2, b3);
		Root.setCenter(v1);

		Scene sc = new Scene(Root, 650, 500);

		stage.setScene(sc);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void Department(Stage stage) {
		VBox ro = new VBox(20);
		ro.setAlignment(Pos.CENTER);
		Label l1 = new Label("Department : ");
		l1.setMaxSize(150, 40);
		l1.setAlignment(Pos.CENTER);
		l1.setFont(new Font(20));

		VBox v = new VBox();

		Button Add1 = new Button("Insert new Department");
		Add1.setStyle("-fx-background-radius:20.0 10.0;");

		Add1.setMaxSize(250, 400);
		Add1.setOnAction(e -> {
			insert(new Stage());
			stage.close();
		});
		Button Delete1 = new Button("Print department");
		Delete1.setStyle("-fx-background-radius:20.0 10.0;");
		Delete1.setMaxSize(250, 400);
		Delete1.setOnAction(e -> {
			print(new Stage());
			stage.close();
		});
		Button Update1 = new Button("Serch for department ");
		Update1.setStyle("-fx-background-radius:20.0 10.0;");
		Update1.setMaxSize(250, 400);
		Update1.setOnAction(e -> {
			serch(new Stage());
			stage.close();
		});
		Button Search1 = new Button("Delete a specific departmen ");
		Search1.setStyle("-fx-background-radius:20.0 10.0;");
		Search1.setMaxSize(250, 400);
		Search1.setOnAction(e -> {
			deleat(new Stage());
			stage.close();
		});
		Button Return1 = new Button("Calculate tree height ");
		Return1.setStyle("-fx-background-radius:20.0 10.0;");
		Return1.setMaxSize(250, 400);
		Return1.setOnAction(e -> {
			findCalculit(new Stage());
			stage.close();
		});

		Add1.setId("Add");
		Delete1.setId("Delete");
		Update1.setId("Update");
		Search1.setId("Search");
		Return1.setId("Return");

		Button b6 = new Button();
		b6.setPrefSize(60, 40);
		b6.setMaxSize(60, 40);
		Image image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView imageV = new ImageView(image);
		imageV.setFitHeight(40);
		imageV.setFitWidth(40);
		b6.setGraphic(imageV);
		b6.setStyle(" -fx-background-color: #00ff00");
		b6.setStyle(" -fx-font-size: 1em; ");
		b6.setOnAction(e -> {

			try {
				start(new Stage());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stage.close();
		});

		v.setId("root");

		v.setPadding(new Insets(50, 50, 50, 50));
		v.setSpacing(10);
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(Add1, Delete1, Update1, Search1, Return1, b6);

		Scene sc = new Scene(v, 650, 500, Color.ALICEBLUE);
		stage.setScene(sc);
		stage.show();

	}

	public void insert(Stage st) {
		GridPane root5 = new GridPane();
		BorderPane Root5 = new BorderPane();
		Root5.setTop(root5);
		root5.setPadding(new Insets(15, 15, 15, 15));
		root5.setVgap(10);
		root5.setHgap(10);

		Label ID5 = new Label("Enter the Department name");
		TextField tex = new TextField();
		ID5.setStyle("-fx-font-weight:bold;");
		HBox hb4737 = new HBox();
		hb4737.getChildren().addAll(ID5, tex);
		hb4737.setSpacing(25);

		Label Name5 = new Label("Enter the file Name");
		TextField tex1 = new TextField();
		Name5.setStyle("-fx-font-weight:bold;");
		HBox hb24573 = new HBox();
		hb24573.getChildren().addAll(Name5, tex1);
		hb24573.setSpacing(25);

		Label Address5 = new Label("is Add");
		TextField tex2 = new TextField();
		Address5.setStyle("-fx-font-weight:bold;");
		HBox hb378697 = new HBox();
		hb378697.getChildren().addAll(Address5, tex2);
		hb378697.setSpacing(25);

		Label Response5 = new Label();
		Image image9 = new Image("https://img.icons8.com/office/344/add.png", 40, 40, false, false);
		ImageView imageView9 = new ImageView();
		imageView9.setImage(image9);
		Root5.setCenter(imageView9);
		Button add5 = new Button("Add", imageView9);
		add5.setStyle("-fx-background-color:transparent;");
		add5.setOnAction(n -> {

			try {

				File myObj = new File(tex1.getText() + ".txt");

				if (myObj.createNewFile()) {
					FileWriter myWriter = new FileWriter(myObj);
					System.out.println("0");
					Node T = new Node(tex.getText(), tex1.getText());
					av.insert(T);
					System.out.println("File created: " + myObj.getName());
					comp.getItems().add(tex1.getText());
					tex2.setText("Add is done");
					myWriter.close();
				} else {
					System.out.println("1");
					System.out.println("File already exists.");
					tex2.setText("file is already exit");

				}
			} catch (IOException o) {
				System.out.println("An error occurred.");
				o.printStackTrace();
			}

			if (tex.getText() != null && !tex.getText().isEmpty() && tex1.getText() != null && !tex1.getText().isEmpty()
					&& tex2.getText() != null && !tex2.getText().isEmpty()) {
				Response5.setText(tex1.getText() + " " + "Registration completed !");
			} else {
				Response5.setText("you have missing fields ! try again.");
			}
		});

		Image image10 = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView imageView10 = new ImageView();
		imageView10.setImage(image10);
		Root5.setCenter(imageView10);
		Button back5 = new Button("Back", imageView10);
		back5.setStyle("-fx-background-color:transparent;");
		imageView10.setFitHeight(40);
		imageView10.setFitWidth(40);
		back5.setOnAction(o -> {
			Department(new Stage());

			st.close();
		});

		Image image1011 = new Image("https://img.icons8.com/clouds/344/delete-sign.png");
		ImageView imageView1011 = new ImageView();
		imageView1011.setImage(image1011);
		Root5.setCenter(imageView1011);
		Button clear = new Button("Clear", imageView1011);
		clear.setStyle("-fx-background-color:transparent;");
		imageView1011.setFitHeight(40);
		imageView1011.setFitWidth(40);
		clear.setOnAction(o -> {
			tex1.clear();
			tex.clear();
			tex2.clear();
		});

		DropShadow shadow5 = new DropShadow();
		add5.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eg) -> {
			add5.setEffect(shadow5);
		});
		back5.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eh) -> {
			back5.setEffect(shadow5);
		});
		clear.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eh) -> {
			clear.setEffect(shadow5);
		});

		add5.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ei) -> {
			add5.setEffect(null);
		});
		back5.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ej) -> {
			back5.setEffect(null);
		});
		clear.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ej) -> {
			clear.setEffect(null);
		});

		root5.add(ID5, 0, 1);
		root5.add(tex, 1, 1);
		root5.add(Name5, 0, 2);
		root5.add(tex1, 1, 2);
		root5.add(Address5, 0, 3);
		root5.add(tex2, 1, 3);
		root5.add(Response5, 0, 6);

		HBox hBox02 = new HBox();
		hBox02.getChildren().addAll(add5, back5, clear);
		hBox02.setAlignment(Pos.CENTER);
		hBox02.setSpacing(25);
		Root5.setBottom(hBox02);

		Scene sc = new Scene(Root5, 650, 500);
		st.setScene(sc);
		st.show();
	}

	public void print(Stage st) {
		GridPane rt4 = new GridPane();
		BorderPane Rt4 = new BorderPane();
		Rt4.setTop(rt4);
		rt4.setPadding(new Insets(15, 15, 15, 15));
		rt4.setVgap(10);
		rt4.setHgap(10);

		TextArea rentedPrint = new TextArea();
		rentedPrint.setStyle("-fx-border: gone;");
		rentedPrint.setStyle("-fx-background-color: #63cdda;");

		Image rented_image = new Image(
				"https://img.icons8.com/external-icongeek26-outline-colour-icongeek26/344/external-print-photography-icongeek26-outline-colour-icongeek26.png",
				40, 40, false, false);
		ImageView rented_imageView = new ImageView();
		rented_imageView.setImage(rented_image);
		Rt4.setCenter(rented_imageView);
		Button Add2 = new Button("Print", rented_imageView);
		Add2.setStyle("-fx-background-color:transparent;");
		Add2.setOnAction(bt11 -> {
			rentedPrint.appendText(av.printIn(av.getRoot()));
			av.out = "";
		});

		Image back2_image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView back2_imageView = new ImageView();
		back2_imageView.setImage(back2_image);
		Rt4.setCenter(back2_imageView);
		Button Back2 = new Button("Back", back2_imageView);
		Back2.setStyle("-fx-background-color:transparent;");
		back2_imageView.setFitHeight(40);
		back2_imageView.setFitWidth(40);
		Back2.setOnAction(i2222 -> {
			Department(new Stage());
			st.close();
		});

		DropShadow dropshadow2 = new DropShadow();
		Add2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eSKNF2) -> {
			Add2.setEffect(dropshadow2);
		});
		Back2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eKNHDO2) -> {
			Back2.setEffect(dropshadow2);
		});

		Add2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ePOIUY2) -> {
			Add2.setEffect(null);
		});
		Back2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent eDSADD2) -> {
			Back2.setEffect(null);
		});

		rt4.add(rentedPrint, 0, 3);

		HBox hBoxB = new HBox();
		hBoxB.getChildren().addAll(Add2, Back2);
		hBoxB.setAlignment(Pos.CENTER);
		hBoxB.setSpacing(50);
		Rt4.setBottom(hBoxB);

		Scene sc = new Scene(Rt4, 650, 500);
		st.setScene(sc);
		st.show();

	}

	public void serch(Stage st) {
		GridPane rt3 = new GridPane();
		BorderPane Rt3 = new BorderPane();
		Rt3.setTop(rt3);
		rt3.setPadding(new Insets(15, 15, 15, 15));
		rt3.setVgap(10);
		rt3.setHgap(10);

		Label idA = new Label("Department name : ");
		TextField CustomerIDA = new TextField();
		idA.setStyle("-fx-font-weight:bold;");
		HBox HB1 = new HBox();
		HB1.getChildren().addAll(idA, CustomerIDA);
		HB1.setSpacing(25);

		TextArea requestPrint = new TextArea();
		requestPrint.setStyle("-fx-border: gone;");
		requestPrint.setStyle("-fx-background-color: #63cdda;");

		Image request_image = new Image("https://img.icons8.com/nolan/344/search.png", 40, 40, false, false);
		ImageView request_imageView = new ImageView();
		request_imageView.setImage(request_image);
		Rt3.setCenter(request_imageView);
		Button Add1 = new Button("Search", request_imageView);
		Add1.setStyle("-fx-background-color:transparent;");
		Add1.setOnAction(bt12 -> {
			if (av.find(CustomerIDA.getText()) == null) {
				requestPrint.setText("not found");
				return;
			}
			requestPrint.setText(av.find(CustomerIDA.getText()).name);
		});

		Image back1_image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView back1_imageView = new ImageView();
		back1_imageView.setImage(back1_image);
		Rt3.setCenter(back1_imageView);
		Button Back1 = new Button("Back", back1_imageView);
		Back1.setStyle("-fx-background-color:transparent;");
		back1_imageView.setFitHeight(40);
		back1_imageView.setFitWidth(40);
		Back1.setOnAction(i2333 -> {
			Department(new Stage());

			st.close();
		});

		DropShadow dropshadow1 = new DropShadow();
		Add1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eSKNF3) -> {
			Add1.setEffect(dropshadow1);
		});
		Back1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eKNHDO3) -> {
			Back1.setEffect(dropshadow1);
		});

		Add1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ePOIUY3) -> {
			Add1.setEffect(null);
		});
		Back1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent eDSADD3) -> {
			Back1.setEffect(null);
		});

		rt3.add(idA, 0, 1);
		rt3.add(CustomerIDA, 1, 1);
		rt3.add(requestPrint, 0, 3);

		HBox hBoxA = new HBox();
		hBoxA.getChildren().addAll(Add1, Back1);
		hBoxA.setAlignment(Pos.CENTER);
		hBoxA.setSpacing(50);
		Rt3.setBottom(hBoxA);

		Scene scene = new Scene(Rt3, 650, 500);
		st.setScene(scene);
		st.show();
	}

	public void deleat(Stage st) {
		GridPane rt3 = new GridPane();
		BorderPane Rt3 = new BorderPane();
		Rt3.setTop(rt3);
		rt3.setPadding(new Insets(15, 15, 15, 15));
		rt3.setVgap(10);
		rt3.setHgap(10);

		Label idA = new Label("Department name : ");
		TextField CustomerIDA = new TextField();
		idA.setStyle("-fx-font-weight:bold;");
		HBox HB1 = new HBox();
		HB1.getChildren().addAll(idA, CustomerIDA);
		HB1.setSpacing(25);

		TextArea requestPrint = new TextArea();
		requestPrint.setStyle("-fx-border: gone;");
		requestPrint.setStyle("-fx-background-color: #63cdda;");

		Image request_image = new Image("https://img.icons8.com/nolan/344/search.png", 40, 40, false, false);
		ImageView request_imageView = new ImageView();
		request_imageView.setImage(request_image);
		Rt3.setCenter(request_imageView);
		Button Add1 = new Button("Search", request_imageView);
		Add1.setStyle("-fx-background-color:transparent;");
		Add1.setOnAction(bt12 -> {
			av.delete(CustomerIDA.getText());
			String b = CustomerIDA.getText() + ".txt";
			File file = new File(b);
			file.delete();
		});

		Image back1_images = new Image("https://img.icons8.com/nolan/344/check-all.png");
		ImageView back1_imageViews = new ImageView();
		back1_imageViews.setImage(back1_images);
		Rt3.setCenter(back1_imageViews);
		Button check = new Button("check ", back1_imageViews);
		check.setStyle("-fx-background-color:transparent;");
		check.setOnAction(e -> {

			if (av.find(CustomerIDA.getText()) == null) {
				requestPrint.setText("true ");

				return;
			} else {
				requestPrint.setText("false");
			}
		});

		Image back1_image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView back1_imageView = new ImageView();
		back1_imageView.setImage(back1_image);
		Rt3.setCenter(back1_imageView);
		Button Back1 = new Button("Back", back1_imageView);
		Back1.setStyle("-fx-background-color:transparent;");
		back1_imageView.setFitHeight(40);
		back1_imageView.setFitWidth(40);
		Back1.setOnAction(i2333 -> {
			Department(new Stage());

			st.close();
		});

		DropShadow dropshadow1 = new DropShadow();
		Add1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eSKNF3) -> {
			Add1.setEffect(dropshadow1);
		});
		Back1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eKNHDO3) -> {
			Back1.setEffect(dropshadow1);
		});

		Add1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ePOIUY3) -> {
			Add1.setEffect(null);
		});
		Back1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent eDSADD3) -> {
			Back1.setEffect(null);
		});

		rt3.add(idA, 0, 1);
		rt3.add(CustomerIDA, 1, 1);
		rt3.add(requestPrint, 0, 3);

		HBox hBoxA = new HBox();
		hBoxA.getChildren().addAll(Add1, check, Back1);
		hBoxA.setAlignment(Pos.CENTER);
		hBoxA.setSpacing(50);
		Rt3.setBottom(hBoxA);

		Scene scene = new Scene(Rt3, 650, 500);
		st.setScene(scene);
		st.show();
	}

	public void findCalculit(Stage st) {
		GridPane rt3 = new GridPane();
		BorderPane Rt3 = new BorderPane();
		Rt3.setTop(rt3);
		rt3.setPadding(new Insets(15, 15, 15, 15));
		rt3.setVgap(10);
		rt3.setHgap(10);

		Label idA = new Label("Hight : ");
		TextField CustomerIDA = new TextField();
		idA.setStyle("-fx-font-weight:bold;");
		HBox HB1 = new HBox();
		HB1.getChildren().addAll(idA, CustomerIDA);
		HB1.setSpacing(25);

		Image request_image = new Image("https://img.icons8.com/nolan/344/search.png", 40, 40, false, false);
		ImageView request_imageView = new ImageView();
		request_imageView.setImage(request_image);
		Rt3.setCenter(request_imageView);
		Button Add1 = new Button("Find", request_imageView);
		Add1.setStyle("-fx-background-color:transparent;");
		Add1.setOnAction(bt12 -> {
			CustomerIDA.setText(String.valueOf(av.height()));

		});

		Image back1_image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView back1_imageView = new ImageView();
		back1_imageView.setImage(back1_image);
		Rt3.setCenter(back1_imageView);
		Button Back1 = new Button("Back", back1_imageView);
		Back1.setStyle("-fx-background-color:transparent;");
		back1_imageView.setFitHeight(40);
		back1_imageView.setFitWidth(40);
		Back1.setOnAction(i2333 -> {
			Department(new Stage());

			st.close();
		});

		DropShadow dropshadow1 = new DropShadow();
		Add1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eSKNF3) -> {
			Add1.setEffect(dropshadow1);
		});
		Back1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent eKNHDO3) -> {
			Back1.setEffect(dropshadow1);
		});

		Add1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent ePOIUY3) -> {
			Add1.setEffect(null);
		});
		Back1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent eDSADD3) -> {
			Back1.setEffect(null);
		});

		rt3.add(idA, 0, 1);
		rt3.add(CustomerIDA, 1, 1);

		HBox hBoxA = new HBox();
		hBoxA.getChildren().addAll(Add1, Back1);
		hBoxA.setAlignment(Pos.CENTER);
		hBoxA.setSpacing(50);
		Rt3.setBottom(hBoxA);

		Scene scene = new Scene(Rt3, 650, 500);
		st.setScene(scene);
		st.show();

	}

	public void student(Stage st) {

		VBox ro = new VBox(20);
		ro.setAlignment(Pos.CENTER);
		Label l1 = new Label("Department : ");
		l1.setMaxSize(150, 40);
		l1.setAlignment(Pos.CENTER);
		l1.setFont(new Font(20));

		VBox v = new VBox();

		Button Add1 = new Button("Print hashed table");
		Add1.setStyle("-fx-background-radius:20.0 10.0;");
		Add1.setMaxSize(250, 400);
		Add1.setOnAction(e -> {
			printGHashedTable(new Stage());
			st.close();
		});
		Button Delete1 = new Button("Print the collision resolution strategies");
		Delete1.setStyle("-fx-background-radius:20.0 10.0;");
		Delete1.setMaxSize(250, 400);
		Delete1.setOnAction(e -> {
			printOutHashTable(new Stage());
			st.close();
		});
		Button Update1 = new Button("read from file ");
		Update1.setStyle("-fx-background-radius:20.0 10.0;");
		Update1.setMaxSize(250, 400);
		Update1.setOnAction(e -> {
			readFromFile(new Stage());
			st.close();
		});
		Button Search1 = new Button("insert student");
		Search1.setStyle("-fx-background-radius:20.0 10.0;");
		Search1.setMaxSize(250, 400);
		Search1.setOnAction(e -> {
			insertStudent(new Stage());
			st.close();
		});
		Button Return1 = new Button("Delete a specific record");
		Return1.setStyle("-fx-background-radius:20.0 10.0;");
		Return1.setMaxSize(250, 400);
		Return1.setOnAction(e -> {
			findCalculit(new Stage());
			st.close();
		});

		Add1.setId("Add");
		Delete1.setId("Delete");
		Update1.setId("Update");
		Search1.setId("Search");
		Return1.setId("Return");

		Button b6 = new Button();
		b6.setPrefSize(60, 40);
		b6.setMaxSize(60, 40);
		Image image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView imageV = new ImageView(image);
		imageV.setFitHeight(40);
		imageV.setFitWidth(40);
		b6.setGraphic(imageV);
		b6.setStyle(" -fx-background-color: #00ff00");
		b6.setStyle(" -fx-font-size: 1em; ");
		b6.setOnAction(e -> {

			try {
				start(new Stage());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			st.close();
		});

		v.setId("root");

		v.setPadding(new Insets(50, 50, 50, 50));
		v.setSpacing(10);
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(Update1, Search1, Add1, Delete1, Return1, b6);

		Scene sc = new Scene(v, 650, 500, Color.ALICEBLUE);
		st.setScene(sc);
		st.show();
	}

	public void printOutHashTable(Stage st) {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setVgap(20);
		root.setHgap(20);
		Button b1 = new Button("print : ");
		TextField tex = new TextField();
		b1.setOnAction(e -> {
			tex.setText("qaudratic function");

		});

		Button b6 = new Button();
		b6.setPrefSize(60, 40);
		b6.setMaxSize(60, 40);
		Image image = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView imageV = new ImageView(image);
		imageV.setFitHeight(40);
		imageV.setFitWidth(40);
		b6.setGraphic(imageV);
		b6.setStyle(" -fx-background-color: #00ff00");
		b6.setStyle(" -fx-font-size: 1em; ");
		b6.setOnAction(e -> {
			student(new Stage());
			st.close();
		});

		root.addRow(2, b1, tex);
		root.addRow(4, b6);
		Scene sc = new Scene(root, 300, 300);
		st.setScene(sc);
		st.show();
	}

	public void readFromFile(Stage st) {

		GridPane root = new GridPane();
		root.setHgap(20);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		Label l1 = new Label("choce one");
		Button b1 = new Button("read from file ");
		TextField tex = new TextField();
		root.addRow(2, l1, comp);
		root.addRow(4, b1, tex);
		Button back = new Button("back ");

		root.addRow(5, back);
		b1.setOnAction(e -> {
			String h = comp.getValue();

			try {

				System.out.println(av.ReadFromFile(h));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		back.setOnAction(e -> {
			student(new Stage());
			st.close();
		});
		Scene sc = new Scene(root, 400, 400);
		st.setScene(sc);
		st.show();
	}

	public void insertStudent(Stage st) {

		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		Label l1 = new Label("full Name");
		TextField tex = new TextField();
		Label l2 = new Label("student Id");
		TextField tex1 = new TextField();
		Label l4 = new Label("averge");
		TextField tex4 = new TextField();
		Label l5 = new Label("gander");
		TextField tex5 = new TextField();
		Label l6 = new Label("Department");

		RadioButton r1 = new RadioButton("male");
		RadioButton r2 = new RadioButton("female");
		ToggleGroup tg = new ToggleGroup();

		r1.setToggleGroup(tg);
		r2.setToggleGroup(tg);
		root.setVgap(20);
		root.setHgap(20);
		Label l3 = new Label("is Add ");
		TextField tex2 = new TextField();

		Button back = new Button("back");
		back.setStyle(" -fx-background-color: #00ff00");
		back.setStyle(" -fx-font-size: 1em; ");
		Image images = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView imageVs = new ImageView(images);
		imageVs.setFitHeight(40);
		imageVs.setFitWidth(40);
		back.setGraphic(imageVs);
		back.setOnAction(e -> {
			student(new Stage());
			st.close();
		});

		Button add = new Button("add ");
		Image imagesh = new Image("https://img.icons8.com/cute-clipart/344/add-property.png");
		ImageView imageVsh = new ImageView(imagesh);
		imageVsh.setFitHeight(40);
		imageVsh.setFitWidth(40);
		add.setGraphic(imageVsh);
		add.setOnAction(e -> {
			String fullname = tex.getText();
			int id = Integer.parseInt(tex1.getText());
			double avg = Double.parseDouble(tex4.getText());
			String gander;
			if (r1.isSelected()) {
				gander = "m";
			} else {
				gander = "f";

			}
			Student stt = new Student(fullname, id, avg, gander);
			String dep = comp.getValue();
			try {
				av.addRecored(dep, stt);
				FileWriter fil = new FileWriter(comp.getValue() + ".txt", true);
				fil.write(stt.toString());
				fil.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		root.addRow(0, l1, tex);
		root.addRow(1, l2, tex1);
		root.addRow(2, l4, tex4);
		root.addRow(3, l5, r1, r2);

		root.addRow(5, back, add);
		root.addRow(4, l6, comp);

		Scene sc = new Scene(root, 400, 400);
		st.setScene(sc);
		st.show();
	}

	public void printGHashedTable(Stage st) {

		GridPane root = new GridPane();
		Button pri = new Button("print ");
		Image imagesy = new Image("https://img.icons8.com/clouds/344/print.png");
		ImageView imageVsy = new ImageView(imagesy);
		imageVsy.setFitHeight(40);
		imageVsy.setFitWidth(40);
		pri.setGraphic(imageVsy);
		TextArea tex = new TextArea();
		root.setVgap(20);
		root.setHgap(20);
		root.setAlignment(Pos.CENTER);
		root.addRow(2, pri, tex);
		pri.setOnAction(e -> {
			tex.setText(av.printHash(av.getRoot()));
			av.out = "";
		});

		Button back = new Button("back ");
		Image images = new Image("https://img.icons8.com/clouds/344/back.png");
		ImageView imageVs = new ImageView(images);
		imageVs.setFitHeight(40);
		imageVs.setFitWidth(40);
		back.setGraphic(imageVs);
		back.setOnAction(e -> {
			student(new Stage());
			st.close();
		});
		root.addRow(5, back);

		Scene sc = new Scene(root, 600, 400);
		st.setScene(sc);
		st.show();
	}

	public void printSize(Stage st) {
		GridPane root = new GridPane();
		root.setVgap(20);
		root.setHgap(20);
		Button b1 = new Button("print ");
		TextArea tex = new TextArea();
		b1.setOnAction(e -> {
			int size = av.findSizeOFHashing();
			System.out.println(size);
			tex.setText(size + "");
		});
		root.addRow(4, b1, tex);
		Button b2 = new Button("back ");
		b2.setOnAction(e -> {
			student(new Stage());
			st.close();
		});

		root.addRow(5, b2);
		Scene sc = new Scene(root, 600, 400);
		st.setScene(sc);
		st.show();
	}

	public void SearchForStudent(Stage st) {
		GridPane root = new GridPane();
		root.setVgap(20);
		root.setHgap(20);
		root.setAlignment(Pos.CENTER);
		Label l1 = new Label("name department ");

		root.addRow(2, l1, comp);
		Label l2 = new Label("name student ");
		TextField tex2 = new TextField();
		root.addRow(3, l2, tex2);
		Button b = new Button("search  ");
		TextArea tex3 = new TextArea();
		b.setOnAction(e -> {
			String na = comp.getValue();
			String stName = tex2.getText();

			tex3.setText(av.findStudenthash(na, stName));

		});

		root.addRow(4, b, tex3);
		Button back = new Button("back");
		root.addRow(5, back);
		back.setOnAction(e -> {
			student(new Stage());
			st.close();
		});
		Scene sc = new Scene(root, 500, 500);
		st.setScene(sc);
		st.show();

	}
}