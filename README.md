# Sea_Battle
Учебный проект "Морской бой" по предмету Платформонезависимое программирование. Разработан студентами группы ПРИ-220: Ворчалов И.Д., Круглов А.А., Гурьева А.
<br/>
<br/>
Для корректного запуска проекта нужно выполнить следующие шаги:
<br/>
<br/>
1. Чтобы запустить проект, нам надо подключить библиотеки JavaFX. Для этого перейдем в меню File->Project Structure:
<br/>
![подключение библиотеки JavaFX](/imgs/Screenshot_1.png "подключение библиотеки JavaFX")
<br/>
<br/>
2. В открывшемся окне перейдем к пункту Libraries:
![Libraries](/imgs/Screenshot_2.png "Libraries")
<br/>
<br/>
3. В этой вкладке нажмем на знак + и в появившемся небольшом окошке выберем Java.
<br/>
Далее в открывшемся диалоговом окне выберем путь к каталоге lib в папке, где распакован JavaFX SDK. И нажмем на OK для подключения библиотек.
<br/>
![подключение JavaFX SDK](/imgs/Screenshot_3.png "подключение JavaFX SDK")
<br/>
<br/>
4. И далее нажмем на кнопку Apply для применения изменений и затем на кнопку OK.
<br/>
![Apply](/imgs/Screenshot_4.png "Apply")
<br/>
<br/>
5. Далее перейдем в меню Run -> Edit Configuration
<br/>
![Config](/imgs/Screenshot_5.png "Config")
<br/>
<br/>
6. И в открывшемся окне перейдем к полю VM options. Если это поле отстутствует, то нажмем на опцию Modify options и в контекстном меню выберем Add VM options
<br/>
![Add VM options](/imgs/Screenshot_6.png "Add VM options")
<br/>
<br/>
`--module-path "путь к JavFX SDK\lib" --add-modules javafx.controls,javafx.fxml`
<br/>
<br/>
![Add VM options](/imgs/Screenshot_7.png "Add VM options")
