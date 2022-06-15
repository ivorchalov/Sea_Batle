import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    public static int countOfSteps = 0;

    public static int[][] allyField = new int[12][12];
    public static int[][] enemyField = new int[10][10];

    public static ArrayList<Cell> allyCellList = new ArrayList<>();
    public static ArrayList<Cell> enemyCellList = new ArrayList<>();
    public static ArrayList<Ship> ships = new ArrayList<>();

    public static Group group = new Group();
    public static Scene scene = new Scene(group, 1280, 960);

    public static void main(String[] args){ Application.launch(args); }

    @Override
    public void start(Stage primaryStage){
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setTitle("World of warships");
        primaryStage.setScene(scene);
        primaryStage.show();

        DropShadow shadow = new DropShadow();

        Button button1 = new Button("Начать игру");
        Button button2 = new Button("Авторы");
        Button button3 = new Button("Выход");

        Text title = new Text("World Of Warships");

        group.getChildren().addAll(button1,button2,button3,title);

        title.setX(415);
        title.setY(300);
        title.setStyle("-fx-font-size: 54");

        button1.setEffect(shadow);
        button2.setEffect(shadow);
        button3.setEffect(shadow);

        button1.setLayoutX(515);
        button1.setLayoutY(360);
        button1.setPrefWidth(250);

        button2.setLayoutX(515);
        button2.setLayoutY(430);
        button2.setPrefWidth(250);

        button3.setLayoutX(515);
        button3.setLayoutY(500);
        button3.setPrefWidth(250);

        button1.setStyle(""
                + "-fx-background-color: #ddd;"
                + "-fx-font-size: 24;"
                + "-fx-border-color: black;"
                + "-fx-border-width: 2 2 2 2;");
        button2.setStyle(""
                + "-fx-background-color: #ddd;"
                + "-fx-font-size: 24;"
                + "-fx-border-color: black;"
                + "-fx-border-width: 2 2 2 2;");
        button3.setStyle(""
                + "-fx-background-color: #ddd;"
                + "-fx-font-size: 24;"
                + "-fx-border-color: black;"
                + "-fx-border-width: 2 2 2 2;");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Field field = new Field();
                field.drawFields(group);
                enemyField = field.setEnemyField();
                drawShips(group);
                group.getChildren().remove(title);
                group.getChildren().remove(button1);
                group.getChildren().remove(button2);
                group.getChildren().remove(button3);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Text text = new Text("Пару слов о проекте");
                Text waterText1 = new Text("Задача организации, в особенности же укрепление и развитие структуры позволяет оценить значение направлений прогрессивного развития. Разнообразный и богатый опыт начало повседневной работы по формированию позиции требуют от нас анализа дальнейших направлений развития. Не следует, однако забывать, что начало повседневной работы по формированию позиции представляет собой интересный эксперимент проверки существенных финансовых и административных условий. Не следует, однако забывать, что начало повседневной работы по формированию позиции влечет за собой процесс внедрения и модернизации модели развития. Идейные соображения высшего порядка, а также постоянный количественный рост и сфера нашей активности способствует подготовки и реализации систем массового участия.");
                Text waterText2 = new Text("Не следует, однако забывать, что постоянное информационно-пропагандистское обеспечение нашей деятельности позволяет оценить значение форм развития. Идейные соображения высшего порядка, а также сложившаяся структура организации в значительной степени обуславливает создание новых предложений. Задача организации, в особенности же рамки и место обучения кадров требуют от нас анализа существенных финансовых и административных условий. Повседневная практика показывает, что постоянный количественный рост и сфера нашей активности способствует подготовки и реализации существенных финансовых и административных условий. ");
                Text authorsTitle = new Text("Выполнили ст.гр.ПРИ-220");
                Text authors = new Text("Гурьева Александра Васильевна" + "\n" + "Ворчалов Иван Дмитриевич" + "\n" + "Круглов Артем Алексеевич");

                Button button = new Button("Главная");
                button.setLayoutX(50);
                button.setLayoutY(865);
                button.setStyle("" +
                        "-fx-background-color: #ddd;" +
                        "-fx-font-size: 24;" +
                        "-fx-border-color: black;");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        start(primaryStage);
                        group.getChildren().remove(button);
                        group.getChildren().remove(text);
                        group.getChildren().remove(waterText1);
                        group.getChildren().remove(waterText2);
                        group.getChildren().remove(authorsTitle);
                        group.getChildren().remove(authors);
                    }
                });

                text.setX(50);
                text.setY(80);
                text.setStyle("-fx-font-size: 34;");

                waterText1.setX(50);
                waterText1.setY(130);
                waterText1.setWrappingWidth(1200);
                waterText1.setStyle("-fx-font-size: 21;" + "-fx-text-alignment: justify;");

                waterText2.setX(50);
                waterText2.setY(360);
                waterText2.setWrappingWidth(1200);
                waterText2.setStyle("-fx-font-size: 21;" + "-fx-text-alignment: justify;");

                authorsTitle.setX(50);
                authorsTitle.setY(580);
                authorsTitle.setStyle("-fx-font-size: 34;");

                authors.setX(50);
                authors.setY(630);
                authors.setStyle("-fx-font-size: 21;");

                group.getChildren().addAll(authorsTitle,authors,text,waterText1,waterText2, button);

                group.getChildren().remove(title);
                group.getChildren().remove(button1);
                group.getChildren().remove(button2);
                group.getChildren().remove(button3);
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
    }

    public void drawShips(Group group){
        int x = 100;
        int y = 880;

        Ship sloop = new Ship(1,4);
        ships.add(sloop);
        sloop.drawShip(group, x, y);

        y -= 100;

        Ship destroyer = new Ship(2,3);
        ships.add(destroyer);
        destroyer.drawShip(group, x, y);

        y -= 100;

        Ship cruiser = new Ship(3,2);
        ships.add(cruiser);
        cruiser.drawShip(group, x, y);

        y -= 100;

        Ship battleship = new Ship(4,1);
        ships.add(battleship);
        battleship.drawShip(group, x, y);
    }

    void showWhoIsWin(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("End game");
        if(Ship.allyShipsHealth == 0){
            alert.setHeaderText("Поражение!");
            alert.setContentText("Дорогой дневник, мне не подобрать слов, чтобы описать боль и унижение, которое я испытал...");
        } else {
            alert.setHeaderText("Победа!");
            alert.setContentText("Вам понадобилось всего лишь " + countOfSteps + " ходов, чтобы победить этого глупого робота!" );
        }
        alert.showAndWait();
    }
}



