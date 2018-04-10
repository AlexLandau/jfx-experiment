import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.control.Button

interface ShadowNode {
    fun createComponent(): Node

}

class ShadowButton(val props: KJButton.Props): ShadowNode {
    override fun createComponent(): Node {
        val button = Button()
        button.setText(props.text)
        button.setOnAction(object : EventHandler<ActionEvent> {

            override fun handle(event: ActionEvent) {
                println("Hello World!")
            }
        })
        return button
    }
}
