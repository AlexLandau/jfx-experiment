import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.layout.StackPane



class MyApplication: Application() {
    override fun start(primaryStage: Stage) {
        primaryStage.setTitle("Hello World!")
        val btn = Button()
        btn.setText("Say 'Hello World'")
        btn.setOnAction(object : EventHandler<ActionEvent> {

            override fun handle(event: ActionEvent) {
                println("Hello World!")
            }
        })

        val root = StackPane()
        root.children.add(btn)
        primaryStage.setScene(Scene(root, 300.0, 250.0))
        primaryStage.show()

        val otherStage = Stage()
        otherStage.title = "Blah blah blah"
        otherStage.show()
    }

}

//fun main(args: Array<String>) {
//    Application.launch(MyApplication::class.java, *args)
//}
