# Sea_Battle
Учебный проект "Морской бой" по предмету Платформонезависимое программирование. Разработан студентами группы ПРИ-220: Ворчалов И.Д., Круглов А.А., Гурьева А.В.
<br/>
<br/>
Для корректного запуска проекта нужно выполнить следующие шаги:
<br/>
<br/>
1. Чтобы запустить проект, нам надо подключить библиотеки JavaFX. Для этого перейдем в меню File->Project Structure:
<br/>
<img src="imgs/Screenshot_1.png" alt="подключение библиотеки JavaFX"/>
<br/>
<br/>
2. В открывшемся окне перейдем к пункту Libraries:
<img src="imgs/Screenshot_2.png" alt="Libraries"/>
<br/>
<br/>
3. В этой вкладке нажмем на знак + и в появившемся небольшом окошке выберем Java.
<br/>
Далее в открывшемся диалоговом окне выберем путь к каталоге lib в папке, где распакован JavaFX SDK. И нажмем на OK для подключения библиотек.
<br/>
<img src="imgs/Screenshot_3.png" alt="подключение JavaFX SDK"/>
<br/>
<br/>
4. И далее нажмем на кнопку Apply для применения изменений и затем на кнопку OK.
<br/>
<img src="imgs/Screenshot_4.png" alt="Apply"/>
<br/>
<br/>
5. Далее перейдем в меню Run -> Edit Configuration
<br/>
<img src="imgs/Screenshot_5.png" alt="Config"/>
<br/>
<br/>
6. И в открывшемся окне перейдем к полю VM options. Если это поле отстутствует, то нажмем на опцию Modify options и в контекстном меню выберем Add VM options
<br/>
<img src="imgs/Screenshot_6.png" alt="Add VM options"/>
<br/>
<br/>
`--module-path "путь к JavFX SDK\lib" --add-modules javafx.controls,javafx.fxml`
<br/>
<br/>
<img src="imgs/Screenshot_7.png" alt="Add VM options"/>
