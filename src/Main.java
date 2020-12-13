package sample;
import sample.Mail.test1;
import java.io.IOException;
import java.util.Map;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Hacker hacker = new Hacker();
    private String login;
    private String domain;
    private String key = "Chua co gi";
    private String info = "";

    public Main(){
    }

    private Parent scene1() throws IOException {
        this.hacker.loadName();
        AnchorPane root = new AnchorPane();
        root.setPrefSize(300.0D, 400.0D);
        Button buttonAuto = new Button("Auto Fill");
        buttonAuto.setLayoutX(0.0D);
        buttonAuto.setLayoutY(200.0D);
        buttonAuto.setPrefSize(150.0D, 30.0D);
        Button buttonGetMail = new Button("Get Mail Key");
        buttonGetMail.setLayoutX(200.0D);
        buttonGetMail.setLayoutY(200.0D);
        buttonGetMail.setPrefSize(150.0D, 30.0D);
        Button buttonGetInfo = new Button("GET ALl INFO");
        buttonGetInfo.setLayoutX(100.0D);
        buttonGetInfo.setLayoutY(300.0D);
        buttonGetInfo.setPrefSize(150.0D, 30.0D);
        final TextArea display = new TextArea();
        display.setLayoutX(75.0D);
        display.setLayoutY(50.0D);
        display.setPrefWidth(200.0D);
        display.setPrefHeight(100.0D);
        buttonAuto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                try {
                    String mail = test1.getNewMail();
                    if (!mail.equals("-1")) {
                        String[] spltMail = mail.split("@");
                        Main.this.login = spltMail[0];
                        Main.this.domain = spltMail[1];
                    }

                    Main.this.hacker.auto(mail);
                } catch (InterruptedException var4) {
                    var4.printStackTrace();
                }

            }
        });
        buttonGetMail.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Main.this.key = test1.getMailInbox(Main.this.login, Main.this.domain);
                if (Main.this.key.equals("-1")) {
                    display.setText("Mail chua co gi!");
                } else {
                    display.setText(Main.this.key);
                }

            }
        });
        buttonGetInfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String mail = test1.getNewMail();
                if (!mail.equals("-1")) {
                    String[] spltMail = mail.split("@");
                    Main.this.login = spltMail[0];
                    Main.this.domain = spltMail[1];
                }

                Main.this.hacker.getAllInfo(mail);
                Main.this.info = "";
                info = info + Main.this.hacker.name;
                info = info + "\n";
                info = info + "\n";
                info = info + Main.this.hacker.phone;
                info = info + "\n";
                info = info + "\n";
                info = info + mail;
                info = info + "\n";
                display.setText(Main.this.info);
            }
        });
        root.getChildren().addAll(new Node[]{buttonAuto, buttonGetMail, display, buttonGetInfo});
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(this.scene1()));
        primaryStage.setTitle("LongVu-QuanDo-AutoFill-V0.0.1-2020");
        primaryStage.show();
    }


}
