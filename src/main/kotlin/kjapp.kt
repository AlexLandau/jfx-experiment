import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class KJApplication: Application() {
    override fun start(primaryStage: Stage) {
        this.parameters.unnamed

        primaryStage.setTitle("KJ test")
        val root = StackPane()

        val outmostComponent = KJButton()
        val componentProps = KJButton.Props("Say hi!")

        val kjPane = KJRenderingPane(outmostComponent, componentProps)
        root.children.add(kjPane)

        primaryStage.setScene(Scene(root, 300.0, 250.0))
        primaryStage.show()
    }
}

class KJRenderingPane<PropsT>(val component: KJComponent<PropsT>, val props: PropsT): Pane() {
    // TODO: Set this up to re-render at appropriate times
    init {
        val shadowDom = component.render(props)
        setChildrenOfNodeToShadowNodes(this, listOf(shadowDom))
    }
}

private fun setChildrenOfNodeToShadowNodes(node: Pane, shadowNodes: List<ShadowNode>) {
    // TODO: Do non-naively
    node.children.removeAll()
    for (shadowNode in shadowNodes) {
        node.children.add(shadowNode.createComponent())
    }
}

fun main(args: Array<String>) {
    Application.launch(KJApplication::class.java, *args)
}
